package buttons;

import calc.Calc;

public class NumericCommand extends Command
{
	private static final long serialVersionUID = 1L;

	private int value;

	public NumericCommand(Calc calc, String text, int value, int width, int height)
	{
		super(calc, text, width, height);
		this.value = value;
	}

	@Override
	public void execute()
	{
		calc.nextDigit(value);
	}

}
