package hw8;
import java.util.Collections;

public class hw8 {
		Collections Max;
		public static void main (String[] args) {
	        Warrior warrior = new Warrior("戰士劉子瑜", 10, 100, 10);
	        Maga mage = new Maga("法師葡萄", 15, 70, 55);

	        mage.useMana(warrior);
	        warrior.useShield();
	        warrior.attack(mage);
	        mage.display();
	        warrior.display();
	    }
	}
	abstract class Character {
	    protected String name;
	    protected int attackPower;
	    protected int health;

	    public Character(String name, int attackPower, int health) {
	        this.name = name;
	        this.attackPower = attackPower;
	        this.health = health;
	    }

	    public void takeDamage(int damage) {
	        health = health - damage;
	        System.out.println(name + "受到" + damage + "傷害，剩餘生命：" + health);
	    }

	    public void attack(Character other) {
	        other.takeDamage(attackPower);
	    }

	    private int attackPower(int attack, int health) {
	        int i = health - attack;
	        return i;
	    }

	    public abstract void display();
	}
	class Warrior extends Character{
	    private int defense;
	    public Warrior(String name, int attackPower, int health, int defense){
	        super(name, attackPower, health);
	        this.defense = defense;
	    }
	    public void useShield(){
	        defense += 10;
	        System.out.println(name+"使用盾牌，防禦上升："+defense);
	    }
	    @Override
	    public void takeDamage(int damage){
	        int reduceDamage = Math.max(damage - defense, 0);
	        super.takeDamage(reduceDamage);
	    }
	    @Override
	    public void display(){
	        System.out.println("戰士名稱："+name+"，攻擊力："+attackPower+"，防禦力："+defense+"，生命值："+health);
	    }
	}
	class Maga extends Character{
	    @Override
	    public void display() {
	        System.out.println("法師名稱："+name+"，攻擊力："+attackPower+"，生命值："+health+"，魔力值："+mana);
	    }
	    private int mana;
	    public Maga(String name, int attackPower, int health, int mana){
	        super(name, attackPower, health);
	        this.mana = mana;
	    }
	    public void useMana(Character other){
	        if(mana >= 20){
	            int spellDamage = attackPower * 2;
	            other.takeDamage(spellDamage);
	            mana = mana - 20;
	            System.out.println(name+"使用魔法攻擊，造成"+spellDamage+"傷害，剩餘魔力："+mana);
	        }else{
	            System.out.println(name+"魔力不足，無法使用魔法攻擊");
	        }
	    }

	}



