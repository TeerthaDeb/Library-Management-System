/**
 * The `NoAuthorFoundException` class is a custom exception that is thrown when no author is found.
 */
// --------------------------------------------------------------------
// Assignment : 3
// Part: Author Not found Exception.
// Written by: Maharaj Teertha Deb (40227747)
// --------------------------------------------------------------------


/**
 * The `NoAuthorFoundException` class is a custom exception that is thrown when no author is found.
 */
public class NoAuthorFoundException extends Exception{
	// The code `public NoAuthorFoundException(){ super(); }` is a constructor for the
	// `NoAuthorFoundException` class.
	public NoAuthorFoundException(){
		super();
	}
	// The code `public NoAuthorFoundException(String Message){ super("No Author Found " + Message); }` is
	// a constructor for the `NoAuthorFoundException` class.
	public NoAuthorFoundException(String Message){
		super("No Author Found " + Message);
	}
	/**
	 * The toString() function returns a string representation of the object.
	 * 
	 * @return The `toString()` method is returning the string representation of the object. In this case,
	 * it is calling the `toString()` method of the superclass (i.e., the parent class) using the `super`
	 * keyword.
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
