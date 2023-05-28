import java.util.Random;

public class Enemy {
	public double enHealth;
	public double enArmor;
	public int enPotions;
	public String enType;
	public String enName;
	public boolean isBoss;
	public double damageTaken;
	public boolean Alive;
	public double totalEnHealth;
	public Random randomizer;
	private int typeRandomizer;
	public double damage;
	public double accuracy;
	private int level;
	private int proToLevel = 0;
	
	// Specific Enemy
	public Enemy(double Health, double Armor, int Potions, String Type, boolean Boss ) {
		enHealth = Health;
		enArmor = Armor;
		enPotions = Potions;
		enType = Type;
		enName = Type;
		isBoss = Boss;
		totalEnHealth = Health;
		
		}
	
	// Random Enemy
	public Enemy() {
		randomizer = new Random();
		enHealth = (double)randomizer.nextInt(200 + (100 * level));
		enArmor = (double)randomizer.nextInt(25 + (15 * level));
		enPotions = randomizer.nextInt(3);
		typeRandomizer = randomizer.nextInt(2);
		
		if(typeRandomizer == 0) {
			enType = "Archer";
		}
		if(typeRandomizer == 1) {
			enType = "Bandit";
		}
		if (typeRandomizer == 2) {
			enType = "RogueKnight";
		}
		
		enName = enType;
		isBoss = false;
		totalEnHealth = enHealth;
	}
		
	public double getEnHealth() {
		return enHealth;
	}
	public double getTotalEnHealth() {
		return totalEnHealth;
	}
	
	public double getEnArmor() {
		return enArmor;
	}
	
	public boolean isBoss() {
		return isBoss;
	}
	
	public int getEnPotions() {
		return enPotions;
	}
	
	public String getName() {
		return enName;
	}
	
	public String getEnType() {
		return enType;
		
	}
	public boolean isAlive() {
			return Alive;}
	
	public void isDefeated(User Warrior) {
		if (this.enHealth <= 0) {
			
			Alive = false;
			System.out.println(this.getName() + " was defeated!");
			Warrior.deafetedEnemiesCounter(this); 
			proToLevel++;
			if (proToLevel >= 10) {
				level++;
				proToLevel = 0;
			}
			
		}
	}
	public int getLevel() {
		return level;
	}
	
	
	public double getDamage() {
		return damage;
	}
	
	
	
	public void takeDamage(double damage, User warrior) {
		damageTaken = damage - this.getEnArmor();
		if (damageTaken <= 0) {
			System.out.println("Their armor was to Strong" + damageTaken);
		}
		if (damageTaken > 0) {
		enHealth -= damageTaken;
		System.out.println(this.getName() + " was hit for " + damageTaken + " damage!" );
		if(this.enHealth <= 0) {
			isDefeated(warrior);
			}
		}			
	}
	
	
	public void usePotion() {
		this.enHealth += 200;
		if(this.enHealth > this.getTotalEnHealth()) {
			this.enHealth = this.getTotalEnHealth();
		}
		this.enPotions--;
		
			
			}
	public void attack(User warrior) {
		System.out.println(this.getName() + " tries to attack");
		double accCheck = randomizer.nextDouble();
		if (accCheck <= accuracy) {	
			warrior.takeDamage(getDamage());
			
			} 
		else {
			System.out.println(this.getName() + " missed!");
			}
		}

	//public Enemy generateEnemy(String genType) {
	//	String enType = genType;
	//	return Enemy((double)randomizer.nextInt(1000), (double)randomizer.nextInt(1000),randomizer.nextInt(3),
				//	enType, false);
		//
		
		
	

	
	}

	
		
	

	
	

	




	


