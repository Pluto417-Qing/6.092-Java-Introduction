import java.util.*;

public class Library {
    // Add the missing implementation to this class
	ArrayList<Book> collections;
	static String openingHours = "9am to 5pm";
	String address;
	
	Library(String addr){
		address = addr;
		collections = new ArrayList<Book>();
	}
	
	void addBook(Book newBook){
		collections.add(newBook);
	}
	
	static void printOpeningHours(){
		System.out.println("Libraries are open daily from " + openingHours);
	}
	
	void printAddress(){
		System.out.println(address);
	}
	
	void borrowBook(String borrowedBook){
		Boolean find = false;
		Boolean borrowed = false;
		for(Book book : collections){
			if(book.title.equals(borrowedBook)){
				if(book.borrowed){
					System.out.println("Sorry, this book is already borrowed.");
					return;
				} else {
					book.borrowed = true;
					System.out.println("You successfully borrowed " + borrowedBook);
					return;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	void printAvailableBooks(){
		if(collections.isEmpty()){
			System.out.println("No book in catalog");
			return;
		}
		for(Book book : collections){			
			if(!book.borrowed){
				System.out.println(book.title);
			}
		}
	}
	
	void returnBook(String returnedBook){
		for(Book book : collections){
			if(book.title.equals(returnedBook)){
				book.borrowed = false;
				System.out.println("You successfully returned " + returnedBook);
				return;
			}
		}
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 