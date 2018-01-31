package buttons.signs;

import buttons.AButtonOperation;
import calc.Calc;

public class AdditionButton extends AButtonOperation
{
	private static final long serialVersionUID = 1L;

	public AdditionButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		this.calc.setOperation(this);
		this.calc.swapMemory();
		System.out.print("+");
	}

	@Override
	public double operation()
	{
		System.out.println("addition en cours");
		return this.calc.getMemory() + this.calc.getBuffer();
	}
}
