import java.util.Random;

public class Archer extends Enemy {
	
	public  Random randomizer;
	
	public Archer(double Health, double Armor, int Potions, String Type, boolean boss) {
		super(Health, Armor, Potions, Type, boss  );
		damage = (double)randomizer.nextInt(300);
		accuracy = randomizer.nextDouble() + 0.1;	
	}
	public Archer(boolean isBoss) {	
		randomizer = new Random();
		super.enHealth = (double)randomizer.nextInt(15 + (100 * Adventure.getLevel()))+ (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.enHealth += (double)randomizer.nextInt(500 + (300 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());;
		}
		super.enArmor = (double)randomizer.nextInt(15 + (15 * Adventure.getLevel())) + (15.0 * (double)Adventure.getLevel());
		super.enPotions = randomizer.nextInt(3);
		super.enName = enType;
		if (isBoss) {
			super.enName = "Ranger";
		}
		super.isBoss = false;
		super.totalEnHealth = enHealth;
		super.damage = (double)randomizer.nextInt(45 + (40 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.damage += (double)randomizer.nextInt(50 + (30 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		}
		
		super.accuracy  = randomizer.nextDouble() + 0.3;
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


