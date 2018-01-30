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

import buttons.NumericCommand;
import buttons.signs.DecimalSignCommand;
import buttons.signs.EqualSignCommand;

public class Calc extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int BUTTON_SIZE = 100 + 41 * 0;

	private JTextField display;

	private double	mem;
	private boolean	isDecimal;

	public static void main(String... args)
	{
		new Calc();
	}

	Calc()
	{

		super();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("TP DEMINEUR");
		setResizable(false);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		final Border border = BorderFactory.createLineBorder(Color.black);

		display = new JTextField();
		display.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
		add(display, BorderLayout.PAGE_START);
		display.setText("Hi there");
		display.setBorder(border);
		display.setFont(new Font("Consolas", Font.BOLD, (int) (BUTTON_SIZE / 2)));
		display.setVisible(true);

		JPanel paveNumerique = new JPanel();
		paveNumerique.setLayout(new GridLayout(4, 3));
		add(paveNumerique, BorderLayout.LINE_START);
		paveNumerique.setVisible(true);

		JPanel paveOperation = new JPanel();
		paveOperation.setLayout(new GridLayout(4, 2));
		add(paveOperation, BorderLayout.LINE_END);
		paveOperation.setVisible(true);

		JLabel spacer = new JLabel();
		JPanel paveCentral = new JPanel();
		add(paveCentral, BorderLayout.CENTER);
		paveCentral.add("there's a spaceman....", spacer);
		paveCentral.setVisible(true);

		int[] buttonOrder = new int[] {7, 8, 9, 4, 5, 6, 1, 2, 3, 0 };
		for (int b: buttonOrder)
		{
			paveNumerique.add("button_" + b, new NumericCommand(this, Integer.toString(b), b, BUTTON_SIZE, BUTTON_SIZE));
		}

		paveNumerique.add("button_decimal_sign", new DecimalSignCommand(this, ".", BUTTON_SIZE, BUTTON_SIZE));
		paveNumerique.add("button_equal", new EqualSignCommand(this, "=", BUTTON_SIZE, BUTTON_SIZE));

		paveOperation.add("button_clear______", new EqualSignCommand(this, "C", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_backspace__", new EqualSignCommand(this, new String(Character.toChars(8592)), BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_add________", new EqualSignCommand(this, "+", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_substract__", new EqualSignCommand(this, "-", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_multiply___", new EqualSignCommand(this, "x", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_divide_____", new EqualSignCommand(this, "/", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_square_____", new EqualSignCommand(this, "²", BUTTON_SIZE, BUTTON_SIZE));
		paveOperation.add("button_square_root", new EqualSignCommand(this, new String(Character.toChars(8730)), BUTTON_SIZE, BUTTON_SIZE));

		pack();
		setVisible(true);
	}

	public void nextDigit(int d)
	{
		mem = mem * 10 + d;
		display.setText(Double.toString(mem));
		repaint();
	}

	/*  Layout
	 * 
	 *	+-----------------------+
	 *	|                       |
	 *	| +-------------------+ |
	 *	| |AFFICHAGE          | |
	 *	| +-------------------+ |
	 *	|                       |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	| |7| |8| |9|   |C| |<| |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	|                       |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	| |4| |5| |6|   |+| |-| |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	|                       |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	| |1| |2| |3|   |*| |/| |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	|                       |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	| |0| |.| |=|   |²| |V| |
	 *	| +-+ +-+ +-+   +-+ +-+ |
	 *	|                       |
	 *	+-----------------------+
	 *
	 */
}
