package buttons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import calc.Calc;

public abstract class AButton extends JButton
{
	private static final long serialVersionUID = 1L;

	protected Calc calc;

	public AButton(Calc calc, String text, int width, int height)
	{
		super();
		this.calc = calc;

		final Border border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);

		this.setPreferredSize(new Dimension(width, height));

		this.setText(new String(text));
		this.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, Math.min(width, height) / 2));
		this.setBackground(new Color(200, 200, 200));

		this.addActionListener(new ActionListenerCalc(this));
		this.addMouseListener(new MouseListenerCalc(this));
		this.setVisible(true);
	}

	protected abstract void execute();

	@Override
	public String toString()
	{
		return this.getText();
	}

}
