package buttons.operations;

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
	public double operate()
	{
		return this.calc.getMemory() * this.calc.getTyping();
	}
}
