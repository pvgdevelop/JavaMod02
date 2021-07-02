package by.practice.mod06e.book;

import java.util.ArrayList;
import java.lang.*;

// Singleton Class
public class LibraryLogic {
	private static final LibraryLogic instance = new LibraryLogic();
	
	
	private LibraryLogic() {}
	

	public static LibraryLogic getInstance() {
		return instance;
	}

	// Assuming books are sorted in library (which may not be the case)
	public static Book findById(ArrayList<Book> books, int id) {
		return _binarySearch(books, id);
	}
	

	private static Book _binarySearch(ArrayList<Book> list, int key) {
		Book res;
		int mid;
		int id;
		int from;
		int to;

		from = 0;
		to = list.size();
				
		while (from <= to) {
			mid = (from + to) / 2;

			res = list.get(mid);
	    	id = res.getId();
			
			if (id == key) {
				return res;
			}
			else if (from == to) {
				break;
			} else if (id > key) {
				to = mid;
			} else if (id < key) {
				from = mid + 1;
			}
		}
		
		throw new RuntimeException(String.format("Book with id=%s doesn't exist", key));
	}
}
