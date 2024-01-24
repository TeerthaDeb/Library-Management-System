/**
 * The Book class represents a book object with properties such as title, author, genre, year, price,
 * and ISBN, and includes methods for setting and getting these properties, as well as methods for
 * creating a book object from a string, cloning a book object, checking equality with another book
 * object, and checking if the year is within a certain range.
 */


// --------------------------------------------------------------------
// Assignment : 3
// Part: BookClass
// Written by: Maharaj Teertha Deb (40227747)
// --------------------------------------------------------------------


/**
 * The Book class represents a book object.
 */
public class Book {
	private String title , author , genre;
	private int year;
	private double price;
	private long ISBN;

	//Default Constructor:
	// The `public Book()` is a default constructor for the Book class. It initializes the instance
	// variables of the Book object with default values. In this case, it sets the title to "NoTitle",
	// author to "MaharajTeerthaDeb", genre to "HappyGenre", year to 2023, price to 0.00, and ISBN to
	// 12346789.
	public Book()
	{
		setTitle("NoTitle");
		setAuthor("MaharajTeerthaDeb");
		setGenre("HappyGenre");
		setYear(2023);
		setPrice(0.00);
		setISBN(12346789);
	}

	//Perametrarized Constructor:
	// The `public Book(String Title , String Author , String Genre , int Year , double Price , long
	// ISBN)` is a parameterized constructor for the Book class. It takes in six parameters: Title,
	// Author, Genre, Year, Price, and ISBN.
	public Book(String Title , String Author , String Genre , int Year , double Price , long ISBN){
		setTitle(Title);
		setAuthor(Author);
		setGenre(Genre);
		setYear(Year);
		setPrice(Price);
		setISBN(ISBN);
	}

	//Copy Constructor:
	// The code `public Book(final Book anotherBook)` is a copy constructor for the Book class. It takes
	// in another Book object as a parameter and creates a new Book object with the same values for its
	// instance variables. It essentially creates a copy of the original Book object.
	public Book(final Book anotherBook){
		setTitle(anotherBook.getTitle());
		setAuthor(anotherBook.getAuthor());
		setGenre(anotherBook.getGenre());
		setYear(anotherBook.getYear());
		setPrice(anotherBook.getPrice());
		setISBN(anotherBook.getISBN());
	}

	/**
	 * The function `createBookFromStringArray` takes a string representing book information, splits it
	 * into an array, trims whitespace from each element, and creates a new `Book` object using the array
	 * elements.
	 * 
	 * @param bookInformation The `bookInformation` parameter is a string that contains the information
	 * needed to create a `Book` object. The string should be in the following format:
	 * @return The method is returning a `Book` object.
	 */
	public static Book createBookFromStringArray(final String bookInformation)
	{
		String[] stringArray = bookInformation.split(",");
		int i = 0;
		// The code block is using a try-catch statement to iterate through each element in the `stringArray`
		// and trim any leading or trailing whitespace from each element. The `trim()` method removes any
		// whitespace characters at the beginning and end of a string. The try-catch statement is used to
		// handle any exceptions that may occur during the trimming process.
		try {
			for (i = 0; i < stringArray.length; i++) {
				stringArray[i] = stringArray[i].trim();
			}
		}
		catch (Exception e) {
			System.out.println("Could not trim : " + stringArray[i] + ". Error: " + e.getMessage());
		}
		Book newBook = null;
		// The code block is checking if the length of the `stringArray` is not equal to 6. If it is not
		// equal to 6, it means that the `bookInformation` string does not contain all the necessary
		// information to create a valid book object. In this case, the code prints a message indicating that
		// the book record is not valid and returns a null book object.
		if(stringArray.length != 6){
			System.out.println("The book record: " + bookInformation + " not a valid book. Returning null book");
			return newBook;
		}
		// The code `newBook = new Book(stringArray[0] , stringArray[1] , stringArray[4] ,
		// Integer.parseInt(stringArray[5]) , 
		// 							Double.parseDouble(stringArray[2]) , Long.parseLong(stringArray[3]));
		// 		return newBook;` is creating a new `Book` object and assigning it to the `newBook` variable.
		newBook = new Book(stringArray[0] , stringArray[1] , stringArray[4] , Integer.parseInt(stringArray[5]) , 
							Double.parseDouble(stringArray[2]) , Long.parseLong(stringArray[3]));
		return newBook;
	}

