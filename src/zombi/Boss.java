package zombi;

public class Boss extends Unit {
	
	
	int power;
	int shield;
	int count;
	
	public  Boss(int pos, int hp, int max, int count, int power, int shield){
		super(pos, hp, max);
		this.count = count;
		this.power = power;
		this.shield = shield;
		
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	void attack(Unit hero) {
	
		hero.setHp(hero.getHp()-power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		System.out.println("Boss가"+ power + "의 공격력으로 공격");
		System.out.println("현재 Hero 의 HP : " + hero.getHp());
	}

}