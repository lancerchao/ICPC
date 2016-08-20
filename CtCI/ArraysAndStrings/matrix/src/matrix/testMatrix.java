package matrix;

import junit.framework.*;

public class testMatrix extends TestCase
{
	int[][] matrix1;
	int matrix1Size = 4;
	int[][] matrix2;
	int matrix2Size=5;
	int[][] matrix3;
	int matrix3Size=16;
	public void setUp()
	{
		matrix1 = new int[matrix1Size][matrix1Size];
		initialize_matrix(matrix1, matrix1Size);
		matrix2 = new int[matrix2Size][matrix2Size];
		initialize_matrix(matrix2, matrix2Size);
		matrix3 = new int[matrix3Size][matrix3Size];
		initialize_matrix(matrix3, matrix3Size);
	}

	public void testEquals()
	{
		int[][] matrix2 = new int[matrix1Size][matrix1Size];
		for (int row = 0; row < matrix1Size; row++)
			for (int col = 0; col < matrix1Size; col++)
				matrix2[row][col] = row * matrix1Size + col;
		assertTrue(Matrix.equals(matrix2, matrix1));
	}

	public void testRotate()
	{
		int[][] matrixrot = new int[matrix1Size][matrix1Size];
		for (int row = 0; row < matrix1Size; row++)
			for (int col = 0; col < matrix1Size; col++)
				matrixrot[row][col] = (matrix1Size-col-1) * matrix1Size + row;
		Matrix.print(matrix1, matrix1Size);
		Matrix.rotate(matrix1, matrix1Size);
		Matrix.print(matrix1, matrix1Size);
		assertTrue(Matrix.equals(matrixrot, matrix1));
	}
	public void testRotate2()
	{
		int[][] matrixrot = new int[matrix2Size][matrix2Size];
		for (int row = 0; row < matrix2Size; row++)
			for (int col = 0; col < matrix2Size; col++)
				matrixrot[row][col] = (matrix2Size-col-1) * matrix2Size + row;
		Matrix.rotate(matrix2, matrix2Size);
		assertTrue(Matrix.equals(matrixrot, matrix2));
	}
	
	public void testRotate3()
	{
		int[][] matrixrot = new int[matrix3Size][matrix3Size];
		for (int row = 0; row < matrix3Size; row++)
			for (int col = 0; col < matrix3Size; col++)
				matrixrot[row][col] = (matrix3Size-col-1) * matrix3Size + row;
		Matrix.rotate(matrix3, matrix3Size);
		assertTrue(Matrix.equals(matrixrot, matrix3));
	}
	private void initialize_matrix(int[][] matrix, int size)
	{
		for (int row = 0; row < size; row++)
			for (int col = 0; col < size; col++)
				matrix[row][col] = row * size + col;
	}
}
