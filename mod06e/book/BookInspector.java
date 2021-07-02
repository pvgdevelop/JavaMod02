package by.practice.mod06e.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

		String booksFile = "src/by/practice/mod06e/book/book.csv";

		Book b = new Book();
		System.out.println(b);

		try {
			Book book;
			Scanner myReader = new Scanner(new File(booksFile));
			int count = 0;
						
			while (myReader.hasNextLine()) {
				book = new Book();
				String data = myReader.nextLine();
			
				if (count == 0) {
					count++;
					continue; // Skipping headers
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


		ArrayList<Book> res = lib.findByAuthor("Lepidus");	
			
		for ( Book book : res) {
			System.out.println(book);	
		}
		
		System.out.println();
		
		ArrayList<Book> res1 = lib.findByYearPublishedAfter(2009);	
			
		for ( Book book : res1) {
			System.out.println(book);	
		}
				
	}
}
