package by.tc.mod2.alg.array2d;

import java.util.Arrays;

//5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
// [1   1   1 ... 1 1 1]
// [2   2   2 ... 2 2 0]
// [3   3   3 ... 3 0 0]
// [... ... ... ... ...]
// [n-1 n-1 0 ... 0 0 0]
// [n   0   0 ... 0 0 0]
public class Task05 {
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
				if (j >= num - i) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = i + 1;
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int num;
		int[][] arr;

		num = 8;
		
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