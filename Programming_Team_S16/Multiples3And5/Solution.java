import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(c.readLine());
		System.out.println(mult3And5(n));
	}

	private static int mult3And5(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (i%3 == 0 || i % 5 == 0)
				sum+=i;
		}
		return sum;
	}

}
