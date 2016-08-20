import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(c.readLine());
		int[] ar = createArray(c.readLine(), n);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (!set.contains(ar[i])) {
				System.out.print(ar[i] + " ");
				set.add(ar[i]);
			}
		}
	}

	private static int[] createArray(String str, int arrayLength) {
		int[] array = new int[arrayLength];
		String[] split = str.split(" ");
		if (split.length != arrayLength) {
			System.out.println("ERROR: ArrayLength is inconsistent with string");
			System.exit(-1);
		}
		for (int i = 0; i < arrayLength; i++)
			array[i] = Integer.parseInt(split[i]);
		return array;
	}

	private static int[] generateFrequencyTable(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int index = charToIntLowercase(s.charAt(i));
			if (index != -1)
				freq[index]++;
		}
		return freq;
	}

	private static int charToIntLowercase(char c) {
		if (c >= 'a' && c <= 'z')
			return c - 'a';
		return -1;
	}

}
