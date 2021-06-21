package by.tc.mod2.alg.array2d;

import java.util.Arrays;
import java.util.Random;

//3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
public class Task03 {
	public static int getElementByRowAndCol(int[][] arr, int row, int col) {
		return arr[row - 1][col - 1];
	}

	public static int[][] makeArray2D(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(10);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int row;
		int col;
		int res;
		int[][] arr;

		rows = 5;
		cols = 5;

		arr = makeArray2D(rows, cols);

		System.out.println("Initial matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		row = 4;
		col = 5;
				
		res = getElementByRowAndCol(arr, row, col);
		
		System.out.println("Row=" + row + " Col=" + col);
		System.out.println("Result=" + res);
	}
}