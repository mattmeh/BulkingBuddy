import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;

import javax.swing.JTable;


@SuppressWarnings("serial")
public class CreateDietPlan extends JPanel {

	private JTable table;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	String[] colName = {"Food Item",
            "Serving Size",
            "# of Servings",
            "Grams of protien",
            "grams of carbohydrates",
            "grams of fat",
            "calories"};
	Object[][] rowData = new Object[][] {};
	DefaultTableModel model = new DefaultTableModel(rowData, colName);
	private JLabel lblTotalCalories;
	private JTextField txtCalories;
	private JLabel lblTotalProtien;
	private JTextField txtProtien;
	private JLabel lblTotalCarbs;
	private JTextField txtCarbs;
	private JLabel lblTotalFat;
	private JTextField txtFat;
	private JLabel lblMacroSplit;
	private JTextField txtMacroSplit;
	private JButton btnSave;
	private JButton btnLoad;
	public CreateDietPlan() {
	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		table = new JTable(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		add(new JScrollPane(table), gbc_table);
		model.addRow(new Object[]{});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getButton() == 3) {
					doPop(arg0);
				}
		}
	});
		
		table.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) { 
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					model.addRow(new Object[]{});
					setTotals();
                }     
				}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		lblTotalCalories = new JLabel("Total Calories:");
		GridBagConstraints gbc_lblTotalCalories = new GridBagConstraints();
		gbc_lblTotalCalories.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCalories.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCalories.gridx = 0;
		gbc_lblTotalCalories.gridy = 1;
	    add(lblTotalCalories, gbc_lblTotalCalories);
		
		txtCalories = new JTextField();
		txtCalories.setEditable(false);
		GridBagConstraints gbc_txtCalories = new GridBagConstraints();
		gbc_txtCalories.insets = new Insets(0, 0, 5, 5);
		gbc_txtCalories.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCalories.gridx = 1;
		gbc_txtCalories.gridy = 1;
		add(txtCalories, gbc_txtCalories);
		txtCalories.setColumns(10);
		
		lblTotalProtien = new JLabel("Total Protien:");
		GridBagConstraints gbc_lblTotalProtien = new GridBagConstraints();
		gbc_lblTotalProtien.anchor = GridBagConstraints.EAST;
		gbc_lblTotalProtien.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalProtien.gridx = 0;
		gbc_lblTotalProtien.gridy = 2;
		add(lblTotalProtien, gbc_lblTotalProtien);
		
		txtProtien = new JTextField();
		txtProtien.setEditable(false);
		GridBagConstraints gbc_txtProtien = new GridBagConstraints();
		gbc_txtProtien.insets = new Insets(0, 0, 5, 5);
		gbc_txtProtien.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProtien.gridx = 1;
		gbc_txtProtien.gridy = 2;
		add(txtProtien, gbc_txtProtien);
		txtProtien.setColumns(10);
		
		lblTotalCarbs = new JLabel("Total Carbs:");
		GridBagConstraints gbc_lblTotalCarbs = new GridBagConstraints();
		gbc_lblTotalCarbs.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCarbs.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCarbs.gridx = 0;
		gbc_lblTotalCarbs.gridy = 3;
		add(lblTotalCarbs, gbc_lblTotalCarbs);
		
		txtCarbs = new JTextField();
		txtCarbs.setEditable(false);
		GridBagConstraints gbc_txtCarbs = new GridBagConstraints();
		gbc_txtCarbs.anchor = GridBagConstraints.NORTH;
		gbc_txtCarbs.insets = new Insets(0, 0, 5, 5);
		gbc_txtCarbs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCarbs.gridx = 1;
		gbc_txtCarbs.gridy = 3;
		add(txtCarbs, gbc_txtCarbs);
		txtCarbs.setColumns(10);
		
		lblTotalFat = new JLabel("Total Fat:");
		GridBagConstraints gbc_lblTotalFat = new GridBagConstraints();
		gbc_lblTotalFat.anchor = GridBagConstraints.EAST;
		gbc_lblTotalFat.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalFat.gridx = 0;
		gbc_lblTotalFat.gridy = 4;
		add(lblTotalFat, gbc_lblTotalFat);
		
		txtFat = new JTextField();
		txtFat.setEditable(false);
		GridBagConstraints gbc_txtFat = new GridBagConstraints();
		gbc_txtFat.insets = new Insets(0, 0, 5, 5);
		gbc_txtFat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFat.gridx = 1;
		gbc_txtFat.gridy = 4;
		add(txtFat, gbc_txtFat);
		txtFat.setColumns(10);
		
		lblMacroSplit = new JLabel("% Macro Split P:C:F ");
		GridBagConstraints gbc_lblMacroSplit = new GridBagConstraints();
		gbc_lblMacroSplit.anchor = GridBagConstraints.EAST;
		gbc_lblMacroSplit.insets = new Insets(0, 0, 5, 5);
		gbc_lblMacroSplit.gridx = 0;
		gbc_lblMacroSplit.gridy = 5;
		add(lblMacroSplit, gbc_lblMacroSplit);
		
		txtMacroSplit = new JTextField();
		txtMacroSplit.setEditable(false);
		GridBagConstraints gbc_txtMacroSplit = new GridBagConstraints();
		gbc_txtMacroSplit.insets = new Insets(0, 0, 5, 5);
		gbc_txtMacroSplit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMacroSplit.gridx = 1;
		gbc_txtMacroSplit.gridy = 5;
		add(txtMacroSplit, gbc_txtMacroSplit);
		txtMacroSplit.setColumns(10);
		
		btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 6;
		add(btnSave, gbc_btnSave);
		
		btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoad.gridx = 2;
		gbc_btnLoad.gridy = 6;
		add(btnLoad, gbc_btnLoad);
	}
	
	private void doPop(MouseEvent e){
        PopUpMenu menu = new PopUpMenu(1);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
	private double calculateRowTotal(int col)
	{
		double total = 0;
		int row = model.getRowCount() -1;
		for(int i = 0; i < row; i++)
		{
			try{
				total = Double.parseDouble((String) model.getValueAt(i, col)) + total;
			}catch(Exception e){
				//do nothing leave total as is
			}
		}
		return total;
	}
	private void setTotals()
	{
		double protien = calculateRowTotal(3);
		double carbs = calculateRowTotal(4);
		double fats = calculateRowTotal(5);
		double total = protien + carbs + fats;
		txtCalories.setText(Double.toString(calculateRowTotal(6)));
		txtProtien.setText(Double.toString(protien));
		txtCarbs.setText(Double.toString(carbs));
		txtFat.setText(Double.toString(fats));
		double percProtien = (protien/total)*100;
		double percFat = (fats/total)*100;
		double percCarbs = (carbs/total)*100;
		
		DecimalFormat df = new DecimalFormat("##");
        
        txtMacroSplit.setText(df.format(percProtien) + ":" + df.format(percCarbs)+ ":" + df.format(percFat));
	}
	
	
	   public void save()
	   {
		   JFileChooser fc = new JFileChooser();
		   Writer writer = null;
		   String separator = System.getProperty("line.separator");
		   int returnVal = fc.showSaveDialog(this);
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 try {
					 File file = fc.getSelectedFile();
				       writer = new BufferedWriter(new OutputStreamWriter(
				             new FileOutputStream(file.getPath()), "utf-8"));
				       TableModel model = table.getModel();
				       for(int i = 0; i < model.getColumnCount(); i++)
				    	   writer.write(model.getColumnName(i)+"\t");
				       for(int i = 0; i < model.getRowCount(); i++)
				       {
				    	   writer.write(separator);
				    	   for(int x = 0; x < model.getColumnCount(); x++)
				    	   {
				    		   writer.write((String)(model.getValueAt(i, x))+"\t");
				    	   }
				       }
				   } catch (IOException ex) {
					   
				   } finally {
				      try {
				    	  writer.close();
				    	  } catch (Exception ex) {
				    		  
				    	  }
				   }
			 }
	   }
	   
	public JTable getTable(){
		return table;
	}
	
	public void load(){
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		 if (returnVal == JFileChooser.APPROVE_OPTION) {
			 File file = fc.getSelectedFile();
			 try {
				 int x = 0;
				BufferedReader bfw = new BufferedReader(new FileReader(file.getPath()));
				for(String load = bfw.readLine(); load!=null; load = bfw.readLine())
				{
					String[] dataArray = load.split("\t");
					if(x>0)
					{
						if(table.getRowCount()<x)
						{
							model.addRow(new Object[]{});
						}
						for(int z = 0; z<table.getColumnCount();z++)
						{
							if(dataArray[z].equals("null"))
							{
								table.setValueAt("", (x-1), z);
							}else{
								table.setValueAt((Object)dataArray[z], (x-1), z);
							}
						}
					}
					x++;
				}
				bfw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
}
