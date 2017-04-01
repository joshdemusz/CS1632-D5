package com.laboon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StepButton extends JButton {

    private MainPanel _m;

    /**
     * Javadoc comment for StepButton
     */
    public StepButton(MainPanel m) {
	super("Step");
	_m = m;
	addActionListener(new StepButtonListener());
    }

    static class StepButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    // _m.step();
	}
    }    
    
}
