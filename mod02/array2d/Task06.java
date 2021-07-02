package by.practice.mod02.array2d;

import java.util.Arrays;

//6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
// [1   1   1 ... 1 1 1]
// [0   1   1 ... 1 1 0]
// [0   0   1 ... 1 0 0]
// [... ... ... ... ...]
// [0   1   1 ... 1 1 0]
// [1   1   1 ... 1 1 1]

public class Task06 {
	public static int[][] makeMatrix(int num) {
		int[][] arr;

		if (num == 0 || num % 2 != 0) {
			arr = new int[0][0];
			System.out.println("'num' must be even and > 0. Entered " + num);
			return arr;
		}

		arr = new int[num][num];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j] = 1;

				// Top half of the matrix
				if (i < num / 2) {
					if (j < i || j > num - 1 - i) {
						arr[i][j] = 0;
					}

					// Bottom half
				} else {
					if (j < num - 1 - i || j > i) {
						arr[i][j] = 0;
					}
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int num;
		int[][] arr;

		num = 8;

		arr = makeMatrix(num);

		if (arr.length != 0) {
			System.out.println("Creating matrix of size " + num);

			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}

			System.out.println();
		}
	}
}