import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int isbnNo;
    private String bookName;
    private String author;

    public int getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(int isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library {
    private ArrayList<Book> bookList = new ArrayList<>();

    public void addBook(Book bookObj) {
        bookList.add(bookObj);
    }

    public boolean isEmpty() {
        return bookList.isEmpty();
    }

    public ArrayList<Book> viewAllBooks() {
        return bookList;
    }

    public ArrayList<Book> viewBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public int countNoOfBooks(String bookName) {
        int count = 0;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Display all book details");
            System.out.println("3. Search Book by author");
            System.out.println("4. Count number of books - by book name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Book book = new Book();
                    System.out.print("Enter the ISBN number: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter the author name: ");
                    String author = scanner.nextLine();

                    book.setIsbnNo(isbn);
                    book.setBookName(bookName);
                    book.setAuthor(author);

                    library.addBook(book);
                    break;
                case 2:
                    ArrayList<Book> allBooks = library.viewAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("The list is empty");
                    } else {
                        for (Book b : allBooks) {
                            System.out.println("ISBN number: " + b.getIsbnNo());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the author name: ");
                    String searchAuthor = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.viewBooksByAuthor(searchAuthor);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("None of the books published by the author " + searchAuthor);
                    } else {
                        for (Book b : booksByAuthor) {
                            System.out.println("ISBN number: " + b.getIsbnNo());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the book name: ");
                    String searchBookName = scanner.nextLine();
                    int count = library.countNoOfBooks(searchBookName);
                    System.out.println("Count is " + count);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}
