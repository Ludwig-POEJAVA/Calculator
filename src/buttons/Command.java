package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import calc.Calc;

public abstract class Command extends JButton
{
	private static final long serialVersionUID = 1L;

	protected Calc calc;

	public Command(Calc calc, String text, int width, int height)
	{
		super();
		this.calc = calc;

		final Border border = BorderFactory.createLineBorder(Color.black);
		setBorder(border);

		setPreferredSize(new Dimension(width, height));

		setText(new String(text));
		setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, (int) (Math.min(width, height) / 2)));
		setBackground(new Color(200, 200, 200));

		addActionListener(new ActionListenerCalc(this));
		addMouseListener(new MouseListenerCalc(this));
		setVisible(true);
	}

	public abstract void execute();

	public Calc getCalc()
	{
		return calc;
	}

}
