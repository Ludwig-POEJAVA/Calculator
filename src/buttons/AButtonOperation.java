package buttons;

import calc.Calc;

public abstract class AButtonOperation extends AButton
{
	private static final long serialVersionUID = 1L;

	public AButtonOperation(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	protected void execute()
	{
		this.calc.compute();
		this.calc.setOperation(this);
	}

	public abstract double operate();
}
