package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
public class Task13 {

	public static int[][] sortColsAsc(int[][] arr) {
		int rows;
		int cols;
		int temp[];
		int[][] res;

		rows = arr.length;
		cols = arr[0].length;
		res = new int[rows][cols];

		// Reversing i and j to go over rows first
		for (int i = 0; i < cols; i++) {
			temp = new int[rows];

			// Storing current column in temp array
			for (int j = 0; j < rows; j++) {
				temp[j] = arr[j][i];
			}

			temp = bubbleSort(temp);

			// Inserting sorted values in resulting array
			for (int j = 0; j < rows; j++) {
				res[j][i] = temp[j];
			}
		}

		return res;
	}

	public static int[][] sortColsDesc(int[][] arr) {
		int rows;
		int cols;
		int temp[];
		int[][] res;

		rows = arr.length;
		cols = arr[0].length;
		res = new int[rows][cols];

		// Reversing i and j to go over rows first
		for (int i = 0; i < cols; i++) {
			temp = new int[rows];

			// Storing current column in temp array
			for (int j = 0; j < rows; j++) {
				temp[j] = arr[j][i];
			}

			temp = bubbleSort(temp);
			temp = reverse(temp);

			// Inserting sorted values in resulting array
			for (int j = 0; j < rows; j++) {
				res[j][i] = temp[j];
			}
		}

		return res;
	}

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
				arr[i][j] = rand.nextInt(10);
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

		rows = 4;
		cols = 2;

		arr = makeMatrix(rows, cols);

		asc = sortColsAsc(arr);
		desc = sortColsDesc(arr);

		System.out.println("Initial Matrix");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();
		System.out.println("Sorted rows in ASC order");
		for (int i = 0; i < asc.length; i++) {
			System.out.println(Arrays.toString(asc[i]));
		}

		System.out.println();
		System.out.println("Sorted rows in DESC order");
		for (int i = 0; i < desc.length; i++) {
			System.out.println(Arrays.toString(desc[i]));
		}
	}
}
