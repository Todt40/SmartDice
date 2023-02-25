package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PlayDice implements ActionListener{
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			dice();
		
		} catch(IllegalArgumentException ei) {
			Var.imputEyes++;
			dice();

		}

		FrameConstructor.jl2.setText(Var.dicedString);

	}

	public static void dice() {
		
		Random rand = new Random();
	
		Var.dicedInt = rand.nextInt(Var.imputEyes);
		Var.dicedInt++;
		Var.dicedString = String.valueOf(Var.dicedInt);	
	}
}
