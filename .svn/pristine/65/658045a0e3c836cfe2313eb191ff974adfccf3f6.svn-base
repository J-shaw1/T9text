package predictivegui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextArea;

/**
 * Represents a label, like the phone screen
 * @author jgs328
 *
 */
@SuppressWarnings("serial")
public class TextField extends JTextArea implements Observer {

	private PredictiveModel model;

	/**
	 * Constructor to set up the model, and create the label
	 * @param model
	 */
	public TextField(PredictiveModel model) {
		super();
		super.setEditable(false);
		super.setLineWrap(true);
		this.model = model;
	}

	/**
	 * States how to update this, gets the current whole message and appends that to the current word
	 * @param arg0 The observable
	 * @param arg1 An object
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(model.getMessage() + model.getCurrentWord());
	}

}
