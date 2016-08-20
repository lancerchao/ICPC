import junit.framework.*;
public class UniqueCharTest extends TestCase
{
	public void testNotUnique()
	{
		String a = "helloworld";
		UniqueChar u = new UniqueChar();
		assertFalse(u.isUnique(a));
		UniqueNoDS v = new UniqueNoDS();
		assertFalse(v.isUnique(a));
		UniqueCharBetter b = new UniqueCharBetter();
		assertFalse(b.isUnique(a));
	}
	
	public void testUnique()
	{
		String a = "asdf";
		UniqueChar u = new UniqueChar();
		assertTrue(u.isUnique(a));
		UniqueNoDS v = new UniqueNoDS();
		assertTrue(v.isUnique(a));
		UniqueCharBetter b = new UniqueCharBetter();
		assertTrue(b.isUnique(a));
	}
}
