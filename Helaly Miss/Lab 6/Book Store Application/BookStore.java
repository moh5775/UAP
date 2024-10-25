package bookstore;

import java.util.ArrayList;

public class BookStore {
	String name;
	double totalSale;
	ArrayList<Book> books;

	public BookStore(String name) {
		this.name = name;
		this.totalSale = 0;
		this.books = new ArrayList<>();
	}

	public Book findBook(String bookTitle, String bookAuthor) {
		for (Book p : books) {
			if (p.bookTitle.equals(bookTitle) && p.bookAuthor.equals(bookAuthor)) {
				return p;
			}
		}

		return null;
	}

	public void sell(String bookTitle, String author, int noOfCopies, double salePercentage) {
		if (findBook(bookTitle, author) != null) {
			findBook(bookTitle, author).decreaseQuantity(noOfCopies);
			Book book = findBook(bookTitle, author);
			double price_of_1_Copy = book.getDiscountedPrice((float) salePercentage);
			totalSale += price_of_1_Copy * noOfCopies;
		} else {
			System.out.print("Book not found\n");
		}

	}

	public void order(String bookTitle, String author, double price, int noOfCopies) {
		Book book = findBook(bookTitle, author);
		if (book != null) {
			book.increaseQuantity(noOfCopies);
		} else {
			Book obj = new Book(bookTitle, author, price, noOfCopies);
			books.add(obj);
		}
	}

	public double getDiscountedPrice(String bookTitle, String author, float salePercentage) {
		Book book = findBook(bookTitle, author);
		if (book != null) {
			double discountedPrice = book.getDiscountedPrice(salePercentage);
			return discountedPrice;
		} else {
			System.out.print("Book Not found");
			return 0.0;
		}
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void display() {
		for (Book p : books) {
			System.out.println(p.toString());
		}
	}

}
