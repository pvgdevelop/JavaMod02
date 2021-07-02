package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. 
//Заменить все ее члены, большие данного Z, этим числом. 
//Подсчитать количество замен.
public class Task02 {

	static int count; // Count of substitutions

	public static void setCount(int count) {
		Task02.count = count;
	}

	// Substitute elements of array that are bigger then num with num.
	// Update count - class variables.
	public static double[] substitute(double[] arr, double num) {
		double[] res;
		int count = 0;
		int len = arr.length;

		res = new double[len];

		for (int i = 0; i < len; i++) {
			res[i] = arr[i];

			if (arr[i] > num) {
				res[i] = num;
				++count;
			}
		}

		// Store count in class variable
		setCount(count);

		return res;
	}

	public static double[] makeArray(int n) {
		double num;
		int num1;
		int num2;

		double[] arr = new double[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			num1 = rand.nextInt(1000);
			num2 = rand.nextInt(10);

			num = num1 / (num2 + 1.0);
			arr[i] = num;
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		double z;
		double[] arr;
		double[] res;

		n = 10;
		arr = makeArray(n);

		z = 100.0;
		res = substitute(arr, z);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Resulting array: " + Arrays.toString(res));
		System.out.println("Number of substitutions: " + Task02.count);
	}
}
