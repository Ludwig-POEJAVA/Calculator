package buttons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import calc.Calc;

public abstract class Command extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private Calc calc;

	public Command(Calc calc, String text, int width, int height)
	{
		super();
		this.calc = calc;

		final Border border = BorderFactory.createLineBorder(Color.black);
		setBorder(border);
		addActionListener(new ActionListennerCalc());

		setPreferredSize(new Dimension(width, height));

		setText(new String(text));

		setVisible(true);
	}

	public abstract void execute();

}
