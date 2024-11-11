package zombi;

public  class Magician extends Unit {

	int power;
	int shield;
	int count;

	public Magician(int pos, int hp, int max, int count, int power, int shield) {
		super(pos, hp, max);
		this.count = count;
		this.power = power;
		this.shield = shield;

	}
	
	
	public void recovery() {
		if(count > 0) {
			setHp(getHp()+100);
			System.out.println("체력 회복");
			count --;
		}
		else if(count == 0) {
			System.out.println("포션이 모두 소진되었습니다.");
		}
	}


	@Override
	void attack(Unit unit) {
		// TODO Auto-generated method stub
		
	}
}
