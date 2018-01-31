package buttons.signs;

import buttons.AButton;
import calc.Calc;

public class SquareRootButton extends AButton
{
	private static final long serialVersionUID = 1L;

	public SquareRootButton(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		if (this.calc.getComputationStatus())
		{
			this.calc.setMemory(Math.sqrt(this.calc.getMemory()));
			this.calc.updateDisplay(this.calc.getMemory());
			System.out.println("phase A");
		}
		else
		{
			this.calc.setTyping(Math.sqrt(this.calc.getTyping()));
			this.calc.updateDisplay(this.calc.getTyping());
			System.out.println("phase B");
		}
	}
}
