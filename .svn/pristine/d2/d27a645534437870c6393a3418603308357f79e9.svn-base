package predictivegui;

import javax.swing.JFrame;

//import predictive.DictionaryListImpl;
//import predictive.DictionaryMapImpl;
import predictive.DictionaryTreeImpl;

/**
 * The class to run that displays the GUI
 * @author jgs328
 */
public class PredictiveGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Predictive Text");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new PredictiveComponent(new DictionaryTreeImpl()));	
		
		frame.setVisible(true);

	}

}
