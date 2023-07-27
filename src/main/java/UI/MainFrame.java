package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controller.BookStoreManager;

import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.time.LocalDate;
import java.time.Month;

import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTabbedPane tabbedPane;
	
	private JPanel addBookPanel;
	private BookStoreManager bkStMgr;
	private JComboBox<String> dayComboBox;
	private JComboBox<String> yearComboBox;
	private JComboBox<Month> monthComboBox;
	private JTextArea descriptionTextArea;
	private JLabel charLeftLabel;
	private JLabel firstBookError;
	private JLabel authorInputLabel;
	private String[] years;
	private String[] days;
	private int currentYear;
	private int charLeft;
	private final int FIRSTBOOKYEARPUBLISH = 868;
	private final int FIRSTBOOKDAYPUBLISH = 11;
	private final int FIRSTBOOKMONTHPUBLISH = Month.MARCH.getValue();
	private final int SQLTEXTMAXCHAR = 65535;
	private JTextField nameInputText;
	private JTextField surnameInputText;
	private JTextField idInputText;
	private JTextField authorInputText;
	private JList<String> authorJList;
	private DefaultListModel<String> authorListModel;
	private JTextField addressInputText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		init();
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\480Icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titlePane = new JPanel();
		titlePane.setBounds(0, 0, 1064, 140);
		contentPane.add(titlePane);
		titlePane.setLayout(null);
		
		JLabel titleLabel = new JLabel("BOOK STORE");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\git\\Practica1\\PracticaJava1Swing\\imgs\\480WinLogo.png"));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.DARK_GRAY);
		titleLabel.setOpaque(true);
		titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 70));
		titleLabel.setBounds(-69, 0, 866, 140);
		titlePane.add(titleLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 116, 797, 595);
		contentPane.add(tabbedPane);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(28, 249, 252));
		loginPanel.setBorder(null);
		tabbedPane.addTab("New tab", null, loginPanel, null);
		loginPanel.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(57, 254, 144));
		panel.setBounds(54, 0, 680, 567);
		loginPanel.add(panel);
		panel.setLayout(null);
		
		JLabel loginTitle = new JLabel("LOGIN");
		loginTitle.setBackground(new Color(255, 255, 255));
		loginTitle.setForeground(new Color(0, 0, 0));
		loginTitle.setBounds(0, 11, 680, 70);
		loginTitle.setOpaque(true);
		loginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle.setFont(new Font("Century Gothic", Font.BOLD, 45));
		panel.add(loginTitle);
		
		textField = new JTextField();
		textField.setBounds(114, 206, 450, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 336, 450, 30);
		panel.add(passwordField);
		
		JLabel userTip = new JLabel("UserID");
		userTip.setFont(new Font("Century Gothic", Font.BOLD, 35));
		userTip.setHorizontalAlignment(SwingConstants.CENTER);
		userTip.setBounds(0, 155, 680, 40);
		panel.add(userTip);
		
		JLabel passwordTip = new JLabel("Password");
		passwordTip.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTip.setFont(new Font("Century Gothic", Font.BOLD, 35));
		passwordTip.setBounds(0, 285, 680, 40);
		panel.add(passwordTip);
		
		CustomButton btnNewButton = new CustomButton("ACCEPT");
		btnNewButton.setColor(Color.LIGHT_GRAY);
		btnNewButton.setColorOver(Color.WHITE);
		btnNewButton.setColorClick(new Color(180, 252, 254));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnNewButton.setBounds(265, 444, 150, 50);
		panel.add(btnNewButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(180, 252, 254));
		tabbedPane.addTab("MainMenu Tab", null, mainPanel, null);
		
		CustomButton addBookButton = new CustomButton("");
		addBookButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\bookLogo.png"));
		addBookButton.setColorClick(new Color(145, 255, 159));
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		addBookButton.setBounds(10, 8, 250, 250);
		
		CustomButton createOrderButton = new CustomButton("");
		createOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		createOrderButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\cartLogo.png"));
		createOrderButton.setColorClick(new Color(145, 255, 159));
		createOrderButton.setBounds(270, 8, 250, 250);
		
		CustomButton memberRegisterButton = new CustomButton("");
		memberRegisterButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\memberLogo.png"));
		memberRegisterButton.setColorClick(new Color(145, 255, 159));
		memberRegisterButton.setBounds(530, 8, 250, 250);
		
		CustomButton employeeRegisterButton = new CustomButton("");
		employeeRegisterButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\employeeLogo.png"));
		employeeRegisterButton.setColorClick(new Color(145, 255, 159));
		employeeRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		employeeRegisterButton.setBounds(10, 290, 250, 250);
		
		CustomButton seeOrderHistoryButton = new CustomButton("");
		seeOrderHistoryButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\orderHistoryLogo.png"));
		seeOrderHistoryButton.setColorClick(new Color(145, 255, 159));
		seeOrderHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seeOrderHistoryButton.setBounds(270, 290, 250, 250);
		
		CustomButton seeLoginHistoryButton = new CustomButton("");
		seeLoginHistoryButton.setIcon(new ImageIcon("C:\\Users\\AlejandroNebotFlores\\eclipse-workspace\\BookStore480\\images\\connectionHistory.png"));
		seeLoginHistoryButton.setColorClick(new Color(145, 255, 159));
		seeLoginHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seeLoginHistoryButton.setBounds(530, 290, 250, 250);
		mainPanel.setLayout(null);
		mainPanel.add(addBookButton);
		mainPanel.add(createOrderButton);
		mainPanel.add(memberRegisterButton);
		mainPanel.add(employeeRegisterButton);
		mainPanel.add(seeOrderHistoryButton);
		mainPanel.add(seeLoginHistoryButton);
		
		JLabel addBookLabel = new JLabel("Add a new Book");
		addBookLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		addBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addBookLabel.setBounds(10, 265, 250, 14);
		mainPanel.add(addBookLabel);
		
		JLabel newOrderLabel = new JLabel("New order");
		newOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newOrderLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		newOrderLabel.setBounds(270, 265, 250, 14);
		mainPanel.add(newOrderLabel);
		
		JLabel registerNewMemberLabel = new JLabel("Register new member");
		registerNewMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerNewMemberLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		registerNewMemberLabel.setBounds(530, 265, 250, 14);
		mainPanel.add(registerNewMemberLabel);
		
		JLabel seeOrderHistoryLabel = new JLabel("See order history");
		seeOrderHistoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seeOrderHistoryLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		seeOrderHistoryLabel.setBounds(270, 542, 250, 14);
		mainPanel.add(seeOrderHistoryLabel);
		
		JLabel seeLoginHistoryLabel = new JLabel("See login history");
		seeLoginHistoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		seeLoginHistoryLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		seeLoginHistoryLabel.setBounds(530, 542, 250, 14);
		mainPanel.add(seeLoginHistoryLabel);
		
		JLabel manageEmployeesLabel = new JLabel("Manage employees");
		manageEmployeesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		manageEmployeesLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		manageEmployeesLabel.setBounds(10, 542, 250, 14);
		mainPanel.add(manageEmployeesLabel);
		
		setAddBookTabPanel();
		
		JPanel newOrderPanel = new JPanel();
		newOrderPanel.setBackground(new Color(205, 253, 254));
		tabbedPane.addTab("NewOrder Tab", null, newOrderPanel, null);
		newOrderPanel.setLayout(null);
		
		nameInputText = new JTextField();
		nameInputText.setBounds(90, 45, 220, 20);
		newOrderPanel.add(nameInputText);
		nameInputText.setColumns(10);
		
		surnameInputText = new JTextField();
		surnameInputText.setBounds(444, 45, 250, 20);
		newOrderPanel.add(surnameInputText);
		surnameInputText.setColumns(10);
		
		idInputText = new JTextField();
		idInputText.setBounds(90, 104, 202, 20);
		newOrderPanel.add(idInputText);
		idInputText.setColumns(10);
		
		addressInputText = new JTextField();
		addressInputText.setBounds(90, 166, 480, 20);
		newOrderPanel.add(addressInputText);
		addressInputText.setColumns(10);
		
		JComboBox<Double> comboBox = new JComboBox<>();
		comboBox.setBounds(90, 216, 480, 22);
		newOrderPanel.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(90, 275, 51, 20);
		newOrderPanel.add(spinner);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		formattedTextField.setEditable(false);
		formattedTextField.setBounds(90, 360, 99, 20);
		newOrderPanel.add(formattedTextField);
		
		JComboBox monthComboBox_1 = new JComboBox();
		monthComboBox_1.setModel(new DefaultComboBoxModel(Month.values()));
		monthComboBox_1.setBounds(372, 104, 100, 22);
		newOrderPanel.add(monthComboBox_1);
		
		JComboBox dayComboBox_1 = new JComboBox();
		dayComboBox_1.setBounds(482, 104, 45, 22);
		newOrderPanel.add(dayComboBox_1);
		
		JComboBox<String> yearComboBox_1 = new JComboBox<String>();
		yearComboBox_1.setBounds(537, 104, 70, 22);
		newOrderPanel.add(yearComboBox_1);
		
		JPanel employeesPanel = new JPanel();
		tabbedPane.addTab("Employees Tab", null, employeesPanel, null);
		
		JPanel orderHistoryPanel = new JPanel();
		tabbedPane.addTab("OrderHistory Tab", null, orderHistoryPanel, null);
		
		JPanel loginHistoryPanel = new JPanel();
		tabbedPane.addTab("LoginHisotry Tab", null, loginHistoryPanel, null);
	}
	
	private void init() {
		bkStMgr = new BookStoreManager();
		currentYear = Integer.parseInt(String.valueOf(LocalDate.now().getYear()));
		years = new String[(currentYear+1)-FIRSTBOOKYEARPUBLISH];
		charLeft = SQLTEXTMAXCHAR;
		
		int pos = 0;
		
		for (int i = currentYear; i >= FIRSTBOOKYEARPUBLISH; i--) {
			years[pos++] = String.valueOf(i);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setAddBookTabPanel() {
		authorListModel = new DefaultListModel();
		
		addBookPanel = new JPanel();
		addBookPanel.setBackground(new Color(205, 253, 254));
		tabbedPane.addTab("AddBook Tab", null, addBookPanel, null);
		addBookPanel.setLayout(null);
		
		JTextField isbnTextInput = new JTextField();
		isbnTextInput.setBounds(170, 54, 300, 20);
		addBookPanel.add(isbnTextInput);
		isbnTextInput.setColumns(10);
		
		JTextField titleTextInput = new JTextField();
		titleTextInput.setBounds(170, 85, 300, 20);
		addBookPanel.add(titleTextInput);
		titleTextInput.setColumns(10);
		
		JSpinner minimumAgeSpinner = new JSpinner();
		minimumAgeSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		minimumAgeSpinner.setBounds(170, 116, 40, 20);
		addBookPanel.add(minimumAgeSpinner);
		
		descriptionTextArea = new JTextArea();
		descriptionTextArea.setBackground(new Color(255, 255, 255));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setToolTipText("");
		descriptionTextArea.setBounds(170, 145, 350, 120);
		descriptionTextArea.getDocument().addDocumentListener(new DocumentListener() {

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	        	maxCharUpdate();
	        }

	        @Override
	        public void insertUpdate(DocumentEvent e) {
	        	maxCharUpdate();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent arg0) {
	        	maxCharUpdate();
	        }
	    });
		addBookPanel.add(descriptionTextArea);
		
		JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
		scrollPane.setBounds(170,147,300,149);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		addBookPanel.add(scrollPane);
		
		JTextField publishingHouseTextInput = new JTextField();
		publishingHouseTextInput.setBounds(170, 307, 300, 20);
		addBookPanel.add(publishingHouseTextInput);
		publishingHouseTextInput.setColumns(10);
		
		dayComboBox = new JComboBox();
		dayComboBox.setModel(new DefaultComboBoxModel());
		dayComboBox.setBounds(280, 338, 45, 22);
		addBookPanel.add(dayComboBox);
		
		yearComboBox = new JComboBox<>();
		yearComboBox.setModel(new DefaultComboBoxModel(years));
		yearComboBox.setBounds(335, 338, 70, 22);
		yearComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setDaysArray();
			}
		});
		addBookPanel.add(yearComboBox);
		
		monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(Month.values()));
		monthComboBox.setBounds(170, 338, 100, 22);
		monthComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				setDaysArray();
			}
		});
		addBookPanel.add(monthComboBox);
		
		JSpinner priceSpinner = new JSpinner();
		priceSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		priceSpinner.setBounds(170, 371, 60, 20);
		addBookPanel.add(priceSpinner);
		
		JSpinner amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		amountSpinner.setBounds(170, 402, 40, 20);
		addBookPanel.add(amountSpinner);
		
		firstBookError = new JLabel("First book ever was published on 11/03/868");
		firstBookError.setForeground(new Color(255, 0, 0));
		firstBookError.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		firstBookError.setBounds(415, 342, 367, 14);
		addBookPanel.add(firstBookError);
		firstBookError.setVisible(false);
		
		JLabel isbnPanel = new JLabel("ISBN:");
		isbnPanel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		isbnPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		isbnPanel.setBounds(10, 57, 150, 14);
		addBookPanel.add(isbnPanel);
		
		JLabel bookTitleLabel = new JLabel("Title:");
		bookTitleLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		bookTitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bookTitleLabel.setBounds(10, 88, 150, 14);
		addBookPanel.add(bookTitleLabel);
		
		JLabel minAgeLabel = new JLabel("Minimum Age:");
		minAgeLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		minAgeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minAgeLabel.setBounds(10, 119, 150, 14);
		addBookPanel.add(minAgeLabel);
		
		JLabel descripLabel = new JLabel("Description:");
		descripLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		descripLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		descripLabel.setBounds(10, 144, 150, 14);
		addBookPanel.add(descripLabel);
		
		JLabel publishingHouseLabel = new JLabel("Publishing House:");
		publishingHouseLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		publishingHouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		publishingHouseLabel.setBounds(10, 310, 150, 14);
		addBookPanel.add(publishingHouseLabel);
		
		JLabel publishDateLabel = new JLabel("Publishing Date:");
		publishDateLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		publishDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		publishDateLabel.setBounds(10, 342, 150, 14);
		addBookPanel.add(publishDateLabel);
		
		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLabel.setBounds(10, 374, 150, 14);
		addBookPanel.add(priceLabel);
		
		JLabel amountLabel = new JLabel("Amount To Add:");
		amountLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLabel.setBounds(10, 405, 150, 14);
		addBookPanel.add(amountLabel);
		
		CustomButton acceptAddBook = new CustomButton("Accept");
		acceptAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		acceptAddBook.setBounds(207, 470, 120, 40);
		addBookPanel.add(acceptAddBook);
		
		CustomButton returnAddBook = new CustomButton("Back");
		returnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		returnAddBook.setBounds(437, 470, 120, 40);
		addBookPanel.add(returnAddBook);
		
		charLeftLabel = new JLabel("(" + charLeft + ")");
		charLeftLabel.setVerticalAlignment(SwingConstants.TOP);
		charLeftLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		charLeftLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		charLeftLabel.setBounds(10, 169, 150, 127);
		addBookPanel.add(charLeftLabel);
		
		authorInputLabel = new JLabel("Author/s:");
		authorInputLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		authorInputLabel.setForeground(new Color(0, 0, 0));
		authorInputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorInputLabel.setBounds(480, 56, 100, 14);
		addBookPanel.add(authorInputLabel);
		
		authorInputText = new JTextField();
		authorInputText.setBounds(522, 85, 260, 20);
		addBookPanel.add(authorInputText);
		authorInputText.setColumns(10);
		
		authorJList = new JList();
		authorJList.setModel(authorListModel);
		authorJList.setValueIsAdjusting(true);
		authorJList.setBounds(503, 146, 260, 180);
		addBookPanel.add(authorJList);
		
		JScrollPane authorListScrollPane = new JScrollPane(authorJList);
		authorListScrollPane.setLocation(522, 145);
		authorListScrollPane.setSize(260, 151);
		authorListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		addBookPanel.add(authorListScrollPane);
		
		CustomButton addAuthorButton = new CustomButton("Add Author");
		addAuthorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int repeated = 0;
				for (int i = 0; i < authorListModel.getSize(); i++) {
					if(authorListModel.get(i).equals(authorInputText.getText())) {
						repeated++;
					}
				}
				if(repeated == 0) {
					authorListModel.addElement(authorInputText.getText());
				}
			}
		});
		addAuthorButton.setBounds(691, 115, 91, 22);
		addBookPanel.add(addAuthorButton);
		
		setDaysArray();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setDaysArray() {
		int year = Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()));
		int amountDays = 30;
		int day = 1;
		int oddEvenOrFeb = -1;
		
		Month selectedMonth = (Month)monthComboBox.getSelectedItem();
		int monthValue = selectedMonth.getValue();
		
		if(year != FIRSTBOOKYEARPUBLISH || (year == FIRSTBOOKYEARPUBLISH && monthValue >= FIRSTBOOKMONTHPUBLISH)) {
			oddEvenOrFeb = bkStMgr.oddOrEvenOrFebruaryMonth(monthValue);
			if(year == FIRSTBOOKYEARPUBLISH && monthValue == FIRSTBOOKMONTHPUBLISH) {
				day = FIRSTBOOKDAYPUBLISH;
				firstBookError.setVisible(false);
				amountDays -= 10;
			}
		}else {
			oddEvenOrFeb = 0;
			amountDays = 0;
			firstBookError.setVisible(true);
		}
		
		if(oddEvenOrFeb < 2) {
			amountDays += oddEvenOrFeb;
		}else {
			if(bkStMgr.isLeapYear(year)) {
				amountDays -= 1;
			}else {
				amountDays -= 2;
			}
		}
		
		days = new String[amountDays];
		
		for (int i = 0; i < days.length; i++) {
			days[i] = String.valueOf(day++);
		}
		
		dayComboBox.setModel(new DefaultComboBoxModel(days));
	}
	
	private void maxCharUpdate() {
		String text = descriptionTextArea.getText();
		int textLenght = text.length();
		
		charLeft = SQLTEXTMAXCHAR - textLenght;
		
		if(charLeft <= 0) {
			descriptionTextArea.setText(text.substring(0, (SQLTEXTMAXCHAR+1)));
		}
		
		charLeftLabel.setText("(" + (charLeft) + ")");
	}
}
