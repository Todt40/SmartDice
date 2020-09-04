package pack;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class FrameConstructor extends JFrame {

	JLabel jl1;
	public static JLabel jl2;
	public static JLabel jl3;
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
		
		jl1 = new JLabel("Smarter Würfel");
		jl1.setBounds(275, 10, 400, 30);
		Font fond1 = (jl1.getFont().deriveFont(Font.BOLD, 30));
		jl1.setFont(fond1);
		add(jl1);
		
		jl2 = new JLabel("Bitte gib eine Zahl zwischen 1 und 6 ein !");
		jl2.setBounds(125, 90, 700, 50);
		Font fond2 = (jl2.getFont().deriveFont(Font.BOLD, 30));
		jl2.setFont(fond2);
		add(jl2);
		
		jl3 = new JLabel("Invalid Number");
		jl3.setBounds(330, 205, 100, 50);
		Font fond3 = (jl3.getFont().deriveFont(13));	//Bitte in Rot
		jl3.setFont(fond3);
		jl3.setVisible(false);
		add(jl3);
		
		jb = new JButton("Würfeln!");
		jb.setBounds(280, 275, 200, 50);
		jb.addActionListener(new ActionHandler());
		jb.addActionListener(new PlayDice());
		jb.setEnabled(false);
		add(jb);
		
		jt = new JTextField();
		jt.setBounds(330, 190, 100, 30);
		jt.addCaretListener(new CaretHandler());
		jt.addCaretListener(new CaretActor());
		jt.addKeyListener(new NumberOnlyValidation1());
		add(jt);

		
}

//wenn Button gedrückt wurde, wird der Text aus dem Textfeld in die Variable getan
private class ActionHandler implements ActionListener{
			
		@Override
		public void actionPerformed(ActionEvent e) {

			Var.hmeyes1 = jt.getText();
		}
}

//Button ausgrauen, wenn Textfeld leer ist
private class CaretHandler implements CaretListener{

	@Override
	public void caretUpdate(CaretEvent e) {
		
		Var.s = jt.getText();
		Var.s = Var.s.trim();
		
		if(Var.s.isEmpty()) {
			jb.setEnabled(false);
			
		}else {
			jb.setEnabled(true);
		}
	}
}

private class CaretActor implements CaretListener{

	@Override
	public void caretUpdate(CaretEvent e) {
		
		Var.t = jt.getText();
		Var.t = Var.t.trim();
		
		if(Var.t.isEmpty()) {
			jl3.setVisible(false);
		}
	}
}

//Methode um nur Nummern zuzulassen
//nochmal optimieren, weil bei einer einzigen Zahl ebenfalls die Ausgabe erscheint
private class NumberOnlyValidation1 implements KeyListener {
						
	//private int i;
				 
		@Override
		public void keyTyped(KeyEvent e) {	
		}

		@Override
		public void keyPressed(KeyEvent e) {
		//maybe in keyReleased
			try {
				Var.hmeyes2 = Integer.parseInt(FrameConstructor.jt.getText());
				FrameConstructor.jl3.setVisible(false);
						
				} catch (NumberFormatException e2) {
							
					FrameConstructor.jl3.setVisible(true);
					}			
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}
			}
}

