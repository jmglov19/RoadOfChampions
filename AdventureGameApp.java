import javax.swing.JFrame;
 
public class AdventureGameApp {

	public static void main(String[] args) {
		JFrame windowFrame = new JFrame("Adventure Begins");
		
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Adventure game = new Adventure(new User("John", 1500 ), 0
				);
		
		windowFrame.getContentPane().add(new Window(game)); //test());//Window(game));
		
		windowFrame.pack();
		
		windowFrame.setVisible(true);
		
		

	}

}
