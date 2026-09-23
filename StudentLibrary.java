import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }
}

class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class StudentLibrary {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        books.add(new Book(101, "Java Programming"));
        books.add(new Book(102, "Data Structures"));
        books.add(new Book(103, "Artificial Intelligence"));

        students.add(new Student(1, "Sathwika"));

        int choice;

        do {
            System.out.println("\n===== STUDENT LIBRARY MANAGEMENT =====");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayBooks();
                    break;

                case 2:
                    searchBook();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    displayStudents();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void displayBooks() {
        System.out.println("\n--- BOOK LIST ---");

        for (Book b : books) {
            System.out.println(
                b.getId() + " - " +
                b.getTitle() + " - " +
                (b.isIssued() ? "Issued" : "Available")
            );
        }
    }

    static void searchBook() {
        System.out.print("Enter book title: ");
        sc.nextLine();
        String title = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found!");
                System.out.println("Book ID: " + b.getId());
                System.out.println("Status: " +
                    (b.isIssued() ? "Issued" : "Available"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isIssued()) {
                    b.issueBook();
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    static void displayStudents() {
        System.out.println("\n--- STUDENT LIST ---");

        for (Student s : students) {
            System.out.println(
                "ID: " + s.getId() +
                ", Name: " + s.getName()
            );
        }
    }
}