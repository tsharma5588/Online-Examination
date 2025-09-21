import java.util.ArrayList;

public class Member {
    private String name;
    private ArrayList<Book> issuedBooks;

    public Member(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() { return name; }

    public ArrayList<Book> getIssuedBooks() { return issuedBooks; }

    public void issueBook(Book book) {
        if (book.isIssued()) {
            System.out.println("❌ Book already issued.");
            return;
        }
        book.setIssued(true);
        issuedBooks.add(book);
        System.out.println("✅ Book issued.");
    }

    public void returnBook(int bookId) {
        for (Book b : issuedBooks) {
            if (b.getId() == bookId) {
                b.setIssued(false);
                issuedBooks.remove(b);
                System.out.println("✅ Book returned.");
                return;
            }
        }
        System.out.println("❌ You don’t have this book.");
    }
}
