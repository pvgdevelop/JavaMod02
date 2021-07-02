package by.practice.mod02.array1d;

import java.util.Arrays;
import java.util.Random;

//4. Даны действительные числа а1 ,а2 ,..., аn. 
//Поменять местами наибольший и наименьший элементы.
public class Task04 {

	public static double[] swapMinMax(double[] arr) {
		int iMax; // index of max
		int iMin; // index of min
		double min;
		double max;
		double cur;

		double[] res = new double[arr.length];

		// Setting initial min and max.
		min = arr[0];
		max = arr[0];

		iMax = 0;
		iMin = 0;

		for (int i = 0; i < arr.length; i++) {
			cur = arr[i];

			if (cur < min) {
				min = cur;
				iMin = i;
			} else if (cur > max) {
				max = cur;
				iMax = i;
			}

			res[i] = arr[i];
		}

		// Swapping min and max.
		res[iMin] = max;
		res[iMax] = min;

		return res;
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

		res = swapMinMax(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Result array: " + Arrays.toString(res));

	}
}