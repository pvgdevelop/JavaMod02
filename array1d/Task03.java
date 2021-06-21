package by.tc.mod2.alg.array1d;

import java.util.Arrays;
import java.util.Random;

//3. Дан массив действительных чисел, размерность которого N.
// Подсчитать, сколько в нем 
// отрицательных, 
// положительных и 
// нулевых элементов.
public class Task03 {

	public static int[] getCounts(double[] arr) {
		int pos = 0;
		int neg = 0;
		int zer = 0;

		int[] res;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				zer++;
			} else if (arr[i] > 0) {
				pos++;
			} else if (arr[i] < 0) {
				neg++;
			} else {
				System.out.println("Unable to determine the kind of number: " + arr[i]);
			}
		}

		res = new int[] { pos, neg, zer };

		return res;

	}

	public static double[] makeArray(int n) {
		double num;
		double[] arr = new double[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			num = rand.nextInt(120);

			arr[i] = num;

			if (num % 3 == 0 && i != 0) {
				arr[i] = 0.0;
			}
			if (num % 4 == 0 && i != 0) {
				arr[i] = -1 * arr[i];
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		double[] arr;
		int[] res;

		n = 18;
		arr = makeArray(n);

		res = getCounts(arr);

		System.out.println("Initial array: " + Arrays.toString(arr));
		System.out.println("Positives: " + res[0]);
		System.out.println("Negatives: " + res[1]);
		System.out.println("Zeros: " + res[2]);
	}
}
