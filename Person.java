import java.util.Random;

/**
 * Responsibilities of class: Holds information about Person relating to their COVID prevention methods
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai
 *         Other contributors: None
 * 
 * @version 23 October 2021
 */
public class Person
{
	Random randomObject = new Random();

	///////// fields//////////////
	private boolean isWearingMask = false;
	private boolean isCovidPositive = false;
	private boolean isInQuarantine = false;

	private int daysSick = 0;
	private int spreadCapacity;
	
	Mask myMask = new Mask();
	Vaccine myVaccine = new Vaccine();
	
	
	private int maskType = randomObject.nextInt(1);

	////////////////////////// methods//////////////////////////////

	public Person()
	{
		this.isWearingMask = false;
		this.isCovidPositive = false;
		this.isInQuarantine = false;
		this.spreadCapacity = 0;
		if(maskType == 0)
		{
			this.myMask = new Mask(0);
			myMask.setIsGoodMask(false);
		}
		else
		{
			this.myMask = new Mask(40);
			myMask.setIsGoodMask(true);
		}
		Vaccine myVaccine = new Vaccine();
	}

	public Person(boolean wearingMask,
			boolean covidStatus, boolean quarantining, int spreadCapacity)

	{
		this.isWearingMask = wearingMask;
		Mask myMask = new Mask(40);
		myVaccine = new Vaccine();
		this.isCovidPositive = covidStatus;
		this.isInQuarantine = quarantining;
		this.spreadCapacity = spreadCapacity;
	}

	//////////////// getter and setter methods//////////////////



/**
    * Get true if person is wearing mask
    * @return True value if person is wearing mask
    */
	public boolean getIsWearingMask()
	{
		return this.isWearingMask;
	}
/**
    * Set true if person is Wearing Mask
    *
    */
	public void setIsWearingMask(boolean maskStatus)
	{
		isWearingMask = maskStatus;
	}

/**
    * Get true if person is COVID positive
    * @return True value if person is COVID positive
    */
	public boolean getIsCovidPositive()
	{
		return this.isCovidPositive;
	}
/**
    * Set true if COVID Positive
    *
    */
	public void setIsCovidPositive(boolean covidStatus)
	{
		this.isCovidPositive = covidStatus;
	}

/**
    * Get true if person is in Quarantine
    * @return True value if person is in Quarantine
    */
	public boolean getIsInQuarantine()
	{
		return this.isInQuarantine;
	}
/**
    * Set true if person is in Quarantine
    *
    */
	public void setIsInQuarantine(boolean quarantineStatus)
	{
		this.isInQuarantine = quarantineStatus;
	}

/**
    * Change value of spread capacity by 5 if person goes to an outdoor venue
    *
    */
	public void goOutdoorEstablishment()
	{
		this.spreadCapacity += 5;
	}

/**
    * Change value of spread capacity by 10 if person goes to an indoor venue
    *
    */
	public void goIndoorEstablishment()
	{
		this.spreadCapacity += 10;
	}
	
/**
    * Get integer value of spread Capacity
    * @return Integer value of spread Capacity
    */
	public int getSpreadCapacity()
	{
		return this.spreadCapacity;
	}
	
/**
    * Set integer value of the current spread Capacity
    * @param currentSpreadCapacity value of current spread Capacity
    */
	public void setSpreadCapacity(int currentSpreadCapacity)
	{
		this.spreadCapacity = currentSpreadCapacity;
	}
/**
    * Get integer value of days of person being sick
    * @return Integer value of days of person being sick
    */	
	public int getDaysSick()
	{
		return this.daysSick;
	}
/**
    * Change value of days sick by increasing 1 as one day has passed
    */	
	public void passOneDaySick()
	{
		this.daysSick++;
	}
	
/**
    * Reset days sick to 0
    */
	public void resetDaysSick()
	{
		this.daysSick = 0;
	}
/**
    * Get integer value of Mask Success 
    * @return integer value of covid spread prevention
    */
	public int getMaskSuccess()
	{
		return this.myMask.getCovidSpreadPrevention();
	}
	
/**
    * Get integer value of Vaccine Success
    * @return integer value of Vaccine Success
    */
	public int getVaccineSuccess()
	{
		return this.myVaccine.getVaccineSuccess();
	}



}
