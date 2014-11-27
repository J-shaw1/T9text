package predictivegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The listener for a button so change the current working sig
 * @author jgs328
 *
 */
public class ButtonListener implements ActionListener {

	private PredictiveModel model;
	private int sig;

	/**
	 * Constructor to set up the model, and the sig char
	 * @param k The sig char
	 * @param model The model to work on
	 */
	public ButtonListener(int k, PredictiveModel model) {
		this.model = model;
		this.sig = k;
	}

	/**
	 * Adds what to do then the button is clicked
	 * ActionEvent e The action event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		model.addSigChar(sig);
	}

}
