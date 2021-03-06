import junit.framework.*;

public class LRUTest extends TestCase {
	
	public void testBasic()
	{
		LRUCache c = new LRUCache(10);
		c.set(1, 2);
		c.set(2, 3);
		assertEquals(c.get(1), 2);
		assertEquals(c.get(2), 3);
	}
	
	public void testRemove()
	{
		LRUCache c = new LRUCache(3);
		c.set(1, 2);
		c.set(2, 3);
		c.set(4, 5);
		c.get(1);
		c.set(6, 7);
		assertEquals(c.get(2), -1);
		assertEquals(c.get(1), 2);
		assertEquals(c.get(4), 5);
		assertEquals(c.get(6), 7);
		
	}
	
	public void testNotFound()
	{
		LRUCache c = new LRUCache(3);
		c.set(1, 2);
		c.set(2, 3);
		c.set(4, 5);
		assertEquals(c.get(6), -1);
	}
	
	public void testWrong()
	{
		LRUCache c = new LRUCache(2);
		assertEquals(c.get(2), -1);
		c.set(2, 6);
		assertEquals(c.get(1), -1);
		c.set(1, 5);
		c.set(1, 2);
		assertEquals(c.get(1), 2);
		assertEquals(c.get(2), 6);
		
	}
}
