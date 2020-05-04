import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class InputReader{
	
	List list = (List) Collections.synchronizedList(new LinkedList()); //Queue of signals sent from scoring machine
	
	HashMap<String, String> inputTranslator = new HashMap<String, String>(); //Translates scoring machine signals to commands
	
	public InputReader() {
		this.inputTranslator.put("0", "Foil Mode");
		this.inputTranslator.put("1", "Epee Mode");
		this.inputTranslator.put("2", "Sabre Mode");
		this.inputTranslator.put("3", "Right Score: up");
		this.inputTranslator.put("4", "Right Score: down");
		this.inputTranslator.put("5", "Reset All");
		this.inputTranslator.put("6", "Time: up");
		this.inputTranslator.put("7", "Time: down");
		this.inputTranslator.put("8", "Time: reset");
		this.inputTranslator.put("9", "Score: reset");
		this.inputTranslator.put("10", "Cads: reset");
		this.inputTranslator.put("11", "Left Card: up");
		this.inputTranslator.put("12", "Left Card: down");
		this.inputTranslator.put("13", "Right Card: up");
		this.inputTranslator.put("14", "Right Card: down");
		this.inputTranslator.put("15", "Clock");
		this.inputTranslator.put("16", "Left Score: up");
		this.inputTranslator.put("17", "Left Score: down");
		this.inputTranslator.put("18", "On Target: A");
		this.inputTranslator.put("19", "Off Target: A");
		this.inputTranslator.put("20", "Off Target: B");
		this.inputTranslator.put("21", "On Target: B");
		this.inputTranslator.put("22", "Locked Out");
		this.inputTranslator.put("23", "Reset Lights");
	}
	
}
