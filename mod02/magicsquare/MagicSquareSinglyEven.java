package by.practice.mod02.magicsquare;

import java.util.Arrays;

// Reference https://schoolbag.info/mathematics/numbers/61.html
// 1. We divide single-even order square into 4 odd order ones, and call the
// (A,B,C,D)
// We denote the order as k = 2m + 1 (k = n/2) -> for 6-sided square k = 3, m =
// 1;0
// 2. We build square A,
// Square B is obtained by adding k^2 = 9 to all numbers of square A.
// Square C is obtained by adding k^2 to all numbers of square B,
// Square D is obtained by adding k^2 to all numbers of square C.
// 3. The adjustments will be the following:
// We first take the numbers in the first m positions in each row of quadrant A,
// except the middle row, where we will skip the first position and
// then take the next m positions.
// Then we will exchange the numbers in these positions with the correspondingly
// placed
// numbers in square D below.
// 4. We then take the last m – 1 cells in each row of square C and
// exchange them with the numbers in the corresponding cells of square B.
public class MagicSquareSinglyEven {

	public static int[][] magicSquareSingleEven(int num) {
		int k; // size of odd squares
		int m; // multiplier
		int[][] temp;
		int[][] sqA;
		int[][] sqB;
		int[][] sqC;
		int[][] sqD;
		int[][] res;

		res = new int[num][num];

		k = num / 2;
		m = (k - 1) / 2; // k = 2m + 1

		sqA = magicSquareOdd(k);

		sqB = new int[k][k];
		sqC = new int[k][k];
		sqD = new int[k][k];
		temp = new int[k][k];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				sqB[i][j] = sqA[i][j] + k * k;
				sqC[i][j] = sqB[i][j] + k * k;
				sqD[i][j] = sqC[i][j] + k * k;
			}
		}

		// Step 3 Switch first m columns of A and D (there is offset j+1 for the middle
		// row)
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < m; j++) {
				if (i == k / 2) {
					temp[i][j + 1] = sqA[i][j + 1];
					sqA[i][j + 1] = sqD[i][j + 1];
					sqD[i][j + 1] = temp[i][j + 1];
				} else {
					temp[i][j] = sqA[i][j];
					sqA[i][j] = sqD[i][j];
					sqD[i][j] = temp[i][j];
				}
			}
		}

		// Step 4 Switch last (m - 1) columns of C and B
		for (int i = 0; i < k; i++) {
			if (m - 1 == 0)
				break;

			// Determining the index of first column thats being switched.
			// m - 1 -> k - (m - 1) = k - m + 1
			for (int j = k - m + 1; j < k; j++) {
				temp[i][j] = sqC[i][j];
				sqC[i][j] = sqB[i][j];
				sqB[i][j] = temp[i][j];
			}
		}

		// Combine the squares like so:
		// [A][C]
		// [D][B]
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				res[i][j] = sqA[i][j];
				res[i][j + k] = sqC[i][j];
				res[i + k][j] = sqD[i][j];
				res[i + k][j + k] = sqB[i][j];
			}
		}

		return res;
	}
	
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

		num = 6;
		
		res = magicSquareSingleEven(num);
				
		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
