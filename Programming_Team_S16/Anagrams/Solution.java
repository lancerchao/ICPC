import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        int[] a = generateFrequencyTable(c.readLine());
        int[] b = generateFrequencyTable(c.readLine());
        for(int i=0;i<a.length;i++)
        {
            if (a[i] != b[i])
            {
                 System.out.println("false");
                 System.exit(0);
            }   

        }
        System.out.println("true");
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
    
    private static int charToIntLowercase(char c)
    {
    if (c >= 'a' && c<='z')
        return c-'a';
    return -1;
}

}
