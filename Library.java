import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private int bookIdCounter = 1;

    public void addBook(Scanner sc) {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        books.add(new Book(bookIdCounter++, title, author));
        System.out.println("✅ Book added.");
    }

    public void deleteBook(Scanner sc) {
        System.out.print("Enter book ID to delete: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                books.remove(b);
                System.out.println("✅ Book deleted.");
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books available.");
        } else {
            for (Book b : books) b.display();
        }
    }

    public void searchBook(Scanner sc) {
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword) || b.getAuthor().toLowerCase().contains(keyword)) {
                b.display();
                found = true;
            }
        }
        if (!found) System.out.println("❌ No books found.");
    }

    public void addMember(Scanner sc) {
        System.out.print("Enter member name: ");
        String name = sc.nextLine();
        members.add(new Member(name));
        System.out.println("✅ Member added.");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("📭 No members found.");
        } else {
            for (Member m : members) {
                System.out.println("- " + m.getName());
            }
        }
    }

    public Member findMemberByName(String name) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public void issueBook(Scanner sc, Member m) {
        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                m.issueBook(b);
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    public void returnBook(Scanner sc, Member m) {
        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        m.returnBook(id);
    }
}
