/**
 * Responsibilities of class: Hold information about Vaccine 
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai
 *         Other contributors: None
 * 
 * @version 24 October 2021
 */
public class Vaccine
{

	///////fields////////

	private int vaccineSuccess;


	////////////constructor///////////

	public Vaccine() 
	{
		
	}

	////////////////getter setter for VaccineType///////////////

 /**
    * Get integer value of vaccine success
    * 
    * @return Integer value of vaccine success
    */
	public int getVaccineSuccess()
	{
		return vaccineSuccess;
	}

 /**
    * Set Vaccine sucess as a integer value
    */
	public void setVaccineSuccess(int vaccineSuccess)
	{
		this.vaccineSuccess = vaccineSuccess;
	}

}