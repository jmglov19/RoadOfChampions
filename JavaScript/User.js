
class User {
	
	constructor(Health) {
		this.health = Health;
		this.enemiesDefeated = 0;
		this.bossesDefeated = 0;
		this.smallPotions = 4;
		this.largePotions = 1;
		this.CurrentWeapon = new Weapon(1, 1);
		this.StoredWeapon = new Weapon(3, 0);
		this.isAlive = true;
		this.equiptedArmor = [];
		this.equiptedArmor[0] = new Armor(0, 0);
		this.equiptedArmor[1] = new Armor(1, 0);
		this.equiptedArmor[2] = new Armor(2, 0);
		this.equiptedArmor[3] = new Armor(3, 0);
		
	}
	
	
    getCurrentWeaponDamage(){
		return this.CurrentWeapon.getAttackDamage();	
	}
	
	getStoredWeaponDamage(){
		return this.StoredWeapon.getAttackDamage();	
	}
	
	getArmor() {
		return this.equiptedArmor[0].armorRating + this.equiptedArmor[1].armorRating + 
				this.equiptedArmor[2].armorRating + this.equiptedArmor[3].armorRating +
				this.CurrentWeapon.getSASArmor();	
	}
	
	getHelmetArmor() {
		return this.equiptedArmor[0].armorRating;
	}
	
	getChestArmor() {
		return this.equiptedArmor[1].armorRating;
	}
	
	getLeggingArmor() {
		return this.equiptedArmor[2].armorRating;
	}
	getBootsArmor() {
		return this.equiptedArmor[3].armorRating;
	}
	
	getEnemiesDeafeted() {
		return this.enemiesDefeated;
	}
	
	getBossesDefeated() {
		return this.bossesDefeated;
	}
	
	checkSmallPotions() {
		if (smallPotions > 0) {
			return true;
		}
		else {return false;}
		
	}
	
	checkLargePotions() {
		if (this.largePotions > 0) {
			return true;
		}
		else {return false;}
		
	}
	
	switchWeapons() {
		var switchWeapon = this.CurrentWeapon;
		this.CurrentWeapon = this.StoredWeapon;
		this.StoredWeapon = switchWeapon;
	}
	
	
	
	checkIfAlive() {
		return this.isAlive;
	}
	
	takeDamage(damage) {
		var damageTaken = damage - this.getArmor();
		if (damageTaken > 0) {
			this.health -= damageTaken;
			
			if (this.health <= 0) {
				this.isAlive = false;
			}
		} 
		return damageTaken	
	}
			
	
	
	
	attack(enemy) {
		
		
		var acc = this.CurrentWeapon.getAccuracy();
		if (Math.random() <= acc) {
			var enType = enemy.enType
			console.log(enType)
			var currentWepType = this.CurrentWeapon.getType();
			
			
			var damage =this.CurrentWeapon.attackDamage;
			console.log(currentWepType)
			console.log(enType)
			console.log(damage)
			if (currentWepType == "Bow") {
				console.log("bow")
				if (enType == "Archer") {
					damage = damage
				}
				if (enType == "Bandit") {
					damage *= 1.5;
				}
				if (enType == "RogueKnight") {
					damage *= 0.5				
				}
			}
			if (currentWepType == "SwordAndShield") {
				console.log("SAS")
				if (enType == "Archer") {
					damage *= 1.5;
					
				}
				if (enType == "Bandit") {
					damage *= 0.5;
					
				}
				if (enType == "RogueKnight") {
					damage = damage
				
				}
				
			}
			if (currentWepType == "dualSwords") {
				console.log("dual")
				if (enType == "Archer") {
					damage  *= 0.5;
				}
				if (enType == "Bandit") {
					damage = damage
				}
				if (enType == "RogueKnight") {
					damage *= 1.5;
				}
				
			}
			if (currentWepType == "none") {
				if (enType == "Archer") {
					damage = damage
				}
				if (enType == "Bandit") {
					damage = damage
				}
				if (enType == "RogueKnight") {
					damage *= 0.75;
				}
				
			}
			console.log(damage)
			var dmgDealt = enemy.takeDamage(Math.round(damage), this);
		}
		return dmgDealt	
}
	
	deafetedEnemiesCounter(enemy) {
		Adventure.levelUp();
		if (enemy.isBoss()) {
			bossesDefeated++;	
		}
		else { enemiesDefeated++;
		}
	}
	
	useLargePotion() {
		if(this.largePotions > 0) {
			this.health += 450;
			if (this.health > 1000){
				this.health = 1000
			}
			this.largePotions -= 1;
			return true
		}
		return false
			
	}
	
	useSmallPotion() {
		if(this.smallPotions > 0) {
			this.health += 150;
			if (this.health > 1000){
				this.health = 1000
			}
			this.smallPotions -= 1;
			return true
		}
		return false
	}
	
	equipArmor(foundArmor) {
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
	
	equipCurrentWeapon(foundWeapon) {
		this.CurrentWeapon = foundWeapon;
	}	
}
