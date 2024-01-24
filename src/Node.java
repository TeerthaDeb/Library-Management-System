/**
 * The `Node` class represents a node in a linked list and contains a reference to a `Book` object and
 * the next node in the list.
 */

// --------------------------------------------------------------------
// Assignment : 3
// Part: Node
// Written by: Maharaj Teertha Deb (40227747)
// --------------------------------------------------------------------


/**
 * The `Node` class represents a node in a linked list and contains a reference to a `Book` object and
 * the next node in the list.
 */
public class Node {
	protected Book b;
	protected Node next;

	// Constructor
	public Node(){
		this.b = null;
		this.next = null;
	}

	public Node(final Node oldNode){
		this.b = new Book(oldNode.b);
		this.next = oldNode.next;
	}
	
	// The code `public Node(Book b) { this.b = b; this.next = null; }` is a constructor for the `Node`
	// class. It takes a `Book` object as a parameter and assigns it to the instance variable `b`. It also
	// sets the `next` reference to `null`.
	public Node(Book b) {
		this.b = b;
		this.next = null;
	}

	// Getters and Setters
	
	/**
	 * The function returns a Book object.
	 * 
	 * @return The method is returning an object of type Book.
	 */
	public Book getBook() {
		return b;
	}

	/**
	 * The function sets the value of a Book object.
	 * 
	 * @param b The parameter "b" is of type Book.
	 */
	public void setBook(Book b) {
		this.b = b;
	}

	/**
	 * The function returns the next node in a linked list.
	 * 
	 * @return The method is returning the value of the "next" variable, which is of type Node.
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * The function sets the next node in a linked list.
	 * 
	 * @param next The "next" parameter is a reference to the next node in a linked list.
	 */
	public void setNext(Node next) {
		this.next = next;
	}


	/**
	 * The `equals` method is used to check if two `Node` objects are equal by comparing their `b` values and `next` references.
	 * 
	 * @param obj The `obj` parameter is an object that is being compared for equality with the current object.
	 * @return The method is returning a boolean value. It returns true if the current object is equal to
	 * the object passed as a parameter, and false otherwise.
	 */
	
	@Override
	public boolean equals(Object obj)
	{
		// The code `if(obj == null || obj.getClass() != this.getClass()){ return false; }` is checking if
		// the `obj` parameter is null or if it is not an instance of the same class as the current object.
		if(obj == null || obj.getClass() != this.getClass()){
			return false;
		}
		Node obj1 = (Node) obj;
		// The line `return b.equals(obj1.b) && next == obj1.next;` is checking if two `Node` objects are equal.
		return b.equals(obj1.b) && next == obj1.next;
	}

}
