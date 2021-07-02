package by.practice.mod02.array2d;

import java.util.Arrays;

//7. Сформировать квадратную матрицу порядка N по правилу:
public class Task07 {
	public static int countPositive(double[][] arr) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > 0) {
					count++;
				}
			}
		}

		return count;
	}

	public static double[][] makeMatrix(int num) {
		double[][] arr;
		double val;

		arr = new double[num][num];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				val = Math.sin((i * i - j * j) / num * 1.0);

				arr[i][j] = val;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int num;
		int res;
		double[][] arr;

		num = 5;

		arr = makeMatrix(num);

		System.out.println("Creating matrix of size " + num);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		res = countPositive(arr);

		System.out.println("Number of positive values: " + res);

	}
}