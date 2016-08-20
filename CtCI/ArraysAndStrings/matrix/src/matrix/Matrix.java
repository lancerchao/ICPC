package matrix;

public class Matrix
{
	public static void rotate(int[][] matrix, int n)
	{
		for(int first=0;first<n/2;first++)
		{
			int last = (n-1)-first;
			for(int offset=first;offset<last;offset++)
			{
				//save the top
				int temp = matrix[first][offset];
				//left to top
				matrix[first][offset] = matrix[last-offset+first][first];
				//bottom to left
				matrix[last-offset+first][first] = matrix[last][last-offset+first];
				//right to bottom
				matrix[last][last-offset+first] = matrix[offset][last];
				//restore the top to right
				matrix[offset][last] = temp;
			}
		}
	}

	public static boolean equals(int[][] matrix1, int[][] matrix2)
	{
		if (matrix1.length != matrix2.length)
			return false;
		for (int i = 0; i < matrix1.length; i++)
		{
			int[] cur_row1 = matrix1[i];
			int[] cur_row2 = matrix2[i];

			if (cur_row1.length != cur_row2.length)
				return false;
			for (int j = 0; j < cur_row1.length; j++)
			{
				if (cur_row1[j] != cur_row2[j])
					return false;
			}
		}
		return true;
	}

	public static void print(int[][] matrix, int length)
	{
		for (int row = 0; row < length; row++)
			for (int col = 0; col < length; col++)
				System.out.println(matrix[row][col]);
	}
}