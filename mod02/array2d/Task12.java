package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
public class Task12 {

	public static int[][] sortRowsAsc(int[][] arr) {
		int len;
		int temp[];
		int[][] res;

		res = arr.clone();

		for (int i = 0; i < arr.length; i++) {
			temp = bubbleSort(arr[i]);
			res[i] = temp;
		}

		return res;
	}

	public static int[][] sortRowsDesc(int[][] arr) {
		int len;
		int temp[];
		int[][] res;

		res = arr.clone();

		for (int i = 0; i < arr.length; i++) {
			temp = bubbleSort(arr[i]);
			res[i] = reverse(temp);
		}

		return res;
	}

	// I could add flag to bubbleSort method (asc, desc),
	// and change condition accordingly.
	// This would save extra iterations.
	public static int[] reverse(int[] arr) {
		int len;
		int[] res;

		len = arr.length;
		res = new int[len];

		for (int i = 0; i < len; i++) {
			res[len - 1 - i] = arr[i];
		}

		return res;
	}

	// Return new sorted array.
	public static int[] bubbleSort(int[] arr) {
		int[] sorted;
		int temp;
		int count;
		boolean done;

		sorted = arr.clone();
		done = false;

		while (!done) {
			count = 0;

			for (int i = 0; i < arr.length - 1; i++) {
				if (sorted[i] > sorted[i + 1]) {
					temp = sorted[i];

					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;

					count++;
				}
			}

			// If no swaps occurred, we are done!
			done = count == 0;
		}

		return sorted;
	}

	public static int[][] makeMatrix(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(16);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int[][] arr;
		int[][] asc;
		int[][] desc;

		rows = 5;
		cols = 5;

		arr = makeMatrix(rows, cols);

		asc = sortRowsAsc(arr);

		desc = sortRowsDesc(arr);

		System.out.println("Initial Matrix");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();
		System.out.println("Sorted rows in ASC order");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(asc[i]));
		}

		System.out.println();
		System.out.println("Sorted rows in DESC order");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(desc[i]));
		}
	}
}