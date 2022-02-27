import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.event.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

/**
 * Responsibilities of class: Run the main simulation for the program in a GUI
 * References: Morelli, R., &amp; Walde, R. (2016). Java, Java, Java:
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * @author Emilio Aurelio
 * @author Htet Hnin Su Wai Other contributors: None
 * 
 * @version 16 December 2021
 */

// GUI SECTION//

public class CovidSimulationWorld extends JFrame

{

	// fields for text label, text field, slider bars and drop down window

	private static boolean startSwitch = false;

	static String text = "Results: \n";

	static int percentagePositive = 0;
	static Integer timeframe = 0;
	static int percentageMask = 0;
	static int percentageVaccinated = 0;

	private static JPanel mainPanel;
	private JPanel gridPanel;
	private JButton confirmButton;

	private JLabel titleLabel;

	private JLabel covidPercentageLabel; // percentage of population w/ COVID
											// positive
	private JSlider sliderCovidPercentage;

	private JLabel maskPercentageLabel; // percentage of population that wear
										// masks
	private JSlider sliderMaskPercentage;

	private JLabel vaccinePercentageLabel; // percentage of population that is
											// vaccinated
	private JSlider sliderVaccinePercentage;

	private JLabel periodOfSimulationLabel;
	private JComboBox<Integer> periodOfSimulation; // dropdown box for how long
													// simulation is ran

	public static JTextArea simulationResult = new JTextArea(60, 60); // Simulation
																		// result

	/**
	 * Constructor for the GUI window COVIDSimulationWorld where the simulation is
	 * ran.
	 * 
	 */
	// new constructor
	public CovidSimulationWorld() {
		super("Covid Simulation");

		final int WINDOW_WIDTH = 1600;
		final int WINDOW_HEIGHT = 1000;
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		gridPanel = new JPanel();

		createMainPanel();
		add(mainPanel);

		createGridPanel();

		setVisible(true);

	}

	/**
	 * Method to create the Main Panel that uses BorderLayout
	 * 
	 */
	private void createMainPanel() {

		// title label on top, gives prompt instructions
		titleLabel = new JLabel("Welcome to our COVID Simulation!");
		confirmButton = new JButton("Start Simulation");

		// covid percentage label and
		// covid percentage slider in same grid space
		covidPercentageLabel = new JLabel("What percentage of the starting population has COVID?");

		sliderCovidPercentage = new JSlider();
		sliderCovidPercentage.setMajorTickSpacing(10);
		sliderCovidPercentage.setMinorTickSpacing(1);
		sliderCovidPercentage.setPaintTicks(true);
		sliderCovidPercentage.setPaintLabels(true);

		// mask percentage label and
		// mask percentage slider in same grid space
		maskPercentageLabel = new JLabel("What percentage of the population actively wears masks?");

		sliderMaskPercentage = new JSlider();
		sliderMaskPercentage.setMajorTickSpacing(10);
		sliderMaskPercentage.setMinorTickSpacing(1);
		sliderMaskPercentage.setPaintTicks(true);
		sliderMaskPercentage.setPaintLabels(true);

		// vaccine percentage label and
		// vaccine percentage slider in same grid space
		vaccinePercentageLabel = new JLabel("What percentage of the population are vaccinated?");

		sliderVaccinePercentage = new JSlider();
		sliderVaccinePercentage.setMajorTickSpacing(10);
		sliderVaccinePercentage.setMinorTickSpacing(1);
		sliderVaccinePercentage.setPaintTicks(true);
		sliderVaccinePercentage.setPaintLabels(true);

		// time frame dropdown window label and
		// time frame dropdown box in same grid space

		periodOfSimulationLabel = new JLabel(
				"<html>How long do you want to run the simulation for? <br/>Select 1 for a day, 2 for a week and 3 for a month.</html>");
		Integer[] timeFrameOptions = { 1, 2, 3 };
		periodOfSimulation = new JComboBox<Integer>(timeFrameOptions);

		// overarching layout is the border layout, separated into title jlabel
		// and grid layout.
		// grid layout is inside border layout
		BorderLayout mainPanelLayout = new BorderLayout();

		mainPanel.setLayout(mainPanelLayout);
		mainPanel.add(titleLabel, BorderLayout.NORTH);
		mainPanel.add(gridPanel, BorderLayout.CENTER);
		mainPanel.add(simulationResult, BorderLayout.EAST);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.YELLOW);

