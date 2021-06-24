package by.tc.mod2.alg.magicsquare;

import java.util.Arrays;

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
public class MagicSquareDoublyEven {

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
				//Bottom half
				if (i >= num / 2) {
					if (j % 2 == 0) {
						val = num - 1 - i;
					} else {
						val = i;
					}
				//Top half
				} else {
					// Obtaining the value from the bottom half mimicking vertical reflection. 
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
	
	public static void main(String[] args) {
		int num;
		int[][] res;
		
		num = 4;
		
		res = magicSquareDoubleEven(num);
		
		for(int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
