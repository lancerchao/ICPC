package compression;
import junit.framework.*;
public class testcompression extends TestCase
{
	public void testCompression()
	{
		String toCompress = "aabcccccaaa";
		String compressed = "a2b1c5a3";
		assertEquals(compression.compress(toCompress), compressed);
	}
	
	public void testCompression2()
	{
		String toCompress = "aabcccccaaab";
		String compressed = "a2b1c5a3b1";
		assertEquals(compression.compress(toCompress), compressed);
	}
	
	public void testNoCompression()
	{
		String toCompress = "abcdefg";
		String compressed = "abcdefg";
		assertEquals(compression.compress(toCompress), compressed);
	}
}