		ButtonListener buttonListenerObject = new ButtonListener();
		confirmButton.addActionListener(buttonListenerObject);

		mainPanel.add(confirmButton, BorderLayout.SOUTH);
		Font font = new Font("Arial", Font.ITALIC, 15);
		confirmButton.setFont(font);

	}

	/**
	 * Method to create the Grid Panel that includes the widgets and uses the layout
	 * Grid layout.
	 * 
	 */
	private void createGridPanel() {

		GridLayout layoutObjectGrid = new GridLayout(4, 2);
		gridPanel.setLayout(layoutObjectGrid);

		gridPanel.add(covidPercentageLabel);
		gridPanel.add(sliderCovidPercentage);

		gridPanel.add(maskPercentageLabel);
		gridPanel.add(sliderMaskPercentage);

		gridPanel.add(vaccinePercentageLabel);
		gridPanel.add(sliderVaccinePercentage);

		gridPanel.add(periodOfSimulationLabel);
		gridPanel.add(periodOfSimulation);

	}

	/**
	 * Class ButtonListener that assign actions to the Button that runs the
	 * simulation
	 * 
	 */
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			percentagePositive = sliderCovidPercentage.getValue();
			System.out.println("Percentage of COVID positive patients currently: " + percentagePositive + "%");

			timeframe = (Integer) periodOfSimulation.getSelectedItem(); // getting
																		// value

			percentageMask = sliderMaskPercentage.getValue();
			System.out.println("Percentage of people that wears masks: " + percentageMask + "%");
			percentageVaccinated = sliderVaccinePercentage.getValue();
			System.out.println("Percentage of people that are vaccinated: " + percentageVaccinated + "%");
			System.out.println("Option chosen for time frame of Simulation " + "\n"
					+ "(1 - a day, 2 - a week, 3 - a month) : " + timeframe);
			startSwitch = true;

		}

	}

	////////// fields/////////

	/**
	 * 
	 */
	private int day = 1;
	private int numberPeopleCovid = 0;
	private int numberDeaths = 0;

	/////// methods////////
	/**
	 * Get integer value of Day
	 * 
	 * @return integer value of day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Set day to the integer day
	 *
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Increase day value by 1 as one day has passed
	 */
	public void passOneDay() {
		this.setDay(this.getDay() + 1);
	}

	/**
	 * Increase day value by 7 as a week has passed
	 */
	public void passOneWeek() {
		for (int i = 0; i < 7; i++)
			this.setDay(this.getDay() + 1);
	}

	/**
	 * Increase day value by 30 as a month has passed
	 */
	public void passOneMonth() {
		for (int i = 0; i < 30; i++)
			this.setDay(this.getDay() + 1);
	}

	/**
	 * Increment number of people who has COVID by 1
	 */
	public void newCovidPositive() {
		numberPeopleCovid++;
	}

	/**
	 * Increase number of people
	 */
	public void increaseNumberPeopleCovid() {
		this.numberPeopleCovid++;
	}

	/**
	 * Get integer of Number of people who has COVID
	 * 
	 * @return integer of number of people who have COVID
	 */
	public int getNumberPeopleCovid() {
		return numberPeopleCovid;
	}

	/**
	 * Set Number of People who has COVID to integer
	 *
	 */
	public void setNumberPeopleCovid(int numberPeopleCovid) {
		this.numberPeopleCovid = numberPeopleCovid;
	}

	/**
	 * Get integer value of number of Deaths
	 * 
	 * @return integer value of number of deaths
	 */
	public int getNumberDeaths() {
		return numberDeaths;
	}

	/**
	 * Set Number of Deaths to an integer value
	 */
	public void setNumberDeaths(int numberDeaths) {
		this.numberDeaths = numberDeaths;
	}

	public void newDeath() {
		this.numberDeaths++;
	}

	/////// main method////////

	/**
	 * @param args command line arguments
	 * @throws InterruptedException
	 * @throws IllegalArgumentException
	 */

	public void runProgram() {

	}

	public static void main(String args[]) throws InterruptedException {

		// creating a new simulation which will be used to track variables
		// across the whole scope of the program.
		CovidSimulationWorld newSimulation = new CovidSimulationWorld();

		// random object will be used to simulate randomness and probability in
		// the simulation.

		///////////////// lines 368-440 for project 1
		///////////////// version////////////////////

		while (startSwitch == false) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}

		Random randomObject = new Random();
		// Scanner keyboard = new Scanner(System.in);

		// System.out.println("Welcome to our COVID Simulation!");
		// System.out.println(
		// "Please input information prompted in order to run the simulation
		// that shows the spread of COVID-19.");
		// int percentagePositive = -1;
		// int timeframe = -1;

		// try
		// {
		// System.out.println(
		// "What percentage of the starting population has Covid?");
		// percentagePositive = keyboard.nextInt();
		//
		// //slider bar here
		//
		// // to catch integers out of bounds
		// if (!(percentagePositive >= 0 && percentagePositive <= 100))
		// {
		// System.out.print("The integer must be between 0 and 100.");
		// System.exit(0);
		// }
		//
		// System.out.println(
		// "What percentage of the population actively wear masks? (Enter a
		// number from 1-100)");
		//
		// //slider bar here
		//
		// // initialization to -1 in case the try catch blocks do not
		// execute.
		// int percentageMasked = -1;
		// percentageMasked = keyboard.nextInt();
		//
		// // to catch integers out of bounds
		// if (!(percentageMasked >= 0 && percentageMasked <= 100))
		// {
		// System.out.print("The integer must be between 0 and 100.");
		// System.exit(0);
		// }
		//
		// System.out.println(
		// "What percentage of the population is vaccinated? (Enter a number
		// from 1-100)");
		//
		//
		// // to catch integers out of bounds
		// int percentageVaccinated = -1;
		// percentageVaccinated = keyboard.nextInt();
		//
		// if (!(percentageVaccinated >= 0 && percentageVaccinated <= 100))
		// {
		// System.out.print("The integer must be between 0 and 100.");
		// System.exit(0);
		// }
		//
		// System.out.println(
		// "How long would you like to run the simulation for? (Enter 1 for
		// a
		// day, 2 for a week and 3 for month)");
		//
		//
		// timeframe = keyboard.nextInt();
		//
		// if (!(timeframe >= 1 && timeframe <= 3))
		// {
		// System.out.print("The integer must be between 1 and 3.");
		// System.exit(0);
		// }
		//
		// }
		//
		// catch (InputMismatchException e)
		// { // Exception Handler
		// System.out.println("Input not valid! Enter an integer.");
		// System.exit(0);
		// }
		// finally
		// {
		// keyboard.close();
		// }

		// The default starting population for this simulation is 1000//
		// We are assuming half the population of COVID positive patients
		// are
		// symptomatic while the other half are not//

		// creating array for Symptom Person and NonsymptomPerson
		SymptomPerson[] populationArraySymptom = new SymptomPerson[1000 / 2];
		NonsymptomPerson[] populationArrayNonsymptom = new NonsymptomPerson[1000 / 2];

		// filling the arrays with elements
		for (int i = 0; i < 1000 / 2; i++) {

			int randomMaskStatus = randomObject.nextInt(1);
			boolean initialMaskStatus = false;
			if (randomMaskStatus == 1) {
				initialMaskStatus = true;
			}

			int randomCarefulStatus = randomObject.nextInt(1);
			boolean initialCarefulStatus = false;
			if (randomCarefulStatus == 1) {
				initialCarefulStatus = true;
			}

			populationArraySymptom[i] = new SymptomPerson(initialMaskStatus, false, true, 0);
			populationArrayNonsymptom[i] = new NonsymptomPerson(initialMaskStatus, false, initialCarefulStatus, 0);

		}

		for (int i = 0; i < percentagePositive * 10 / 2; i++) {

			int randomPersonSymptom; // variables created for better
										// organization
			int randomPersonNonsymptom;
			randomPersonSymptom = randomObject.nextInt(500 - 1); // minus 1
																	// to
																	// account
																	// for
																	// array
																	// index

			randomPersonNonsymptom = randomObject.nextInt(500 - 1); // minus
																	// 1
																	// to
																	// account
																	// for
																	// array
																	// index

			populationArraySymptom[randomPersonSymptom].contract();
			populationArrayNonsymptom[randomPersonNonsymptom].contract();

		}

		/////////////////////// simulation section//////////////////////////

		int daysToRun = 1;

		if (timeframe == 1) {
			daysToRun = 1; // conversion from user input to total time
		}

		else if (timeframe == 2) {
			daysToRun = 7; // conversion from user input to total time
		}

		else {
			daysToRun = 30; // conversion from user input to total time
		}

		int covidListLocation = 0;

		for (int j = 0; j < daysToRun; j++) {

			newSimulation.setNumberPeopleCovid(0);

			for (int i = 0; i < 500; i++) {

				////// random variables to simulate probability//////
				int victimNumber; // victimNumber variable stands for the
									// location of the person that could
									// potentially get infected
				int vaccinePrevention = 0;
				int maskPrevention = 0;
				int symptomOrNonsymptom;

				for (int k = 0; k < populationArraySymptom[i].getSpreadCapacity(); k++) {

					if (populationArraySymptom[i].getIsAlive() == true) {
						victimNumber = randomObject.nextInt(500);
						symptomOrNonsymptom = randomObject.nextInt(1);

						if (symptomOrNonsymptom == 0) {
							vaccinePrevention = populationArraySymptom[i].getVaccineSuccess();
							maskPrevention = populationArraySymptom[i].getMaskSuccess();

							if (vaccinePrevention < randomObject.nextInt(100)
									&& maskPrevention < randomObject.nextInt(100)) {
								populationArraySymptom[victimNumber].contract();
							}
						}

						else {
							vaccinePrevention = populationArrayNonsymptom[i].getVaccineSuccess();
							maskPrevention = populationArrayNonsymptom[i].getMaskSuccess();

							if (vaccinePrevention < randomObject.nextInt(100)
									&& maskPrevention < randomObject.nextInt(100)) {
								populationArrayNonsymptom[victimNumber].setIsCovidPositive(true);
							}
						}

					}
				}

				populationArrayNonsymptom[i].setSpreadCapacity(0);

				if (populationArrayNonsymptom[i].getIsCareful() == false) {
					victimNumber = randomObject.nextInt(50);
					symptomOrNonsymptom = randomObject.nextInt(1);

					if (symptomOrNonsymptom == 0) {
						populationArraySymptom[victimNumber].contract();
					}

					else {
						populationArrayNonsymptom[victimNumber].contract();
					}
					populationArrayNonsymptom[i].decreaseSpreadCapacity();

					if (populationArrayNonsymptom[i].getIsCovidPositive() == true) {
						populationArrayNonsymptom[i].passOneDaySick();
					}

					if (populationArraySymptom[i].getIsCovidPositive() == true) {
						populationArraySymptom[i].passOneDaySick();
					}

					if (populationArrayNonsymptom[i].getDaysSick() == 14) {
						populationArrayNonsymptom[i].setIsCovidPositive(false);
						populationArrayNonsymptom[i].resetDaysSick();
					}

					if (populationArraySymptom[i].getDaysSick() == 14) {
						populationArraySymptom[i].setIsCovidPositive(false);
						populationArraySymptom[i].resetDaysSick();
					}
				}

				if (populationArrayNonsymptom[i].getIsCovidPositive() == true) {
					newSimulation.newCovidPositive();
				}
			}

			int positive = 0;

			for (int i = 0; i < 500; i++) {
				if (populationArraySymptom[i].getIsCovidPositive() == true) {
					newSimulation.increaseNumberPeopleCovid();
				}

				if (populationArrayNonsymptom[i].getIsCovidPositive() == true) {
					newSimulation.increaseNumberPeopleCovid();
				}

				if (populationArraySymptom[i].getIsAlive() == false) {
					newSimulation.newDeath();
				}

			}

			System.out.println("Number of people with COVID Positive during  day " + newSimulation.getDay() + ": "
					+ newSimulation.getNumberPeopleCovid());

			text = text.concat("Number of people with COVID Positive during  day " + newSimulation.getDay() + ": "
					+ newSimulation.getNumberPeopleCovid()) + "\n";

			newSimulation.passOneDay();

			int[] covidPositiveList = new int[daysToRun];

			covidPositiveList[covidListLocation] = positive;
			covidListLocation++;

		}

		text = text.concat("The Simulation has successfully been ran for " + (newSimulation.getDay() - 1)
				+ " days and the final amount of people with COVID at the end of this simulation is : "
				+ newSimulation.getNumberPeopleCovid()) + "\n";

		simulationResult.setText(text);
		mainPanel.add(simulationResult, BorderLayout.EAST);

		System.out.println(text);

	}

}
