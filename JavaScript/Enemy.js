

class Enemy {
	//proToLevel = 0;
	
	// Specific Enemy
    /*constructor(Health, Armor, Potions, Type, Boss ) {
		enHealth = Health;
		enArmor = Armor;
		enPotions = Potions;
		enType = Type;
		enName = Type;
		isBoss = Boss;
		totalEnHealth = Health;
		
	}*/

	
	// Random Enemy
	constructor(level, isBoss) {

		
		this.enPotions = Math.floor(Math.random() * 4);
		this.typeRandomizer = Math.floor(Math.random() * 3);
		

		if(this.typeRandomizer == 0) {
			this.enType = "Archer";
			this.enHealth = Math.floor(Math.random() * 100) + (50 * level);
			this.enArmor = Math.floor(Math.random() * 10) + (15 * level);
			this.damage = Math.floor(Math.random() * 50) + (20 * level);
			this.accuracy = Math.random() + 0.3;
		}
		if(this.typeRandomizer == 1) {
			this.enType = "Bandit";
			this.enHealth = Math.floor(Math.random() * 150) + (50 * level);
			this.enArmor = Math.floor(Math.random() * 15) + (15 * level);
			this.damage = Math.floor(Math.random() * 40) + (20 * level);
			this.accuracy = Math.random() + 0.35;
		}
		if (this.typeRandomizer == 2) {
			this.enType = "RogueKnight";
			this.enHealth = Math.floor(Math.random() * 200) + (50 * level);
			this.enArmor = Math.floor(Math.random() * 20) + (15 * level);
			this.damage = Math.floor(Math.random() * 35) + (20 * level);
			this.accuracy = Math.random() + 0.40;
		}
		
		this.enName = this.enType;
		if (isBoss) {
			this.enHealth += Math.floor(Math.random() * 300) + (200 * level);
			this.enArmor += 20;
			this.damage += Math.floor(Math.random() * 60) + (10 * level);

		}
		
		this.totalEnHealth = this.enHealth;
	}
	
	getEnHealth() {
		return enHealth;
	}
	getTotalEnHealth() {
		return totalEnHealth;
	}
	
	getEnArmor() {
		return enArmor;
	}
	
	isBoss() {
		return isBoss;
	}
	
	getEnPotions() {
		return enPotions;
	}
	
	getName() {
		return enName;
	}
	
	getEnType() {
		return enType;
		
	}
	isAlive() {
			return Alive;}
	
	isDefeated(Warrior) {
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
	getLevel() {
		return level;
	}
	
	
	getDamage() {
		return damage;
	}
	
	
	
	takeDamage(damage, warrior) {
		var damageTaken = damage - this.enArmor;
		/*if (damageTaken <= 0) {
			System.out.println("Their armor was to Strong" + damageTaken);
		}*/
		if (damageTaken > 0) {
		this.enHealth -= damageTaken;
		
		if(this.enHealth <= 0) {
			this.enHealth = 0
			//isDefeated(warrior);
			}
		}
		if (damageTaken <= 0) {
			return 0
		}
		else{
			return damageTaken	
		}		
	}
	
	
	usePotion() {
		this.enHealth += 200;
		if(this.enHealth > this.getTotalEnHealth()) {
			this.enHealth = this.getTotalEnHealth();
		}
		this.enPotions--;
		
			
			}
	attack(warrior) {
		System.out.println(this.getName() + " tries to attack");
		accCheck = randomizer.nextDouble();
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

	
		
	
	
