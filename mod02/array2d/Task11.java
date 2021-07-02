package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;

//11. Матрицу 10x20 заполнить случайными числами от 0 до 15. 
//Вывести на экран саму матрицу и номера строк, 
//в которых число 5 встречается три и более раз.
public class Task11 {

	public static int[] getResult(int[][] arr) {
		int len;
		int count;
		int idx;
		int[] res;
		int[] temp;

		len = arr.length;
		temp = new int[len];
		idx = 0;
			
		for (int i = 0; i < len; i++) {
			count = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 5) {
					count++;
				}
				
				if (count >= 3) {
					temp[idx] = i;
					idx++;
					break; //Will prevent us from getting the same row more then once.
				}
			}
		}

		// Creating new array of proper length
		res = new int[idx];

		for (int i = 0; i < idx; i++) {
			res[i] = temp[i];
		}

		return res;
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
		int[] res;

		rows = 10;
		cols = 20;

		arr = makeMatrix(rows, cols);

		System.out.println("Initial Matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		res = getResult(arr);

		System.out.println();
		System.out.println("Result (row indices): " + Arrays.toString(res));
	}
}