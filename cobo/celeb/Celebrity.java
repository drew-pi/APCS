/*
Team PinkLemonade:  Jacob Ng, Andrew Piatetsky, Emily Ortiz
APCS
L09: Some Folks Call It A Charades
2022-04-26
time spent: _ hrs
*/


package celeb;

/**
 * Celebrity base class for the Celebrity game.
 * @author cody.henrichsen
 * @version 1.4 17/09/2018
 */
public class Celebrity
{
	/**
	 * The clue to determine the celebrity
	 */
	String _clue;
	
	/**
	 * The answer or name of the celebrity.
	 */
	String _name;
	
	/**
	 * Creates a Celebrity instance with the supplied answer and clue
	 * @param answer
	 * @param clue
	 */
	public Celebrity(String answer, String clue)
	{
		_name = answer;
		_clue = clue;
	}

	public Celebrity(String answer, String clue, String type) {
		this(answer,clue);
		// _type = type;
	}

	/**
	 * Supplies the clue for the celebrity
	 * @return
	 */
	public String getClue()
	{
		return _clue;
	}

	/**
	 * Supplies the answer for the celebrity.
	 * @return
	 */
	public String getAnswer()
	{
		return _name;
	}

	/**
	 * Updates the clue to the provided String.
	 * @param clue The new clue.
	 */
	public void setClue(String clue)
	{
		_clue = clue;
	}

	/**
	 * Updates the answer to the provided String.
	 * @param answer The new answer.
	 */
	public void setAnswer(String answer)
	{
		_name = answer;
	}

	/**
	 * Provides a String representation of the Celebrity.
	 */
	@Override
	public String toString()
	{
		return _name;
	}

}
