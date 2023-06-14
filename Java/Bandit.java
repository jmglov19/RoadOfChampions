import java.util.Random;

public class Bandit extends Enemy {
	
	
	public Random randomizer;
	
	public Bandit(double Health, double Armor, int Potions, String Type, boolean boss) {
		super(Health - 25, Armor, Potions, Type, boss  );
		damage = (double)randomizer.nextInt(250);
		accuracy = randomizer.nextDouble() + 0.15;	
	}
	
	public Bandit(boolean isBoss) {	
		randomizer = new Random();
		super.enHealth = (double)randomizer.nextInt(20 + (100 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.enHealth += (double)randomizer.nextInt(500 + (300 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());;
		}
		super.enArmor = (double)randomizer.nextInt(10 + (30 * Adventure.getLevel())) + (20.0 * (double)Adventure.getLevel());
		super.enPotions = randomizer.nextInt(3);
		enType = "Bandit";		
		super.enName = enType;
		if (isBoss) {
			super.enName = "Merc";
		}
		super.isBoss = false;
		super.totalEnHealth = enHealth;
		super.damage = (double)randomizer.nextInt(50 + (30 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.damage += (double)randomizer.nextInt(50 + (30 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		}
		super.accuracy = randomizer.nextDouble() + 0.25;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public void attack(User warrior) {
		if (randomizer.nextDouble() <= accuracy) {	
			warrior.takeDamage(getDamage());}
		}

}
