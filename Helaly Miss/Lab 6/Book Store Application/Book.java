package bookstore;

public class Book {
	String bookTitle;
	String bookAuthor;
	double price;
	int numOfCopies;

	public Book(String title, String author, double price, int copies) {
		this.bookAuthor = author;
		this.bookTitle = title;
		this.numOfCopies = copies;
		this.price = price;
	}

	public double getDiscountedPrice(float salePercentage) {
		double PriceAfterDiscount;
		return PriceAfterDiscount = (price) - (price * salePercentage) / 100;
	}

	public void increaseQuantity(int amt) {
		numOfCopies += amt;
	}

	void decreaseQuantity(int amt) {
		if (amt <= numOfCopies) {
			numOfCopies -= amt;
		} else {
			System.out.print("Insufficient copies\n");
		}
	}

	public String toString() {
		return "Title: " + bookTitle + "\tAuthor: " + bookAuthor + "\tQuantity: " + numOfCopies;
	}
}
