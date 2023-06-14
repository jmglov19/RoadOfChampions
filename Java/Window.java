
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Window extends JPanel implements ActionListener, SwingConstants {
	private JLabel healthBar;
	private JButton attack;
	private JButton flee;
	private JButton yes;
	private JButton no;
	private JButton switchWep;
	private JButton smallPotion;
	private JButton largePotion;
	private JLabel equitment;
	private JLabel data;
	private JLabel enemiesDefeated;
	private JLabel Helmet;
	private JLabel Chestplate;
	private JLabel Leggings;
	private JLabel Boots;
	private JLabel totalArmor;
	private JLabel CurrentWeapon;
	private JLabel StoredWeapon;
	private Adventure Game;
	
	
	
	
	public Window(Adventure Test) {
		
		
		super.setPreferredSize(new Dimension(1500, 800)); 

		Game = Test;
		Game.fight();

		
		
		// Health Bar
		this.healthBar = new JLabel("Health =" + String.format("%.3f", Test.Warrior.getHealth()));
		//this.healthBar.setHorizontalTextPosition(RIGHT);
		//this.healthBar.setText
		
		//this.choiceBox.addActionListener(this);
		
		this.attack = new JButton("Attack");		
		this.attack.addActionListener(this);
		
		this.flee = new JButton("Flee");		
		this.flee.addActionListener(this);
		
		this.yes = new JButton("Yes");		
		this.yes.addActionListener(this);
		
		this.no = new JButton("No");		
		this.no.addActionListener(this);
		
		this.switchWep = new JButton("Switch Weapon");		
		this.switchWep.addActionListener(this);
		
		this.smallPotion = new JButton("Use Small Potion");		
		this.smallPotion.addActionListener(this);
		
		this.largePotion = new JButton("Use Large Potion");		
		this.largePotion.addActionListener(this);
		
		
		// Data
		this.data = new JLabel("--");
		//this.data.setText(Test.printFun());
		
		//this.data.setText(String.format("%.3f"));
		
		// Equipment
		this.Helmet = new JLabel("--");
		this.Chestplate = new JLabel("--");
		this.Leggings = new JLabel("--");
		this.Boots = new JLabel("--");
		this.totalArmor = new JLabel("--");
		this.CurrentWeapon = new JLabel("--");
		this.StoredWeapon = new JLabel("--");
		
		
		
		this.Helmet.setText("Helmet =" + String.format("%.3f", Test.Warrior.getHelmetArmor()));	
		this.Chestplate.setText(("ChestPlate =" + String.format("%.3f", Test.Warrior.getChestArmor())));
		this.Leggings.setText("Leggings =" + String.format("%.3f", Test.Warrior.getLeggingArmor()));
		this.Boots.setText("Boots =" + String.format("%.3f", Test.Warrior.getBootsArmor()));
		this.totalArmor.setText("Armor =" + String.format("%.3f", Test.Warrior.getArmor()));
		
		this.CurrentWeapon.setText(Test.Warrior.getActiveWeaponName() + "  " +
				String.format("%.3f", Test.Warrior.getCurrentWeaponDamage()));
		
		this.StoredWeapon.setText(Test.Warrior.getStoredWeaponName() + "  " +
				String.format("%.3f", Test.Warrior.getStoredWeaponDamage()));
		
		
		//this.equitment.setVerticalAlignment(4);//("Armor = " + String.format("%.3f",Test.Warrior.getArmor()));
		//this.equitment.add(Helmet);
		
		
		//this.equitment.setText("Armor = " + String.format("%.3f",Test.Warrior.getArmor()));
		
		
		this.enemiesDefeated = new JLabel ("--");
		
		//this.fromLabel = new JLabel ("Temperature (F)");
		//this.toLabel = new JLabel("Converted Temp") ;
		
		super.setLayout(new BorderLayout());
		
		// add the topcombobox to the PAGESTART section of this panel
		super.add(this.healthBar, BorderLayout.PAGE_START);
		
		JPanel centerPanel = new JPanel();
		JPanel centerLeftPanel = new JPanel();
		JPanel centerLeftRightPanel = new JPanel();
		JPanel centerRightPanel = new JPanel();
		JPanel centerRightLeftPanel = new JPanel();
		JPanel EquipmentPanel = new JPanel();
		
		centerPanel.setLayout(new GridLayout(1,2));
		centerLeftPanel.setLayout(new GridLayout (1,2));
		centerLeftRightPanel.setLayout(new GridLayout(2,1));
		centerRightPanel.setLayout(new GridLayout (1,2));
		centerRightLeftPanel.setLayout(new GridLayout(2,1));
		EquipmentPanel.setLayout(new GridLayout(7,1));
		
		
		centerPanel.add(centerLeftPanel);
		centerPanel.add(centerRightPanel);
		
		centerLeftPanel.add(EquipmentPanel);
		centerLeftPanel.add(centerLeftRightPanel);
		
		EquipmentPanel.add(this.totalArmor);
		EquipmentPanel.add(this.Helmet);
		EquipmentPanel.add(this.Chestplate);
		EquipmentPanel.add(this.Leggings);
		EquipmentPanel.add(this.Boots);
		EquipmentPanel.add(this.CurrentWeapon);
		EquipmentPanel.add(this.StoredWeapon);
		
		
		
		centerLeftRightPanel.add(this.smallPotion);
		centerLeftRightPanel.add(this.largePotion);
		
		centerRightPanel.add(centerRightLeftPanel);
		centerRightPanel.add(this.data);
		
		centerRightLeftPanel.add(attack);
		centerRightLeftPanel.add(flee);		
		//add the centerpanel to the cneter section of this panel		
		super.add(centerPanel, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		
		bottomPanel.setLayout(new GridLayout(1,4));
		
		bottomPanel.add(switchWep);
		bottomPanel.add(yes);
		bottomPanel.add(no);
		bottomPanel.add(enemiesDefeated);
		
		
		super.add(bottomPanel, BorderLayout.PAGE_END);
		
		}
	
	public void actionPerformed(ActionEvent event) {
		// is the action event from the combo box
		//if(event.getSource()== this.choiceBox) {
			// update the description labels according to the choices
			
			//if (this.choiceBox.getSelectedIndex() == 0) {
				//this.fromLabel.setText("Temperature (F)");
				//this.toLabel.setText("Converted Temperature(C)");
			//} else {// if not , must be C--F
				//this.fromLabel.setText("Temperature(C)");
				//this.toLabel.setText("Converted Temperature(F)");
		//	}
			// reset the converted temperature display
			//this.convertedLabel.setText("---");
	//	}
		// was the convert button activated
		if(event.getSource()== this.attack) {
			this.Game.Warrior.attack(Game.Opponent);
		}
		
		if(event.getSource() == this.smallPotion) {
			this.Game.Warrior.useSmallPotion();
		}
		
		if(event.getSource() == this.largePotion) {
			this.Game.Warrior.useLargePotion();
		}
		if(event.getSource() == this.flee) {
			//this.Game.fight();
		}
		
			// perform the appropriate conversion
			//double fromTemperature = Double.parseDouble(this.temperatureField.getText());
			//double toTemperature;
			
			//if (this.choiceBox.getSelectedIndex() == 0) {
				//toTemperature = (fromTemperature - 32) * 5 /9;
				
		//	} else {// if not, it must be C --> F
				//toTemperature = fromTemperature * 9/5 +32;
				
			//}
			//this.convertedLabel.setText(String.format("%.3f", toTemperature));
		
	}
		
}
	

		
	
		
		
		
		 
		
		
	