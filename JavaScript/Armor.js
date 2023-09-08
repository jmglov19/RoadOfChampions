
class Armor {
		
	constructor(type, level) {
		
		if (type == 0){
			this.armorRating = Math.floor(Math.random() * 15) + (15 * level);
			this.type = "Helmet";
		}
		if(type == 1) {
			this.armorRating = Math.floor(Math.random() * 40) + (15 * level);	
			this.type = "Chestplate";			
		}
			
		if(type == 2) {
			this.armorRating = Math.floor(Math.random() * 35) + (15 * level);
			this.type = "Leggings";			
		}
			
		if(type == 3) {
			this.armorRating = Math.floor(Math.random() * 15) + (15 * level);
			this.type = "Boots"			
		}	
	}
		
	getArmorRating() {
		return armorRating;	
	}
	
	getType() {
		return this.type;   
	}

    setBaseStats(){
        if(this.type == "Helmet"){
            this.armorRating = 15;
        }

        if(this.type == "Chestplate"){
            this.armorRating = 25;

        }
        if(this.type == "Leggings"){
            this.armorRating = 15;

        }
        if(this.type == "Boots"){
            this.armorRating = 15;
        }
        
    }
}

