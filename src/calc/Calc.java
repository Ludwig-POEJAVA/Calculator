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

import buttons.AButtonOperation;
import buttons.DigitButton;
import buttons.signs.*;

public class Calc extends JFrame
{
	private static final long serialVersionUID = 1L;

	private final int BUTTON_SIZE = 128;

	private JTextField display;

	private double	mem;
	private double	buff;

	private AButtonOperation operation;

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
		this.display.setText("Hi there");
		this.display.setBorder(border);
		this.display.setFont(new Font("Consolas", Font.BOLD, this.BUTTON_SIZE / 2));
		this.display.setHorizontalAlignment(JTextField.LEFT);
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
		for (int b: buttonOrder)
		{
			paveNumerique.add("button_" + b, new DigitButton(this, Integer.toString(b), this.BUTTON_SIZE, this.BUTTON_SIZE, b));
		}

		paveNumerique.add("button_decimal_sign", new DecimalButton(this, ".", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveNumerique.add("button_equal", new EqualButton(this, "=", this.BUTTON_SIZE, this.BUTTON_SIZE));

		String sqr = new String(Character.toChars(8730));
		String bck = new String(Character.toChars(8592));
		paveOperation.add("button_clear"/*_______*/, new ClearButton(/*__________*/this, "C", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_backspace"/*___*/, new BackspaceButton(/*______*/this, bck, this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_add"/*_________*/, new AdditionButton(/*_______*/this, "+", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_substract"/*___*/, new SubstractionButton(/*___*/this, "-", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_multiply"/*____*/, new MultiplicationButton(/*_*/this, "x", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_divide"/*______*/, new DivisionButton(/*_______*/this, "/", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_square"/*______*/, new SquareButton(/*_________*/this, "²", this.BUTTON_SIZE, this.BUTTON_SIZE));
		paveOperation.add("button_square_root"/*_*/, new SquareButton(/*_________*/this, sqr, this.BUTTON_SIZE, this.BUTTON_SIZE));

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
		this.doOperation();
		this.operation = button;
		this.swapMemory();
	}

	public void doOperation()
	{
		if (this.operation != null)
		{
			this.mem = this.operation.operation();
			this.updateDisplay(this.mem);
			System.out.print(this.mem);
		}
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
