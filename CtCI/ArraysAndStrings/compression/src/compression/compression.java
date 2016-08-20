package compression;

public class compression
{
	public static String compress(String s)
	{
		char last = s.charAt(0);
		int count = 1;
		StringBuilder ret = new StringBuilder();
		for(int i=1;i<s.length();i++)
		{
			char curchar = s.charAt(i);
			if (curchar == last)
			{
				count++;
			}
			else
			{
				ret.append(last);
				ret.append(count);
				count=1;
				last = curchar;
			}
		}
		ret.append(last);
		ret.append(count);
		if (ret.length() < s.length())
			return ret.toString();
		return s;
	}
}
