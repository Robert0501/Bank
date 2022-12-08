package graphicInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Login;
import app.UserApplication;
import card.Account;
import card.Card;
import card.Transactions;
import database.Database;

public class UserApplicationInterface {
	Font cardDetailFont = new Font("Tahoma", Font.BOLD, 22);

	public static final JFrame frame = new JFrame("Revolve");
	public static final JPanel applicationPanel = new JPanel();
	public static final JPanel titlePanel = new JPanel();
	public static final JLabel amountTitle = new JLabel("Amount: ");

	private JPanel createNewCardButton;
	private JPanel topUpButton;
	private JPanel sendMoneyButton;
	private JPanel payUtilitesButton;
	private JPanel lastTransactionsButton;
	private JPanel accountDetailButton;
	private JPanel printReceiptButton;
	private JPanel changePinButton;
	private JPanel logoutButton;

	public static final JPanel createNewCardPanel = new JPanel();
	public static final JPanel topUpPanel = new JPanel();
	public static final JPanel sendMoneyPanel = new JPanel();
	public static final JPanel payUtilitiesPanel = new JPanel();
	public static final JPanel lastTransactionsPanel = new JPanel();
	public static final JPanel accountDetailPanel = new JPanel();
	public static final JPanel printReceiptPanel = new JPanel();
	public static final JPanel changePinPanel = new JPanel();
	public static final JPanel logoutPanel = new JPanel();
	public static final JLabel title = new JLabel("Welcome ");

	private JLabel createNewCard;
	private JLabel topUp;
	private JLabel sendMoney;
	private JLabel payUtilites;
	private JLabel lastTransactions;
	private JLabel accountDetail;
	private JLabel printReceipt;
	private JLabel changePin;
	private JLabel logout;

	private JLabel cardNumber;
	private JLabel cvv;
	private JLabel expirationDate;
	private JLabel topUpAmount;
	private JLabel recieverCard;
	public static final JTextField cardNumberIn = new JTextField();
	public static final JTextField cvvIn = new JTextField();
	public static final JTextField holderNameIn = new JTextField();
	public static final JTextField expirationDateIn = new JTextField();
	public static final JTextField topUpAmountIn = new JTextField();
	@SuppressWarnings("rawtypes")
	public static final JComboBox cardsComboBox = new JComboBox();
	public static final JButton topup = new JButton("Top up");

	private JLabel sendMoneyCardNumber;
	private JLabel sendMoneyAmount;
	private JLabel recieverName;
	private JLabel sendMoneyCurrencyChoose;
	public static final JTextField sendMoneyAmountIn = new JTextField();
	public static final JTextField sendMoneyCardNumberIn = new JTextField();
	public static final JTextField recieverNameIn = new JTextField();
	public static final JButton send = new JButton("Send");
	@SuppressWarnings("rawtypes")
	public static final JComboBox sendMoneyCardComboBox = new JComboBox();

	private JLabel payUtilitiesAmount;
	private JLabel provider;
	private JLabel payUtilitiesChooseCard;
	private static String[] utilities = { "Choose Provider", "Phone Provider", "Water Provider", "Gas Provider    " };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final JComboBox utilitiesBox = new JComboBox(utilities);
	@SuppressWarnings("rawtypes")
	public static final JComboBox payUtilitiesCardComboBox = new JComboBox();

	public static final JTextField payUtilitiesAmountIn = new JTextField();
	public static final JButton pay = new JButton("Pay");

