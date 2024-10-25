package bookapp;

import java.util.Scanner;

import bookstore.BookStore;

public class BookStoreApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter store name:");
		String name = input.nextLine();
		BookStore store = new BookStore(name);
		while (true) {
			System.out.print(
					"\n1: display all books\n2: display the information of a specific book.\n3: order one or more books.\n4: sell one or more books.\n5: view the discounted price of a book.\n6: display the totalSale.\n0: exit\n");
			System.out.print("\nEnter your choice: ");
			int option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1:
				store.display();
				break;
			case 2:
				System.out.print("Title: ");
				String Title = input.nextLine();
				System.out.print("Author: ");
				String Author = input.nextLine();
				System.out.println(store.findBook(Title, Author));

				break;
			case 3:
				System.out.print("Title: ");
				String Book_title = input.nextLine();
				System.out.print("Author: ");
				String Book_author = input.nextLine();
				System.out.print("Number of copies: ");
				int noOfCopy = input.nextInt();
				System.out.print("Price: ");
				double price = input.nextDouble();
				store.order(Book_title, Book_author, price, noOfCopy);
				break;
			case 4:
				System.out.print("Title: ");
				String title = input.nextLine();
				System.out.print("Author: ");
				String author = input.nextLine();
				System.out.print("Number of copies: ");
				int noOfCopies = input.nextInt();
				System.out.print("Sale Perccentage: ");
				float percentage = input.nextFloat();
				store.sell(title, author, noOfCopies, percentage);
				break;
			case 5:
				System.out.print("Title: ");
				String bookTitle = input.nextLine();
				System.out.print("Author: ");
				String bookAuthor = input.nextLine();
				System.out.print("Discount: ");
				float discount = input.nextFloat();
				System.out.println("Discounted price: " + store.getDiscountedPrice(bookTitle, bookAuthor, discount));
				break;
			case 6:
				System.out.println("Total sale: " + store.getTotalSale());
				break;
			case 0:
				break;
			}
		}
	}
}
