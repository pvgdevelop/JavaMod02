package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//10. Найти положительные элементы главной диагонали квадратной матрицы.
public class Task10 {

	public static int[] getPositiveItemsInDiagonal(int[][] arr) {
		int len;
		int count;
		int[] res;
		int[] temp;

		len = arr.length;
		temp = new int[len];
		count = 0;

		for (int i = 0; i < len; i++) {
			if (arr[i][i] > 0) {
				temp[count] = arr[i][i];
				count++;
			}
		}

		// Creating new array of proper length
		res = new int[count];

		for (int i = 0; i < count; i++) {
			res[i] = temp[i];
		}

		return res;
	}

	public static int[][] makeMatrix(int num) {
		int[][] arr = new int[num][num];
		Random rand = new Random();

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j] = rand.nextInt();
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int num;
		int[][] arr;
		int[] res;

		num = 5;

		arr = makeMatrix(num);

		System.out.println("Initial Matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		res = getPositiveItemsInDiagonal(arr);

		System.out.println();
		System.out.println("Result: " + Arrays.toString(res));
	}
}