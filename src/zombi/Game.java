package zombi;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//                pos/hp/MAX/count/power/shield
		Hero hero = new Hero(1,100,100,10,15,5);
		Magician magic = new Magician(1,100,100,10,10,10);
		Zombi zombi = new Zombi(5,50,50,0,5,0);
		Boss boss = new Boss(9,200,200,0,50,50);

		int pos = 1;

		while (true) {
			System.out.println("직업을 선택해주세요");
			System.out.println("[1] ");
			System.out.println("[2] ");
			int select = scan.nextInt();

			if (select == 1) {
				System.out.println("전사를 선택하셨습니다.");
			} else if (select == 2) {
				System.out.println("마법사를 선택하셨습니다.");
			}
			if (select == 1) {
				System.out.println("[1] 앞으로 갈래 ");
				System.out.println("[2] 안갈래 이대로 종료 할꺼야");
				int move = scan.nextInt();

				if (move == 1) {
					
					pos = pos + 1;
					hero.setPos(pos);
					if (hero.getPos() == 5) {
						System.out.println("좀비를 만났습니다.");
						while (true) {
							System.out.println("[1] 공격하기 ");
							System.out.println("[2] 포션먹기");
							int sel = scan.nextInt();

							if (sel == 1) {
								zombi.attack(hero);
								hero.attack(zombi);
							} else if (sel == 2) {
								hero.recovery();
								if (hero.getHp() <= 0)
									System.out.println("Hero가 죽었습니다.");
								break;
//								if (zombi.getHp() <= 0)
//									System.out.println("Zombi가 죽었습니다.");
//								break;
							}
						}
					}
					if (hero.getPos() == 9) {
						System.out.println("보스를 만났습니다.");
						while (true) {
							System.out.println("[1] 공격하기 ");
							System.out.println("[2] 포션먹기");
							int sel = scan.nextInt();

							if (sel == 1) {
								zombi.attack(hero);
								hero.attack(zombi);
							} else if (sel == 2) {
								hero.recovery();
								if (hero.getHp() <= 0)
									System.out.println("Hero가 죽었습니다.");
								break;
//								if (zombi.getHp() <= 0)
//									System.out.println("Zombi가 죽었습니다.");
//								break;
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
			} else if (select == 2) {
				System.out.println("[1] 앞으로 갈래 ");
				System.out.println("[2] 안갈래 이대로 종료 할꺼야");
				int move = scan.nextInt();

				if (move == 1) {
					pos = pos + 1;
					magic.setPos(pos);
					if (hero.getPos() == 5) {
						System.out.println("좀비를 만났습니다.");

						while (true) {
							System.out.println("[1] 공격하기 ");
							System.out.println("[2] 포션먹기");
							int sel = scan.nextInt();

							if (sel == 1) {
								zombi.attack(magic);
								magic.attack(zombi);
							} else if (sel == 2) {
								magic.recovery();
								if (magic.getHp() <= 0)
									System.out.println("Magic가 죽었습니다.");
								break;
//								if (zombi.getHp() <= 0)
//									System.out.println("Zombi가 죽었습니다.");
//								break;
							}
						}
					}
					if (magic.getPos() == 9) {
						System.out.println("보스를 만났습니다.");
						while (true) {
							System.out.println("[1] 공격하기 ");
							System.out.println("[2] 포션먹기");
							int sel = scan.nextInt();

							if (sel == 1) {
								zombi.attack(magic);
								magic.attack(zombi);
							} else if (sel == 2) {
								magic.recovery();
								if (magic.getHp() <= 0)
									System.out.println("Magic가 죽었습니다.");
								break;
//								if (zombi.getHp() <= 0)
//									System.out.println("Zombi가 죽었습니다.");
//								break;
							}
						}
					}
					if (magic.getPos() == 10) {
						System.out.println("보물을 얻었습니다. 종료합니다.");
						break;
					}
				} else {
					System.out.println("게임을 종료합니다.");
					break;
				}
			}
		}
	}
}
