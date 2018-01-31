package buttons.operations;

import buttons.AButtonOperation;
import calc.Calc;

public class DivisionButton extends AButtonOperation
{
	private static final long serialVersionUID = 1L;

	public DivisionButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	protected void execute()
	{
		this.calc.setOperation(this);
		System.out.print("/");
	}

	@Override
	public double operation()
	{
		return this.calc.getMemory() / this.calc.getBuffer();
	}
}
