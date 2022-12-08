package graphicInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Login;
import database.Database;

public class LoginInterface {

	public static final JPanel loginPanel = new JPanel();
	public static final JFrame frame = new JFrame("Login");

	private JLabel title;
	private JLabel background;
	private JLabel username;
	private JLabel password;
	private JLabel createAccount;
	public static final JLabel signUp = new JLabel("Click here!");

	public static final JTextField usernameIn = new JTextField();
	public static final JPasswordField passwordIn = new JPasswordField();

	public static final JButton loginButton = new JButton("Login");

	public LoginInterface() {

		Database.connectDB();

		frame();
		background();
		title();
		username();
		password();
		insertUsername();
		insertPassword();
		loginButton();
		createAccount();
		loginPanel();

		new Login();
		new ForgotPasswordInterface();
		frame.setSize(1080, 720);
	}

	private void frame() {
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 719);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(loginPanel);
	}

	private void loginPanel() {
		loginPanel.add(title);

		loginPanel.add(username);
		loginPanel.add(usernameIn);
		loginPanel.add(password);
		loginPanel.add(passwordIn);
		loginPanel.add(loginButton);
		loginPanel.add(createAccount);
		loginPanel.add(signUp);
		loginPanel.add(background);
	}

	private void background() {
		background = new JLabel("");
		background.setIcon(new ImageIcon(("src//main//java//Images//Backgrounds//bank_background.jpg")));
		background.setBounds(0, 0, 1080, 720);
	}

	private void title() {
		title = new JLabel("Welcome to Revolve");
		title.setBounds(0, 20, 1080, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 50));
		title.setForeground(Color.white);
	}

	private void username() {
		username = new JLabel("Username");
		username.setBounds(0, 180, 1080, 50);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tahoma", Font.BOLD, 31));
		username.setForeground(Color.white);
	}

	private void password() {
		password = new JLabel("Password");
		password.setBounds(0, 350, 1080, 50);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.BOLD, 31));
		password.setForeground(Color.white);
	}

	private void insertUsername() {
		usernameIn.setBounds(390, 250, 300, 30);
		usernameIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}

	private void insertPassword() {
		passwordIn.setBounds(390, 420, 300, 30);
	}

	private void loginButton() {
		loginButton.setBounds(450, 480, 180, 30);
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	private void createAccount() {
		createAccount = new JLabel("Don't have an account?");
		createAccount.setBounds(450, 500, 118, 50);
		createAccount.setForeground(Color.white);

		signUp.setBounds(568, 512, 50, 26);
		signUp.setForeground(Color.decode("#febc01"));
		signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

}
