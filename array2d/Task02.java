package by.tc.mod2.alg.array2d;

import java.util.Arrays;
import java.util.Random;

//2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
public class Task02 {

	public static void result(int[][] arr) {
		int lastRow;

		lastRow = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == j) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print("X ");
				}
			}
			System.out.println();
		}
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
		int[][] arr;

		rows = 9;
		cols = 9;

		arr = makeArray2D(rows, cols);

		System.out.println("Initial matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		result(arr);
	}
}