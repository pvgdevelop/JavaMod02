package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//8. Дана последовательность целых чисел a1,a2,...,an. 
//Образовать новую последовательность, выбросив из исходной те члены, которые 
//равны min(a1,a2,..,an).
public class Task08 {

	public static int min(int[] arr) {
		int min;

		min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		return min;
	}

	public static int[] result(int[] arr) {
		int min;
		int len;
		int count;
		int[] temp;
		int[] res;

		count = 0;
		len = arr.length;
		min = min(arr);

		temp = new int[len];

		for (int i = 0; i < len; i++) {
			if (arr[i] == min) {
				count++;
			} else {
				temp[i - count] = arr[i]; // shifting indices
			}
		}

		res = new int[len - count];

		for (int i = 0; i < res.length; i++) {
			res[i] = temp[i];
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
		int n;
		int[] arr;
		int[] res;

		n = 9;
		arr = makeArray(n);

		res = result(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Initial array: " + Arrays.toString(res));
	}
}
