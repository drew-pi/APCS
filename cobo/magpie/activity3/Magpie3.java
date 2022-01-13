/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{

	// HELPER METHODS + VARS

	public final String PUNCT = "!?,.''-() ";

	// taken from hw31 pig
	public boolean hasA( String w, String letter ) {
    
		for (int index = 0; index < w.length(); index ++) {
		  if (w.substring(index,index+1).equals(letter)) {
			return true;
		  }
		}
		return false;
	
	  }//end hasA()

	  public boolean isAPunct( String letter ) {
    
		if (hasA(PUNCT,letter)) {
		  return true;
		}
		return false;
	  }

	  // finds just the defined word, (not nested letters in a word), and returns its index or -1 if no target
	public int isoIndexOf(String str, String target) {
		if (str.indexOf(target) < 0) {
			return -1;
		}
		int begIndex = str.indexOf(target);
		String begVal = " ";
		if (begIndex > 0) {
			begVal = str.substring(begIndex-1,begIndex);
		}

		int endIndex = begIndex + target.length() -1;
		String endVal = " ";
		if (endIndex+1 < str.length()) {
			endVal = str.substring(endIndex+1,endIndex+2);;
		}

		//System.out.println("ISO:"+str + " " + target + " " + begVal + " " + endVal);

		if (isAPunct(endVal) && isAPunct(begVal)) {
			return begIndex;
		}
		return -1;
	}
	// END HELPER METHODS




	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (isoIndexOf(statement,"no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (isoIndexOf(statement,"mother") >= 0
				|| isoIndexOf(statement,"father") >= 0
				|| isoIndexOf(statement,"sister") >= 0
				|| isoIndexOf(statement,"brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
}