	public static final JPanel cardTypePanel = new JPanel();
	public static final JPanel cardTypeConfirmPanel = new JPanel();
	public static final JLabel cardType = new JLabel();
	public static final JLabel confirmLabel = new JLabel();
	public static final JLabel passwordLabel = new JLabel();
	public static final JLabel debitCard = new JLabel();
	public static final JLabel creditCard = new JLabel();
	private static String[] currencyArray = { "Choose Currency", "RON", "EUR", "USD", "GBP" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static final JComboBox currencyBox = new JComboBox(currencyArray);

	public static final JPasswordField passwordIn = new JPasswordField();

	private JLabel accountDetailPassword;
	public static final JPasswordField accountDetailPasswordIn = new JPasswordField();
	public static final JButton accountDetailNextButton = new JButton("See Details");
	public static final JPanel passwordAccountDetailPanel = new JPanel();
	public static final JPanel seeAccountDetailPanel = new JPanel();

	public static final JButton confirmButton = new JButton("Confirm");
	public static final JButton backButton = new JButton("Back");

	private JPanel panels[] = new JPanel[8];

	public static int transactionNumber = 0;
	public static Transactions tranzactii[];
	public static Card cards[];

	private JLabel background;
	public static JLabel lastTransactionLabels[];
	public static JLabel firstCardAccountDetailLabels[];
	public static JLabel secondCardAccountDetailLabels[];
	public static JLabel thirdCardAccountDetailLabels[];
	public static JLabel forthCardAccountDetailLabels[];

	private JLabel changePinPassword;
	private JLabel oldPin;
	private JLabel newPin;
	private JLabel changePinCard;

	public static final JPasswordField changePinPasswordIn = new JPasswordField();
	public static final JPasswordField oldPinIn = new JPasswordField();
	public static final JPasswordField newPinIn = new JPasswordField();
	@SuppressWarnings("rawtypes")
	public static final JComboBox changePinComboBox = new JComboBox();
	public static final JButton change = new JButton("Change PIN");

	private JLabel saveToLabel;
	public static final JTextField browseIn = new JTextField();
	public static final JButton browseButton = new JButton("Browse");
	public static final JButton print = new JButton("Print");

	private int width = 85;
	public static int position;

	public UserApplicationInterface() {
		frame();
		panelsDeclaration();
		putButtons();
		titlePanel();
		createPanels();
		populatePanelVector();
		newCard();
		topUp();
		sendMoney();
		payUtilites();
		lastTransactions();
		accountDetail();
		printReceipt();
		changePin();
		logout();
	}

	private void applyLeftButtons(JPanel panel, JLabel label, String text) {
		panel.setLayout(null);
		panel.setBounds(10, width, 300, 95);
		panel.setBackground(Color.black);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		applicationPanel.add(panel);

		width += 100;

		label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.white);
		label.setBounds(0, 0, 300, 95);
		label.setFont(cardDetailFont);
		panel.add(label);
	}

	private void setBackground(JPanel panel) {
		background = new JLabel();
		background.setIcon(new ImageIcon("src//main//java//Images//Backgrounds//woodBackground.jpg"));
		background.setBounds(0, 0, 735, 895);
		panel.add(background);
	}

	private void panelsDeclaration() {
		createNewCardButton = new JPanel();
		topUpButton = new JPanel();
		sendMoneyButton = new JPanel();
		payUtilitesButton = new JPanel();
		lastTransactionsButton = new JPanel();
		accountDetailButton = new JPanel();
		printReceiptButton = new JPanel();
		changePinButton = new JPanel();
		logoutButton = new JPanel();
	}

