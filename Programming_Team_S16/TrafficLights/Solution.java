import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static class BIT {
		private int[] tree;

		/* Initialize all elements to zero. */
		BIT(int size) {
			this.tree = new int[size];
		}

		/* O(log n) get sum of tree[0..idx], inclusive */
		int getPartialSum(int idx) {
			int res = 0;
			while (idx >= 0) {
				res += tree[idx];
				idx = (idx & (idx + 1)) - 1;
			}
			return res;
		}

		/* O(log n) update. t[idx] += val */
		void add(int idx, int val) {
			while (idx < tree.length) {
				tree[idx] += val;
				idx |= (idx + 1);
			}
		}

		/* O(log n) return t[idx] */
		int getSingle(int idx) {
			int sum = tree[idx];
			if (idx > 0) {
				int z = (idx & (idx + 1)) - 1;
				idx--;
				while (idx != z) {
					sum -= tree[idx];
					idx = (idx & (idx + 1)) - 1;
				}
			}
			return sum;
		}

		/* O(log n) return sum(t[idx] for idx in range[from, to]) */
		int getRangeSum(int from, int to) {
			return getPartialSum(to) - getPartialSum(from - 1);
		}
	}

	static class Segment {
		String dir;
		int a, b, c;

		public Segment(String dir, int a, int b, int c) {
			this.dir = dir;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		TreeMap<Integer, List<Segment>> map = new TreeMap<Integer, List<Segment>>();
		List<Integer> compressList = new ArrayList<Integer>();
		HashMap<Integer, Integer> compress = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			String[] s = reader.readLine().split(" ");
			String dir = s[0];
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			int c = Integer.parseInt(s[3]);
			Segment seg = new Segment(dir, a, b, c);
			if (dir.equals("V")) {
				mapPutHelper(map, c, seg);
				compressList.add(a);
				compressList.add(b);
			} else {
				assert (dir.equals("H"));
				mapPutHelper(map, a, seg);
				mapPutHelper(map, b, seg);
				compressList.add(c);
			}
		}
		Collections.sort(compressList);
		for (int i = 0; i < compressList.size(); i++)
			compress.put(compressList.get(i), i);
		Iterator<Integer> iter = map.keySet().iterator();
		BIT bit = new BIT(compressList.size());
		long sum = 0;
		while (iter.hasNext()) {
			int event = iter.next();
			List<Segment> list = map.get(event);
			// First add horizontal events to BIT
			for (int i = 0; i < list.size(); i++) {

				Segment seg = list.get(i);
				if (seg.dir.equals("H") && seg.a == event) {
					int index = compress.get(seg.c);
					bit.add(index, 1);
				}
			}

			// Then do a query on the BIT
			for (int i = 0; i < list.size(); i++) {
				Segment seg = list.get(i);
				if (seg.dir.equals("V")) {
					assert (seg.c == event);
					int idx1 = compress.get(seg.a);
					int idx2 = compress.get(seg.b);
					sum += bit.getRangeSum(idx1, idx2);
				}
			}
			for (int i = 0; i < list.size(); i++) {

				Segment seg = list.get(i);
				if (seg.dir.equals("H") && seg.b == event) {
					int index = compress.get(seg.c);
					bit.add(index, -1);
				}
			}
		}
		System.out.println(sum);
	}

	private static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}

	private static void mapPutHelper(TreeMap<Integer, List<Segment>> map, int key, Segment val) {
		if (!map.containsKey(key))
			map.put(key, new ArrayList<Segment>());
		List<Segment> list = map.get(key);
		list.add(val);
	}

}

