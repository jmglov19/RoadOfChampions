import java.util.Random;
public class RogueKnight extends Enemy {
	
	public Random randomizer;
	
	public RogueKnight(double Health, double Armor, int Potions, String Type, boolean boss) {
		super(Health + 75, Armor + 25, Potions, Type, boss  );
		damage = (double)randomizer.nextInt(350);
		accuracy = randomizer.nextDouble() + 0.05;	
	}
	
	public RogueKnight(boolean isBoss) {	
		randomizer = new Random();
		super.enHealth = (double)randomizer.nextInt(30 + (100 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.enHealth += (double)randomizer.nextInt(500 + (300 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());;
		}
		super.enArmor = (double)randomizer.nextInt(30+ (20 * Adventure.getLevel())) + (25.0 * (double)Adventure.getLevel());;
		super.enPotions = randomizer.nextInt(3);
		enType = "RogueKnight";
		super.enName = enType;
		if (isBoss) {
			super.enName = "Captian";
		}
		super.isBoss = false;
		super.totalEnHealth = enHealth;
		damage = (double)randomizer.nextInt(40 + (20 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		if (isBoss) {
			super.damage += (double)randomizer.nextInt(50 + (20 * Adventure.getLevel())) + (50.0 * (double)Adventure.getLevel());
		}
		accuracy = randomizer.nextDouble() + 0.40;
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
