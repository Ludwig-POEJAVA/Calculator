package buttons;

import java.awt.Color;

import calc.Calc;

public class NumericCommand extends Command
{
	private static final long serialVersionUID = 1L;

	private int value;

	public NumericCommand(Calc calc, String text, int value, int width, int height)
	{
		super(calc, text, width, height);
		this.value = value;
		setBackground(new Color(220, 220, 220));
	}

	@Override
	public void execute()
	{
		calc.nextDigit(value);
	}

}
