package calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import buttons.*;
import buttons.digit.*;
import buttons.operations.*;
import buttons.signs.*;

public class Calc extends JFrame
{
	private static final long serialVersionUID = 1L;

	private final int BUTTON_SIZE = 128;

	private JTextField display;

	private double	memory;
	private double	typing;

	private AButtonOperation operation;

	DecimalButton	decimalButton;
	EqualButton		equalButton;
	DigitButton[]	digits;

	ClearButton				clearButton;
	BackspaceButton			backspaceButton;
	AdditionButton			additionButton;
	SubstractionButton		substractionButton;
	MultiplicationButton	multiplicationButton;
	DivisionButton			divisionButton;
	SquareButton			squareButton;
	SquareRootButton		squareRootButton;

	private boolean isComputationDone;

	public static void main(String... args)
	{
		new Calc();
	}

	Calc()
	{
		super();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("TP DEMINEUR");
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setLayout(new BorderLayout());

		final Border border = BorderFactory.createLineBorder(Color.black);

		this.display = new JTextField();
		this.display.setPreferredSize(new Dimension(this.BUTTON_SIZE, this.BUTTON_SIZE));
		this.add(this.display, BorderLayout.PAGE_START);
		this.display.setText("-0");
		this.display.setBorder(border);
		this.display.setFont(new Font("Consolas", Font.BOLD, this.BUTTON_SIZE / 2));
		this.display.setHorizontalAlignment(JTextField.RIGHT);
		this.display.setVisible(true);

		JPanel paveNumerique = new JPanel();
		paveNumerique.setLayout(new GridLayout(4, 3));
		this.add(paveNumerique, BorderLayout.LINE_START);
		paveNumerique.setVisible(true);

		JPanel paveOperation = new JPanel();
		paveOperation.setLayout(new GridLayout(4, 2));
		this.add(paveOperation, BorderLayout.LINE_END);
		paveOperation.setVisible(true);

		JLabel spacer = new JLabel();
		JPanel paveCentral = new JPanel();
		this.add(paveCentral, BorderLayout.CENTER);
		paveCentral.add("there's a spaceman....", spacer);
		paveCentral.setVisible(true);

		int[] buttonOrder = new int[] {7, 8, 9, 4, 5, 6, 1, 2, 3, 0 };
		this.digits = new DigitButton[10];
		for (int i = 0; i < buttonOrder.length; i++ )
		{
			int val = buttonOrder[i];
			DigitButton digitButton = new DigitButton(this, Integer.toString(val), this.BUTTON_SIZE, this.BUTTON_SIZE, val);
			this.digits[buttonOrder[val]] = digitButton;
			paveNumerique.add("button_" + val, digitButton);
		}

		String sqr = new String(Character.toChars(8730));
		String bck = new String(Character.toChars(8592));

		this.decimalButton /*________*/ = new DecimalButton(this, ".", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.equalButton /*__________*/ = new EqualButton(this, "=", this.BUTTON_SIZE, this.BUTTON_SIZE);

		this.clearButton /*__________*/ = new ClearButton(/*__________*/this, "C", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.backspaceButton /*______*/ = new BackspaceButton(/*______*/this, bck, this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.additionButton/*________*/ = new AdditionButton(/*_______*/this, "+", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.substractionButton/*____*/ = new SubstractionButton(/*___*/this, "-", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.multiplicationButton /*_*/ = new MultiplicationButton(/*_*/this, "x", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.divisionButton /*_______*/ = new DivisionButton(/*_______*/this, "/", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.squareButton /*_________*/ = new SquareButton(/*_________*/this, "²", this.BUTTON_SIZE, this.BUTTON_SIZE);
		this.squareRootButton /*_____*/ = new SquareRootButton(/*_____*/this, sqr, this.BUTTON_SIZE, this.BUTTON_SIZE);

		paveNumerique.add("button_decimal"/*______*/, this.decimalButton);
		paveNumerique.add("button_equal"/*________*/, this.equalButton);

		paveOperation.add("button_clear"/*________*/, this.clearButton);
		paveOperation.add("button_backspace"/*____*/, this.backspaceButton);
		paveOperation.add("button_add"/*__________*/, this.additionButton);
		paveOperation.add("button_substract"/*____*/, this.substractionButton);
		paveOperation.add("button_multiply"/*_____*/, this.multiplicationButton);
		paveOperation.add("button_divide"/*_______*/, this.divisionButton);
		paveOperation.add("button_square"/*_______*/, this.squareButton);
		paveOperation.add("button_square_root"/*__*/, this.squareRootButton);

		this.pack();
		this.setVisible(true);
	}

	public void setDigit(int d)
	{
		this.typing = (this.typing * 10) + d;
		this.updateDisplay(this.typing);
		this.isComputationDone = false;
	}

	public void updateDisplay(double value)
	{
		//Easter egg.
		/*
		if ((this.memory == 0) && (this.typing == 0) && (this.operation != null) && this.operation.getText().equals("+"))
		{
			this.display.setText("0+0=la tête à Toto");
			this.repaint();
		}
		*/
		String displayedValue;
		displayedValue = Double.toString(value);
		this.display.setText(displayedValue);
		this.repaint();

	}

	public void setOperation(AButtonOperation button)
	{
		if ( !this.isComputationDone)
		{
			this.memory = this.typing;
		}
		this.typing = 0;
		this.operation = button;
	}

	public double getMemory()
	{
		return this.memory;
	}

	public void setMemory(double value)
	{
		this.memory = value;
	}

	public double getTyping()
	{
		return this.typing;
	}

	public void setTyping(double value)
	{
		this.typing = value;
	}

	public boolean getComputationStatus()
	{
		return this.isComputationDone;
	}

	public AButtonOperation getOperation()
	{
		return this.operation;
	}

	public void compute()
	{
		if (this.operation != null)
		{
			this.memory = this.operation.operate();
			this.updateDisplay(this.memory);
			this.isComputationDone = true;
		}
	}

	@SuppressWarnings("unused")
	private void myLayoutIsAwesomeAndSexy()
	{
		/*  Layout
		 *
		 *	+------------------------------+
		 *	|                              |
		 *	| +--------------------------+ |
		 *	| |AFFICHAGE                 | |
		 *	| +--------------------------+ |
		 *	|                              |
		 *	| +-------------+  +---------+ |
		 *	| |             |  |         | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| | |7| |8| |9| |  | |C| |<| | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| |             |  |         | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| | |4| |5| |6| |  | |+| |-| | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| |             |  |         | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| | |1| |2| |3| |  | |*| |/| | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| |             |  |         | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| | |0| |.| |=| |  | |²| |V| | |
		 *	| | +-+ +-+ +-+ |  | +-+ +-+ | |
		 *	| |             |  |         | |
		 *	| +-------------+  +---------+ |
		 *	|                              |
		 *	+------------------------------+
		 *
		 */
	}
}
