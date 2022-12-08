
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import database.Database;
import graphicInterface.LoginInterface;

public class Main {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException  | InstantiationException  | IllegalAccessException | UnsupportedLookAndFeelException e ) {
			e.printStackTrace();
		} 

		Database.connectDB();
		new LoginInterface();

	}

}
