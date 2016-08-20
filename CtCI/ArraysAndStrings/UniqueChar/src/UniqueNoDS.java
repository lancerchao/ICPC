
public class UniqueNoDS
{
	public boolean isUnique(String s)
	{
		int numops = 0;
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				if (s.charAt(i) == s.charAt(j))
					return false;
				numops++;
			}
		}
		System.out.println("Numops = " + numops);
		return true;
	}
}
