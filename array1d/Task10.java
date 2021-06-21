package by.tc.mod2.alg.array1d;

import java.util.Arrays;
import java.util.Random;

//10. Дан целочисленный массив с количеством элементов п. 
//Сжать массив, выбросив из него каждый второй элемент 
//(освободившиеся элементы заполнить нулями). 
//Примечание. Дополнительный массив не использовать.
public class Task10 {

	public static void shrinkArray(int[] arr) {
		int len;
		int idx; // Index of next "empty" slot.

		len = arr.length;
		idx = 0;

		// Starting from 2nd element, because 1st one will always remain the same
		for (int i = 1; i < len; i++) {
			if ((i + 1) % 2 == 0) {
				arr[i] = 0;
				idx++;
			}

			// Moving every odd element left <-
			// While moving 0 right ->
			arr[idx] = arr[i];
			arr[i] = 0;
		}
	}

	public static int[] makeArray(int n) {
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10);
		}

		return arr;
	}

	public static void main(String[] args) {
		int n;
		int[] arr;

		n = 8;
		arr = makeArray(n);
		
		System.out.println("Initial array: " + Arrays.toString(arr));

		shrinkArray(arr);

		System.out.println("Result array: " + Arrays.toString(arr));
	}
}