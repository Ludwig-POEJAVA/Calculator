package buttons.signs;

import buttons.AButton;
import calc.Calc;

public class SquareButton extends AButton
{
	private static final long serialVersionUID = 1L;

	public SquareButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		if (this.calc.getComputationStatus())
		{
			this.calc.setMemory(this.calc.getMemory() * this.calc.getMemory());
			this.calc.updateDisplay(this.calc.getMemory());
			System.out.println("phase A");
		}
		else
		{
			this.calc.setTyping(this.calc.getTyping() * this.calc.getTyping());
			this.calc.updateDisplay(this.calc.getTyping());
			System.out.println("phase B");
		}
	}
}
