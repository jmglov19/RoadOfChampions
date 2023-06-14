
import java.util.Random;
import java.util.Scanner;
public class User {
	
	private double health;
	private int enemiesDefeated;
	private int bossesDefeated;
	private int smallPotions;
	private int largePotions;
	private weapon CurrentWeapon;
	private weapon StoredWeapon;
	private String name;
	private weapon switchWeapon;
	private boolean isAlive;
	public double damageTaken;
	public double acc;
	public Random randomizer;
	private String enType;
	private String currentWepType;
	private double damage;
	private Armor[]equiptedArmor; 
	private Scanner myScanner = new Scanner(System.in);
	
	public User(String Name, double Health ) {
		name = Name;
		health = Health;
		enemiesDefeated = 0;
		bossesDefeated = 0;
		smallPotions = 4;
		largePotions = 1;
		CurrentWeapon = new weapon("starter SAS");
		StoredWeapon = new weapon("none");
		isAlive = true;
		equiptedArmor = new Armor[4];
		equiptedArmor[0] = new Armor("StarterHelmet", 15.00, "helmet");
		equiptedArmor[1] = new Armor("StarterChestplate", 25.00, "chestplate");
		equiptedArmor[2] = new Armor("StarterLeggings", 15.00, "leggings");
		equiptedArmor[3] = new Armor("StarterBoots", 15.00, "boots");
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getCurrentWeaponDamage(){
		return this.CurrentWeapon.getAttackDamage();	
	}
	
	public double getStoredWeaponDamage(){
		return this.StoredWeapon.getAttackDamage();	
	}
	
	public double getArmor() {
		return this.equiptedArmor[0].armorRating + this.equiptedArmor[1].armorRating + 
				this.equiptedArmor[2].armorRating + this.equiptedArmor[3].armorRating +
				this.CurrentWeapon.getSASArmor();	
	}
	
	public double getHelmetArmor() {
		return this.equiptedArmor[0].armorRating;
	}
	
	public double getChestArmor() {
		return this.equiptedArmor[1].armorRating;
	}
	
	public double getLeggingArmor() {
		return this.equiptedArmor[2].armorRating;
	}
	public double getBootsArmor() {
		return this.equiptedArmor[3].armorRating;
	}
	
	public int getEnemiesDeafeted() {
		return enemiesDefeated;
	}
	
	public int getBossesDefeated() {
		return bossesDefeated;
	}
	
	public boolean checkSmallPotions() {
		if (smallPotions > 0) {
			return true;
		}
		else {return false;}
		
	}
	
	public boolean checkLargePotions() {
		if (largePotions > 0) {
			return true;
		}
		else {return false;}
		
	}
	
	public void switchWeapons() {
		switchWeapon = CurrentWeapon;
		CurrentWeapon = StoredWeapon;
		StoredWeapon = switchWeapon;
	}
	
	public String getActiveWeaponName() {
		return CurrentWeapon.getName();
		
	}
	
	public String getStoredWeaponName() {
		return StoredWeapon.getName();
	}
	
	public boolean checkIfAlive() {
		return isAlive;
	}
	
	public void takeDamage(double damage) {
		damageTaken = damage - this.getArmor();
		if (damageTaken > 0) {
			health -= damageTaken;
			System.out.println("you just took " + damageTaken + " damage!");
			if (health <= 0) {
				isAlive = false;
			}
		} else { System.out.println("your armor was to strong");
			
		}
			
	
	}

	
	public void attack(Enemy enemy) {
		randomizer = new Random();
		acc = this.CurrentWeapon.getAccuracy();
		if (randomizer.nextDouble() <= acc) {
			enType = enemy.getEnType();
			currentWepType = this.CurrentWeapon.getType();
			if (currentWepType.equals("Bow")) {
				if (enType.equals("Archer")) {
					damage = CurrentWeapon.getAttackDamage();
				}
				if (enType.equals("Bandit")) {
					damage = CurrentWeapon.getAttackDamage() * 1.5;
				}
				if (enType.equals("RougeKnight")) {
					damage = CurrentWeapon.getAttackDamage() * 0.5;
				}
				
			}
			if (currentWepType.equals("SwordAndShield")) {
				if (enType.equals("Archer")) {
					damage = CurrentWeapon.getAttackDamage() * 1.5;
					
				}
				if (enType.equals("Bandit")) {
					damage = CurrentWeapon.getAttackDamage() * 0.5;
					
				}
				if (enType.equals("RougeKnight")) {
					damage = CurrentWeapon.getAttackDamage();
				
				}
				
			}
			if (currentWepType.equals("dualSwords")) {
				if (enType.equals("Archer")) {
					damage = CurrentWeapon.getAttackDamage() * 0.5;
				}
				if (enType.equals("Bandit")) {
					damage = CurrentWeapon.getAttackDamage();
				}
				if (enType.equals("RougeKnight")) {
					damage = CurrentWeapon.getAttackDamage() * 1.5;
				}
				
			}
			if (currentWepType.equals("none")) {
				if (enType.equals("Archer")) {
					damage = CurrentWeapon.getAttackDamage();
				}
				if (enType.equals("Bandit")) {
					damage = CurrentWeapon.getAttackDamage();
				}
				if (enType.equals("RougeKnight")) {
					damage = CurrentWeapon.getAttackDamage() * 0.75;
				}
				
			}
			System.out.println("hit " + damage);
			enemy.takeDamage(damage, this);
		}
		else { 
			System.out.println("miss");}
	
}
	
	public void deafetedEnemiesCounter(Enemy enemy) {
		Adventure.levelUp();
		if (enemy.isBoss()) {
			bossesDefeated++;	
		}
		else { enemiesDefeated++;
		}
	}
	
	public void useLargePotion() {
		if(this.largePotions > 0) {
			this.health += 450;
			System.out.println("You used a large potion and now have " + this.getHealth());
		} else {
			System.out.println("you don't have any large potions left");
		}
			
	}
	
	public void useSmallPotion() {
		if(this.smallPotions > 0) {
			this.health += 150;
			System.out.println("You used a small potion and now have " + this.getHealth());
		} else {
			System.out.println("you don't have any small potions left");
		}
	}
	
	public void equipArmor(Armor foundArmor) {
		if(foundArmor.getType().equals("Helmet")) {
			this.equiptedArmor[0] = foundArmor;
		}
		if(foundArmor.getType().equals("Chestplate")) {
			this.equiptedArmor[1] = foundArmor;
		}
		if(foundArmor.getType().equals("Leggings")) {
			this.equiptedArmor[2] = foundArmor;
		}
		if(foundArmor.getType().equals("Boots")) {
			this.equiptedArmor[3] = foundArmor;
		}
	}
	
	public void equipCurrentWeapon(weapon foundWeapon) {
		this.CurrentWeapon = foundWeapon;
	}

	public void equipStoredWeapon(weapon foundWeapon) {
		this.StoredWeapon = foundWeapon;
	}

	
		
		
	
	

	
}
