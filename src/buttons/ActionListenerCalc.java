package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerCalc implements ActionListener
{
	private AButton button;

	ActionListenerCalc(AButton button)
	{
		super();
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		this.button.execute();
	}

}
