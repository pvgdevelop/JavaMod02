package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
public class Task15 {

	public static int getMax(int[][] arr) {
		int max;

		max = arr[0][0];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}

		return max;
	}

	public static int[][] replaceOdds(int[][] arr, int max) {
		int[][] res;

		res = arr.clone();

		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i].clone();

			for (int j = 0; j < res[i].length; j++) {
				if (res[i][j] % 2 != 0) {
					res[i][j] = max;
				}
			}
		}
		return res;
	}

	public static int[][] makeMatrix(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(1000000);
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int max;
		int[][] arr;
		int[][] res;

		rows = 5;
		cols = 9;

		arr = makeMatrix(rows, cols);

		max = getMax(arr);

		res = replaceOdds(arr, max);

		System.out.println("Initial Matrix");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();
		System.out.println("Replaced odd values with Max " + max);
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}