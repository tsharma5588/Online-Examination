import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Welcome to Library Management System ====");
        System.out.print("Login as (admin/user): ");
        String role = sc.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.print("Enter Admin Password: ");
            String pass = sc.nextLine();
            if (!pass.equals("admin123")) {
                System.out.println("❌ Invalid password.");
                return;
            }

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- Admin Menu ---");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. View All Books");
                System.out.println("4. Add Member");
                System.out.println("5. View Members");
                System.out.println("6. Exit");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        library.addBook(sc);
                        break;
                    case 2:
                        library.deleteBook(sc);
                        break;
                    case 3:
                        library.viewBooks();
                        break;
                    case 4:
                        library.addMember(sc);
                        break;
                    case 5:
                        library.viewMembers();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } else if (role.equalsIgnoreCase("user")) {
            System.out.print("Enter Member Name: ");
            String name = sc.nextLine();
            Member member = library.findMemberByName(name);

            if (member == null) {
                System.out.println("❌ Member not found.");
                return;
            }

            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- User Menu ---");
                System.out.println("1. View Books");
                System.out.println("2. Search Book");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Send Email Query");
                System.out.println("6. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        library.viewBooks();
                        break;
                    case 2:
                        library.searchBook(sc);
                        break;
                    case 3:
                        library.issueBook(sc, member);
                        break;
                    case 4:
                        library.returnBook(sc, member);
                        break;
                    case 5:
                        System.out.print("Enter your message: ");
                        String msg = sc.nextLine();
                        System.out.println("📧 Email sent to admin: " + msg);
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } else {
            System.out.println("❌ Invalid role.");
        }

        sc.close();
    }
}
