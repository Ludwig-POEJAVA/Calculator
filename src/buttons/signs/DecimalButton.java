package buttons.signs;

import buttons.AButton;
import calc.Calc;

public class DecimalButton extends AButton
{
	private static final long serialVersionUID = 1L;

	public DecimalButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		System.out.print(".");
	}
}
