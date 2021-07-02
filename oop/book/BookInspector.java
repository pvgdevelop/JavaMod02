package by.jonline.modx.oop.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Задача 3.
//Данное задание вам может показаться тяжелым и вы не сразу будете
//знать как его решить, или как правильно решить. В этой задаче главное
//воспользоваться всеми уже полученными знаниями и решить как
//получается.
//Создать класс Book, спецификация которого приведена ниже. 
//-Определить конструкторы
//-set- и get- методы.
//-Создать второй класс, агрегирующий массив типа Book
//-с подходящими конструкторами и методами. 
//-Задать критерии выбора данных и 
//- вывести эти данные на консоль.
//
//-Book: id, название, автор(ы), издательство, год издания, 
//количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных после заданного года.
//
public class BookInspector {

	public static void main(String[] args) {
		Library lib = new Library();
		ArrayList<Book> books = new ArrayList<Book>();

		String booksFile = "src/by/jonline/modx/oop/book/books.txt";

		Book b = new Book();
		System.out.println(b);

		try {
			File myObj = new File(booksFile);
			Book book;
			Scanner myReader = new Scanner(myObj);
			String[] fields;
			int count = 0;
			int id;
			String title;
			String author;
			String cover;
			int price;


			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				if (count == 0) {
					count++;
               		continue; // Skipping headers
				}

				fields = data.split(",");


				book = new Book();

				book.setId(Integer.parseInt(fields[0]));
				book.setTitle(fields[1]);
				book.setAuthor(fields[2]);
				book.setCover(fields[3]);
				book.setPrice(Integer.parseInt(fields[4]));
		
				lib.add(book);

				System.out.println("ID: " + Integer.parseInt(fields[0]));
				System.out.println(Arrays.toString(fields));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
