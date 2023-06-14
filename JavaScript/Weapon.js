
class Weapon {
	constructor(Type, level) {
		
		var dmg = Math.floor(Math.random() * 80);
		dmg += 35 * level;
		
		if(Type == 0) {
			this.attackDamage = dmg + 20;
			this.accuracy = 1;// randomizer.nextDouble() + 0.4 ;	
			this.SASArmor = 0;
			this.type = "Bow";
		}
		if (Type == 1) {
			this.attackDamage = dmg + 30;
			this.accuracy = 1; //randomizer.nextDouble() + 0.35;
			this.SASArmor = Math.floor(Math.random(100));
			this.type = "SwordAndSheild";
			
		}
		if(Type == 2) {
			this.attackDamage = dmg;
			this.accuracy = 1;// randomizer.nextDouble() + 0.45;
			this.SASArmor = 0;
			this.type = "dualSwords";
		}
		if (Type == 3) {
			this.attackDamage = 30;
			this.accuracy = 0.5;
			this.SASArmor = 0;
			this.type = "none";
			
		}
		if(Type == 4) {
			this.attackDamage = 35;
			this.accuracy = 0.7; //randomizer.nextDouble() + 0.35;
			this.SASArmor =  10;
			this.type = "SwordAndShield";
			
		}
		
	}
			
	
	getType() {
		return this.type;
	}
	
    getAttackDamage() {
		return this.attackDamage;	
	}
	getAccuracy() {
		return this.accuracy;
	}
	
	getSASArmor() {
		return this.SASArmor;
	}
}
	


