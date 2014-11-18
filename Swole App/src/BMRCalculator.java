import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BMRCalculator extends JPanel {

	private JTextField txtWeight;
	private JTextField txtHeight;
	private JTextField txtAge;
	private boolean sex = true; //t is Male f is Female male is selected as default
	private JTextField txtBMR;
	private double weight =0;
	private double heightInInches = 0;
	private int years = 0;
	private double activityMultiplyer = 1.2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public BMRCalculator() {
		setBounds(100, 100, 450, 300);
		
		JLabel lblWeight = new JLabel("Weight in lbs:");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.gridx = 0;
		gbc_lblWeight.gridy = 0;
		add(lblWeight, gbc_lblWeight);
		
		txtWeight = new JTextField();
		GridBagConstraints gbc_txtWeight = new GridBagConstraints();
		gbc_txtWeight.insets = new Insets(0, 0, 5, 5);
		gbc_txtWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWeight.gridx = 1;
		gbc_txtWeight.gridy = 0;
		add(txtWeight, gbc_txtWeight);
		txtWeight.setColumns(10);
		
		JLabel lblHeightInInches = new JLabel("Height in inches:");
		GridBagConstraints gbc_lblHeightInInches = new GridBagConstraints();
		gbc_lblHeightInInches.anchor = GridBagConstraints.EAST;
		gbc_lblHeightInInches.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeightInInches.gridx = 0;
		gbc_lblHeightInInches.gridy = 1;
		add(lblHeightInInches, gbc_lblHeightInInches);
		
		txtHeight = new JTextField();
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.insets = new Insets(0, 0, 5, 5);
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 1;
		gbc_txtHeight.gridy = 1;
		add(txtHeight, gbc_txtHeight);
		txtHeight.setColumns(10);
		
		JLabel lblAgeInYears = new JLabel("Age in years:");
		GridBagConstraints gbc_lblAgeInYears = new GridBagConstraints();
		gbc_lblAgeInYears.anchor = GridBagConstraints.EAST;
		gbc_lblAgeInYears.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgeInYears.gridx = 0;
		gbc_lblAgeInYears.gridy = 2;
		add(lblAgeInYears, gbc_lblAgeInYears);
		
		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.insets = new Insets(0, 0, 5, 5);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 1;
		gbc_txtAge.gridy = 2;
		add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		GridBagConstraints gbc_lblSex = new GridBagConstraints();
		gbc_lblSex.anchor = GridBagConstraints.EAST;
		gbc_lblSex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex.gridx = 0;
		gbc_lblSex.gridy = 3;
		add(lblSex, gbc_lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
		gbc_rdbtnMale.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMale.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMale.gridx = 1;
		gbc_rdbtnMale.gridy = 3;
		add(rdbtnMale, gbc_rdbtnMale);
		
		 JRadioButton rdbtnSedentary = new JRadioButton("Sedentary");
		 GridBagConstraints gbc_rdbtnSedentary = new GridBagConstraints();
		 gbc_rdbtnSedentary.anchor = GridBagConstraints.WEST;
		 gbc_rdbtnSedentary.insets = new Insets(0, 0, 5, 5);
		 gbc_rdbtnSedentary.gridx = 1;
		 gbc_rdbtnSedentary.gridy = 4;
		 add(rdbtnSedentary, gbc_rdbtnSedentary);
		 
		 JRadioButton rdbtnLightActivity = new JRadioButton("Light Activity");
		 GridBagConstraints gbc_rdbtnLightActivity = new GridBagConstraints();
		 gbc_rdbtnLightActivity.anchor = GridBagConstraints.WEST;
		 gbc_rdbtnLightActivity.insets = new Insets(0, 0, 5, 0);
		 gbc_rdbtnLightActivity.gridx = 2;
		 gbc_rdbtnLightActivity.gridy = 4;
		 add(rdbtnLightActivity, gbc_rdbtnLightActivity);
		 
		 JRadioButton rdbtnModerateActivity = new JRadioButton("Moderate Activity");
		 GridBagConstraints gbc_rdbtnModerateActivity = new GridBagConstraints();
		 gbc_rdbtnModerateActivity.anchor = GridBagConstraints.WEST;
		 gbc_rdbtnModerateActivity.insets = new Insets(0, 0, 5, 5);
		 gbc_rdbtnModerateActivity.gridx = 1;
		 gbc_rdbtnModerateActivity.gridy = 5;
		 add(rdbtnModerateActivity, gbc_rdbtnModerateActivity);
		 
		 JRadioButton rdbtnIntenseActivity = new JRadioButton("Intense Activity");
		 GridBagConstraints gbc_rdbtnIntenseActivity = new GridBagConstraints();
		 gbc_rdbtnIntenseActivity.anchor = GridBagConstraints.WEST;
		 gbc_rdbtnIntenseActivity.insets = new Insets(0, 0, 5, 0);
		 gbc_rdbtnIntenseActivity.gridx = 2;
		 gbc_rdbtnIntenseActivity.gridy = 5;
		 add(rdbtnIntenseActivity, gbc_rdbtnIntenseActivity);
		 
		 JRadioButton rdbtnVeryIntenseActivity = new JRadioButton("Very Intense Activity");
		 GridBagConstraints gbc_rdbtnVeryIntenseActivity = new GridBagConstraints();
		 gbc_rdbtnVeryIntenseActivity.anchor = GridBagConstraints.WEST;
		 gbc_rdbtnVeryIntenseActivity.insets = new Insets(0, 0, 5, 5);
	 	 gbc_rdbtnVeryIntenseActivity.gridx = 1;
		 gbc_rdbtnVeryIntenseActivity.gridy = 6;
		 add(rdbtnVeryIntenseActivity, gbc_rdbtnVeryIntenseActivity);
		 
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
		gbc_rdbtnFemale.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnFemale.anchor = GridBagConstraints.WEST;
		gbc_rdbtnFemale.gridx = 2;
		gbc_rdbtnFemale.gridy = 3;
		add(rdbtnFemale, gbc_rdbtnFemale);
		
		 ButtonGroup grpGender = new ButtonGroup();
		 grpGender.add(rdbtnFemale);
		 grpGender.add(rdbtnMale);
		 rdbtnMale.setSelected(true);
		 
		 rdbtnFemale.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		sex = true;
			 	}
			 });
		 rdbtnMale.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		sex = false;
			 	}
			 });
		 
		 ButtonGroup grpActivity = new ButtonGroup();
		 grpActivity.add(rdbtnSedentary);
		 grpActivity.add(rdbtnModerateActivity);
		 grpActivity.add(rdbtnLightActivity);
		 grpActivity.add(rdbtnIntenseActivity);
		 grpActivity.add(rdbtnVeryIntenseActivity);
		 rdbtnSedentary.setSelected(true);
		 
		 rdbtnSedentary.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		setActivityMultiplyer(1.2);
			 	}
			 });
		 rdbtnModerateActivity.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		setActivityMultiplyer(1.55);
			 	}
			 });
		 rdbtnLightActivity.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		setActivityMultiplyer(1.375);
			 	}
			 });
		 rdbtnIntenseActivity.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		setActivityMultiplyer(1.725);
			 	}
			 });
		 rdbtnVeryIntenseActivity.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		setActivityMultiplyer(1.9);
			 	}
			 });
		 
		 JButton btnCalculateBmr = new JButton("Calculate BMR");
		 btnCalculateBmr.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		double bmr = 0;
		 		int inputValidationFlag = validateInput();
		 		switch(inputValidationFlag){
		 			case 0:
		 				bmr = calculateBMR();
		 				break;
		 			case 1:
		 				JOptionPane.showMessageDialog(null, "Please enter a positive non zero number for your weight.");
		 				break;
		 			case 2:
		 				JOptionPane.showMessageDialog(null, "Please enter a positive non zero number for your height.");
		 				break;
		 			case 3:
		 				JOptionPane.showMessageDialog(null, "Please enter a positive non zero number for your age.");
		 				break;
		 		}
		 		if(bmr != 0)
		 			txtBMR.setText("Your BMR is: " + bmr);
		 	}
		 });
		 
		 JLabel lblLevelOfActivity = new JLabel("Level of activity:");
		 GridBagConstraints gbc_lblLevelOfActivity = new GridBagConstraints();
		 gbc_lblLevelOfActivity.anchor = GridBagConstraints.EAST;
		 gbc_lblLevelOfActivity.insets = new Insets(0, 0, 5, 5);
		 gbc_lblLevelOfActivity.gridx = 0;
		 gbc_lblLevelOfActivity.gridy = 4;
		 add(lblLevelOfActivity, gbc_lblLevelOfActivity);

		 GridBagConstraints gbc_btnCalculateBmr = new GridBagConstraints();
		 gbc_btnCalculateBmr.insets = new Insets(0, 0, 0, 5);
		 gbc_btnCalculateBmr.gridx = 0;
		 gbc_btnCalculateBmr.gridy = 7;
		 add(btnCalculateBmr, gbc_btnCalculateBmr);
		 
		 txtBMR = new JTextField();
		 txtBMR.setEditable(false);
		 GridBagConstraints gbc_txtBMR = new GridBagConstraints();
		 gbc_txtBMR.insets = new Insets(0, 0, 0, 5);
		 gbc_txtBMR.fill = GridBagConstraints.HORIZONTAL;
		 gbc_txtBMR.gridx = 1;
		 gbc_txtBMR.gridy = 7;
		 add(txtBMR, gbc_txtBMR);
		 txtBMR.setColumns(10);
		 
		 
	}
	
	public int validateInput()
	{
		int errorFlag = 0;
		if(txtWeight.getText()==null)
 		{
 			errorFlag = 1;
 		}else{
 			try
 			{
 			  setWeight(Double.parseDouble(txtWeight.getText()));
 			}
 			catch(NumberFormatException e)
 			{
 			  errorFlag = 1;
 			}
 			if(getWeight()<=0)
 			{
 				errorFlag = 1;
 			}
 		}
		if(txtHeight.getText()==null)
		{
			errorFlag = 2;
		}else{
			try
 			{
 			  setHeightInInches(Double.parseDouble(txtHeight.getText()));
 			}
 			catch(NumberFormatException e)
 			{
 			  errorFlag = 2;
 			}
			if(getHeightInInches()<=0)
 			{
 				errorFlag = 2;
 			}
		}
		if(txtAge.getText()==null)
		{
			errorFlag=3;
		}else{
			try
 			{
 			  setYears(Integer.parseInt(txtAge.getText()));
 			}
 			catch(NumberFormatException e)
 			{
 			  errorFlag = 3;
 			}
			if(getYears()<=0)
 			{
 				errorFlag = 3;
 			}
		}
		return errorFlag;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setHeightInInches(double heightInInches) {
		this.heightInInches = heightInInches;
	}
	
	public double getHeightInInches() {
		return heightInInches;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public double calculateBMR(){
		double bmr = 0;
		boolean s = getSex();
		double h = getHeightInInches();
		double a = getYears();
		double w = getWeight();
		double multiplyer = getActivityMultiplyer();
		if(s == true){
			bmr =  (66 + (6.23 * w) + (12.7 * h) - (6.8 * a))*multiplyer;
		}else{
			bmr = (655 + (4.35 * w) + (4.7 * h) - (4.7 * a))*multiplyer;
		}
		return bmr;
	}
	
	public boolean getSex(){
		return sex;
	}
	
	public void setSex(boolean x){
		sex = x;
	}
	
	public void setActivityMultiplyer(double a)
	{
		this.activityMultiplyer = a;
	}
	public double getActivityMultiplyer()
	{
		return this.activityMultiplyer;
	}
}
