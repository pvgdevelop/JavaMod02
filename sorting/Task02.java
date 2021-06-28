package by.tc.mod2.alg.sorting;

import java.util.Arrays;
import java.util.Random;

// 2. Даны две последовательности a1<=a2<=...<=an и b1<=b2<=...<=bm. 
// Образовать из них новую последовательность чисел так, 
// чтобы она тоже была неубывающей. 
// Примечание. Дополнительный массив не использовать.
public class Task02 {

	public static int[] merge(int[] arr1, int[] arr2) {
		int len;
		int len1;
		int len2;
		int count;
		int idx1;
		int idx2;
		int[] res;

		idx1 = 0;
		idx2 = 0;

		len1 = arr1.length;
		len2 = arr2.length;
		len = len1 + len2;

		res = new int[len];

		for (int i = 0; i < len; i++) {
			if (idx1 >= len1) {
				res[i] = arr2[idx2];
				idx2++;
			} else if (idx2 >= len2) {
				res[i] = arr1[idx1];
				idx1++;
			} else if (arr1[idx1] <= arr2[idx2]) {
				res[i] = arr1[idx1];
				idx1++;
			} else if (arr1[idx1] > arr2[idx2]) {
				res[i] = arr2[idx2];
				idx2++;
			} else {
				System.out.println("Something went wrong?!");
			}
		}

		return res;
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
		int[] arr1;
		int[] arr2;
		int[] res;

		arr1 = makeArray(9);
		arr2 = makeArray(12);

		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		System.out.println(Arrays.toString(arr2));
		System.out.println();

		res = merge(arr1, arr2);

		System.out.println(Arrays.toString(res));
	}
}
