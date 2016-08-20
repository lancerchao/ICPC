import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
	private static class UF {

		int[] parent;
		int[] size;
		int count;
		HashSet<Integer> leaders;

		public UF(int n) {
			parent = new int[n];
			size = new int[n];
			count = n;
			leaders = new HashSet<Integer>();
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
				leaders.add(i);
			}
		}

		public int getCount() {
			return count;
		}

		public int find(int x) {
			while (x != parent[x]) {
				parent[x] = parent[parent[x]];
				x = parent[x];
			}
			return x;
		}

		public int size(int x) {
			int root = find(x);
			return size[root];
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

		public void union(int x, int y) {
			int rootx = find(x);
			int rooty = find(y);
			if (rootx == rooty)
				return;
			if (size[rootx] > size[rooty]) {
				parent[rooty] = rootx;
				size[rootx] += size[rooty];
				leaders.remove(rooty);

			} else {
				parent[rootx] = rooty;
				size[rooty] += size[rootx];
				leaders.remove(rootx);
			}
			count--;
		}

		public HashSet<Integer> leaders() {
			return leaders;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
		String[] split = c.readLine().split(" ");
		int numPeople = Integer.parseInt(split[0]);
		int numPairs = Integer.parseInt(split[1]);
		String[] people = c.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < numPeople; i++)
			map.put(people[i], i);
		UF find = new UF(numPeople);
		for (int i = 0; i < numPairs; i++) {
			split = c.readLine().split(" ");
			int a = map.get(split[0]);
			int b = map.get(split[1]);
			find.union(a, b);
		}
		System.out.println(find.getCount());

	}
}