	//Setters:
	/**
	 * The function sets the title of an object.
	 * 
	 * @param title The title parameter is a string that represents the new title for an object.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The function sets the author of a book.
	 * 
	 * @param author The parameter "author" is a String that represents the name of the author.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * The function sets the genre of an object.
	 * 
	 * @param genre The genre parameter is a String that represents the genre of a particular object.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * The function sets the value of the "year" variable.
	 * 
	 * @param year The parameter "year" is an integer that represents the year value to be set.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * The function sets the price of an object.
	 * 
	 * @param price The price parameter is a double data type, which means it can hold decimal values. It
	 * is used to set the price of an object or item.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * The function sets the ISBN (International Standard Book Number) for a book.
	 * 
	 * @param ISBN The ISBN (International Standard Book Number) is a unique identifier for a book. It is
	 * typically a 10 or 13 digit number that is used to identify a specific edition of a book.
	 */
	public void setISBN(long ISBN){
		this.ISBN = ISBN;
	}

	//getters:
	/**
	 * The getTitle() function returns the title of an object.
	 * 
	 * @return The method is returning a String value.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * The function returns the author of a book.
	 * 
	 * @return The method is returning a String value, which is the author.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * The function returns the genre of a particular object.
	 * 
	 * @return The genre of the object.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * The function returns the value of the year variable.
	 * 
	 * @return The method is returning the value of the variable "year".
	 */
	public int getYear() {
		return year;
	}

	/**
	 * The getPrice() function returns the price.
	 * 
	 * @return The method is returning a double value, which is the price.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * The function returns the ISBN (International Standard Book Number) as a long data type.
	 * 
	 * @return The method is returning the value of the ISBN, which is a long data type.
	 */
	public long getISBN() {
		return ISBN;
	}

	//toString method:
	/**
	 * The toString() function returns a string representation of a book object, including its title,
	 * author, year, genre, ISBN, and price.
	 * 
	 * @return The toString() method is returning a string that contains information about a book,
	 * including its title, author, year, genre, ISBN, and price.
	 */
	@Override
	public String toString() {
		return getTitle() + " was written by " + getAuthor() + " in " + getYear() + ". The genre of the book is: "
				+ getGenre() + ". ISBN: " + getISBN() + ". And the price is: " + getPrice();
	}

	// clone method
    
	/**
	 * The above function is an implementation of the clone() method in Java that creates a new instance
	 * of the Book class with the same attributes as the original book.
	 * 
	 * @return The `clone()` method is returning a new instance of the `Book` class.
	 */
	@Override
	public Book clone() {
        return new Book(getTitle() , getAuthor() , getGenre() , getYear() , getPrice() , getISBN());
    }

	/**
	 * The equals() function checks if two Book objects have the same author, genre, title, ISBN, year,
	 * and price.
	 * 
	 * @param obj The object that is being compared to the current object for equality.
	 * @return The method is returning a boolean value.
	 */
	@Override
	public boolean equals(final Object obj)
	{
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		final Book obj1 = (Book) obj;
		return((getAuthor().equals(obj1.getAuthor())) && (getGenre().equals(obj1.getGenre())) && (getTitle().equals(obj1.getTitle()))
		 		&& (getISBN() == obj1.getISBN()) && (getYear() == obj1.getYear()) && (getPrice() == obj1.getPrice()));
	}

	/**
	 * The function checks if the year is between 1900 and 2023 (inclusive).
	 * 
	 * @return The method is returning a boolean value.
	 */
	public boolean isCorrectYear()
	{
		return this.year>=1900 && this.year <=2023;
	}

	
}