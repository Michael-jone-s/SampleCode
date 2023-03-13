package LibraryManagement;

public class Library {
    private final String[] bookNames;
    private final String[] authorNames;
    private final int[] availableCopies;

    public Library(String[] bookNames, String[] authorNames, int[] availableCopies) {
        this.bookNames = bookNames;
        this.authorNames = authorNames;
        this.availableCopies = availableCopies;
    }

    public void searchBookByBookName(String bookName) {
        boolean found = false;
        for (int i = 0; i < bookNames.length; i++) {
            if (bookNames[i].equalsIgnoreCase(bookName)) {
                System.out.println("Book found! Author: " + authorNames[i] + ", Available Copies: " + availableCopies[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public void searchBookByAuthorName(String authorName) {
        boolean found = false;
        for (int i = 0; i < authorNames.length; i++) {
            if (authorNames[i].equalsIgnoreCase(authorName)) {
                System.out.println("Book found! Name: " + bookNames[i] + ", Available Copies: " + availableCopies[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public void searchBookByBoth(String bookName, String authorName) {
        boolean found = false;
        for (int i = 0; i < bookNames.length; i++) {
            if (bookNames[i].equalsIgnoreCase(bookName) && authorNames[i].equalsIgnoreCase(authorName)) {
                System.out.println("Book found! Available Copies: " + availableCopies[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public void issueBook(String bookName) {
        boolean found = false;
        for (int i = 0; i < bookNames.length; i++) {
            if (bookNames[i].equalsIgnoreCase(bookName) && availableCopies[i] > 0) {
                availableCopies[i]--;
                System.out.println("Book issued successfully! Available Copies: " + availableCopies[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found or not available!");
        }
    }

    public void returnBook(String bookName) {
        boolean found = false;
        for (int i = 0; i < bookNames.length; i++) {
            if (bookNames[i].equalsIgnoreCase(bookName)) {
                availableCopies[i]++;
                System.out.println("Book returned successfully! Available Copies: " + availableCopies[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }
}
