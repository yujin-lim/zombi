package zombi;


public class Zombi extends Unit {
	
	int power;
	int shield;
	int count;
	
	public Zombi (int pos, int hp, int max, int count, int power, int shield){
		super(pos, hp, max);
		this.count = count;
		this.power = power;
		this.shield = shield;
		
	}
	
	@Override
	void attack(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
