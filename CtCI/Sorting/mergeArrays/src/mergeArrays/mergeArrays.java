package mergeArrays;

public class mergeArrays {

	/* CtCI 11.1 */
	public static void mergeArray(int[] array1, int[] array2, int num1elem, int num2elem) {
		int newIndex = num1elem + num2elem - 1;
		int array1_index = num1elem - 1;
		int array2_index = num2elem - 1;
		while(array2_index >= 0)
		{
			if (array1_index >= 0 && (array1[array1_index]>=array2[array2_index]))
			{
				array1[newIndex] = array1[array1_index];
				array1_index--;
			}
			else
			{
				array1[newIndex] = array2[array2_index];
				array2_index--;
			}
			newIndex--;
		}
	}

	public static boolean isArrayEqual(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i])
				return false;
		}
		return true;
	}
}
