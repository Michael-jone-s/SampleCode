package LibraryManagement;

import java.util.Scanner;

public class LibraryManagement {
    private static final String[] BOOK_NAMES = {"Book_1", "Book_2", "Book_3"};
    private static final String[] AUTHOR_NAMES = {"Author_1", "Author_2", "Author_3"};
    private static final int[] AVAILABLE_COPIES = {2, 1, 3};

    public static void main(String[] args) {
        Library library = new Library(BOOK_NAMES, AUTHOR_NAMES, AVAILABLE_COPIES);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the number of the operation you want to perform: ");
            System.out.println("1. Search Book by Book Name");
            System.out.println("2. Search Book by Author Name");
            System.out.println("3. Search Book by Both");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String bookName = scanner.next();
                    library.searchBookByBookName(bookName);
                    break;
                case 2:
                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.next();
                    library.searchBookByAuthorName(authorName);
                    break;
                case 3:
                    System.out.print("Enter Book Name: ");
                    bookName = scanner.next();
                    System.out.print("Enter Author Name: ");
                    authorName = scanner.next();
                    library.searchBookByBoth(bookName, authorName);
                    break;
                case 4:
                    System.out.print("Enter Book Name: ");
                    bookName = scanner.next();
                    library.issueBook(bookName);
                    break;
                case 5:
                    System.out.print("Enter Book Name: ");
                    bookName = scanner.next();
                    library.returnBook(bookName);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operation number. Please try again.");
            }
        }
    }
}
