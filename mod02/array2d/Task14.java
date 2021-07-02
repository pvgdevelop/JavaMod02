package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, 
//причем в каждом столбце число единиц равно номеру столбца.
public class Task14 {
	public static int[][] makeMatrix() {
		int rows;
		int cols;
		int count;

		Random rand = new Random();

		rows = rand.nextInt(10);
		cols = rand.nextInt(10);

		int[][] arr = new int[rows][cols];

		for (int j = 0; j < cols; j++) {
			count = 0;

			for (int i = 0; i < rows; i++) {
				if (count <= j) {
					arr[i][j] = 1;
					count++;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int[][] arr;

		arr = makeMatrix();

		System.out.println("Initial Matrix");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}