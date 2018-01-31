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

	private double	mem;
	private double	buff;

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
		this.buff = (this.buff * 10) + d;
		this.updateDisplay(this.buff);
	}

	public void updateDisplay(double value)
	{
		String displayedValue;
		displayedValue = Double.toString(value);
		this.display.setText(displayedValue);
		this.repaint();
	}

	public void setOperation(AButtonOperation button)
	{
		this.equalButton.execute();
		this.operation = button;
		this.swapMemory();
	}

	public double getMemory()
	{
		return this.mem;
	}

	public void setMemory(double mem)
	{
		this.mem = mem;
	}

	public double getBuffer()
	{
		return this.buff;
	}

	public void setBuffer(double buff)
	{
		this.buff = buff;
	}

	public void swapMemory()
	{
		this.mem = this.buff;
		this.buff = 0;
	}

	public AButtonOperation getOperation()
	{
		return this.operation;
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
