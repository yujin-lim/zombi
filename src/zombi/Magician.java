package zombi;


public  class Magician extends Unit implements Repairable{

	private int power;
	private int shield;
	private int count;

	public Magician(int pos, int hp, int max, int count, int power, int shield) {
		super(pos, hp, max);
		this.count = count;
		this.power = power;
		this.shield = shield;

	}
	public void recovery() {
		if(count == 0) {
			System.out.println("포션은 없습니다.");
		}
	}

	@Override
	public void attack(Unit enemy) {
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
			System.out.println("Magician가 " + power + "의 공격력으로 공격 ");
			System.out.println("현재 Boss Hp : " + boss.getHp());
		} else {
			enemy.setHp(enemy.getHp() - power);
			if (enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.println("Magician가 " + power + "의 공격력으로 공격");
			System.out.println("현재 zombi Hp : " + enemy.getHp());
		}
	}

	public void repair(Repairable target) {
		if (target instanceof Repairable) {		
			Hero hero = (Hero) target;
			
		
				hero.setHp(hero.getHp() + 100 );
				String message = String.format("Hero 힐..[HERO HP: %d]", hero.getHp(), hero.getMax());
				System.out.println(message);

			}
			System.out.println(">>>힐 완료>>>");
		}
	}

