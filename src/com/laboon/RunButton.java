package com.laboon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RunButton extends JButton {

    private MainPanel _m;

	/**
	 * Javadoc comment for RunButton()
	 */
    public RunButton(MainPanel m) {
	super("Run");
	_m = m;
	addActionListener(new RunButtonListener());
    }

    class RunButtonListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    _m.run();
	}
    }    
    
}
