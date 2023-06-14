import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;


public class Adventure //implements ActionListener//
{
	public User Warrior;
	private int currentTurn;
	Scanner myScanner = new Scanner(System.in);
	public static int level;
	public static int proToLevel;
	
	private int typeRandomizer;
	public Random randomizer;
	public Enemy Opponent;
	private static boolean isBoss;
	public String print;
	
	public Adventure(User userWarrior, int newlevel) {
		randomizer = new Random();
		Warrior = userWarrior;
		typeRandomizer = randomizer.nextInt(3);
		level = newlevel;
		
		if(typeRandomizer == 0) {
			Opponent = new Archer(isBoss);
		}
		if(typeRandomizer == 1) {
			Opponent = new Bandit(isBoss);
		}
		if (typeRandomizer == 2) {
			Opponent = new RogueKnight(isBoss);
		}
		 
		currentTurn = 4;
		
	}
	
	
	
	public void fight() {
		while(isOver()) {
			if(currentTurn == 1) {
				
				//print = "What to you wish to do?";
				System.out.print("What to you wish to do?");
				String command = myScanner.next();
				
				if (command.equals("attack")) {
					Warrior.attack(Opponent);
					 
					currentTurn = 2;
				}
				
				if (command.equals("uselargepotion")) {
					
					Warrior.useLargePotion();
					currentTurn = 2;
				}
				
				if (command.equals("usesmallpotion")) {
					
					Warrior.useSmallPotion();
					currentTurn = 2;
				}
				
				if (command.equals("switchweapons")) {
					
					Warrior.switchWeapons();
					currentTurn = 2;
				}
				
				if (command.equals("checkdefeatedenemies")){					
					System.out.println(Warrior.getEnemiesDeafeted());
					System.out.println(Warrior.getBossesDefeated());
				}
					
			}
			
			//Enemies Turn
			if(currentTurn == 2) {
				
					if (Opponent.getEnHealth () > 0) {
						
						//print ="opponents turn";
						System.out.println("opponents turn");
					if(Opponent.getEnHealth() < Opponent.getTotalEnHealth() * 0.2 &&
						Opponent.getEnPotions() > 0) {
					
							Opponent.usePotion();
							System.out.println(Opponent.getName() + " just Healed");
							currentTurn = 1;
						} 
					else {
						
						System.out.println("Opponent tries to attack");
						Opponent.attack(Warrior);
						currentTurn = 1;
					 
						}
					
					} else {System.out.println("You won!"); 
						int dropChance = randomizer.nextInt(6);
						if (dropChance == 0) {
							weapon droppedWeapon = genWeapon();
							System.out.println("you found a " + droppedWeapon.getName() + " with " + droppedWeapon.getAttackDamage() 
							+ " damage and " + droppedWeapon.getAccuracy() + "accuracy. Equip?");
							String command = myScanner.next();
							
							if (command.equals("yes")) {
								System.out.print("What weapon do you want to drop?");
								String command2 = myScanner.next();
								if (command2.equals("stored")) {
									Warrior.equipStoredWeapon(droppedWeapon);
								}
								if (command2.equals("current")) {
									Warrior.equipCurrentWeapon(droppedWeapon);
								}
								currentTurn = 3;					
							}
							if (command.equals("no")) {
								currentTurn = 3;
							}
						}
						if (dropChance == 1) {
							Armor droppedArmor = genArmor();
							System.out.println("you found a " + droppedArmor.getType() + " with " + droppedArmor.getArmorRating() 
							+ " armor. Equip?");
							String command = myScanner.next();
							if (command.equals("yes")) {
								Warrior.equipArmor(droppedArmor);						
							}
							if (command.equals("no")) {
								currentTurn = 3;
							}
							
						}
						
						currentTurn = 3;
						
					}
			}
			if(currentTurn == 3) {
				System.out.print("What to you wish to do after your victory?");
				String command = myScanner.next();
				System.out.println(command);
				
				if (command.equals("switch")) {
					
					Warrior.switchWeapons();
					System.out.println("you switched to your " + Warrior.getActiveWeaponName());
					currentTurn = 4;
				}
				
				if (command.equals("small")) {
					
					Warrior.useSmallPotion();
					currentTurn = 4;
				}
				
				if (command.equals("large")) {
					Warrior.useLargePotion();
					currentTurn = 4;
				}
				
				if(command.equals("checkarmor")) {
					System.out.println(Warrior.getArmor());
					currentTurn = 4;
				}
				if(command.equals("wepstats")) {
					System.out.println("Cuurent Weapon - " + Warrior.getCurrentWeaponDamage());
					System.out.println("Stored Weapon - " + Warrior.getStoredWeaponDamage());
					currentTurn = 4;
				}
				
				if(command.equals("level")) {
					System.out.println(proToLevel + " " + level);
					currentTurn = 4;
				}
				
				if (command.equals("moveon")) {
					System.out.println("finding new enemy");
					randomizer = new Random();
					typeRandomizer = randomizer.nextInt(3);
					
					if(typeRandomizer == 0) {
						Opponent = new Archer(isBoss);
						isBoss = false;
					}
					if(typeRandomizer == 1) {
						Opponent = new Bandit(isBoss);
						isBoss = false;
					}
					if (typeRandomizer == 2) {
						Opponent = new RogueKnight(isBoss);
						isBoss = false;
					}
					System.out.println(Opponent.getName() + " " + Opponent.getTotalEnHealth() +" " + Opponent.getEnArmor());
					currentTurn = 1;
				}
				
				
			}
			
			if(currentTurn == 4) {
				System.out.println("and?");
				currentTurn = 3;
				
			}
		}myScanner.close();
			
				
}
			

		 
		 
	
	
			
			
	public static void levelUp() {
		proToLevel++;
		if(proToLevel >= 10) {
			isBoss = true;
			level++;
			proToLevel = 0;
		}
	}
	
	public static int getLevel() {
		return level;
	}
		

	public boolean isOver() {
		return Warrior.checkIfAlive();
	}
	
	public weapon genWeapon() {
		return new weapon();
	}
	
	public Armor genArmor() {
		return new Armor();
	}
	
	
	
}
