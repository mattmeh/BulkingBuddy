import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


@SuppressWarnings("serial")
public class PopUpMenu extends JPopupMenu{
	JMenuItem searchForNet;
	JMenuItem searchItems;
    public PopUpMenu(int n){
    	//TODO add switch statements to change drop down menu based on menu you are using
    	switch(n){
    	case 1:
    		searchForNet = new JMenuItem("Search the Internet");
        	searchItems = new JMenuItem("Search Saved Entries");
            add(searchForNet);
            add(searchItems);
            searchForNet.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				String url = JOptionPane.showInputDialog("Enter the name of the item you would like to search for: ");
    				findNutrition(url);
    			}
    		});
            break;
    	case 2:
    		JMenuItem loadDiet = new JMenuItem("Load Day's Diet");
    		add(loadDiet);
    		loadDiet.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				loadDiet();
    			}
    		});
    	}
        
    }
    
    public void loadDiet()
    {
    	
    }
    
    public void findNutrition(String searchTerm)
	{
		searchTerm = searchTerm.replaceAll(" ","%20");;
		String htmlFilePath = "http://nutritiondata.self.com/foods-"; 
		String endPath = "000000000000000000000.html";
		htmlFilePath= htmlFilePath + searchTerm + endPath;

	       try {
	           //Set your page url in this string. For eg, I m using URL for Google Search engine
	           java.awt.Desktop.getDesktop().browse(java.net.URI.create(htmlFilePath));
	         }
	         catch (java.io.IOException e) {
	             System.out.println(e.getMessage());
	         }
	}
}
