import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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
import javax.swing.JTable;

@SuppressWarnings("serial")
public class WorkoutPlanner extends JPanel {

	private JTable table;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	String[] colName = {"Split",
			"Lift",
            "# of Sets",
            "# of Reps"};
	Object[][] rowData = new Object[][] {};
	DefaultTableModel model = new DefaultTableModel(rowData, colName);
	private JButton btnSave;
	private JButton btnLoad;
	public WorkoutPlanner() {
	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		table = new JTable(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 3;
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, gbc_table);
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
		
		btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 3;
		add(btnSave, gbc_btnSave);
		
		btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoad.gridx = 1;
		gbc_btnLoad.gridy = 3;
		add(btnLoad, gbc_btnLoad);
	}
	
	private void doPop(MouseEvent e){
        PopUpMenu menu = new PopUpMenu(1);
        menu.show(e.getComponent(), e.getX(), e.getY());
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

