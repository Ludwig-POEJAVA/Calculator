package buttons.signs;

import buttons.AButtonOperation;
import calc.Calc;

public class SubstractionButton extends AButtonOperation
{
	private static final long serialVersionUID = 1L;

	public SubstractionButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	protected void execute()
	{
	}

	@Override
	public double operation()
	{
		return 0;
	}
}
