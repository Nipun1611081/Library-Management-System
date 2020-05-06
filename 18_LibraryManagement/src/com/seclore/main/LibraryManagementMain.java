package com.seclore.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.seclore.interfaces.LibraryAdminService;
import com.seclore.interfaces.LibraryManagerService;
import com.seclore.pojo.Book;
import com.seclore.pojo.Member;
import com.seclore.pojo.Order;
import com.seclore.services.LibraryAdminServiceImpl;
import com.seclore.services.LibraryManagerServiceImpl;

public class LibraryManagementMain {
	public static void main(String[] args) {
		System.out.println("Welcome to the Library Management System");
		int roleChoice;
		String continueLibrary = "yes";
		Scanner scanner = new Scanner(System.in);

		while (continueLibrary.equalsIgnoreCase("yes")) {
			System.out.println("Please enter your Role: \n 1)Admin \n 2)Manager");
			roleChoice = scanner.nextInt();
			switch (roleChoice) {
			case 1: {
				libraryAdminConsole(scanner);
				break;
			}
			case 2: {
				libraryManagerConsole(scanner);
				break;
			}
			default: {
				System.out.println("Invalid choice");
				break;
			}
			}
			System.out.println("Do you want to explore the Library Management System?");
			continueLibrary = scanner.next();
			// only admin ka functionality
		}
		scanner.close();
	}

