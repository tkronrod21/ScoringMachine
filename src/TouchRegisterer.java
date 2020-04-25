import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Interperates wire inputs and relays the touch that occured
 * @author talkr
 *
 */
public class TouchRegisterer {
	
	private WeaponBeingUsed weapon;
	private HashMap<String, ArrayList<Lights>> possibleEpeeCombos;
	private HashMap<String, ArrayList<Lights>> possibleFoilCombos;
	private HashMap<String, ArrayList<Lights>> possibleSabreCombos;
	
	public TouchRegisterer() {
		this.possibleEpeeCombos = new HashMap();
		this.possibleFoilCombos = new HashMap();
		this.possibleSabreCombos = new HashMap();
		this.fillEpeeCombos();
		this.fillFoilCombos();
		this.fillSabreCombos();
	}
	
	public ArrayList<Lights> interperate(boolean[] wireInputs, 
										WeaponBeingUsed weapon) {
		this.weapon = weapon;
		
		if(this.weapon == WeaponBeingUsed.epee) {
			return this.epee(wireInputs);
		}
		else if(this.weapon == WeaponBeingUsed.sabre) {
			return this.sabre(wireInputs);
		}
		else {
			return this.foil(wireInputs);
		}
	}
	
	/**
	 * Converts wire inputs into readable string for hashmap and returns hashmap value for inputs for epee
	 * @param wires a boolean array of all wires as either on or off
	 * @return arraylist of lights that need to turn on on the machine
	 */
	private ArrayList<Lights> epee(boolean[] wires) {
		String in = "";
		for (boolean b : wires) {
			if(b)
				in += "1";
			else
				in += "0";
		}
		return this.possibleEpeeCombos.get(in);
	}
	
	/**
	 * Converts wire inputs into readable string for hashmap and returns hashmap value for inputs for foil
	 * @param wires a boolean array of all wires as either on or off
	 * @return arraylist of lights that need to turn on on the machine
	 */
	private ArrayList<Lights> foil(boolean[] wires) {
		String in = "";
		for (boolean b : wires) {
			if(b)
				in += "1";
			else
				in += "0";
		}
		return this.possibleFoilCombos.get(in);
	}
	
	/**
	 * Converts wire inputs into readable string for hashmap and returns hashmap value for inputs for sabre
	 * @param wires a boolean array of all wires as either on or off
	 * @return arraylist of lights that need to turn on on the machine
	 */
	private ArrayList<Lights> sabre(boolean[] wires) {
		String in = "";
		for (boolean b : wires) {
			if(b)
				in += "1";
			else
				in += "0";
		}
		return this.possibleSabreCombos.get(in);
	}
	
	/**
	 * Fills HashMap of all possible epee touch combinations
	 */
	private void fillEpeeCombos() {
		possibleEpeeCombos.put("1100000", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch)));
		possibleEpeeCombos.put("0000110", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch)));
		possibleEpeeCombos.put("1101000", new ArrayList<Lights>(Arrays.asList(Lights.leftGround)));
		possibleEpeeCombos.put("1100001", new ArrayList<Lights>(Arrays.asList(Lights.leftGround)));
		possibleEpeeCombos.put("0001110", new ArrayList<Lights>(Arrays.asList(Lights.rightGround)));
		possibleEpeeCombos.put("0010110", new ArrayList<Lights>(Arrays.asList(Lights.rightGround)));
		possibleEpeeCombos.put("1100110", new ArrayList<Lights>(Arrays.asList(Lights.leftGround, Lights.rightTouch)));
		possibleEpeeCombos.put("1110110", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch, Lights.rightGround)));
		possibleEpeeCombos.put("1100111", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftGround)));
		possibleEpeeCombos.put("1110111", new ArrayList<Lights>(Arrays.asList(Lights.leftGround, Lights.rightGround)));
	}
	
	/**
	 * Fills HashMap of all possible foil touch combinations
	 */
	private void fillFoilCombos() {
		possibleFoilCombos.put("0100001", new ArrayList<Lights>(Arrays.asList(Lights.leftOffTarget)));
		possibleFoilCombos.put("0101000", new ArrayList<Lights>(Arrays.asList(Lights.leftGround)));
		possibleFoilCombos.put("0100100", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch)));
		possibleFoilCombos.put("1100110", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftTouch)));
		possibleFoilCombos.put("0110110", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch, Lights.rightOffTarget)));
		possibleFoilCombos.put("0010010", new ArrayList<Lights>(Arrays.asList(Lights.rightOffTarget)));
		possibleFoilCombos.put("1000010", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch)));
		possibleFoilCombos.put("0001010", new ArrayList<Lights>(Arrays.asList(Lights.rightGround)));
		possibleFoilCombos.put("1100011", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftOffTarget)));
		possibleFoilCombos.put("1101010", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftGround)));
		possibleFoilCombos.put("0101110", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch, Lights.rightGround)));
		possibleFoilCombos.put("0100010", new ArrayList<Lights>(Arrays.asList(Lights.leftOffTarget, Lights.rightOffTarget)));
		possibleFoilCombos.put("0100000", new ArrayList<Lights>(Arrays.asList(Lights.leftOffTarget)));
		possibleFoilCombos.put("0000010", new ArrayList<Lights>(Arrays.asList(Lights.rightOffTarget)));
		possibleFoilCombos.put("0101010", new ArrayList<Lights>(Arrays.asList(Lights.leftGround, Lights.rightGround)));
	}
	
	/**
	 * Fills HashMap of all possible sabre touch combinations
	 */
	private void fillSabreCombos() {
		possibleSabreCombos.put("0110100", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch)));
		possibleSabreCombos.put("1000011", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch)));
		possibleSabreCombos.put("0110000", new ArrayList<Lights>(Arrays.asList(Lights.leftOffTarget)));
		possibleSabreCombos.put("0111000", new ArrayList<Lights>(Arrays.asList(Lights.leftGround)));
		possibleSabreCombos.put("0001011", new ArrayList<Lights>(Arrays.asList(Lights.rightGround)));
		possibleSabreCombos.put("1111011", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftGround)));
		possibleSabreCombos.put("0111111", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch, Lights.rightGround)));
		possibleSabreCombos.put("0000011", new ArrayList<Lights>(Arrays.asList(Lights.rightOffTarget)));
		possibleSabreCombos.put("1110111", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftTouch)));
		possibleSabreCombos.put("1110011", new ArrayList<Lights>(Arrays.asList(Lights.rightTouch, Lights.leftOffTarget)));
		possibleSabreCombos.put("0110111", new ArrayList<Lights>(Arrays.asList(Lights.leftTouch, Lights.rightOffTarget)));
		possibleSabreCombos.put("0110011", new ArrayList<Lights>(Arrays.asList(Lights.leftOffTarget, Lights.rightOffTarget)));
		possibleSabreCombos.put("0111011", new ArrayList<Lights>(Arrays.asList(Lights.leftGround, Lights.rightGround)));
	}
}
	

