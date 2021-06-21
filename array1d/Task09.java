package by.tc.mod2.alg.array1d;

import java.util.Arrays;
import java.util.Random;

//9. В массиве целых чисел с количеством элементов n 
//найти наиболее часто встречающееся число. 
//Если таких чисел несколько, то 
//определить наименьшее из них.
public class Task09 {

	public static int result(int[] arr) {
		int len;
		int count;
		int maxCount;
		int minNum;
		Collection[] col;

		col = getNumbersCount(arr);

		// Setting initial values
		maxCount = col[0].count;
		minNum = col[0].number;
		len = col.length;
		count = 0;

		for (int i = len - 1; i >= 1; i--) {
			if (col[i] == null) {
				count++;

			} else if (col[i].count > maxCount) {
				maxCount = col[i].count;
				minNum = col[i].number;

			} else if (col[i].count == maxCount && col[i].number < minNum) {
				minNum = col[i].number;
			}
		}

		return minNum;
	}

	public static Collection[] getNumbersCount(int[] arr) {
		int len;
		Collection[] col;

		len = arr.length;
		col = new Collection[len];

		for (int i = 0; i < len; i++) {
			col = increamentCount(col, arr[i]);
		}

		return col;
	}

	public static Collection[] increamentCount(Collection[] col, int num) {

		for (int i = 0; i < col.length; i++) {
			if (col[i] == null) {
				col[i] = new Collection();

				col[i].number = num;
				col[i].count++;
				break;

			} else if (num == col[i].number) {
				col[i].count++;
				break;

			}
		}

		return col;
	}

	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(5);

			if (i % 2 == 0) {
				arr[i] = -1 * arr[i];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		int res;
		int[] arr;

		n = 20;
		arr = makeArray(n);

		res = result(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("The lowest number that repeats the most: " + res);
	}
}

class Collection {

	int number;
	int count;

}