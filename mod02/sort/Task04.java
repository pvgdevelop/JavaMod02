package by.practice.mod02.sort;

import java.util.Arrays;
import java.util.Random;

// 4. Сортировка обменами. Дана последовательность чисел 
// a1 >= a2 >= ... >= an . Требуется переставить числа в 
// порядке возрастания. Для этого сравниваются два соседних числа 
// a[i] и a[i+1]. Если a[i] > a[i+1], то делается перестановка. 
// Так продолжается до тех пор, пока все элементы не станут расположены 
// в порядке возрастания. Составить алгоритм сортировки, 
// подсчитывая при этом количество перестановок.
public class Task04 {

	public static int[] bubbleSort(int[] arr) {
		int len;
		int temp;
		int count;
		int[] sorted;
		boolean done;

		sorted = arr.clone();

		count = 0;

		done = false;

		while (!done) {
			temp = count;

			for (int i = 0; i < sorted.length - 1; i++) {

				if (sorted[i] > sorted[i + 1]) {
					temp = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;

					count++;
				}
			}

			done = temp == count;
		}

		System.out.println("Number of swaps: " + count);

		return sorted;
	}

	public static void main(String[] args) {
		int[] arr;
		int[] res;

		arr = new int[] { 55, 48, 39, 38, 32, 27, 26, 19, 16, 8 };

		System.out.println(Arrays.toString(arr));
		System.out.println();

		res = bubbleSort(arr);

		System.out.println(Arrays.toString(res));
	}
}
