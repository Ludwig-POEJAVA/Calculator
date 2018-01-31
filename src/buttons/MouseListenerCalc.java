package buttons;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerCalc implements MouseListener
{
	AButton	command;
	Color	oldColor;

	MouseListenerCalc(AButton command)
	{
		this.command = command;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		oldColor = command.getBackground();
		command.setBackground(new Color(255, 255, 255));
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		command.setBackground(oldColor);
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
	}
}
