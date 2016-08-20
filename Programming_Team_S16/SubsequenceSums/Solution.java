import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        String[] split = c.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int sum = Integer.parseInt(split[1]);
        int[] ar = createArray(c.readLine(), n);
        int pre = 0;
        int fp = 0;
        int bp = 0;
        while(fp < ar.length)
        {
        	if(pre < sum)
        	{
        		if (bp == ar.length)
        		{
        			System.out.println("false");
        			System.exit(0);
        		}
        		pre += ar[bp];
        		bp++;
        		continue;
        	}
        	if (pre > sum)
        	{
        		pre -= ar[fp];
        		fp++;
        		continue;
        	}
        	System.out.println("true");
        	System.exit(0);
        }
        System.out.println("false");
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
