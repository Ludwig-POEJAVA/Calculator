package buttons.signs;

import buttons.AButton;
import calc.Calc;

public class EqualButton extends AButton
{
	private static final long serialVersionUID = 1L;

	public EqualButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		this.calc.compute();
	}
}
