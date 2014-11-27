package predictivegui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import predictive.ValueMaps;


@SuppressWarnings("serial")
/**
 * Sets up the buttons on the phone
 * @author jgs328
 */
public class PhoneButtons extends JPanel {

	private JButton[][] buttons;
	private final int buttonRows = 4;
	private final int buttonColumns = 3;

	/**
	 * Constructs the buttons, assigns action listeners and add them to the frame
	 * @param model the model to execute on
	 */
	public PhoneButtons(final PredictiveModel model) {
		setLayout(new GridLayout(buttonRows, buttonColumns));

		buttons = new JButton[buttonRows][buttonColumns];

		int k = 1;
		
		for (int i = 0; i < buttonRows - 1; i++) {
			for (int j = 0; j < buttonColumns; j++) {
				String s = new String();
				
				if(k != 1){
					s += String.valueOf(k) + "  (" + ValueMaps.getNumToLettersValueString(k) + ")";	
				}
				else{
					s = "1";
				}
				
				buttons[i][j] = new JButton(s);
				
				if(k != 1){
					buttons[i][j].addActionListener(new ButtonListener(k, model));
				}
				
				k++;
			}
		}
		
		buttons[0][0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.backSpace();
				
			}
		});
		
		buttons[3][0] = new JButton("*");
		
		buttons[3][0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.nextWord();
			}
		});
		
		buttons[3][1] = new JButton("0");
		
		buttons[3][1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				model.newWord();
			}
		});
		
		buttons[3][2] = new JButton("#");
		
		for (int i = 0; i < buttonRows; i++) {
			for (int j = 0; j < buttonColumns; j++) {
				add(buttons[i][j]);
			}
		}
		
	}

}
