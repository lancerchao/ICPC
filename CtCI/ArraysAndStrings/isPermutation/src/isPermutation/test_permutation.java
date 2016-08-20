package isPermutation;
import junit.framework.*;
public class test_permutation extends TestCase
{
	public void test_is_permutation()
	{
		isPermutation p = new isPermutation();
		assertTrue(p.is_permutation("asdfjkl", "ldfsajk"));
	}
	
	public void test_is_not_permutation()
	{
		isPermutation p = new isPermutation();
		assertFalse(p.is_permutation("asdf", "asdf "));
	}
}
