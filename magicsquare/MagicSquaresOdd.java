package by.tc.mod2.alg.magicsquare;

import java.util.Arrays;

// Magic Square of odd order (2*N + 1) -> 3, 5, 7, ...
// The first number is always in the middle of one of the sides. We'll go with
// top.
// 1. Position (i, j) of number 1 is at (0, n/2)
// 2. The position of the next number is at (i-1, j+1)
// 3. If the cell already contains the number (other then 0), then we check at
// position
// (i+2, j-1) relative to the taken cell 1r directly below the previous
// insertion (i+1, j).
// 4. We locking values of i and j to be within 0 and num - 1.
public class MagicSquaresOdd {

	public static int[][] magicSquareOdd(int num) {
		int i;
		int j;
		int val;
		int[][] res;

		i = 0;
		j = num / 2;
		val = 1;

		res = new int[num][num];

		while (val <= num * num) {
			if (i < 0 || i >= num) {
				i = (num + i) % num;
			}

			if (j < 0 || j >= num) {
				j = (num + j) % num;
			}

			if (res[i][j] != 0) {
				j--;
				i += 2;
				// Re-run and adjust i and j if needed, also check the value at new position.
				continue;
			}

			res[i][j] = val;

			i--;
			j++;
			val++;
		}

		return res;
	}

	public static void main(String[] args) {
		int num;
		int[][] res;

		num = 5;

		res = magicSquareOdd(num);

		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
