package libraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener {

	JLabel l1;

	public LibraryManagementSystem() {
		setTitle("Library Management System");

		setSize(1366, 390);
		setLocation(300, 300);
		getContentPane().setLayout(null);
		
		JButton b1 = new JButton("Next");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		b1.setForeground(Color.GRAY);
		b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b1.setBounds(1184, 290, 156, 50);
		getContentPane().add(b1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Library Management System\\src\\libraryManagementSystem\\icons\\first.jpg"));
		lblNewLabel.setBounds(0, 0, 1350, 351);
		getContentPane().add(lblNewLabel);
		
	}

	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);

	}

	public static void main(String[] args) {
		LibraryManagementSystem window = new LibraryManagementSystem();
		window.setVisible(true);
	}
}