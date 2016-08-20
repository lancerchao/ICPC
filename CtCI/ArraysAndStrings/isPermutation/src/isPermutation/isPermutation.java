package isPermutation;

public class isPermutation
{

	boolean is_permutation(String s1, String s2)
	{
		if (s1.length() != s2.length())
			return false;
		int[] freq1 = new int[128];
		int[] freq2 = new int[128];
		count_freq(s1, freq1);
		count_freq(s2, freq2);
		return check_freq(freq1, freq2);
		
	}

	void count_freq(String s, int[] freq)
	{
		for (int i = 0; i < s.length(); i++)
		{
			freq[s.charAt(i)]++;
		}
	}
	
	boolean check_freq(int[] freq1, int[] freq2)
	{
		for(int i=0;i<freq1.length;i++)
		{
			if (freq1[i] != freq2[i])
				return false;
		}
		return true;
	}

}
