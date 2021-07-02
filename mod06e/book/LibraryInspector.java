package by.practice.mod06e.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// 	Задача 3.
// 	Данное задание вам может показаться тяжелым и вы не сразу будете
// 	знать как его решить, или как правильно решить. В этой задаче главное
// 	воспользоваться всеми уже полученными знаниями и решить как
// 	получается.
// 	Создать класс Book, спецификация которого приведена ниже. 
// 	-Определить конструкторы
// 	-set- и get- методы.
//	-Создать второй класс, агрегирующий массив типа Book
//	-с подходящими конструкторами и методами. 
//	-Задать критерии выбора данных и 
//	- вывести эти данные на консоль.
//
//	-Book: id, название, автор(ы), издательство, год издания, 
//	количество страниц, цена, тип переплета.
// 
//	Найти и вывести:
// 		a) список книг заданного автора;
// 		b) список книг, выпущенных после заданного года.
//
public class LibraryInspector {

	// Create library by parsing CSV file with books data
	public static Library parseBooksData() {
		Library lib = new Library();

		String booksFile = "src/by/practice/mod06e/book/book.csv";

		try {
			Book book;
			Scanner myReader = new Scanner(new File(booksFile));
			int count = 0;

			while (myReader.hasNextLine()) {
				book = new Book();
				String data = myReader.nextLine();

				if (count == 0) {
					count++;
					continue; // Skipping header
				}

				String[] fields = data.split("::");

				String title = fields[0];
				String author = fields[1];
				String publisher = fields[2];
				int yearPublished = Integer.parseInt(fields[3]);
				int pages = Integer.parseInt(fields[4]);
				double price = Double.parseDouble(fields[5]);
				String cover = fields[6];
				String isbn = fields[7];

				book.setTitle(title);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setYearPublished(yearPublished);
				book.setPages(pages);
				book.setPrice(price);
				book.setCover(cover);
				book.setIsbn(isbn);

				lib.add(book);

			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return lib;
	}

	public static void main(String[] args) {
		Library lib = parseBooksData();
		Book book;
		Book book1;
		ArrayList<Book> res1;
		ArrayList<Book> res2;

		// Book not in library - throws exception
		// book1 = new Book();
		// lib.findById(book1.getId()); 

		res1 = lib.findByAuthor("Lepidus");
		res2 = lib.findByYearPublishedAfter(2009);
		book = lib.findById(50);
		
		for (Book b : res1) {
			System.out.println(b);
		}

		System.out.println();

		for (Book b : res2) {
			System.out.println(b);
		}
		
		System.out.println();
		System.out.println(book);

	}
}
