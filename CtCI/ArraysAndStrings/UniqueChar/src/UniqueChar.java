
public class UniqueChar
{
	public boolean isUnique(String s)
	{
		int[] charCount = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			char a = s.charAt(i);
			int index = charToInt(a);
			charCount[index]++;
		}
		return checkArray(charCount);

	}

	public int charToInt(char a)
	{
		return a - 'a';
	}

	public boolean checkArray(int[] a)
	{
		int len = a.length;
		for (int i = 0; i < len; i++)
		{
			if (a[i] >= 2)
				return false;
		}
		return true;
	}
}
