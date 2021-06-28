package by.tc.mod2.alg.sorting;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

	// Binary search of sorted in ascending order array.
	public static int binarySearch2(int[] arr, int from, int to, int key) {
		int mid;

		arr = arr.clone();

		while (from <= to) {
			mid = (to + from) / 2;

			if (arr[mid] == key) {
				return mid;

			} else if (from == to) {
				break;

			} else if (arr[mid] > key) {
				to = mid - 1;

			} else {
				from = mid + 1;
			}
		}

		return -1;
	}

	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		Random rand = new Random();

		arr[0] = rand.nextInt(10);

		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] + rand.nextInt(10);
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr;
		int res;
		int to;
		int key;

		arr = makeArray(11);

		key = 777;
		to = arr.length - 1;

		res = binarySearch2(arr, 0, to, key);

		System.out.println(Arrays.toString(arr));
		System.out.println(res);

	}
}
