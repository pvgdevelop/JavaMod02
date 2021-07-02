package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//5. Даны целые числа а1 ,а2 ,..., аn.
//Вывести на печать только те числа, для которых аi > i.
public class Task05 {

	public static void printResult(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > i) {
				System.out.println(arr[i]);
			}
		}
	}

	public static double[] makeArray(int n) {
		double num;

		double[] arr = new double[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(120);

			if (arr[i] % 2 == 0 && i != 0) {
				arr[i] = -1 * arr[i];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		double[] arr;
		double[] res;

		n = 9;
		arr = makeArray(n);

		System.out.println("Initial array: " + Arrays.toString(arr));

		printResult(arr);
	}
}