	public static void libraryAdminConsole(Scanner scanner) {
		LibraryAdminService libraryAdminService = new LibraryAdminServiceImpl();
		String continueChoice = "yes";
		int choice;
		System.out.println("Hello Admin");
		while (continueChoice.equalsIgnoreCase("yes")) {
			System.out.println("Enter your option \n 1)Add Book \n 2)Update Book \n 3)Delete Book \n"
					+ "\n 4)Add member \n 5)Update Member \n 6)Delete Member");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter book ID");
				String book_id = scanner.next();
				System.out.println("Enter Book Title");
				scanner.nextLine();
				String title = scanner.nextLine();
				System.out.println("Enter Author name");
				String author = scanner.nextLine();
				System.out.println("Is the book issuable? Type Y for yes and N for No");
				String issue = scanner.next();
				System.out.println("Enter the quantity of the book");
				int quantity = scanner.nextInt();
				Book book = new Book(book_id, title, author, issue, quantity);
				if (libraryAdminService.addBook(book)) {
					System.out.println("Book has been inserted successfully!");
				}
				break;
			}

			case 2: {
				System.out.println("Enter book ID to be updated");
				String book_id = scanner.next();
				System.out.println("Enter Book Title");
				scanner.nextLine();
				String title = scanner.nextLine();
				System.out.println("Enter Author name");
				String author = scanner.nextLine();
				System.out.println("Is the book issuable? Type Y for yes and N for No");
				String issue = scanner.next();
				System.out.println("Enter the quantity of the book");
				int quantity = scanner.nextInt();
				Book book = new Book(book_id, title, author, issue, quantity);
				if (libraryAdminService.updateBook(book)) {
					System.out.println("Book has been updated successfully!");
				}
				break;
			}

			case 3: {
				System.out.println("Enter book ID to be deleted");
				String book_id = scanner.next();
				if (libraryAdminService.deleteBook(book_id)) {
					System.out.println("Book deleted successfully");
				}
				break;
			}

			case 4: {
				System.out.println("Enter member ID");
				String member_id = scanner.next();
				System.out.println("Enter Name of Member");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Is the Member a teacher or a student? Type T for teacher and S for Student");
				String member_type = scanner.next();
				Member member = new Member(member_id, name, member_type);
				if (libraryAdminService.addMember(member)) {
					System.out.println("Member has been inserted successfully!");
				}
				break;
			}

			case 5: {
				System.out.println("Enter member ID to be updated");
				String member_id = scanner.next();
				System.out.println("Enter Name of Member");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Is the Member a teacher or a student? Type T for teacher and S for Student");
				String member_type = scanner.next();
				Member member = new Member(member_id, name, member_type);
				if (libraryAdminService.updateMember(member)) {
					System.out.println("Member has been inserted successfully!");
				}
				break;
			}

			case 6: {
				System.out.println("Enter member ID to be deleted");
				String member_id = scanner.next();
				if (libraryAdminService.deleteMember(member_id)) {
					System.out.println("Member deleted successfully");
				}
				break;
			}

			default: {
				System.out.println("Invalid choice!");
				break;
			}
			}
			System.out.println("Do you want to continue as Admin?");
			continueChoice = scanner.next();
		}

	}

	public static void libraryManagerConsole(Scanner scanner) {
		System.out.println("Welcome Manager!");
		LibraryAdminService libraryAdminService = new LibraryAdminServiceImpl();
		Order order;
		LibraryManagerService libraryManagerService = new LibraryManagerServiceImpl();
		String continueChoice = "yes", dateChoice = "no";
		int choice;
		java.sql.Date issueDate = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date returnDate = new java.sql.Date(System.currentTimeMillis());
		while (continueChoice.equalsIgnoreCase("yes")) {
			libraryManagerService.getRecord();
			System.out.println("Enter your option \n 1)Issue Book \n 2)Return Book \n 3)Delete Record");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				libraryManagerService.showOrder_id();
				Book book = new Book();
				Member member = new Member();
				System.out.println("Enter member code");
				String member_code = scanner.next();
				member = libraryManagerService.getMember(member_code);
				if (member.getMember_code() == null) {
					System.out.println("Not a registered member");
					break;
				}
				if (member.getIssue_capacity() == 0) {
					System.out.println("Sorry! You cannot issue any more book");
					break;
				}
				System.out.println("Welcome " + member.getName());
				System.out.println("Enter book code");
				String book_code = scanner.next();
				book = libraryManagerService.getBook(book_code);
				if (book.getBook_code() == null) {
					System.out.println("Invalid  code. Please try again!");
					break;
				}
				if (book.getQuantity() == 0) {
					System.out.println("Sorry! The book is out of stock");
					break;
				}
				if (book.getIssue_book().equalsIgnoreCase("N")) {
					System.out.println("This book cannot be issued");
					break;
				}
				System.out.println("Book title: " + book.getTitle() + " Book Author:" + book.getAuthor());

				System.out.println("Issue date is: " + issueDate);
				System.out.println("Do you want to change the date? Yes/No");
				dateChoice = scanner.next();
				if (dateChoice.equalsIgnoreCase("yes")) {
					System.out.println("Enter new date in YYYY-MM-DD format");
					String changeDate = scanner.next();
					issueDate = java.sql.Date.valueOf(changeDate);
				}
				returnDate = getReturnDate(issueDate, member.getMember_type());
				System.out.println("Your return date is: " + returnDate);
				order = new Order(member, book, issueDate, returnDate, "Issued");
				if (libraryManagerService.issueBook(order)) {
					System.out.println("Book has been issued successfully!");
					order.getMember().setIssue_capacity(order.getMember().getIssue_capacity() - 1);
					order.getBook().setQuantity(order.getBook().getQuantity() - 1);
					libraryAdminService.updateBook(book);
					libraryAdminService.updateMember(member);

				}
				break;
			}

			case 2: {
				System.out.println("Enter order id of book to be returned");
				int order_id = scanner.nextInt();
				order = libraryManagerService.getOrder(order_id);
				if (order.getStatus().equalsIgnoreCase("Returned")) {
					System.out.println("Book has already been returned!");
					break;
				}
				if (libraryManagerService.returnBook(order_id)) {
					System.out.println("Book returned successfully!");
					order.getMember().setIssue_capacity(order.getMember().getIssue_capacity() + 1);
					order.getBook().setQuantity(order.getBook().getQuantity() + 1);
					libraryAdminService.updateBook(order.getBook());
					libraryAdminService.updateMember(order.getMember());
				} else {
					System.out.println("Sorry! Couldn't process your request.");
				}
				break;
			}

			case 3: {
				System.out.println("Enter order id of book to be deleted");
				int order_id = scanner.nextInt();
				if (libraryManagerService.deleteBook(order_id)) {
					System.out.println("Record returned successfully!");
				} else {
					System.out.println("Sorry! Couldn't process your request.");
				}
				break;
			}

			default: {
				System.out.println("Invalid choice!");
				break;
			}
			}
			System.out.println("Do you want to continue as Manager?");
			continueChoice = scanner.next();
		}
	}

	public static java.sql.Date getReturnDate(java.sql.Date issueDate, String member_type) {
		String returnDay;
		File file = new File(".\\src\\date.properties"); // for relative path
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (member_type.equalsIgnoreCase("T")) {
			returnDay = properties.getProperty("teacherReturnDate");
		} else {
			returnDay = properties.getProperty("studentReturnDate");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(issueDate);
		c.add(Calendar.DATE, Integer.parseInt(returnDay));
		java.sql.Date returnDate = new java.sql.Date(c.getTimeInMillis());
		return returnDate;
	}
}
