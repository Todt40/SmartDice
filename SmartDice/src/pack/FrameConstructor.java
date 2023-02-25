package pack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class FrameConstructor extends JFrame {

	JLabel jl1;
	public static JLabel jl2;
	JButton jb;
	public static JTextField jt;
	
	
	public FrameConstructor() {
		
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		setTitle("Smart Dice");
		setLayout(null);
		
		setFocusable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jl1 = new JLabel("Smarter Wuerfel");
		jl1.setBounds(275, 10, 400, 30);
		Font fond1 = (jl1.getFont().deriveFont(Font.BOLD, 30));
		jl1.setFont(fond1);
		add(jl1);
		
		jl2 = new JLabel("Bitte gib eine beliebige Zahl ein!");
		jl2.setBounds(125, 90, 700, 50);
		Font fond2 = (jl2.getFont().deriveFont(Font.BOLD, 30));
		jl2.setFont(fond2);
		add(jl2);
		
		jb = new JButton("Wuerfeln!");
		jb.setBounds(280, 275, 200, 50);
		jb.addActionListener(new PlaceNumber());
		jb.addActionListener(new PlayDice());
		jb.setEnabled(false);
		add(jb);
		
		jt = new JTextField();
		jt.setBounds(330, 190, 100, 30);
		jt.addCaretListener(new IsTextFieldEmpty());
		add(jt);

		
}

private class PlaceNumber implements ActionListener{

	private String w;
	private int v;

	public void TrimNumber() {

		w = jt.getText();
		w = w.replaceAll("\\s","");
		v = Integer.parseInt(w);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			TrimNumber();
			Var.imputEyes = v;

		} catch (NumberFormatException ex) {

			FrameConstructor.jl2.setText("Dies ist keine Zahl!");
			Var.imputEyes = 0;

		}
	}

}

private class IsTextFieldEmpty implements CaretListener{

	private String s;

	@Override
	public void caretUpdate(CaretEvent e) {
		
		s = jt.getText();
		s = s.trim();

		if(s.isEmpty()) {
			jb.setEnabled(false);
			
		}else {
			jb.setEnabled(true);
		}
	}
}
}

