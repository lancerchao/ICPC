import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        String[] split = c.readLine().split(" ");
        int numPlayers = Integer.parseInt(split[0]);
        int numComplaints = Integer.parseInt(split[1]);
        HashMap<Integer, List<Integer>> map = parseComplaints(c, numComplaints);
        Set<Integer> keys = map.keySet();
        Iterator<Integer> iter = keys.iterator();
        HashSet<Integer> blue = new HashSet<Integer>();
        HashSet<Integer> red = new HashSet<Integer>();
        boolean[] visited = new boolean[numPlayers];
        Queue<Integer> q = new ArrayDeque<Integer>();
        for(int i=0;i<numPlayers;i++)
        {
            if (visited[i])
                continue;
            blue.add(i);
            q.add(i);
            visited[i] = true;
            while(!q.isEmpty())
            {
                int cur = q.poll();
                HashSet<Integer> curColor = (red.contains(cur))?red:blue;
                HashSet<Integer> other = (curColor == red)?blue:red;
                //mark all adj with other color
                List<Integer> list = map.get(cur);
                if (list == null)
                   continue;
                for(int j=0;j<list.size();j++)
                {
                    if (curColor.contains(list.get(j)))
                    {
                        System.out.println("no");
                        System.exit(0);
                    }
                    if (visited[list.get(j)])
                        continue;
                    q.add(list.get(j));
                    other.add(list.get(j));
                    visited[list.get(j)] = true;
                }

            }
        }
        System.out.println("yes");
    }

    private static HashMap<Integer, List<Integer>> parseComplaints(BufferedReader c, int numComplaints) throws IOException
    {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<numComplaints;i++)
        {
            String[] split = c.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if (!map.containsKey(a))
                map.put(a, new ArrayList<Integer>());
            List<Integer> list = map.get(a);
            list.add(b); 
            if (!map.containsKey(b))
                map.put(b, new ArrayList<Integer>());
            list = map.get(b);
            list.add(a);    
        }
        return map;
    }

}