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
		//*************************************************************************************************************
		//System.out.print(this.button.toString());
		System.out.println("************************************************************************");
		System.out.println("appui sur : " + this.button.toString());
		System.out.println("AVANT");
		System.out.println("\tmemory    =" + this.button.calc.getMemory());
		System.out.println("\ttyping    =" + this.button.calc.getTyping());
		if (this.button.calc.getOperation() != null)
		{
			System.out.println("\toperation =" + this.button.calc.getOperation().toString());
		}
		else
		{
			System.out.println("\toperation = NULL");
		}
		//*************************************************************************************************************

		this.button.execute();

		//*************************************************************************************************************
		System.out.println("APRES");
		System.out.println("\tmemory    =" + this.button.calc.getMemory());
		System.out.println("\ttyping    =" + this.button.calc.getTyping());
		if (this.button.calc.getOperation() != null)
		{
			System.out.println("\toperation =" + this.button.calc.getOperation().toString());
		}
		else
		{
			System.out.println("\toperation = NULL");
		}
		System.out.println();
		//*************************************************************************************************************
	}

}
