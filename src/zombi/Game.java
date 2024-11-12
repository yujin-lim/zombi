package zombi;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		final int ALONE = 1;
		final int TOGETHER = 2;
		final int GOING = 1;
		final int ATTACK = 1;
		final int POTION = 2;
		final int HILL = 2;

		// pos/hp/MAX/count/power/shield
		Hero hero = new Hero(1, 200, 200, 10, 15, 5);
		Magician magic = new Magician(1, 200, 200, 10, 10, 10);
		Zombi zombi = new Zombi(5, 50, 50, 0, 5, 0);
		Boss boss = new Boss(9, 300, 300, 0, 50, 50);

		int pos = 1;
		hero.setPos(pos);

		while (true) {
			System.out.println("너의 운명입니다. 선택하세요");
			System.out.println("[1] 혼자 갑니다.");
			System.out.println("[2] 힐러와 같이 갑니다.");
			int select = scan.nextInt();

			if (select == ALONE) {
				System.out.println("혼자 가시는 걸 선택하셨습니다. 포션 10개가 지급됩니다.");
				while (true) {
					System.out.println("[1] 앞으로 갈래 ");
					System.out.println("[2] 안갈래 이대로 종료 할꺼야");
					int move = scan.nextInt();

					if (move == GOING) {
						pos = pos + 1;
						hero.setPos(pos);
						if (hero.getPos() == 5) {
							System.out.println("좀비를 만났습니다.");
							while (true) {
								System.out.println("[1] 공격하기 ");
								System.out.println("[2] 포션먹기");
								int sel = scan.nextInt();

								if (sel == ATTACK) {
									zombi.attack(hero);
									hero.attack(zombi);
								} else if (sel == POTION) {
									hero.recovery();
								}
								if (hero.getHp() <= 0) {
									System.out.println("Hero가 죽었습니다.");
									break;
								}
								if (zombi.getHp() <= 0) {
									System.out.println("Zombi가 죽었습니다.");
									break;
								}
							}
						}

						if (hero.getPos() == 9) {
							System.out.println("보스를 만났습니다.");
							while (true) {
								System.out.println("[1] 공격하기 ");
								System.out.println("[2] 포션먹기");
								int sel = scan.nextInt();

								if (sel == ATTACK) {
									boss.attack(hero);
									hero.attack(boss);
								} else if (sel == POTION) {
									hero.recovery();
								}
								if (hero.getHp() <= 0) {
									System.out.println("Hero가 죽었습니다.");
									break;
								}
								if (boss.getHp() <= 0) {
									System.out.println("Boss가 죽었습니다.");
									break;
								}
							}
						}
						if (hero.getPos() == 10) {
							System.out.println("보물을 얻었습니다. 종료합니다.");
							break;
						}
					} else {
						System.out.println("게임을 종료합니다.");
						break;
					}
				}
			}

			else if (select == TOGETHER) {
				System.out.println("힐러와 같이 가시는 걸 선택하셨습니다.");
				while (true) {
					System.out.println("[1] 앞으로 갈래 ");
					System.out.println("[2] 안갈래 이대로 종료 할꺼야");
					int move = scan.nextInt();

					if (move == GOING) {
						pos = pos + 1;
						hero.setPos(pos);
						magic.setPos(pos);
						if (hero.getPos() == 5 && magic.getPos() == 5) {
							System.out.println("좀비를 만났습니다.");
							while (true) {
								System.out.println("[1] 공격하기");
								System.out.println("[2] 회복하기");
								int sel = scan.nextInt();

								if (sel == ATTACK) {
									zombi.attack(hero);
									hero.attack(zombi);
									magic.attack(zombi);
								} else if (sel == HILL) {
									magic.repair(hero);
								}
								if (hero.getHp() <= 0) {
									System.out.println("Hero가 죽었습니다.");
									break;
								}
								if (zombi.getHp() <= 0) {
									System.out.println("Zombi가 죽었습니다.");
									break;
								}
							}
						}
						if (hero.getPos() == 9 && magic.getPos() == 9) {
							System.out.println("보스를 만났습니다.");
							while (true) {
								System.out.println("[1] 공격하기 ");
								System.out.println("[2] 회복하기");
								int sel = scan.nextInt();

								if (sel == ATTACK) {
									boss.attack(hero);
									hero.attack(boss);
								} else if (sel == HILL) {
									magic.repair(hero);
								}
								if (hero.getHp() <= 0) {
									System.out.println("Hero가 죽었습니다.");
									break;
								}
								if (boss.getHp() <= 0) {
									System.out.println("Boss가 죽었습니다.");
									break;
								}
							}
						}
						if (hero.getPos() == 10 && magic.getPos() == 10) {
							System.out.println("보물을 얻었습니다. 종료합니다.");
							break;
						}
					} else {
						System.out.println("게임을 종료합니다.");
						break;
					}
				}
			}
			break;
		}
	}
}