	private void frame() {
		applicationPanel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 1025);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(applicationPanel);
	}

	private void putButtons() {
		applyLeftButtons(createNewCardButton, createNewCard, "Create New Card");
		applyLeftButtons(topUpButton, topUp, "Top-Up");
		applyLeftButtons(sendMoneyButton, sendMoney, "Send Money");
		applyLeftButtons(payUtilitesButton, payUtilites, "Pay Utilities");
		applyLeftButtons(lastTransactionsButton, lastTransactions, "Last Transactions");
		applyLeftButtons(accountDetailButton, accountDetail, "Account Detail");
		applyLeftButtons(printReceiptButton, printReceipt, "Print Receipt");
		applyLeftButtons(changePinButton, changePin, "Change PIN");
		applyLeftButtons(logoutButton, logout, "Logout");
	}

	private void putPanels(JPanel panel) {
		panel.setBounds(320, 85, 735, 895);
		panel.setVisible(false);
		panel.setBackground(Color.black);
		panel.setLayout(null);
		applicationPanel.add(panel);
	}

	private void putTitles(JPanel panel, JLabel label, String text) {
		label = new JLabel(text);
		label.setBounds(0, 50, 735, 35);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setForeground(Color.white);
		panel.add(label);
	}

	private void titlePanel() {
		titlePanel.setLayout(null);
		titlePanel.setBounds(10, 10, 1045, 70);
		titlePanel.setBackground(Color.black);
		applicationPanel.add(titlePanel);

		title.setBounds(40, 15, 1080, 30);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 35));
		title.setForeground(Color.white);
		titlePanel.add(title);

		amountTitle.setBounds(10, 35, 1080, 30);
		amountTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		amountTitle.setForeground(Color.white);
		titlePanel.add(amountTitle);
	}

	private void createPanels() {
		createNewCardPanel();
		createTopUpPanel();
		createSendMoneyPanel();
		createPayUtilitesPanel();
		createLastTransactionsPanel();
		createAccountDetailPanel();
		createPrinReceiptPanel();
		createChangePinPanel();
	}

	private void createNewCardPanel() {
		putPanels(createNewCardPanel);
		putTitles(createNewCardPanel, createNewCard, "Choose Card Type");

		cardTypePanel.setLayout(null);
		cardTypePanel.setVisible(false);
		cardTypePanel.setBounds(0, 0, 735, 895);
		createNewCardPanel.add(cardTypePanel);

		cardTypeConfirmPanel.setLayout(null);
		cardTypeConfirmPanel.setVisible(false);
		cardTypeConfirmPanel.setBounds(0, 0, 735, 895);
		createNewCardPanel.add(cardTypeConfirmPanel);
	}

	private void createTopUpPanel() {
		putPanels(topUpPanel);
		putTitles(topUpPanel, topUp, "Top-Up");
	}

	private void createSendMoneyPanel() {
		putPanels(sendMoneyPanel);
		putTitles(sendMoneyPanel, sendMoney, "Send Money");
	}

	private void createPayUtilitesPanel() {
		putPanels(payUtilitiesPanel);
		putTitles(payUtilitiesPanel, payUtilites, "Pay Utilites");
	}

	private void createLastTransactionsPanel() {
		putPanels(lastTransactionsPanel);
		putTitles(lastTransactionsPanel, lastTransactions, "Last Transactions");
		lastTransactionsPanel.setVisible(true);
	}

	private void createAccountDetailPanel() {
		putPanels(accountDetailPanel);
		putTitles(accountDetailPanel, accountDetail, "Account Details");
	}

	private void createPrinReceiptPanel() {
		putPanels(printReceiptPanel);
		putTitles(printReceiptPanel, printReceipt, "Print Receipt");
	}

	private void createChangePinPanel() {
		putPanels(changePinPanel);
		putTitles(changePinPanel, changePin, "Change PIN");
	}

	private void populatePanelVector() {
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}

		panels[0] = createNewCardPanel;
		panels[1] = topUpPanel;
		panels[2] = sendMoneyPanel;
		panels[3] = payUtilitiesPanel;
		panels[4] = lastTransactionsPanel;
		panels[5] = accountDetailPanel;
		panels[6] = printReceiptPanel;
		panels[7] = changePinPanel;

	}

	private void setVisible(JPanel panel) {
		for (int i = 0; i < panels.length; i++) {
			if (panels[i].equals(panel)) {
				panel.setVisible(true);
			} else {
				panels[i].setVisible(false);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void newCard() {
		createNewCardButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(createNewCardPanel);
				cardTypePanel.setVisible(true);
			}
		});

		debitCard.setIcon(new ImageIcon("src//main//java//Images//Images//debitCard.png"));
		debitCard.setBounds(192, 350, 350, 220);
		debitCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cardTypePanel.add(debitCard);

		debitCard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cardTypePanel.setVisible(false);
				cardTypeConfirmPanel.setVisible(true);

			}
		});

		currencyBox.setBounds(267, 350, 200, 30);
		cardTypeConfirmPanel.add(currencyBox);

		passwordLabel.setBounds(100, 400, 200, 22);
		passwordLabel.setText("Password");
		passwordLabel.setForeground(Color.white);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		cardTypeConfirmPanel.add(passwordLabel);

		backButton.setBounds(267, 450, 90, 25);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cardTypeConfirmPanel.setVisible(false);
				cardTypePanel.setVisible(true);
				passwordIn.setText("");
			}
		});
		cardTypeConfirmPanel.add(backButton);

		confirmButton.setBounds(377, 450, 90, 25);
		cardTypeConfirmPanel.add(confirmButton);

		passwordIn.setBounds(267, 400, 200, 25);
		cardTypeConfirmPanel.add(passwordIn);

		setBackground(cardTypePanel);
		setBackground(createNewCardPanel);
		setBackground(cardTypeConfirmPanel);
	}

	@SuppressWarnings("rawtypes")
	private void topUp() {
		topUpButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(topUpPanel);
			}
		});

		topUpAmount = new JLabel("Amount");
		topUpAmount.setBounds(100, 300, 180, 25);
		topUpAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		topUpAmount.setForeground(Color.white);
		topUpPanel.add(topUpAmount);

		topUpAmountIn.setBounds(300, 300, 250, 25);
		topUpPanel.add(topUpAmountIn);

		cardNumber = new JLabel("Card Number");
		cardNumber.setBounds(100, 385, 150, 25);
		cardNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		cardNumber.setForeground(Color.white);
		topUpPanel.add(cardNumber);

		cardNumberIn.setBounds(300, 385, 250, 25);
		topUpPanel.add(cardNumberIn);

		cvv = new JLabel("CVV");
		cvv.setBounds(100, 460, 150, 25);
		cvv.setFont(new Font("Tahoma", Font.BOLD, 20));
		cvv.setForeground(Color.white);
		topUpPanel.add(cvv);

		cvvIn.setBounds(300, 460, 250, 25);
		topUpPanel.add(cvvIn);

		expirationDate = new JLabel("Expiration Date");
		expirationDate.setBounds(100, 545, 180, 25);
		expirationDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		expirationDate.setForeground(Color.white);
		topUpPanel.add(expirationDate);

		expirationDateIn.setBounds(300, 545, 250, 25);
		topUpPanel.add(expirationDateIn);

		topup.setBounds(320, 700, 100, 25);
		topUpPanel.add(topup);

		recieverCard = new JLabel("Reciever Card");
		recieverCard.setBounds(100, 630, 250, 25);
		recieverCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		recieverCard.setForeground(Color.white);
		topUpPanel.add(recieverCard);

		cardsComboBox.setBounds(300, 630, 250, 25);
		topUpPanel.add(cardsComboBox);

		setBackground(topUpPanel);
	}

	@SuppressWarnings("rawtypes")
	private void sendMoney() {
		sendMoneyButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(sendMoneyPanel);
			}
		});

		sendMoneyAmount = new JLabel("Amount");
		sendMoneyAmount.setBounds(100, 300, 180, 25);
		sendMoneyAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		sendMoneyAmount.setForeground(Color.white);
		sendMoneyPanel.add(sendMoneyAmount);

		sendMoneyAmountIn.setBounds(300, 300, 250, 25);
		sendMoneyPanel.add(sendMoneyAmountIn);

		sendMoneyCardNumber = new JLabel("Reciever No.Card");
		sendMoneyCardNumber.setBounds(100, 385, 180, 25);
		sendMoneyCardNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		sendMoneyCardNumber.setForeground(Color.white);
		sendMoneyPanel.add(sendMoneyCardNumber);

		sendMoneyCardNumberIn.setBounds(300, 385, 250, 25);
		sendMoneyPanel.add(sendMoneyCardNumberIn);

		recieverName = new JLabel("Reciever Name");
		recieverName.setBounds(100, 460, 180, 25);
		recieverName.setFont(new Font("Tahoma", Font.BOLD, 20));
		recieverName.setForeground(Color.white);
		sendMoneyPanel.add(recieverName);

		recieverNameIn.setBounds(300, 460, 250, 25);
		sendMoneyPanel.add(recieverNameIn);

		sendMoneyCurrencyChoose = new JLabel("Sender Card");
		sendMoneyCurrencyChoose.setBounds(100, 545, 180, 25);
		sendMoneyCurrencyChoose.setFont(new Font("Tahoma", Font.BOLD, 20));
		sendMoneyCurrencyChoose.setForeground(Color.white);
		sendMoneyPanel.add(sendMoneyCurrencyChoose);

		sendMoneyCardComboBox.setBounds(300, 545, 250, 25);
		sendMoneyPanel.add(sendMoneyCardComboBox);

		send.setBounds(320, 625, 100, 25);
		sendMoneyPanel.add(send);

		setBackground(sendMoneyPanel);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void payUtilites() {
		payUtilitesButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(payUtilitiesPanel);
			}
		});
		payUtilitiesAmount = new JLabel("Amount");
		payUtilitiesAmount.setBounds(100, 385, 180, 25);
		payUtilitiesAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		payUtilitiesAmount.setForeground(Color.white);
		payUtilitiesPanel.add(payUtilitiesAmount);

		payUtilitiesAmountIn.setBounds(300, 385, 250, 25);
		payUtilitiesPanel.add(payUtilitiesAmountIn);

		provider = new JLabel("Provider");
		provider.setBounds(100, 460, 180, 25);
		provider.setFont(new Font("Tahoma", Font.BOLD, 20));
		provider.setForeground(Color.white);
		payUtilitiesPanel.add(provider);

		utilitiesBox.setBounds(300, 460, 250, 25);
		payUtilitiesPanel.add(utilitiesBox);

		payUtilitiesChooseCard = new JLabel("Choose Card");
		payUtilitiesChooseCard.setBounds(100, 545, 250, 25);
		payUtilitiesChooseCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		payUtilitiesChooseCard.setForeground(Color.white);
		payUtilitiesPanel.add(payUtilitiesChooseCard);

		payUtilitiesCardComboBox.setBounds(300, 545, 250, 25);
		payUtilitiesPanel.add(payUtilitiesCardComboBox);

		pay.setBounds(320, 625, 100, 25);
		payUtilitiesPanel.add(pay);

		setBackground(payUtilitiesPanel);
	}

	private void lastTransactions() {
		lastTransactionsButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(lastTransactionsPanel);
			}
		});

		lastTransactionLabels = new JLabel[16];

		transactionNumber = Database.returnTransactionsNumber(Login.email);
		tranzactii = new Transactions[transactionNumber];
		Database.returnTransactionData(Login.email);
		for (int i = 0; i < lastTransactionLabels.length; i++) {
			lastTransactionLabels[i] = new JLabel();
		}

		int width = 900;

		for (int i = 0; i < lastTransactionLabels.length; i++) {
			lastTransactionLabels[i].setBounds(0, width, 735, 23);
			width -= 50;
			lastTransactionLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			lastTransactionLabels[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			lastTransactionLabels[i].setForeground(Color.white);
			lastTransactionsPanel.add(lastTransactionLabels[i]);
		}

		position = lastTransactionLabels.length - 1;
		for (int i = transactionNumber - 1; i >= 0; i--) {
			lastTransactionLabels[position].setText(UserApplicationInterface.tranzactii[i].getTransactionType() + "   "
					+ UserApplicationInterface.tranzactii[i].getDate() + "   "
					+ UserApplicationInterface.tranzactii[i].getHour() + "   "
					+ UserApplicationInterface.tranzactii[i].getName() + "   "
					+ UserApplicationInterface.tranzactii[i].getAmount() + ""
					+ UserApplicationInterface.tranzactii[i].getCard());
			position--;
			if (position == 0) {
				break;
			}
		}

		setBackground(lastTransactionsPanel);
	}

	private void accountDetail() {
		accountDetailButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(accountDetailPanel);
				passwordAccountDetailPanel.setVisible(true);
				seeAccountDetailPanel.setVisible(false);
			}
		});

		passwordAccountDetailPanel.setLayout(null);
		passwordAccountDetailPanel.setVisible(true);
		passwordAccountDetailPanel.setBounds(0, 0, 735, 895);
		accountDetailPanel.add(passwordAccountDetailPanel);

		accountDetailPassword = new JLabel("Password");
		accountDetailPassword.setBounds(100, 385, 180, 25);
		accountDetailPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		accountDetailPassword.setForeground(Color.white);
		passwordAccountDetailPanel.add(accountDetailPassword);

		accountDetailPasswordIn.setBounds(300, 385, 250, 25);
		passwordAccountDetailPanel.add(accountDetailPasswordIn);

		accountDetailNextButton.setBounds(350, 500, 100, 25);
		passwordAccountDetailPanel.add(accountDetailNextButton);

		seeAccountDetailPanel.setLayout(null);
		seeAccountDetailPanel.setVisible(false);
		seeAccountDetailPanel.setBounds(0, 0, 735, 895);
		accountDetailPanel.add(seeAccountDetailPanel);

		firstCardAccountDetailLabels = new JLabel[4];
		secondCardAccountDetailLabels = new JLabel[4];
		thirdCardAccountDetailLabels = new JLabel[4];
		forthCardAccountDetailLabels = new JLabel[4];

		cards = new Card[4];

		for (int i = 0; i < firstCardAccountDetailLabels.length; i++) {
			firstCardAccountDetailLabels[i] = new JLabel();
			secondCardAccountDetailLabels[i] = new JLabel();
			thirdCardAccountDetailLabels[i] = new JLabel();
			forthCardAccountDetailLabels[i] = new JLabel();
		}

		int leftWidth = 200;

		for (int i = 0; i < firstCardAccountDetailLabels.length; i++) {
			firstCardAccountDetailLabels[i].setBounds(0, leftWidth, 735 / 2, 23);
			leftWidth += 50;
			firstCardAccountDetailLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			firstCardAccountDetailLabels[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			firstCardAccountDetailLabels[i].setForeground(Color.white);
			seeAccountDetailPanel.add(firstCardAccountDetailLabels[i]);
		}

		leftWidth += 100;

		for (int i = 0; i < secondCardAccountDetailLabels.length; i++) {
			thirdCardAccountDetailLabels[i].setBounds(0, leftWidth, 735 / 2, 23);
			leftWidth += 50;
			thirdCardAccountDetailLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			thirdCardAccountDetailLabels[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			thirdCardAccountDetailLabels[i].setForeground(Color.white);
			seeAccountDetailPanel.add(thirdCardAccountDetailLabels[i]);
		}

		int rightWidth = 200;

		for (int i = 0; i < thirdCardAccountDetailLabels.length; i++) {
			secondCardAccountDetailLabels[i].setBounds(735 / 2, rightWidth, 735 / 2, 23);
			rightWidth += 50;
			secondCardAccountDetailLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			secondCardAccountDetailLabels[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			secondCardAccountDetailLabels[i].setForeground(Color.white);
			seeAccountDetailPanel.add(secondCardAccountDetailLabels[i]);
		}

		rightWidth += 100;

		for (int i = 0; i < forthCardAccountDetailLabels.length; i++) {
			forthCardAccountDetailLabels[i].setBounds(735 / 2, rightWidth, 735 / 2, 23);
			rightWidth += 50;
			forthCardAccountDetailLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			forthCardAccountDetailLabels[i].setFont(new Font("Tahoma", Font.BOLD, 20));
			forthCardAccountDetailLabels[i].setForeground(Color.white);
			seeAccountDetailPanel.add(forthCardAccountDetailLabels[i]);
		}

		setBackground(seeAccountDetailPanel);
		setBackground(passwordAccountDetailPanel);
	}

	@SuppressWarnings("rawtypes")
	private void changePin() {
		changePinButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(changePinPanel);
				changePinPasswordIn.setText("");
				oldPinIn.setText("");
				newPinIn.setText("");
			}
		});

		changePinPassword = new JLabel("Password");
		changePinPassword.setBounds(100, 300, 180, 25);
		changePinPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		changePinPassword.setForeground(Color.white);
		changePinPanel.add(changePinPassword);

		changePinPasswordIn.setBounds(300, 300, 250, 25);
		changePinPanel.add(changePinPasswordIn);

		oldPin = new JLabel("Actual PIN");
		oldPin.setBounds(100, 385, 180, 25);
		oldPin.setFont(new Font("Tahoma", Font.BOLD, 20));
		oldPin.setForeground(Color.white);
		changePinPanel.add(oldPin);

		oldPinIn.setBounds(300, 385, 250, 25);
		changePinPanel.add(oldPinIn);

		newPin = new JLabel("New PIN");
		newPin.setBounds(100, 460, 180, 25);
		newPin.setFont(new Font("Tahoma", Font.BOLD, 20));
		newPin.setForeground(Color.white);
		changePinPanel.add(newPin);

		newPinIn.setBounds(300, 460, 250, 25);
		changePinPanel.add(newPinIn);

		changePinCard = new JLabel("Card");
		changePinCard.setBounds(100, 545, 180, 25);
		changePinCard.setFont(new Font("Tahoma", Font.BOLD, 20));
		changePinCard.setForeground(Color.white);
		changePinPanel.add(changePinCard);

		changePinComboBox.setBounds(300, 545, 250, 25);
		changePinPanel.add(changePinComboBox);

		change.setBounds(320, 615, 100, 25);
		changePinPanel.add(change);

		setBackground(changePinPanel);
	}

	private void printReceipt() {
		printReceiptButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(printReceiptPanel);
				browseIn.setText("");
			}
		});

		saveToLabel = new JLabel("Save to");
		saveToLabel.setBounds(100, 400, 180, 25);
		saveToLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		saveToLabel.setForeground(Color.white);
		printReceiptPanel.add(saveToLabel);

		browseIn.setBounds(300, 400, 250, 25);
		printReceiptPanel.add(browseIn);

		browseButton.setBounds(600, 400, 100, 25);
		printReceiptPanel.add(browseButton);

		browseButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				UserApplication.fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				UserApplication.fileChooser.showSaveDialog(null);
				browseIn.setText(UserApplication.fileChooser.getSelectedFile().getAbsolutePath());
			}
		});

		print.setBounds(350, 500, 100, 25);
		printReceiptPanel.add(print);

		setBackground(printReceiptPanel);
	}

	private void logout() {
		logoutButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				LoginInterface.frame.setVisible(true);
				Account.isAmountReturned = false;
				UserApplication.addToComboBox = false;
				for (int i = 0; i < tranzactii.length; i++) {
					tranzactii[i] = null;
				}
				LoginInterface.usernameIn.setText("");
				LoginInterface.passwordIn.setText("");
			}
		});
	}

}
