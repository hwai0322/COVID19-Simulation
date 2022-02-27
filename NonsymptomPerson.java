/**
 * Responsibilities of class: Hold information about non-symptomatic COVID positive patients
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai
 *         Other contributors: None
 * 
 * @version 24 October 2021
 */

public class NonsymptomPerson extends Person
{
	private boolean isCareful;

	
	public NonsymptomPerson()
	{
		
	}
	
	public NonsymptomPerson(boolean maskStatus,
							boolean covidStatus,
							boolean carefulStatus, int spreadCapacity)
	{
		super(maskStatus, covidStatus, carefulStatus, spreadCapacity);
		this.isCareful = carefulStatus;
	}


	////////////////getter and setter for isCareful//////////////////
/**
    * Get if person is Careful
    * 
    * @return True value if the person is Careful
    */
	public boolean getIsCareful() 
	{
		return isCareful;
	}
/**
    * Set true if person is Careful
    *
    */
	public void setIsCareful(boolean isCareful) 
	{
		this.isCareful = isCareful;
	}
/**
    * Change values of COVID positive and increase spread capacity as Nonsymptomatic person contracts COVID
    *
    */
	public void contract()
	{
		setIsCovidPositive(true);
		setSpreadCapacity(7);
	}
/**
    * Decrease value of spread capacity according to whether or not proper prevention methods have taken place
    *
    */
	public void decreaseSpreadCapacity()
	{
		if(this.isCareful == true)
		{
			setSpreadCapacity(0);
		}
		else
		{
			setSpreadCapacity( getSpreadCapacity() - 1 );
		}
	}
}