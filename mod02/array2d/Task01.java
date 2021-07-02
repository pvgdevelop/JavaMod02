package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//1. Дана матрица. 
//Вывести на экран все нечетные столбцы, 
//у которых первый элемент больше последнего.
public class Task01 {

	public static void result(int[][] arr) {
		int lastRow;

		lastRow = arr.length - 1;

		for (int j = 0; j < arr[0].length; j++) {
			if (j % 2 != 0) {
				if (arr[0][j] > arr[lastRow][j]) {
					System.out.print(arr[0][j] + " ");
				}
			}
		}
	}

	public static int[][] makeArray2D(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(100);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int[][] arr;

		rows = 5;
		cols = 10;
		
		arr = makeArray2D(rows, cols);

		System.out.println("Initial matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		result(arr);
	}
}