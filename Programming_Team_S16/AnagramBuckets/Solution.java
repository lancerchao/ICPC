import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static class customCompare implements Comparator<List<String>>
	 {
	     public int compare(List<String> strs1,List<String> strs2)
	     {
	         return strs1.get(0).compareTo(strs2.get(0));
	     }
	 }
	public static void main(String[] args) throws IOException {
		BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(c.readLine().trim());
		String[] strs = new String[n];
		for(int i=0;i<strs.length;i++)
		{
			strs[i] = c.readLine();
		}
		List<List<String>> strings = groupAnagrams(strs);
		Collections.sort(strings, new customCompare());
		for(int i=0;i<strings.size();i++)
		{
			List<String> list = strings.get(i);
			for(int j=0;j<list.size();j++)
			{
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
//		String[] split = c.readLine().split(" ");
//		int n = Integer.parseInt(split[0]);
//		int m = Integer.parseInt(split[1]);
//		char[][] grid = create2DArray(n, m, c);
//		System.out.println(numIslands(grid));
		
	}

	private static char[][] create2DArray(int numRows, int numCols, BufferedReader c) throws IOException
    {
    char[][] matrix = new char[numRows][numCols];
    for(int i=0;i<numRows;i++)
        {
        String s = c.readLine();
        for(int j=0;j<numCols;j++)
            {
            matrix[i][j] = s.charAt(j);
        }
    }
    return matrix;
}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        Arrays.sort(strs);
        HashMap<HashMap<Character,Integer>, List<String>> map = new HashMap<HashMap<Character,Integer>, List<String>>();
        for(int i=0;i<strs.length;i++)
        {
            String cur = strs[i];
            HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
            for(int j=0;j<cur.length();j++)
            {
                if (!freq.containsKey(cur.charAt(j)))
                    freq.put(cur.charAt(j), 1);
                else
                    freq.put(cur.charAt(j), freq.get(cur.charAt(j))+1);
            }
            if (!map.containsKey(freq))
                map.put(freq, new ArrayList<String>());
            List<String> list = map.get(freq);
            list.add(cur);
        }
        Iterator<HashMap<Character,Integer>> iter = map.keySet().iterator();
        while(iter.hasNext())
        {
            List<String> list = map.get(iter.next());
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }
	
	public static int numIslands(char[][] grid) {
        int m = grid.length;
        if (m==0)
            return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (grid[i][j] == '1')
                {
                    //found distinct island, do dfs
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    //do a dfs for land, marking them as water
    private static void dfs(char[][] grid, int x, int y, int lenx, int leny)
    {
        if (x <= -1 || x >= lenx || y <= -1 || y >= leny || grid[x][y] == '0')
            return;
        grid[x][y] = '0';
        dfs(grid, x-1, y, lenx, leny);
        dfs(grid, x+1, y, lenx, leny);
        dfs(grid, x, y-1, lenx, leny);
        dfs(grid, x, y+1, lenx, leny);
    }
}
