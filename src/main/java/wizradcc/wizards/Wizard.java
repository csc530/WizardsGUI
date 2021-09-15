package wizradcc.wizards;

public class Wizard{
	static final String alignments = "gGEe";
	private String name;
	private String element;
	private int powerLevel;
	private char alignment;
	
	/**
	 * Creates a Wizard
	 * @param name       the name of the wizard
	 * @param element    the wizard's matsered (preferred) element
	 * @param powerLevel an int value representing the Wizard's power
	 * @param alignment  a character representing the Wizard's (moral) alignment, g for good or e for evil
	 */
	public Wizard(String name, String element, int powerLevel, char alignment){
		setName(name);
		setElement(element);
		setPowerLevel(powerLevel);
		setAlignment(alignment);
	}
	
	/**
	 * Get the Wizard's name
	 * @return a String of the Wizard's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Set the Wizard's name
	 * @param name a String of at least 2 characters to be the Wizard's name
	 */
	public void setName(String name){
		if(name.length() < 2)
			throw new IllegalArgumentException("A wizard's name must be at least 2 characters long.");
		this.name = name;
	}
	
	/**
	 * Get the Wizard's element
	 * @return a String of the element's name
	 */
	public String getElement(){
		return element;
	}
	
	/**
	 * Set the Wizard's (preferred) element
	 * @param element the element's name, which must be at least 3 characters long
	 */
	public void setElement(String element){
		if(element.length() < 3)
			throw new IllegalArgumentException("A wizard's element (name) must be at least 3 characters long.");
		this.element = element;
	}
	
	/**
	 * Get the power level value
	 * @return an int of Wizard's power level
	 */
	public int getPowerLevel(){
		return powerLevel;
	}
	
	/**
	 * Set the power level of the Wizard
	 * @param powerLevel a positive int value
	 */
	public void setPowerLevel(int powerLevel){
		if(powerLevel < 0)
			throw new IllegalArgumentException("A wizard's power level cannot be less than zero (negative).");
		this.powerLevel = powerLevel;
	}
	
	/**
	 * Get the string value of the Wizard's (moral) alignment
	 * @return aString of good or evil
	 */
	public String getAlignment(){
		return alignments.indexOf(alignment) > 1 ? "evil" : "good";
	}
	
	/**
	 * Sets the (moral) alignment of the Wizard
	 * @param alignment a boolean if the Wizard is evil, true if the Wizard is evil and false if they are good
	 */
	public void setAlignment(char alignment){
		if(alignments.indexOf(alignment) == -1)
			throw new IllegalArgumentException("A wizard's alignment must be good (g) or evil (e).");
		this.alignment = alignment;
	}
	
	/**
	 * A string summarizing the Wizard
	 * @return a summary of all the Wizard's attributes
	 */
	@Override
	public String toString(){
		String allegiance = (alignment + "").equalsIgnoreCase("e") ? "evil" : "good";
		return String.format("%s the wizard, a master of %s at a power level of %d. One who uses their power for %s.", name, element, powerLevel, allegiance);
	}
}
