package zombi;


public class Zombi extends Unit {

	private int power;
	private int shield;
	private int count;

	public Zombi(int pos, int hp, int max, int count, int power, int shield) {
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

	@Override
	public void attack(Unit hero) {
		hero.setHp(hero.getHp() - power);
		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}
		System.out.println("좀비가 " + power + "의 공격력으로 공격" );
		System.out.println(" 현재 Hero hp : " + hero.getHp());
	}
}
