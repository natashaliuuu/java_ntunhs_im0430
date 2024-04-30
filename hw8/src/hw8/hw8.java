package hw8;
import java.util.Collections;

public class hw8 {
		Collections Max;
		public static void main (String[] args) {
	        Warrior warrior = new Warrior("�Ԥh�B�l��", 10, 100, 10);
	        Maga mage = new Maga("�k�v����", 15, 70, 55);

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
	        System.out.println(name + "����" + damage + "�ˮ`�A�Ѿl�ͩR�G" + health);
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
	        System.out.println(name+"�ϥά޵P�A���m�W�ɡG"+defense);
	    }
	    @Override
	    public void takeDamage(int damage){
	        int reduceDamage = Math.max(damage - defense, 0);
	        super.takeDamage(reduceDamage);
	    }
	    @Override
	    public void display(){
	        System.out.println("�Ԥh�W�١G"+name+"�A�����O�G"+attackPower+"�A���m�O�G"+defense+"�A�ͩR�ȡG"+health);
	    }
	}
	class Maga extends Character{
	    @Override
	    public void display() {
	        System.out.println("�k�v�W�١G"+name+"�A�����O�G"+attackPower+"�A�ͩR�ȡG"+health+"�A�]�O�ȡG"+mana);
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
	            System.out.println(name+"�ϥ��]�k�����A�y��"+spellDamage+"�ˮ`�A�Ѿl�]�O�G"+mana);
	        }else{
	            System.out.println(name+"�]�O�����A�L�k�ϥ��]�k����");
	        }
	    }

	}



