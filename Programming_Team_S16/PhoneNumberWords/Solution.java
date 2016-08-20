import java.util.*;
import java.io.*;
import java.lang.*;


public class Solution {
	
	public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        List<String> ret = letterCombinations(c.readLine());
        for(int i=0;i<ret.size();i++)
        {
        	System.out.println(ret.get(i));
        }
        
	}
    public static List<String> letterCombinations(String digits) {
    	
        List<String> ret = new ArrayList<String>();
        if (digits.length() == 0)
            return ret;
        String[] buttons = {"","","abc","def","ghi","jkl","mno","prqs","tuv","wxyz"};
        backtrack(digits, 0, "", ret, buttons);
        return ret;
    }

    public static void backtrack(String digits, int curIndex, String prev, List<String> ret, String[] buttons)
    {
        if (curIndex == digits.length())
            ret.add(prev);
        else
        {
            int curButton = charToDigit(digits.charAt(curIndex));
            if (curButton < 2 || curButton > 9)
                return;
            String button = buttons[curButton];
            for(int i=0;i<button.length();i++)
            {
                backtrack(digits, curIndex+1, prev + button.charAt(i), ret, buttons);
            }
        }
    }
    
    public static int charToDigit(char c)
    {
        return c - '0';
    }
}
