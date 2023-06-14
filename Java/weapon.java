import java.util.Random;

public class weapon {
	private double attackDamage;
	private double accuracy;
	private String name;
	private String type;
	private double SASArmor;
	public Random randomizer;
	public weapon(String Type) {
		randomizer = new Random();
		
		if ( Type.equals("Bow")) {
			attackDamage = (double)randomizer.nextInt(100 + (35 * Adventure.getLevel()));
			accuracy = 1;// randomizer.nextDouble() + 0.4;	
			SASArmor = 0;
			type = Type;
			name = Type;
		}
		if (Type.equals("SwordAndSheild")) {
			attackDamage = (double)randomizer.nextInt(110 + (35 * Adventure.getLevel()));
			accuracy = 1; //randomizer.nextDouble() + 0.35;
			SASArmor = randomizer.nextInt(100);
			type = Type;
			name = Type;
		}
		if(Type.equals("dualSwords")) {
			attackDamage = (double)randomizer.nextInt(80 + (35 * Adventure.getLevel()));
			accuracy = 1;// randomizer.nextDouble() + 0.45;
			SASArmor = 0;
			type = Type;
			name = Type;
		}
		if (Type.equals("none")) {
			attackDamage = 30;
			accuracy = 0.5;
			SASArmor = 0;
			type = Type;
			name = Type;
		}
		if(Type.equals("starter SAS")) {
			attackDamage = 35;
			accuracy = 0.7; //randomizer.nextDouble() + 0.35;
			SASArmor =  10;
			type = "SwordAndShield";
			name = type;
		}
		
	}
		
	
	
	public weapon() {
		randomizer = new Random();
		int ranGen = randomizer.nextInt(3);
		
		if ( ranGen == 0) {
			attackDamage = (double)randomizer.nextInt(100 + (35 * Adventure.getLevel()));
			accuracy = 1;// randomizer.nextDouble() + 0.4;	
			SASArmor = 0;
			type = "Bow";
			name = type;
			
		}
		if (ranGen == 1) {
			attackDamage = (double)randomizer.nextInt(110 + (35 * Adventure.getLevel()));
			accuracy = 1; //randomizer.nextDouble() + 0.35;
			SASArmor = randomizer.nextInt(100);
			type = "SwordAndSheild";
			name = type;
		}
		if(ranGen == 2) {
			attackDamage = (double)randomizer.nextInt(80 + (35 * Adventure.getLevel()));
			accuracy = 1;// randomizer.nextDouble() + 0.45;
			SASArmor = 0;
			type = "dualSwords";
			name = type;
		}
			
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getAttackDamage() {
		return attackDamage;	
	}
	public double getAccuracy() {
		return accuracy;
	}
	
	public double getSASArmor() {
		return SASArmor;
	}
	
	
		

}
	


