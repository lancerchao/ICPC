import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	static Scanner rdr = new Scanner(System.in);
	static class Tree {
	    public final String value;
	    public final Tree left, right;

	    public Tree(String value) {
	        this.value = value;
	        this.left = null;
	        this.right = null;
	    }
	    public Tree(String value, Tree left, Tree right) {
	        this.value = value;
	        this.left = left;
	        this.right = right;
	    }
	    public boolean isChild() {
	        return left == null && right == null;
	    }

	    static Tree parse() {
	        String token = rdr.next();
	        if (token.equals("-")) {
	            // null subtree
	            return null;
	        }
	        if (token.equals("[")) {
	            // internal node
	            String value = rdr.next();
	            Tree left = Tree.parse();
	            Tree right = Tree.parse();
	            String end = rdr.next();
	            assert end.equals("]");
	            return new Tree(value, left, right);
	        }
	        // leaf node
	        return new Tree(token);
	    }
	}
	public static void main(String args[]) {
	    Tree root = Tree.parse();
	    assert root != null;
	    printPaths(root, new StringBuilder());
	}

	static void printPaths(Tree root, StringBuilder prev) {
		if (root == null)
			return;
		prev.append(root.value);
		prev.append(" ");
	    if (root.left == null && root.right == null)
	    {
	    	System.out.println(prev.toString());
	    }
	    printPaths(root.left, new StringBuilder(prev.toString()));
	    printPaths(root.right, new StringBuilder(prev.toString()));
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

