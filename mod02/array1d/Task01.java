package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//1. В массив A [N] занесены натуральные числа. 
//Найти сумму тех элементов, которые кратны данному К.
public class Task01 {

	public static int[] makeArray(int n) {
		int num;
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(1000);
		}

		return arr;
	}

	public static int sum(int[] arr, int k) {
		int sum = 0;

		for (int el : arr) {
			if (el % k == 0) {
				sum += el;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int n;
		int k;
		int sum;
		int[] arr;

		n = 10;
		arr = makeArray(n);

		k = 7;
		sum = sum(arr, k);

		System.out.println("Array of " + n + " elements: " + Arrays.toString(arr));
		System.out.println("Sum of elements that are divisible by " + k + " equals to " + sum);
	}
}
