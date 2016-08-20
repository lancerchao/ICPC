import java.io.*;
import java.util.*;

public class Solution {

    private static class UF{

        int[] parent;
        int[] size;
        int count;
        HashSet<Integer> leaders; 

        public UF(int n)
        {
            parent = new int[n];
            size = new int[n];
            count = n;
            leaders = new HashSet<Integer>();
            for(int i=0;i<n;i++)
            {
                parent[i] = i;
                size[i] = 1;
                leaders.add(i);
            }
        }

        public int getCount()
        {
            return count;
        }

        public int find(int x)
        {
            while(x != parent[x])
            {
                parent[x] =  parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int size(int x)
        {
            int root = find(x);
            return size[root];
        }

        public boolean isConnected(int x, int y)
        {
            return find(x) == find(y);
        }

        public void union(int x, int y)
        {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx == rooty)
                return;
            if (size[rootx] > size[rooty])
            {
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
                leaders.remove(rooty);

            }
            else
            {
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
                leaders.remove(rootx);
            }
            count--;
        }

        public ArrayList<Integer> leaders()
        {
            
            return leaders;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int numAstro = Integer.parseInt(temp[0]);
        int numEdges = Integer.parseInt(temp[1]);
      
        for(int i = 0; i < numEdges; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
        }

   
        long combinations = 0;

        // Compute the final answer - the number of combinations
       
        System.out.println(combinations);

    }
}
