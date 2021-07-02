package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//7. Даны действительные числа a1,a2,...,a2n .
//Найти max(a(1) + a(2n), a(2) + a(2n−1),...,a(n) +a(n+1)).
//
//For array of size 2n: a(1) -> a[0],..., a(2n) -> a[2n-1]
// 2 middle values are a[n-1] and a[n]
public class Task07 {

	public static int max(int[] arr) {
		int i;
		int j;
		int cur;
		int len;
		int max;

		len = arr.length;
		max = arr[0] + arr[len - 1]; // setting default max

		for (i = 0; i < len / 2; i++) {
			// a(1) -> a[0]; a(2n) -> a[len - 1 - 0]
			j = len - 1 - i;
			cur = arr[i] + arr[j];

			if (max < cur) {
				max = cur;
				System.out.println("a[i]=" + arr[i] + " a[2n-1-i]=" + arr[j]);
			}
			;
		}

		return max;
	}

	public static int[] makeArray(int n) {
		int[] arr = new int[2 * n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(120);

			if (arr[i] % 3 == 0 && i != 0) {
				arr[i] = -1 * arr[i];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		int[] arr;
		int res;

		n = 16;
		arr = makeArray(n);

		res = max(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Result: " + res);
	}
}
