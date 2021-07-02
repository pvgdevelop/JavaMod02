package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//9. Задана матрица неотрицательных чисел. 
//Посчитать сумму элементов в каждом столбце. 
//Определить, какой столбец содержит максимальную сумму.
public class Task09 {

	public static int[] getColsSum(int[][] arr) {
		int[] sums;

		// Assuming all columns are of the same length.
		sums = new int[arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sums[j] += arr[i][j];
			}
		}

		return sums;
	}

	public static int getMaxIndex(int[] arr) {
		int idx;
		int max;

		idx = 0;
		max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		return idx;
	}

	public static int[][] makeMatrix(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(100);
			}
		}

		return arr;
	}

	public static boolean isValid(int[][] arr) {
		boolean res;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] < 0) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int idx;
		int[][] arr;
		int[] res;

		rows = 5;
		cols = 9;

		arr = makeMatrix(rows, cols);

		System.out.println("Initial Matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		if (!isValid(arr)) {
			System.out.println("Elements of the matrix can not be negative.");
			System.out.println("Program terminated.");
			System.exit(1);
		}

		res = getColsSum(arr);
		idx = getMaxIndex(res);

		System.out.println();
		System.out.println("Result: " + Arrays.toString(res));
		System.out.println("Max sum belongs to the column with index " + idx);
	}
}