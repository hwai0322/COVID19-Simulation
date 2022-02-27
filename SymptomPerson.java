import java.util.Random;

/**
 * Responsibilities of class: Hold information about symptomatic COVID positive patients
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai
 *         Other contributors: None
 * 
 * @version 24 October 2021
 */

public class SymptomPerson extends Person
{

	
	private boolean obviouslySick;
	private boolean isAlive;
	
	
	/////////////constructors////////////
	
	
	/**
	 * Default constructor if given no parameters.
	 * 
	 * Sets isAlive to the default value of true.
	 */
	public SymptomPerson()
	{
		this.isAlive = true;
	}
	
	
	/**
	 * Constructor given multiple parameters.
	 * 
	 * @param maskStatus
	 * @param covidStatus
	 * @param aliveStatus
	 * @param spreadCapacityFactor
	 */
	public SymptomPerson(boolean maskStatus, 
						 boolean covidStatus, boolean aliveStatus, 
						 int spreadCapacityFactor)
	{
		super(maskStatus, covidStatus, aliveStatus, spreadCapacityFactor);
		this.isAlive = aliveStatus;
		
	}

	////////////////getter and setter for obviouslySick///////////

 /**
    * Get if person is obviously sick
    * 
    * @return True value if the person is obviously sick
    */
	public boolean getObviouslySick() 
	{
		return this.obviouslySick;
	}
/**
    * Set true if person is obviously sick
    *
    */
	public void setObviouslySick(boolean sick)
	{
		this.obviouslySick = sick;
	}
	////////////////getter and setter for isAlive////////////////
/**
    * Get true if person is Alive
    * 
    * @return True value that the person is Alive
    */
	public boolean getIsAlive() 
	{
		return this.isAlive;
	}
/**
    * Set true if person is Alive
    *
    */
	public void setIsAlive(boolean Alive)
	{
		this.isAlive = Alive;
	}

/**
    * Change values of COVID positive and increase spread capacity as Symptomatic person contracts COVID
    *
    */
	public void contract()
	{
		setIsCovidPositive(true);
		setSpreadCapacity(2);
		Random randomObject = new Random();
		if(randomObject.nextInt(100) < 10)
		{
			this.isAlive = false;
		}
	}
/**
    * Decrease value of spread capacity by 1 if proper prevention methods have taken place
    *
    */
	public void decreaseSpreadCapacity()
	{
		setSpreadCapacity(getSpreadCapacity() - 1);
	}
}
