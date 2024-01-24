/*
 * This is the main Driver class with all the available options.
 */


// --------------------------------------------------------------------
// Assignment : 3
// Part: MainDriver
// Written by: Maharaj Teertha Deb (40227747)
// --------------------------------------------------------------------


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class MainDriver {

	/**
	 * The mainMenu function is a Java program that displays a menu to the user and performs different
	 * operations based on the user's choice.
	 * 
	 * @param bkLst The parameter "bkLst" is an object of the BookList class. It represents a list of
	 * books and contains methods to perform various operations on the list, such as storing records by
	 * year, deleting consecutive repeated records, extracting a list of books by author, inserting a book
	 * before a specific ISBN
	 */
	private static void mainMenu(BookList bkLst)
	{
		Scanner myObj = new Scanner(System.in);
		String input = null;
		int choice = 0;
		while(choice != 7){
			System.out.println("================================================================ Main Menu ================================================================");
			System.out.println("===========================================================================================================================================");
			System.out.println("[1] Give me a year # and I would extract all records of that year and store them in a file for that year;");
			System.out.println("[2] Ask me to delete all consecutive repeated records;");
			System.out.println("[3] Give me an author name and I will create a new list with the records of this author and display them;");
			System.out.println("[4] Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN;");
			System.out.println("[5] Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
			System.out.println("[6] Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
			System.out.println("[7] Tell me to STOP TALKING.");
			System.out.println("===========================================================================================================================================");
			// The code prompts the user to enter a choice and reads the input from the user. It then
			// tries to convert the input into an integer using the parseInt() method. If the input cannot be
			// converted into an integer (i.e., if the user enters a string instead of a number), it catches the
			// NumberFormatException and prints a message indicating that a string was entered instead of a
			// number. In this case, it sets the choice variable to 0.
			System.out.print("Enter your choice: ");
			input = myObj.nextLine();

			try {
				choice= Integer.parseInt(input);
			}
			catch (NumberFormatException e) {
				System.out.println("You entered a string rather than a number;");
				choice = 0;
			}

			// The code is a part of a Java program. It is checking if the user's choice is equal to 1. If
			// it is, it prompts the user to enter a year. It then attempts to convert the user's input (which
			// is a string) into an integer using the `Integer.parseInt()` method. If the conversion is
			// successful, it prints a message indicating the year entered by the user and calls a method
			// `storeRecordsByYear()` to retrieve and display all the books released in that year. If the
			// conversion fails (i.e., the user enters a string instead of a number
			if(choice == 1){		//extract all the books in the year
				System.out.println("===========================================================================================================================================");
				System.out.print("Enter year(Enter 0 to go to main menu): ");
				String yearString = myObj.nextLine();
				int year;
				// The code is attempting to convert a string variable `yearString` into an integer variable
				// `year` using the `Integer.parseInt()` method.
				// The code is attempting to convert a string variable `yearString` into an integer variable
				// `year` using the `Integer.parseInt()` method.
				try {
					year = Integer.parseInt(yearString);
				}
				// The code is a catch block that handles a NumberFormatException. If the user enters a
				// string instead of a number, the catch block will execute. It will print a message indicating
				// that the user entered a string instead of a year number, and it will set the variable "year" to
				// 0.
				catch (NumberFormatException e) {
					System.out.println("You entered a string rather than a (year) number;");
					year = 0;
				}
				// This code block is checking if the `year` variable is not equal to 0. If it is not equal to 0,
				// it means that the user has entered a valid year.
				if(year != 0){
					System.out.println("All the books released in " + year + " are: ");
					System.out.println("===========================================================================================================================================");
					bkLst.storeRecordsByYear(year);
				}
				System.out.println("===========================================================================================================================================\n\n");
			}

			else if(choice == 2){ // show the list after deleting consecutive records.
				// The code is calling a method named "delConsecutiveRepeatedRecords" on an object named
				// "bkLst". This method is likely implemented to delete consecutive repeated records from a list or
				// collection.
				bkLst.delConsecutiveRepeatedRecords();
				// The code is printing the list of books after deleting consecutive repeated records. It
				// first prints a header for the list, and then calls the `displayContent()` method of the `bkLst`
				// object to print the contents of the list. If a `NoAuthorFoundException` is thrown during the
				// execution of the `displayContent()` method, the corresponding error message is printed.
				System.out.print("\n\tThe list of Books after deleting consecutive repeated records: \n");
				System.out.println("===========================================================================================================================================");
				try {
					bkLst.displayContent();
				} 
				catch (NoAuthorFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("===========================================================================================================================================\n\n");
			}

			// The code is a part of a larger program and it is handling the case when the user selects
			// choice 3.
			else if(choice == 3){
				// The code is prompting the user to enter an author name. It then reads the input from the
				// user and assigns it to the variable `authorName`.
				System.out.print("Enter Author name: ");
				String authorName = myObj.nextLine();
				BookList authorBooklist = bkLst.extractAuthList(authorName.trim());
				System.out.println("The books written by: " + authorName.trim() + " are: ");
				System.out.println("===========================================================================================================================================");
				// The code is trying to display the content of the author's booklist. If a
				// NoAuthorFoundException is thrown, it catches the exception and prints a message indicating the
				// author name entered and the exception message. The continue statement is used to continue the
				// loop execution.
				try {
					authorBooklist.displayContent();
				} 
				catch (NoAuthorFoundException e) {
					System.out.println("You entered: " + authorName + ". And " + e.getMessage());
					continue;
				}
				System.out.println("===========================================================================================================================================\n\n");
			}

			// The code is a part of a Java program that allows the user to add a book to a book list. It
			// prompts the user to enter the ISBN number before which the new book should be added. It then
			// takes input from the user to create a new book object by asking for the book's title, author's
			// name, genre, year of publication, price, and ISBN number.
			else if(choice == 4){
				Long isbn;
				String tempString;
				System.out.print("Enter ISBN number before which I should add a book(Enter 0 to return to main menu): ");
				tempString = myObj.nextLine();
				// The code is taking input from the user to create a new book object. It prompts the user to
				// enter the book's title, author's name, genre, year of publication, price, and ISBN number. It
				// then creates a new Book object with the entered information and tries to insert it into a book
				// list (`bkLst`) using the `insertBefore()` method. If the insertion is successful, it prints a
				// success message and calls the `displayContent()` method on the `bkLst` object to display the
				// updated content of the book list. If the `displayContent()` method
				try {
					isbn = Long.parseLong(tempString.trim());
					if(isbn == 0){
						System.out.println("You are returning to the main menu..");
						continue;
					}
					Book tempBook = new Book();
					//Get bookname from user and set the name.
					System.out.print("Enter the Name of the book: ");
					tempString = myObj.nextLine();
					tempBook.setTitle(tempString.trim());
					//Get Author's from user and set the name.
					System.out.print("Enter the Author\'s name: ");
					tempString = myObj.nextLine();
					tempBook.setAuthor(tempString.trim());
					//Get gener from user and set the gener.
					System.out.print("Enter the gener of the book: ");
					tempString = myObj.nextLine();
					tempBook.setGenre(tempString.trim());
					//Get published year from user and set it.
					System.out.print("Enter the year in which it was published: ");
					tempString = myObj.nextLine();
					tempBook.setYear(Integer.parseInt(tempString.trim()));
					//Get price form user and set its value.
					System.out.print("Enter the Price for this book: ");
					tempString = myObj.nextLine();
					tempBook.setPrice((float)(Double.parseDouble(tempString.trim())));
					//get ISBN and set the ISBN:
					System.out.print("Enter the ISBN number: ");
					tempString = myObj.nextLine();
					tempBook.setISBN(Long.parseLong(tempString.trim()));
					// The code is trying to insert a book with the given ISBN into a book list (`bkLst`). If
					// the insertion is successful, it will print a success message and then call the
					// `displayContent()` method on the `bkLst` object to display the updated content of the book
					// list. If the `displayContent()` method throws a `NoAuthorFoundException`, the code will catch
					// the exception and print the exception message. If the insertion is not successful, it will
					// print an error message.
					if(bkLst.insertBefore(isbn, tempBook)){
						System.out.println("Successfully set the book. After setting the Booklist is: ");
						System.out.println("===========================================================================================================================================");
						// The code is trying to call the `displayContent()` method on an object `bkLst`. If the
						// `displayContent()` method throws a `NoAuthorFoundException`, the code will catch the exception
						// and print the exception message using `System.out.println()`.
						try {
							bkLst.displayContent();
						} 
						catch (NoAuthorFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("===========================================================================================================================================\n\n");
					}
					else{
						System.out.println("This ISBN: " + isbn + " does not exist in the list.");
					}
				}
				catch (NumberFormatException e) {
					System.out.println("You did not enter a number. Returning to the main menu...");
				}
			}

			
			// The code is a part of a larger Java program. It is handling the case when the user selects
			// choice 5 from the menu.
			else if(choice == 5){
				Long isbn , isbn1;
				String tempString;
				System.out.print("Enter the first ISBN number: ");
				tempString = myObj.nextLine();
				// The code is taking user input to create a new book object. It prompts the user to enter
				// the ISBN numbers, book name, author's name, genre, year of publication, price, and ISBN number.
				// It then sets these values in the temporary book object. After that, it calls the `insertBetween`
				// method on the `bkLst` object (which is a book list) to insert the temporary book object between
				// two other books specified by the ISBN numbers. If the insertion is successful, it prints the
				// updated book list. If the insertion fails, it prints an error message.
				try {
					isbn = Long.parseLong(tempString.trim());
					System.out.print("Enter the second ISBN number: ");
					tempString=myObj.nextLine();
					isbn1 = Long.parseLong(tempString.trim());
					Book tempBook = new Book();
					//Get bookname from user and set the name.
					System.out.print("Enter the Name of the book: ");
					tempString = myObj.nextLine();
					tempBook.setTitle(tempString.trim());
					//Get Author's from user and set the name.
					System.out.print("Enter the Author\'s name: ");
					tempString = myObj.nextLine();
					tempBook.setAuthor(tempString.trim());
					//Get gener from user and set the gener.
					System.out.print("Enter the gener of the book: ");
					tempString = myObj.nextLine();
					tempBook.setGenre(tempString.trim());
					//Get published year from user and set it.
					System.out.print("Enter the year in which it was published: ");
					tempString = myObj.nextLine();
					tempBook.setYear(Integer.parseInt(tempString.trim()));
					//Get price form user and set its value.
					System.out.print("Enter the Price for this book: ");
					tempString = myObj.nextLine();
					tempBook.setPrice((float)(Double.parseDouble(tempString.trim())));
					//get ISBN and set the ISBN:
					System.out.print("Enter the ISBN number: ");
					tempString = myObj.nextLine();
					tempBook.setISBN(Long.parseLong(tempString.trim()));
					// The code is checking if a book can be inserted between two other books in a book list. If
					// the insertion is successful, it prints the updated book list. If the insertion fails, it prints
					// an error message.
					if(bkLst.insertBetween(isbn, isbn1, tempBook)){
						System.out.println("Successfully set the book. After setting the Booklist is: ");
						System.out.println("===========================================================================================================================================");
						try {
							bkLst.displayContent();
						} 
						catch (NoAuthorFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("===========================================================================================================================================\n\n");
					}
					else{
						System.out.println("Unknown error while inserting the book.");
					}
				}
				catch (NumberFormatException e) {
					System.out.println("You did not enter a number. Returning to the main menu... message: " + e.getMessage());
				}
			}


			// The code is a part of a larger Java program. It is handling the case when the user selects
			// choice 6 from the menu.
			else if(choice == 6){
				System.out.println("===========================================================================================================================================");
				long ISBN1 , ISBN2;
				String tempString = null;
				System.out.print("provide the first ISBN number here(Enter \'0\' to return to main menu): ");
				tempString=myObj.nextLine();
				// The code is taking two ISBN numbers as input from the user and then swapping the
				// corresponding elements in a book list. If the swap is successful, it will print the updated
				// list. If the swap is not successful, it will print an error message. If the user enters an
				// invalid ISBN number, it will catch the NumberFormatException and display an error message.
				try {
					ISBN1= Long.parseLong(tempString.trim());
					// The code is checking if the variable ISBN1 is equal to 0. If it is, the code will take to the main meny again.
					if(ISBN1 == 0){
						continue;
					}
					System.out.print("provide the second ISBN number here: ");
					tempString=myObj.nextLine();
					ISBN2= Long.parseLong(tempString.trim());
					// The code is swapping two elements in a book list. If the swap is successful, it will
					// print the updated list. If the swap is not successful, it will print an error message.
					if(bkLst.swap(ISBN1, ISBN2)){
						System.out.println("List after swapping: ");
						try {
							bkLst.displayContent();
						}
						catch (NoAuthorFoundException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("===========================================================================================================================================\n\n");
					}
					else{
						System.out.println("Error in swaping. Isbn1= " + ISBN1 + " and isbn 2 = " + ISBN2);
					}
				}
				catch (NumberFormatException e) {
					System.out.println("You did not enter a valid ISBN number. So returning to the main menu." + e.getMessage());
				}		
			}


			// The code is checking if the variable "choice" is equal to 7. If it is, then it will break
			// out of the current loop or switch statement.
			else if(choice == 7){
				break;
			}

			// The code is part of an if-else statement in Java. It is the else block that will be
			// executed if the condition in the if statement is false. In this case, it is printing the message
			// "You entered an invalid choice..........." to the console.
			else {
				System.out.println("You entered an invalid choice...........");
			}
		}
		myObj.close();
	}

	// The code is the main method in a Java program. It is the entry point of the program and is
	// where the program starts executing. However, the code you provided is incomplete and contains a
	// syntax error. The three hash symbols (
	public static void main(String[] args) {
		Scanner booksList = null;
		// The code is trying to create a new Scanner object to read the contents of a file named
		// "Books.txt". It is using the FileInputStream class to open the file for reading.
		try {
			booksList = new Scanner(new FileInputStream("Books.txt"));
		} 
		// The code is handling exceptions that may occur when trying to access a file named "Books.txt".
		catch (FileNotFoundException e) {
			System.out.println("\'Books.txt\' file was not found in the directory. Can not proceed further. exiting with the error message: " + e.getMessage());
			System.exit(0);
		} 
		catch (Exception f) {
			System.out.println("\'Books.txt\' file was found in the directory but SOME OTHER exception. Can not proceed further. exiting with the error message: " + f.getMessage());
			System.exit(0);
		}
		String indivisualBookInformation = null;
		ArrayList<Book> arrLst = new ArrayList<Book>();//This arraylist would store all the books from the book.txt file.
		BookList bkLst = new BookList();
		Book tempBook = null;

		/* The code block `try { indivisualBookInformation = booksList.nextLine(); }` is attempting to read
		 * the next line from the `booksList` Scanner object and assign it to the `indivisualBookInformation`
		 * variable. This is done inside a try-catch block to handle any exceptions that may occur while
		 * reading the file.
		 * The `catch (NoSuchElementException e)` block is handling the exception that occurs when there are
		 * no more lines to read from the "Books.txt" file. It prints an error message indicating that the
		 * file is corrupted and exits the program.
		*/
		try {
			indivisualBookInformation = booksList.nextLine();
		}
		// The code is handling exceptions in Java. It is catching two specific types of exceptions:
		// NoSuchElementException and IllegalStateException.
		catch (NoSuchElementException e) {
			System.out.println("The file \'Books.txt\' seems corrupted. Exiting the program with error code: " + e.getMessage());
			System.exit(0);
		}
		catch(IllegalStateException f) {
			System.out.println("The scanner is closed somewhere. Can not read file. Try again. " + f.getMessage());
			System.exit(0);
		}
		// The code block is a loop that reads each line from the "Books.txt" file and processes it.
		while (indivisualBookInformation != null) {
			tempBook = Book.createBookFromStringArray(indivisualBookInformation);
			// The code `if(!(tempBook.isCorrectYear()))` is checking if the `tempBook` object has an incorrect
			// year. If the year is incorrect, it means that the book is added to the `arrLst` ArrayList.
			if(!(tempBook.isCorrectYear())){
				arrLst.add(tempBook);
			}
			// The code `else{ bkLst.addToStart(tempBook); }` is adding the `tempBook` object to the `bkLst`
			// BookList object if the year of the book is correct.
			else{
				bkLst.addToStart(tempBook);
			}
			// The code is trying to read the next line of input from the "booksList" scanner object and
			// assign it to the "indivisualBookInformation" variable.
			try {
				indivisualBookInformation = booksList.nextLine();
			}
			catch (NoSuchElementException e) {
				// Reading the end of the file was done...
				indivisualBookInformation = null;
			}
			catch (Exception f) {
				System.out.println("Was not done reading the entire file. but some unknown happend. error: " + f.getMessage());
			}
		}
		booksList.close();// We do not need this file next.
		// This code block is checking if the `arrLst` ArrayList has any elements. If it does, it
		// creates a new `PrintWriter` object named `pw` to write the contents of the `arrLst`
		// ArrayList to a file named "YearErr.txt".
		if (arrLst.size() > 0) {
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileOutputStream("YearErr.txt"));
				for (Book book : arrLst) {
					pw.write(book + "\n");
				}
				pw.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Could not create \'YearErr.txt\' file. Error: " + e.getMessage());
			}
		}
		
		// The code `System.out.println("Printing the book list that have the Correct records:\n\n");` is
		// printing a message to the console indicating that the book list with correct records is about to  be displayed.
		System.out.println("Printing the book list that have the Correct records:\n\n");
		// The code is trying to call the `displayContent()` method on an object `bkLst`. If the
		// `displayContent()` method throws a `NoAuthorFoundException`, the code will catch the exception and
		// print the exception message using `System.out.println()`.
		try {
			bkLst.displayContent();
		} 
		catch (NoAuthorFoundException e) {
			System.out.println(e.getMessage());
		}

		// The code is calling a method named "mainMenu" and passing a variable named "bkLst" as an argument.
		mainMenu(bkLst);

		//Exit message:
		System.out.println("Thank you for using our system. See you next. bye...");
	}
}
