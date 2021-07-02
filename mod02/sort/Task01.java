package by.practice.mod02.sort;

import java.util.Arrays;
import java.util.Random;

// 1. Заданы два одномерных массива с различным количеством элементов и 
// натуральное число k. Объединить их в один массив, включив второй массив 
// между k-м и (k+1) - м элементами первого, 
// при этом не используя дополнительный массив.
public class Task01 {

	// Merges arr2 into arr1 (in new array) after K-th element (not index)
	// arr1 = [1,3,4,5]
	// arr2 = [9,7,8]
	// k = 3
	// res = [1,3,4,9,7,8,5]
	public static int[] merge(int[] arr1, int[] arr2, int k) {
		int len;
		int len1;
		int len2;
		int[] res;

		len1 = arr1.length;
		len2 = arr2.length;

		len = len1 + len2;
		res = new int[len];

		for (int i = 0; i < len; i++) {
			if (i < k) {
				res[i] = arr1[i];
			} else if (i < len2 + k) {
				res[i] = arr2[i - k];
			} else {
				res[i] = arr1[i - k];
			}
		}

		return res;
	}

	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}

		return arr;
	}

	public static void main(String[] args) {
		int k;
		int[] arr1;
		int[] arr2;
		int[] res;

		k = 9;
		
		arr1 = makeArray(12);
		arr2 = makeArray(9);

		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		System.out.println(Arrays.toString(arr2));
		System.out.println();

		res = merge(arr1, arr2, k);

		System.out.println(Arrays.toString(res));
	}
}
