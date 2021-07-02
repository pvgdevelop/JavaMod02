package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//6. Задана последовательность N вещественных чисел.
//Вычислить сумму чисел, порядковые номера которых являются простыми числами.
//Простое число - это число, имеющее ровно 2 делителя: 1 и себя самого.
public class Task06 {

	public static double sumOfSimpleNumbers(double[] arr) {
		double sum = 0;

		for (double num : arr) {
			if (isSimple(num)) {
				sum += num;
			}
		}

		return sum;
	}

	public static boolean isSimple(double num) {
		double numPos = num;

		if (num < 0) {
			numPos = -1 * num;
		}

		for (int i = 2; i < numPos; i++) {
			if (numPos % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static double[] makeArray(int n) {
		double num;
		double[] arr = new double[n];
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
		double[] arr;
		double res;

		n = 9;
		arr = makeArray(n);

		res = sumOfSimpleNumbers(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Result: " + res);

	}
}
