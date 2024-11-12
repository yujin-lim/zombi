package zombi;


public class Hero extends Unit implements Repairable{
	
	int power;
	int shield;
	int count;
	
	public Hero(int pos, int hp, int max, int count, int power, int shield) {
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void recovery() {
		if (count > 0) {
			setHp(getHp() + 100);
			System.out.println("체력 회복");
			count--;
		} else if (count == 0) {
			System.out.println("포션이 모두 소진되었습니다.");
		}
	}

	@Override
	void attack(Unit enemy) {
		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;

			if (boss.getShield() > 0) {
				int shield = boss.getShield() - power;
				if (shield >= 0) {
					boss.setShield(boss.getShield() - power);
				} else {
					boss.setShield(0);
					boss.setHp(boss.getHp() - shield);
				}
			} else {
				boss.setHp(boss.getHp() - power);
			}

			if (boss.getHp() <= 0) {
				boss.setHp(0);
			}
			System.out.println("히어로가 " + power + "의 공격력으로 공격 ");
			System.out.println("현재 Boss Hp : " + boss.getHp());
		} else {
			enemy.setHp(enemy.getHp() - power);
			if (enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.println("히어로가 " + power + "의 공격력으로 공격");
			System.out.println("현재 zombi Hp : " + enemy.getHp());
		}
	}
}
