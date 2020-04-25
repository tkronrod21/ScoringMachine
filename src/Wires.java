
public enum Wires {
	LA(0),
	LB(1),
	LC(2),
	G(3),
	RA(4),
	RB(5),
	RC(6);
	
	private int index;

	private Wires(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public static Wires getWire(int index) {
		if(index == 0)
			return Wires.LA;
		else if(index == 1)
			return Wires.LB;
		else if(index == 2)
			return Wires.LC;
		else if(index == 3)
			return Wires.G;
		else if(index == 4)
			return Wires.RA;
		else if(index == 5) 
			return Wires.RB;
		else
			return Wires.RC;
	}
}
