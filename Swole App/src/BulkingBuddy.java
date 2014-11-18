import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.io.File;

@SuppressWarnings("serial")
public class BulkingBuddy extends JFrame {

	private static JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BulkingBuddy frame = new BulkingBuddy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public BulkingBuddy() {
		setTitle("Bulking Buddy 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnViewcreateDiet = new JButton("View/Create Diet Plan\r\n");
		btnViewcreateDiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateDietPlan gui = new CreateDietPlan();
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setContentPane(contentPane);
						revalidate();
					}
				});
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.insets = new Insets(0, 0, 5, 0);
				gbc_btnBack.gridx = 2;
				gbc_btnBack.gridy = 5;
				gui.add(btnBack, gbc_btnBack);
				
				setContentPane(gui);
				revalidate();
			}
		});
		GridBagConstraints gbc_btnViewcreateDiet = new GridBagConstraints();
		gbc_btnViewcreateDiet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewcreateDiet.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewcreateDiet.gridx = 0;
		gbc_btnViewcreateDiet.gridy = 0;
		contentPane.add(btnViewcreateDiet, gbc_btnViewcreateDiet);
		
		JButton btnViewcreateWorkout = new JButton("View/Create Workout Plan\r\n");
		btnViewcreateWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WorkoutPlanner gui = new WorkoutPlanner();
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setContentPane(contentPane);
						revalidate();
					}
				});
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.insets = new Insets(0, 0, 5, 0);
				gbc_btnBack.gridx = 2;
				gbc_btnBack.gridy = 5;
				gui.add(btnBack, gbc_btnBack);
				
				setContentPane(gui);
				revalidate();
			}
		});
		GridBagConstraints gbc_btnViewcreateWorkout = new GridBagConstraints();
		gbc_btnViewcreateWorkout.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewcreateWorkout.gridx = 0;
		gbc_btnViewcreateWorkout.gridy = 1;
		contentPane.add(btnViewcreateWorkout, gbc_btnViewcreateWorkout);
		
		JButton btnBmrCalculator = new JButton("BMR Calculator");
		btnBmrCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BMRCalculator gui = new BMRCalculator();
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setContentPane(contentPane);
						revalidate();
					}
				});
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.insets = new Insets(0, 0, 5, 0);
				gbc_btnBack.gridx = 2;
				gbc_btnBack.gridy = 5;
				gui.add(btnBack, gbc_btnBack);
				setContentPane(gui);
				revalidate();
			}
		});
		GridBagConstraints gbc_btnBmrCalculator = new GridBagConstraints();
		gbc_btnBmrCalculator.insets = new Insets(0, 0, 5, 0);
		gbc_btnBmrCalculator.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBmrCalculator.gridx = 0;
		gbc_btnBmrCalculator.gridy = 2;
		contentPane.add(btnBmrCalculator, gbc_btnBmrCalculator);
	}
	
	private void loadDiet(String date)
	{
		File file = new File(date);
		DietRecorder gui = new DietRecorder(file);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(contentPane);
				revalidate();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 5;
		gui.add(btnBack, gbc_btnBack);
		
		setContentPane(gui);
		revalidate();
	}
	
	private void loadWorkout(String date)
	{
		File file = new File(date);
		WorkoutRecorder gui = new WorkoutRecorder(file);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(contentPane);
				revalidate();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 5;
		gui.add(btnBack, gbc_btnBack);
		
		setContentPane(gui);
		revalidate();
	}

}
