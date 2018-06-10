import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Temperatura extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -8476876886259664341L;
	
	private JLabel lCelsius, lFarenheit;
	private JTextField tCelsius, tFarenheit;
	private JButton bKonweruj;
	private ButtonGroup bgPanel;
	private JRadioButton rbNaC, rbNaF;
	private double tempCelsius, tempFahrenheit;
	
	public Temperatura()
	{
		setSize(380,220);
		setTitle("Konwerter Temperatury");
		setLayout(null);
		
		lCelsius = new JLabel("Stopnie Celsiusza:");
		lCelsius.setBounds(20, 20, 150, 20);
		add(lCelsius);
		
		tCelsius = new JTextField("");
		tCelsius.setBounds(170, 20, 150, 20);
		tCelsius.setText("0");
		add(tCelsius);
		tCelsius.setToolTipText("Podaj temperaturê w stopniach Celsiusza");
		tCelsius.addActionListener(this);
		
		lFarenheit = new JLabel("Stopnie Fahrenheita:");
		lFarenheit.setBounds(20, 70, 150, 20);
		add(lFarenheit);
		
		tFarenheit = new JTextField("");
		tFarenheit.setBounds(170, 70, 150, 20);
		tFarenheit.setText("32");
		add(tFarenheit);
		tFarenheit.setToolTipText("Podaj temperaturê w stopniach Fahrenheita");
		tFarenheit.addActionListener(this);
		
		bKonweruj = new JButton("Konwertuj");
		bKonweruj.setBounds(100, 120, 150, 20);
		add(bKonweruj);
		bKonweruj.setToolTipText("Inicjuje przeliczenie temperatury");
		bKonweruj.addActionListener(this);
		
		bgPanel = new ButtonGroup();
		
		rbNaC = new JRadioButton("C na F", true);
		rbNaC.setBounds(50, 150, 100, 20);
		rbNaC.setSelected(true);
		bgPanel.add(rbNaC);
		add(rbNaC);
		rbNaC.setToolTipText("Przelicza stopnie Celsiusza na Fahrenheita");
//		rbNaC.addActionListener(this);
		
		rbNaF = new JRadioButton("F na C", false);
		rbNaF.setBounds(250, 150, 100, 20);
		bgPanel.add(rbNaF);
		add(rbNaF);
		rbNaF.setToolTipText("Przelicza stopnie Fahrenheita na Celsiusza");
//		rbNaF.addActionListener(this);

	}
	
	public static void main(String[] args)
	{
		Temperatura aplikacja = new Temperatura();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object Ÿród³o = e.getSource();
		if ((Ÿród³o==bKonweruj) || (Ÿród³o==tCelsius) ||(Ÿród³o==rbNaC))
		{
			rbNaC.setSelected(true);
			tempCelsius = Double.parseDouble(tCelsius.getText());
			tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
			tFarenheit.setText(String.valueOf(tempFahrenheit));
		}
		else if ((Ÿród³o==bKonweruj) || (Ÿród³o==tFarenheit) ||(Ÿród³o==rbNaF))
		{
			rbNaF.setSelected(true);
			tempFahrenheit = Double.parseDouble(tFarenheit.getText());
			tempCelsius = (5.0/9.0) * (tempFahrenheit - 32);
			tCelsius.setText(String.valueOf(tempCelsius));
		}
	}		
}