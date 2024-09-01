import java.util.ArrayList;//package define//
import java.util.*;
//book class// 
class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    private String isbn;
    private String publicationyear;

    public Book(String title, String author,String isbn,String publicationyear ) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
        this.isbn=isbn;
        this.publicationyear= publicationyear;
    }
   
    

    public String getTitle() {
        return title;
    }
    public String getIsbn(){
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
//is borrowed function create (book is avilable or not)//
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("You borrowed: " + title);
        } else {
            System.out.println("Sorry, this book is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You returned: " + title);
        } else {
            System.out.println("This book wasn't borrowed.");
        }
    }

   
    public String toString() {
        return "Title: " + title + ", Author: " + author + " , publicationyear: "+ publicationyear +" , Isbn: "+ isbn +", Available: "+!isBorrowed;
    }
}


class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }
  //ADD BOOK FUNCTION//
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
        System.out.println("--------------------------------------------------------------------");

    }
 //VIEW AVILABLE BOOK FUNCTION//
    public void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        System.out.println("--------------------------------------------------------------------");

        }
    }
 //Borrow book Function//
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
//Return Book Function//
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

//main function//
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Available Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter ISBN Code Number: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publicationyear: ");
                    String publicationyear = scanner.nextLine();
                    System.out.println("--------------------------------------------------------------------");
                    library.addBook(new Book(title, author,isbn, publicationyear));
                    
                    
                    break;
                case 2:
                    System.out.println("--------------------------------------------------------------------");
                    library.viewAvailableBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.println("--------------------------------------------------------------------");
                    library.borrowBook(borrowTitle);
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.println("--------------------------------------------------------------------");
                    library.returnBook(returnTitle);
                    System.out.println("--------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.out.println("--------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("--------------------------------------------------------------------");
            }
        } while (choice != 5);
        System.out.println("--------------------------------------------------------------------");
        scanner.close();
    }
}
