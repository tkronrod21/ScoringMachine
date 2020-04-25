import java.util.ArrayList;

public class WireReader {
	
	private long[] lastActivatedTime;
	private TouchRegisterer toucher;
	private WeaponBeingUsed weapon;
	
	public WireReader(TouchRegisterer toucher, WeaponBeingUsed weapon) {
		this.toucher = toucher;
		this.lastActivatedTime = new long[7];
		this.weapon = weapon;
	}
	
	public boolean[] wireTripped(Wires wire, long currentTime) {
		switch(wire) {
		
		case LA:
			this.lastActivatedTime[0] = currentTime;
			break;
		case LB:
			this.lastActivatedTime[1] = currentTime;
			break;
		case LC: 
			this.lastActivatedTime[2] = currentTime;
			break;
		case G:
			this.lastActivatedTime[3] = currentTime;
			break;
		case RA:
			this.lastActivatedTime[4] = currentTime;
			break;
		case RB:
			this.lastActivatedTime[5] = currentTime;
			break;
		case RC:
			this.lastActivatedTime[6] = currentTime;
			break;
		}
		
		return this.determineRelevantWires(wire);
	}
	
	private boolean[] determineRelevantWires(Wires recentWire) {
		long lockoutTime;
		
		if(this.weapon == WeaponBeingUsed.epee) {
			lockoutTime = 40;
		}
		else if(this.weapon == WeaponBeingUsed.foil) {
			lockoutTime = 300;
		}
		else { //sabre
			lockoutTime = 120;
		}
		
		long lastActivatedWireTime = this.lastActivatedTime[recentWire.getIndex()];
		boolean[] activatedWires = new boolean[7];
		
		for(int i = 0; i < this.lastActivatedTime.length; i++) {
			if(lastActivatedWireTime - this.lastActivatedTime[i] <= lockoutTime) {
				activatedWires[i] = true;
			}
			else
				activatedWires[i] = false;
		}
		
		return activatedWires;
	}
}
