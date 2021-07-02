package by.practice.mod02.sort;

import java.util.Arrays;
import java.util.Random;

// 3. Сортировка выбором. 
// Дана последовательность чисел a1 <= a2 <= ... <= an .
// Требуется переставить элементы так, чтобы они были расположены 
// по убыванию. Для этого в массиве, начиная с первого, 
// выбирается наибольший элемент и ставится на первое место, 
// а первый - на место наибольшего. 
// Затем, начиная со второго, эта процедура повторяется. 
// Написать алгоритм сортировки выбором.
public class Task03 {

	public static int[] selectSort(int[] arr) {
		int len;
		int temp;
		int idxStart;
		int max;
		int idxMax;
		int[] sorted;
		boolean done;

		sorted = arr.clone();

		idxStart = 0;
		len = sorted.length;

		done = idxStart == len;

		while (!done) {
			idxMax = idxStart;
			max = sorted[idxStart];

			for (int i = idxStart; i < len; i++) {
				if (sorted[i] >= max) {
					max = sorted[i];
					idxMax = i;
				}
			}

			temp = sorted[idxStart];
			sorted[idxStart] = max;
			sorted[idxMax] = temp;

			idxStart++;

			done = idxStart == len;
		}

		return sorted;
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
		int[] arr;
		int[] res;

		arr = makeArray(9);

		System.out.println(Arrays.toString(arr));
		System.out.println();

		res = selectSort(arr);

		System.out.println(Arrays.toString(res));
	}
}
