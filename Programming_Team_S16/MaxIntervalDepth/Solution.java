import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

    static class interval{
        int x,y;
        public interval(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(c.readLine());
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer,Integer> enter = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> exit = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            String[] split = c.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            set.add(a);
            set.add(b);
            if (!enter.containsKey(a))
                enter.put(a, 1);
            else
                enter.put(a, enter.get(a) + 1);
            if (!exit.containsKey(b))
                exit.put(b, 1);
            else
                exit.put(b, exit.get(b) + 1);
            
        }
        Iterator<Integer> iter = set.iterator();
        List<Integer> list = new ArrayList<Integer>();
        while(iter.hasNext())
        {
            list.add(iter.next());
        }
        Collections.sort(list);
        int cur = 0;
        int max = 0;
        for(int i=0;i<list.size();i++)
        {
            int event = list.get(i);
            if (exit.containsKey(event))
            {
                cur -= exit.get(event);
            }
            if (enter.containsKey(event))
            {
                cur += enter.get(event);
            }
            max = Math.max(max, cur);
        }
        System.out.println(max);
        
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
