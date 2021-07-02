package by.practice.mod04.student;

import java.util.Arrays;
import java.util.Random;

//3. Создайте класс с именем Student, содержащий поля: 
//фамилия и инициалы, номер группы, успеваемость (массив из пяти элементов). 
//Создайте массив из десяти элементов такого типа. 
//Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
public class Student {
	private String name;
	private String initials;
	private int group;
	private int[] score;

	public Student(String name, String initials, int group, int[] score) {
		this.name = name;
		this.initials = initials;
		this.group = group;
		this.score = score;
	}

	public static void getTopPerformers(Student[] students) {
		for (Student st : students) {
			int counter = 0;

			for (int i = 0; i < st.score.length; i++) {
				if (st.score[i] >= 9) {
					counter++;
				}
			}

			if (counter == 5) {
				st.info();
			}
		}
	}

	public void info() {
		System.out.printf("|\t%20s\t|\t%9s\t|\t%20s\t|\n", name + " " + initials, group, Arrays.toString(score));
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	public static Student[] generate() {
		int i;
		int j;
		int idx;
		int group;
		int[] groups;
		int[] score;
		String[] names;
		String initials;
		Student[] students = new Student[10];
		String[] alfa = new String[26];
		Random rand = new Random();

		// Generating array of strings from A to Z;
		j = 0;
		for (char c = 'A'; c <= 'Z'; c++) {
			alfa[j] = String.valueOf(c);
			j++;
		}
		;

		groups = new int[] { 6147221, 6147220, 6145021, 6145020, 6145019 };

		score = new int[] { 9, 10, 9, 9, 9 };

		names = new String[] { "Butterbaugh", "Clovenhoof", "Clutterbuck", "Vinaigrette", "Fewhairs", "Goodpasture",
				"Guster", "Henderson", "Walkingstick", "Snuggleshine" };

		for (i = 0; i < names.length; i++) {
			// Getting 2 random letters for initials.
			idx = rand.nextInt(alfa.length);
			initials = alfa[idx] + ".";

			idx = rand.nextInt(alfa.length);
			initials += alfa[idx] + ".";

			idx = rand.nextInt(groups.length);
			group = groups[idx];

			Student st = new Student(names[i], initials, group, score);

			students[i] = st;
		}

		return students;
	}

	public static void main(String[] args) {
		Student[] stList = new Student[10];
		Student[] students = generate();

		stList[0] = new Student("Butterbaugh", "G.S.", 6147221, new int[] { 7, 5, 7, 9, 10 });
		stList[1] = new Student("Clovenhoof", "A.I.", 6147221, new int[] { 9, 7, 8, 8, 5 });
		stList[2] = new Student("Clutterbuck", "E.D.", 6147220, new int[] { 9, 10, 10, 9, 10 });
		stList[3] = new Student("Vinaigrette", "U.V.", 6147220, new int[] { 9, 10, 9, 10, 9 });
		stList[4] = new Student("Fewhairs", "W.T.", 6147220, new int[] { 9, 9, 9, 9, 9 });
		stList[5] = new Student("Goodpasture", "O.I.", 6145019, new int[] { 9, 9, 9, 9, 10 });
		stList[6] = new Student("Guster", "J.K.", 6145019, new int[] { 9, 10, 8, 9, 10 });
		stList[7] = new Student("Henderson", "P.J.", 6145019, new int[] { 9, 7, 7, 7, 9 });
		stList[8] = new Student("Walkingstick", "J.Z.", 6145020, new int[] { 9, 7, 8, 9, 9 });
		stList[9] = new Student("Snuggleshine", "O.I.", 6145020, new int[] { 9, 10, 9, 9, 9 });

		getTopPerformers(stList);
		getTopPerformers(students);
	}
}