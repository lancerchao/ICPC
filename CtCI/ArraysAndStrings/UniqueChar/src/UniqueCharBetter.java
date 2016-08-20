/* 
 * This algorithm, instead of creating a frequency count of the alphabet and then
 * checking each character for uniqueness, it checks for uniqueness after adding
 * a character to the frequency table so that the first repeat would end up 
 * returning false. Also a quick check to make sure that the string is less than
 * the size of the alphabet is added, since a size of greater than the alphabet
 * would automatically mean there is a repeat*/
public class UniqueCharBetter
{
	public boolean isUnique(String s)
	{
		if (s.length() > 26)
			return false;
		int[] charCount = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			char a = s.charAt(i);
			int index = charToInt(a);
			charCount[index]++;
			if (charCount[index] >= 2)
				return false;
		}
		return true;
	}

	public int charToInt(char a)
	{
		return a - 'a';
	}

}
