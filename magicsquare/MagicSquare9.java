package by.tc.mod2.alg.magicsquare;

public class MagicSquare9 {

	// Magic Squares of order-9
	// Taken from https://grogono.com/magic/9x9.php
	public static Square[] make4Squares(int num) {
		int value;
		int shift;
		Square[] squares;

		squares = new Square[4];

		for (int i = 0; i < squares.length; i++) {
			squares[i] = new Square();
			squares[i].arr = new int[num][num];
		}

		shift = 0;

		for (int i = 0; i < num; i++) {
			if (i % 3 == 0 && i != 0) {
				shift++;
			}

			for (int j = 0; j < num; j++) {
				value = (j + shift) % 3;

				squares[0].arr[i][j] = value;
				squares[1].arr[j][i] = value; // sq2 twisting first along main diagonal
				squares[2].arr[num - 1 - j][i] = value; // sq3 - reflecting sq2 horizontally
				squares[3].arr[num - 1 - i][j] = value; // sq4 - reflecting sq1 horizontally
			}
		}
		return squares;
	}

	public static int[][] makeMagicSquare9(int num) {
		int val;
		int resValue;
		int[][] res;
		Square[] squares;

		squares = make4Squares(num);

		res = new int[9][9];

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				resValue = 0;
				for (int idx = 0; idx < squares.length; idx++) {
					val = squares[idx].arr[i][j];
					// resulting value for each cell is combination of 4 values from 4 squares
					//Example: 1 1 0 2 when applied to valueTable, we get 4 numbers - 27 + 9 + 0 + 2 = 38
					resValue += valueTable(val, idx);
				}
				//Original Example start from 0, thats why we add 1
				res[i][j] = resValue + 1;
			}
		}
		return res;
	}

	public static int valueTable(int value, int index) {
		int[][] arr;

		arr = new int[3][4];

		arr[0] = new int[] { 0, 0, 0, 0 };
		arr[1] = new int[] { 27, 9, 3, 1 };
		arr[2] = new int[] { 54, 18, 6, 2 };

		return arr[value][index];
	}

	public static void main(String[] args) {
		int num;
		int[][] res;

		num = 9;
		res = makeMagicSquare9(num);
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (res[i][j] < 10) {
					System.out.print(0);
						
				}
				System.out.print(res[i][j] + " ");				
			}
			System.out.println();
		}
	}
}

class Square {
	int[][] arr;
}
