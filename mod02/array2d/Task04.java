package by.practice.mod02.array2d;

import java.util.Arrays;

//4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
// [1 2   3   ... n]
// [n n−1 n−2 ... 1]
// [1 2   3   ... n]
// [n n−1 n−2 ... 1]
// [... ... ... ...]
// [n n−1 n−2 ... 1]
public class Task04 {
	public static int[][] makeMatrix(int num) {
		int[][] arr;

		if (num == 0 || num % 2 != 0) {
			arr = new int[0][0];
			System.out.println("'num' must be even and > 0. Entered " + num);
			return arr; 
		}
		
		arr = new int[num][num];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i % 2 == 0) {
					arr[i][j] = j + 1;
				} else {
					arr[i][j] = num - j;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int num;
		int[][] arr;

		num = 6;
		
		arr = makeMatrix(num);

		if (arr.length != 0) {
			System.out.println("Creating matrix of size " + num);
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			
			System.out.println();
		}
	}
}