package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PlayDice implements ActionListener{
	

@Override
public void actionPerformed(ActionEvent e) {
	
	try {
		MakeMethod.dice();
		
	} catch(IllegalArgumentException e2) {
			Var.dice_eye1++;
		
	}
	
	//System.out.println(Var.dice_eye1); For testing
	//System.out.println(Var.dice_eye2); For testing
	//System.out.println(Var.hmeyes2); For testing
	FrameConstructor.jl2.setText(Var.dice_eye2);

}
	
}

class MakeMethod{
	
	public static void dice() {
		
		Random rand = new Random();
		
		Var.dice_eye1 = rand.nextInt(Var.hmeyes2);
		
			Var.dice_eye1++;
		
			Var.dice_eye2 = String.valueOf(Var.dice_eye1);	
	}
}
