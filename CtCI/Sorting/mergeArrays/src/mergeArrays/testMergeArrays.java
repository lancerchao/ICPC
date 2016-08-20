package mergeArrays;

import junit.framework.*;

public class testMergeArrays extends TestCase {

	int[] array1;
	int[] array2;

	public void testMergeBasic() {
		array1 = new int[10];
		array1[0] = 1;
		array1[1] = 3;
		array1[2] = 5;
		array1[3] = 7;
		array1[4] = 9;
		
		array2 = new int[]{2,4,6,8,10};
		mergeArrays.mergeArray(array1, array2, 5, 5);
		
		int[] arrayref = new int[]{1,2,3,4,5,6,7,8,9,10};
		assertTrue(mergeArrays.isArrayEqual(array1, arrayref));
		
	};
}