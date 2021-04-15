package libraryManagementSystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton b1, b2, b3, b4, b5, b6;
	private JLabel l3_2;

	public static void Home(String[] args) {
		new Home().setVisible(true);
	}

	public Home() {
		setTitle("Home");

		setBounds(400, 150, 850, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
		menuBar.setBackground(SystemColor.text);
		menuBar.setBounds(0, 10, 1000, 35);
		contentPane.add(menuBar);

		JMenu mnExit = new JMenu("Exit");
		mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setBackground(new Color(211, 211, 211));
		mntmLogout.setForeground(new Color(105, 105, 105));
		mntmLogout.addActionListener(this);
		mnExit.add(mntmLogout);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setForeground(new Color(105, 105, 105));
		mntmExit.setBackground(new Color(211, 211, 211));
		mntmExit.addActionListener(this);
		mnExit.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

		JMenuItem mntmReadme = new JMenuItem("Read Me");
		mntmReadme.setBackground(new Color(211, 211, 211));
		mntmReadme.setForeground(new Color(105, 105, 105));
		mnHelp.add(mntmReadme);

		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.setForeground(new Color(105, 105, 105));
		mntmAboutUs.setBackground(new Color(211, 211, 211));
		mntmAboutUs.addActionListener(this);
		mnHelp.add(mntmAboutUs);

		JMenu mnRecord = new JMenu("Record");
		mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));

		JMenuItem bookdetails = new JMenuItem("Book Details");
		bookdetails.addActionListener(this);
		bookdetails.setBackground(new Color(211, 211, 211));
		bookdetails.setForeground(Color.DARK_GRAY);
		mnRecord.add(bookdetails);

		JMenuItem studentdetails = new JMenuItem("Student Details");
		studentdetails.setBackground(new Color(211, 211, 211));
		studentdetails.setForeground(Color.DARK_GRAY);
		studentdetails.addActionListener(this);
		mnRecord.add(studentdetails);

		menuBar.add(mnRecord);
		menuBar.add(mnHelp);
		menuBar.add(mnExit);

		JLabel l1 = new JLabel("Library Management System");
		l1.setForeground(new Color(204, 51, 102));
		l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
		l1.setBounds(268, 30, 701, 80);
		contentPane.add(l1);
		
		b1 = new JButton("Add Books");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b1.addActionListener(this);
		b1.setBounds(60, 305, 159, 39);
		contentPane.add(b1);

		b2 = new JButton("Statistics");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b2.addActionListener(this);
		b2.setBounds(313, 305, 139, 40);
		contentPane.add(b2);

		b3 = new JButton("Add Student");
		b3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b3.addActionListener(this);
		b3.setBounds(562, 302, 167, 40);
		contentPane.add(b3);

		b4 = new JButton("Issue Book");
		b4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b4.addActionListener(this);
		b4.setBounds(76, 605, 143, 36);
		contentPane.add(b4);

		b5 = new JButton("Return Book");
		b5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b5.addActionListener(this);
		b5.setBounds(310, 606, 159, 35);
		contentPane.add(b5);

		b6 = new JButton("About Us");
		b6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b6.addActionListener(this);
		b6.setBounds(562, 604, 159, 39);
		contentPane.add(b6);

		getContentPane().setBackground(SystemColor.controlText);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\fourth.png"));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(562, 113, 159, 159);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setForeground(SystemColor.window);
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\third.png"));
		lblNewLabel_3_1.setBackground(SystemColor.text);
		lblNewLabel_3_1.setBounds(293, 121, 176, 159);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\sixth.png"));
		lblNewLabel_3_2.setBackground(Color.BLACK);
		lblNewLabel_3_2.setBounds(60, 408, 159, 159);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\sixth.png"));
		lblNewLabel_3_3.setBackground(Color.BLACK);
		lblNewLabel_3_3.setBounds(293, 408, 159, 159);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\seventh.png"));
		lblNewLabel_3_4.setBackground(Color.BLACK);
		lblNewLabel_3_4.setBounds(570, 408, 159, 159);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\sixth.png"));
		lblNewLabel_3_2_1.setBackground(Color.BLACK);
		lblNewLabel_3_2_1.setBounds(60, 113, 159, 159);
		contentPane.add(lblNewLabel_3_2_1);
	}

	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		if (msg.equals("Logout")) {
			setVisible(false);
			new Login().setVisible(true);
		} else if (msg.equals("Exit")) {
			System.exit(ABORT);

		} else if (msg.equals("Read Me")) {

		} else if (msg.equals("About Us")) {
			setVisible(false);
			new AboutUs().setVisible(true);

		} else if (msg.equals("Book Details")) {
			setVisible(false);
			new BookDetails().setVisible(true);
		} else if (msg.equals("Student Details")) {
			setVisible(false);
			new StudentDetails().setVisible(true);

		}

		if (ae.getSource() == b1) {
			this.setVisible(false);
			new AddBook().setVisible(true);
		}
		if (ae.getSource() == b2) {
			this.setVisible(false);
			new Statistics().setVisible(true);
		}
		if (ae.getSource() == b3) {
			this.setVisible(false);
			new AddStudent().setVisible(true);
		}
		if (ae.getSource() == b4) {
			this.setVisible(false);
			new IssueBook().setVisible(true);
		}
		if (ae.getSource() == b5) {
			this.setVisible(false);
			new ReturnBook().setVisible(true);

		}
		if (ae.getSource() == b6) {
			this.setVisible(false);
			new AboutUs().setVisible(true);

		}

	}
}