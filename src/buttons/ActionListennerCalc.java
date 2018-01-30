package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListennerCalc implements ActionListener
{
	private Command command;

	ActionListennerCalc(Command command)
	{
		super();
		this.command = command;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		command.execute();
	}

}
