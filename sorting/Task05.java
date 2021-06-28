package by.tc.mod2.alg.sorting;

import java.util.Arrays;
import java.util.Random;

// 5. Сортировка вставками. 
// Дана последовательность чисел a1,a2,..,an .
// Требуется переставить числа в порядке возрастания. 
// Делается это следующим образом. 
// Пусть a1,a2,...,ai - упорядоченная последовательность, т. е.
// a1 <= a2 <= ai <=... <= an . 
// Берется следующее число a[i+1] и вставляется в последовательность так, 
// чтобы новая последовательность была тоже возрастающей. 
// Процесс производится до тех пор, пока все элементы от i+1 до n не 
// будут перебраны. 
// Примечание. Место помещения очередного элемента в отсортированную часть 
// производить с помощью двоичного поиска. 
// Двоичный поиск оформить в виде отдельной функции.
public class Task05 {

	public static int[] insertionSort(int[] arr) {
		int idx;
		int to;
		int temp;

		arr = arr.clone();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				temp = arr[i];

				to = i - 1;
				idx = binarySearch(arr, 0, to, arr[i]);

				for (int j = i; j > idx; j--) {
					// shifting sorted part right ->
					arr[j] = arr[j - 1];
				}

				arr[idx] = temp;
			}
		}

		return arr;
	}

	// Binary search of sorted in ascending order array.
	// Return: index of element or closest to it.
	// If key lower then lowest element (or lowest in range), return the index of
	// that element.
	// On the other hand, if the key is > then the largest element in range, return
	// index + 1
	// Note: that if the key is greater then largest number, it will return last
	// index + 1
	public static int binarySearch(int[] arr, int from, int to, int key) {
		int mid = 0;

		while (from <= to) {
			mid = (from + to) / 2;

			if (arr[mid] == key || (from >= to && arr[mid] > key)) {
				// we found it!
				// ...or at least the number we searching is lower then minimum
				return mid;

			} else if (from >= to) {
				break;

			} else if (arr[mid] > key) {
				to = mid - 1;

			} else {
				from = mid + 1;

			}
		}

		return mid + 1;
	}

	public static void main(String[] args) {
		int[] arr;
		int[] res;

		arr = new int[] { -1, 2, 5, 6, 7, 9, 50, 18, 3, 4, 9, 27, 20, 21, 23, 0, -9 };

		res = insertionSort(arr);

		System.out.println(Arrays.toString(res));
	}
}
