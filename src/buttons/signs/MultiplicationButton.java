package buttons.signs;

import buttons.AButtonOperation;
import calc.Calc;

public class MultiplicationButton extends AButtonOperation
{
	private static final long serialVersionUID = 1L;

	public MultiplicationButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	protected void execute()
	{
		this.calc.setOperation(this);
		System.out.print("x");
	}

	@Override
	public double operation()
	{
		return this.calc.getMemory() * this.calc.getBuffer();
	}
}
