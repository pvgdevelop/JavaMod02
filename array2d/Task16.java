package by.tc.mod2.alg.array2d;

import java.util.Arrays;

// 16. Магическим квадратом порядка n называется квадратная матрица 
// размера nxn, составленная из чисел 1, 2, 3, ..., n2 так, что 
// суммы по каждому столбцу, каждой строке и каждой из 
// двух больших диагоналей равны между собой. 
// Построить такой квадрат. Пример магического квадрата порядка 3:
// [6 1 8]
// [7 5 3]
// [2 9 4]
public class Task16 {

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
	// Reference https://schoolbag.info/mathematics/numbers/60.html
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
	// Reference https://schoolbag.info/mathematics/numbers/61.html
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

		// Step 3 Switch first m columns of A and D 
		// taking into the account an offset of j+1 for the middle row
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

	// Double-even order Magic Square: (4*N) -> 4, 8, 12, 16, ...
	// 1. We build a first Latin square of N-order so, that each row of the bottom
	// half of the square
	// is filled by alternating i and n - i - 1,
	// where i - row index.
	// Second half of the square is obtained by reflecting the bottom half around
	// vertical axis
	// 2. We build the 2nd Latin square by turning the first one 90 degrees
	// clockwise.
	// 3. The Magic Square we then get by combining values of two Latin squares
	// with following formula: Cij = N * Aij + Bij
	// Reference http://www.klassikpoez.narod.ru/latsov.htm
	public static int[][] magicSquareDoubleEven(int num) {
		int val;
		int[][] res;
		int[][] sq1;
		int[][] sq2;

		sq1 = new int[num][num];
		sq2 = new int[num][num];
		res = new int[num][num];

		// Step 1 and 2: creating 2 sub-squares.
		for (int i = num - 1; i >= 0; i--) {
			for (int j = num - 1; j >= 0; j--) {

				if (i >= num / 2) { // Bottom half
					if (j % 2 == 0) {
						val = num - 1 - i;
					} else {
						val = i;
					}
				} else { // Top half 
					// Obtaining the value from the bottom half while mimicking vertical reflection.
					// Example: (j = 0 -> j = n - 1 - 0; j = 1 -> j = n - 1 - 1 etc.)
					val = sq1[num / 2 + i][num - 1 - j];
				}

				sq1[i][j] = val;
				sq2[j][num - 1 - i] = val; // Rotating first square 90 degrees clockwise.
			}
		}

		// Step 3
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				res[i][j] = num * sq1[i][j] + sq2[i][j] + 1;
			}
		}

		return res;
	}

	public static boolean isMagic(int[][] arr) {
		int num;
		long sumRow;
		long sumCol;
		long sumDiag1;
		long sumDiag2;
		long temp;
		boolean res;

		num = arr.length;
		sumDiag1 = 0;
		sumDiag2 = 0;
		temp = 0;

		for (int i = 0; i < num; i++) {
			sumRow = 0;
			sumCol = 0;

			sumDiag1 += arr[i][i];
			sumDiag2 += arr[i][num - 1 - i];

			for (int j = 0; j < num; j++) {
				sumRow += arr[i][j];
				sumCol += arr[j][i];
			}

			res = sumRow == sumCol;
			temp = sumRow;

			if (!res) {
				return false;
			}
		}

		res = temp == sumDiag1 && sumDiag1 == sumDiag2;

		return res;
	}

	public static void main(String[] args) {
		int num;
		int[][] arr;

		// !!!!!!!!!!!!!!!!!!!!!!!!!
		// ENTER SQUARE SIZE HERE!!!
		num = 6;
		// !!!!!!!!!!!!!!!!!!!!!!!!!

		arr = new int[0][];

		if (num < 3) {
			System.out.println("There are no magic squares of orders less then 3.");
			System.out.println("Program terminated.");
			System.exit(1);
		} else if ((long) num * num * num > Integer.MAX_VALUE) {
			System.out.println("Num is to high");
			System.out.println("Program terminated.");
			System.exit(1);
		}

		if (num % 2 != 0) {
			arr = magicSquareOdd(num);
		} else if (num % 4 == 0) {
			arr = magicSquareDoubleEven(num);
		} else if (num % 2 == 0) {
			arr = magicSquareSingleEven(num);
		}

		if (arr.length != 0) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
		}

		System.out.println();

		if (isMagic(arr)) {
			System.out.println("The square is Magic :)");
		} else {
			System.out.println("The square is not Magic :(");
		}
	}
}