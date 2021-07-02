package by.practice.mod02.array2d;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//8. В числовой матрице поменять местами два столбца любых столбца,
//т. е. все элементы одного столбца поставить на соответствующие им 
//позиции другого, а его элементы второго переместить в первый. 
//Номера столбцов вводит пользователь с клавиатуры.
public class Task08 {

	public static int[][] swapColumns(int[][] arr, int col1, int col2) {
		int temp;
		int first;
		int second;
		int[][] newArr;

		first = col1 - 1;
		second = col2 - 1;

		newArr = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newArr[i][j] = arr[i][j];
			}

			temp = newArr[i][first];

			newArr[i][first] = newArr[i][second];
			newArr[i][second] = temp;
		}

		return newArr;
	}

	public static int[][] makeMatrix(int rows, int cols) {
		int[][] arr = new int[rows][cols];
		Random rand = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[i][j] = rand.nextInt(10);
			}
		}

		return arr;
	}

	@SuppressWarnings("resource")
	public static int getUserInput(String message) {
		int num;

		Scanner sc = new Scanner(System.in);
		System.out.print(message);

		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Invalid entry.");
			System.out.print(message);
		}

		num = sc.nextInt();

		if (num <= 0) {
			return getUserInput(message);
		}

		return num;
	}

	public static boolean isValid(int num1, int num2, int max) {
		boolean res;

		res = num1 != num2;
		res = res && num1 > 0 && num1 <= max;
		res = res && num2 > 0 && num2 <= max;

		return res;
	}

	public static void main(String[] args) {
		int rows;
		int cols;
		int col1;
		int col2;
		int[][] arr;
		int[][] res;

		rows = getUserInput("Enter number of ROWS >> ");
		cols = getUserInput("Enter number of COLUMNS >> ");

		System.out.println();

		arr = makeMatrix(rows, cols);

		System.out.println("Initial Matrix");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println();

		System.out.println("Enter columns to swap (1-" + cols + ")");

		col1 = getUserInput("Enter 1nd column >> ");
		col2 = getUserInput("Enter 2nd column >> ");

		System.out.println();

		if (!isValid(col1, col2, cols)) {
			System.out.println("Invalid entry for col1 and/or col2.");
			System.out.println("Hint: col1 != col2, col1, col2 > 0, col1, col2 <= " + cols);
			System.out.println("Program terminated.");
			System.exit(1);
		}

		res = swapColumns(arr, col1, col2);

		System.out.println("Swapped columns " + col1 + " and " + col2);

		for (int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}