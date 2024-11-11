package zombi;

abstract public class Unit {
 private final int MAX;
 private int hp;
 private int pos;
 
 
 Unit(int max, int hp, int pos){
	 this.MAX = max;
	 this.hp = hp;
	 this.pos = pos;
 }
 
 public void setPos(int pos) {
	this.pos = pos;
}
 
 public int getPos() {
	return pos;
}
 
 public void setHp(int hp) {
	this.hp = hp;
}
 
 public int getHp() {
	return hp;
}
 
public int getMax() {
	return MAX;
}
 
 public void move () {
	 if(pos <= 10 ) {
		 pos++;
		 System.out.println("오른쪽으로 이동 : 현위치 : "+ pos);
	 }
 }
 

 abstract void attack(Unit unit); 
}
