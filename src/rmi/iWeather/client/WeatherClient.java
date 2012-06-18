package rmi.iWeather.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import javax.swing.*;

import rmi.iWeather.common.RemoteWeather;

public class WeatherClient extends JFrame implements ActionListener{

	public static void addComponentsToPane(Container pane){
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JButton buttonSubmit = new JButton(new ImageIcon("src/logo.jpg"));
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		pane.add(buttonSubmit, c);
		
		JLabel labelZip = new JLabel(" Zipcode: ");
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		pane.add(labelZip, c);
		
		final JTextField textZip = new JTextField(10);
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		pane.add(textZip, c);
		/*
		JLabel labelCity = new JLabel(" City: ");
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(labelCity, c);
		
		JTextField textCity = new JTextField(10);
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(textCity, c);
		*/
		JLabel labelResult = new JLabel(" Result: ");
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(labelResult, c);
		
		final JTextArea textResult = new JTextArea(10,10);
		c.weightx = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(textResult, c);
		
		buttonSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				String zipcode = textZip.getText();
				try{
					System.setSecurityManager(new RMISecurityManager());
					//RemoteWeather weather = (RemoteWeather) Naming.lookup("rmi://localhost/iWeather");
					RemoteWeather weather = (RemoteWeather) Naming.lookup("rmi://localhost/iWeather");
					textResult.setText(weather.getWeather(zipcode));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("iWeather");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		
		addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Conmmand-line version:
		/*
		try{
			System.setSecurityManager(new RMISecurityManager());
			RemoteWeather weather = (RemoteWeather) Naming.lookup("rmi://localhost/iWeather");
			System.out.println("===Welcome to iWeather service.===");
			System.out.println("Please enter ZIPCODE: ");
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(stdin);
			String input = br.readLine();
			
			System.out.println(weather.getWeather(input));
			//System.out.println(weather.sayHi(input));
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
