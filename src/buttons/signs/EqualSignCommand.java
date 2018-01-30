package buttons.signs;

import buttons.Command;
import calc.Calc;

public class EqualSignCommand extends Command
{

	private static final long serialVersionUID = 1L;

	private int value;

	public EqualSignCommand(Calc calc, String text, int width, int height)
	{
		super(calc, text, width, height);
	}

	@Override
	public void execute()
	{
		value = value + 0;
	}

}
