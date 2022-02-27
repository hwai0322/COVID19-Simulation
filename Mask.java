
/**
 * Responsibilities of class: Hold information about mask and how it contributes to spread prevention
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai
 *         Other contributors: None
 * 
 * @version 24 October 2021
 */

public class Mask 
{
	
	////////fields////////
	
	private boolean isGoodMask;
	private int covidSpreadPrevention;
	
	///////constructors////
	

	
	public Mask()
	{
		
	}
	
	/**
	    * Constructor that sets covidspreadPrevention value to spread prevention success as Mask has been used
	    * 
	    * @param spreadSuccess the integer value of COVID Spread prevention success
	    */
	public Mask(int spreadSuccess) 
	{
		this.covidSpreadPrevention = spreadSuccess;
	}
	
	
	///////methods////////
	
/**
    * Get integer value of COVID Spread prevention
    * 
    * @return value of covid Spread prevention
    */
	public int getCovidSpreadPrevention() {
		return covidSpreadPrevention;
	}
/**
    * Set CovidSpreadPrevention value to integer covid spread prevention
    * @param covidSpreadPrevention the integer value of COVID spread prevention
    */
	public void setCovidSpreadPrevention(int covidSpreadPrevention) {
		this.covidSpreadPrevention = covidSpreadPrevention;
	}

/**
    * Get if Mask is a good functioning mask
    * 
    * @return True value if mask is good
    */
	public boolean getIsGoodMask()
	{
		return isGoodMask;
	}

/**
    * Set true if mask is good
    *
    */
	public void setIsGoodMask(boolean goodMaskValue)
	{
		this.isGoodMask = goodMaskValue;
	}
	
}