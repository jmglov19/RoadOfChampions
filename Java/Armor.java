import java.util.Random;

public class Armor {
	public double armorRating;
	public String type;
	public String name;

	public Random randomizer;
	
	public Armor(String Name, double ArmorPoints, String Type) {
		name = Name;
		type = Type;
		armorRating = ArmorPoints;
		}
	public Armor(String Name) {
		randomizer = new Random();
		name = Name;
		type = Name;
		if (type == "Helmet" ){
			armorRating = (double) randomizer.nextInt(50);
		}
		if(type == "Chestplate") {
			armorRating = (double) randomizer.nextInt(100);	
		}
		
		if(type == "Leggings") {
			armorRating = (double) randomizer.nextInt(75);	
		}
		
		if(type == "Boots") {
			armorRating = (double) randomizer.nextInt(50);	
		}
	}
	
	
	public Armor() {
		
		randomizer = new Random();
		int rantype = randomizer.nextInt(4);
		
		if (rantype == 0 ){
			armorRating = (double) randomizer.nextInt(50);
			type = "Helmet";
			name = type;
		}
		if(rantype == 1) {
			armorRating = (double) randomizer.nextInt(100);	
			type = "Chestplate";
			name = type;
		}
			
		if(rantype == 2) {
			armorRating = (double) randomizer.nextInt(75);	
			type = "Leggings";
			name = type;
		}
			
		if(rantype == 3) {
			armorRating = (double) randomizer.nextInt(50);
			type = "Boots";
			name = type;
		}	
	}
		
	public double getArmorRating() {
		return armorRating;	
	}
	
	public String getType() {
		return this.type;
	}
}

