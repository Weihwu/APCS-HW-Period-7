import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TempConverter extends JFrame implements ActionListener{
    private Container pane;
    private JLabel instructions;
    private JTextField number;
    private JCheckBox CtoF;
    private JCheckBox FtoC;
    private JButton start;
    
    public TempConverter(){
	this.setTitle("Temperature Converter");
	this.setSize(500,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	instructions = new JLabel("Put a number in the space below for conversion.");
	number = new JTextField(13);
	CtoF = new JCheckBox("Celsius to Fahrenheit");
	FtoC = new JCheckBox("Fahrenheit to Celsius");
	start = new JButton("Convert");

	start.setActionCommand("convert");
	start.addActionListener(this);

	pane.add(instructions);
	pane.add(number);
	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(start);	
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if(action.equals("convert")){
	    String s = number.getText();
	    int n = Integer.parseInt(s);
	    if(CtoF.isSelected()){
		n = ((n*9)/5) + 32;
	    }
	    if(FtoC.isSelected()){
		n = (n-32) * (5/9);
	    }
	    number.setText(n + "");
	}
    }

    public static void main(String[] args){
	TempConverter g = new TempConverter();
	g.setVisible(true);
    }
}