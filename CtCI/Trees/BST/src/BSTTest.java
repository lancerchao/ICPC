import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import junit.framework.*;

public class BSTTest extends TestCase {
	BST<Integer> intTree;
	BST<Integer> intTreeBalanced;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	public void setUp() {

		System.setOut(new PrintStream(outContent));
		intTree = new BST<Integer>(0);
		intTree.insert(100);
		intTree.insert(50);
		intTree.insert(200);
		intTree.insert(25);
		intTree.insert(75);
		intTree.insert(250);
		intTree.insert(15);
		intTree.insert(35);
		intTree.insert(300);

		intTreeBalanced = new BST<Integer>(0);
		intTreeBalanced.insert(100);
		intTreeBalanced.insert(50);
		intTreeBalanced.insert(200);
		intTreeBalanced.insert(25);
		intTreeBalanced.insert(75);
		intTreeBalanced.insert(150);
		intTreeBalanced.insert(250);
		intTreeBalanced.insert(15);
		intTreeBalanced.insert(35);
		intTreeBalanced.insert(300);
	}

	public void tearDown() {
		System.setOut(null);
	}

	public void testLevels() {
		assertTrue(intTree.levels() == 4);
	}

	public void testLevelsNoGlobal() {
		assertEquals(intTree.levelsNoGlobal(), 4);
	}

	public void testBalancedNaive() {
		assertFalse(intTree.isBalanced());
		assertTrue(intTreeBalanced.isBalanced());
	}

	public void testBalancedBetter() {
		assertFalse(intTree.isBalancedBetter());
		assertTrue(intTreeBalanced.isBalancedBetter());
	}

	public void testImportIncreasingArray() {
		Integer[] array = { 25, 35, 50, 75, 100, 200, 250 };
		intTree.importIncreasingArray(array);
		assertEquals(intTree.levelsNoGlobal(), 3);
		Integer[] array2 = { 2, 5, 10, 15, 25, 35, 50, 75, 100, 200, 250, 300, 350, 400, 450 };
		intTree.importIncreasingArray(array2);
		assertEquals(intTree.levelsNoGlobal(), 4);
		Integer[] array3 = { 2, 5, 10, 15, 20, 25, 35, 50, 75, 100, 150, 200, 250, 300, 350, 400, 450, 500 };
		intTree.importIncreasingArray(array3);
		assertEquals(intTree.levelsNoGlobal(), 5);
	}

	public void testSize() {
		assertEquals(intTree.size(), 9);
		assertEquals(intTreeBalanced.size(), 10);
	}

	public void testCreatedLinkedList() {
		Integer[] array = { 25, 35, 50, 75, 100, 200, 250 };
		intTree.importIncreasingArray(array);
		assertEquals(intTree.levelsNoGlobal(), 3);
		ArrayList<LinkedList<Integer>> ar = intTree.createLinkedList();
		printArrayOfLinkedList(ar);
		String output = "Level0: 75" + System.getProperty("line.separator") + "Level1: 35"
				+ System.getProperty("line.separator") + "Level1: 200" + System.getProperty("line.separator")
				+ "Level2: 25" + System.getProperty("line.separator") + "Level2: 50"
				+ System.getProperty("line.separator") + "Level2: 100" + System.getProperty("line.separator")
				+ "Level2: 250" + System.getProperty("line.separator");
		assertEquals(output, outContent.toString());

	}
	
	public void testIsBST()
	{
		assertTrue(intTree.isBST());
	}

	private void printArrayOfLinkedList(ArrayList<LinkedList<Integer>> array) {
		for (int i = 0; i < array.size(); i++) {
			LinkedList<Integer> list = array.get(i);
			if (array != null) {
				ListIterator<Integer> iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println("Level" + i + ": " + iterator.next());
				}
			}
		}
	}
}
