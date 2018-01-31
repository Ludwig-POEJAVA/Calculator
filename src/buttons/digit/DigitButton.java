package buttons.digit;

import java.awt.Color;

import buttons.AButton;
import calc.Calc;

public class DigitButton extends AButton
{
	private static final long serialVersionUID = 1L;

	private int value;

	public DigitButton(Calc calc, String text, int width, int height, int value)
	{
		super(calc, text, width, height);
		this.value = value;
		this.setBackground(new Color(220, 220, 220));
	}

	@Override
	public void execute()
	{
		System.out.print(this.value);
		this.calc.setDigit(this.value);
	}
}
