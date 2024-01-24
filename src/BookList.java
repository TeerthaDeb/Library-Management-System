// --------------------------------------------------------------------
// Assignment : 3
// Part: BookLinkedList
// Written by: Maharaj Teertha Deb (40227747)
// --------------------------------------------------------------------


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The BookList class represents a circular linked list of Book objects and provides methods for
 * adding, deleting, and manipulating the list.
 */
public class BookList {
    private Node head;

    // Constructor
    // The `public BookList()` is a constructor for the `BookList` class. It initializes the `head`
	// variable to `null`, indicating that the linked list is empty.
	public BookList() {
        head = null;
    }

    /**
	 * The function addToStart adds a new node containing a book to the beginning of a circular linked list.
	 * 
	 * @param b The parameter "b" is of type Book, which represents an object of the Book class.
	 */
	public void addToStart(Book b) {
		Node newNode = new Node(b);
		if (head == null) {
			head = newNode;
			head.next = head; // Point to itself to form a circular list
		} 
		else {
			Node last = head;
			while (last.next != head) {
				last = last.next;
			}
			newNode.next = head;
			head = newNode;
			last.next = head; // Update the last node to point to the new head
		}
	}

	/*
	 * The function stores records with a specific year in a text file.
	 * 
	 * @param yr The parameter "yr" is an integer representing the year.
	*/
	public void storeRecordsByYear(int yr) {
		Node current = head;
		String fileName = yr + ".txt";
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			do {
				if (current.b.getYear() == yr) {
					pw.println(current.b);
					System.out.println(current.b);
				}
				current = current.next;
			} while (current != head);
			pw.close();
		}
		catch (IOException e) {
			System.out.println("From BookList Class: we could not write a year successfully in yr.txt file. Error: " + e.getMessage());
		}
	}

    // Method to insert a new node before the node with the given ISBN
	/**
	 * The function inserts a new book node before a specified book with a given ISBN in a circular linked list.
	 * 
	 * @param isbn The ISBN (International Standard Book Number) of the book that you want to insert before.
	 * @param b The parameter "b" is of type Book, which represents a book object.
	 * @return The method is returning a boolean value. It returns true if the insertion is successful and false if it is not.
	 */
	public boolean insertBefore(long isbn, Book b) {
		Node current = head;
		if (head == null) {
			System.out.println("List is empty. Cannot insert before.");
			return false;
		}
		// Check if the node to insert before is the head
		if (head.b.getISBN() == isbn) {
			Node newNode = new Node(b);
			newNode.next = head;
			Node last = head;
			while (last.next != head) {
				last = last.next;
			}
			last.next = newNode; // Update the last node to point to the new head
			head = newNode;
			return true;
		}
		do {
			if (current.next.b.getISBN() == isbn) {
				Node newNode = new Node(b);
				newNode.next = current.next;
				current.next = newNode;
				return true;
			}
			current = current.next;
		} while (current != head);
		return false;
	}
	

    // Method to insert a new node between two nodes with given ISBNs
    /**
	 * The function inserts a new book node between two existing book nodes in a circular linked list
	 * based on their ISBN numbers.
	 * 
	 * @param isbn1 The ISBN of the book that should come before the new book (b) in the linked list.
	 * @param isbn2 The parameter "isbn2" is the ISBN number of the book that comes after the book we
	 * want to insert.
	 * @param b The parameter "b" is an object of type Book.
	 * @return The method is returning a boolean value. It returns true if the book was successfully
	 * inserted between the two given ISBNs, and false otherwise.
	*/
	public boolean insertBetween(long isbn1, long isbn2, Book b) {
        Node current = head;
		do {
            if ((current.b.getISBN() == isbn1 && current.next.b.getISBN() == isbn2) || (current.b.getISBN() == isbn2 && current.next.b.getISBN() == isbn1)) {
                Node newNode = new Node(b);
                newNode.next = current.next;
                current.next = newNode;
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Method to display the content of the list
    public void displayContent() throws NoAuthorFoundException{
		// The code block is checking if the `head` of the linked list is `null`. If it is `null`, it means
		// that the linked list is empty and there are no books in the list. In this case, the code throws a
		// `NoAuthorFoundException` with a message indicating that either the author was not found or an
		// invalid author was entered. This exception is used to handle the case where there are no books in
		// the list or no books by the specified author.
		if(head == null){
			throw new NoAuthorFoundException("Or you entered an invalid author...");
		}
        Node current = head;
       // The code block is iterating through the linked list and printing the string representation of
	   // each book object (`current.b.toString()`) followed by " ==> ". It then moves to the next node
	   // (`current = current.next`).
	    do {
			try {
				System.out.println(current.b.toString() + " ==> ");
				current = current.next;
			}
			catch (NullPointerException e) {
				System.out.println("A book got missing somehow." + e.getMessage());
				return;
			}
        } while (current != head);
        System.out.println("==> head");
    }

    // Method to delete consecutive repeated records

	/**
	 * The function `delConsecutiveRepeatedRecords` checks for consecutive repeated records in a circular
	 * linked list and removes them if found.
	 * 
	 * @return The method returns a boolean value indicating whether any consecutive repeated records were
	 * deleted from the circular linked list.
	*/
	public boolean delConsecutiveRepeatedRecords() {
        Node current = head;
        boolean deleted = false;
        // The code block is checking for consecutive repeated records in a circular linked list.
		do {
            // The code block `if (current.next.b.equals(current.b)) { current.next =
			// current.next.next; deleted = true; }` is checking if the book in the next node
			// (`current.next.b`) is equal to the book in the current node (`current.b`). If they are
			// equal, it means that there are consecutive repeated records in the linked list. In this
			// case, the code removes the next node by setting the `next` reference of the current node
			// to skip the next node and point to the node after it (`current.next =
			// current.next.next`). The `deleted` variable is set to `true` to indicate that at least
			// one repeated record was deleted.
			if (current.next.b.equals(current.b)) {
                current.next = current.next.next;
                deleted = true;
            } 
            current = current.next;
        } while (current.next != head);
        return deleted;
    }

    /**
	 * The function `extractAuthList` extracts all books from a circular linked list that belong to a
	 * specified author and returns them in a new `BookList` object.
	 * 
	 * @param author The `author` parameter is a `String` that represents the name of the author.
	 * @return The method is returning a BookList object called `extractedList`.
	 */
	public BookList extractAuthList(String author) {
        BookList extractedList = new BookList();
        Node current = head;
        // The code block is iterating through a circular linked list and checking if the author of the
		// book in the current node (`current.b.getAuthor()`) is equal to the specified author
		// (`author`). If they are equal, it means that the book belongs to the specified author. In
		// this case, the code adds the book to a new `BookList` object called `extractedList` using
		// the `addToStart` method (`extractedList.addToStart(current.b)`). The `addToStart` method
		// adds the book to the start (head) of the `extractedList` object.
		do {
            if (current.b.getAuthor().equalsIgnoreCase(author)) {
                extractedList.addToStart(current.b);
            }
            current = current.next;
        } while (current != head);
        return extractedList;
    }

    // Method to swap records of two ISBNs
    /**
	 * The function swaps the positions of two nodes in a circular linked list based on their ISBN values.
	 * 
	 * @param isbn1 The ISBN of the first book that needs to be swapped.
	 * @param isbn2 The parameter "isbn2" is the ISBN of the second book that needs to be swapped.
	 * @return The method is returning a boolean value.
	 */
	public boolean swap(long isbn1, long isbn2) {
		if (head == null) {
			System.out.println("List is empty. Nothing to swap.");
			return false;
		}
	
		Node current = head;
		Node prev1 = null; // Previous node of the first book with isbn1
		Node prev2 = null; // Previous node of the second book with isbn2
		Node node1 = null; // Node of the first book with isbn1
		Node node2 = null; // Node of the second book with isbn2
		do {
			if (current.b.getISBN() == isbn1) {
				node1 = current;
				break;
			}
			prev1 = current;
			current = current.next;
		} while (current != head);
	
		current = head;
		do {
			if (current.b.getISBN() == isbn2) {
				node2 = current;
				break;
			}
			prev2 = current;
			current = current.next;
		} while (current != head);
	
		// Check if both books are found
		if (node1 == null || node2 == null) {
			System.out.println("One or both of the ISBNs not found. Nothing to swap.");
			return false;
		}
	
		// Swap the nodes
		if (prev1 == null) {
			head = node2;
		}
		else {
			prev1.next = node2;
		}
	
		if (prev2 == null) {
			head = node1;
		} 
		else {
			prev2.next = node1;
		}
	
		Node temp = node2.next;
		node2.next = node1.next;
		node1.next = temp;
	
		return true;
	}
	
}
