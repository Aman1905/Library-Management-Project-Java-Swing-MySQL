package libraryManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton b1, b2, b3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new Login().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 400);

		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		JLabel l1 = new JLabel("User Name : ");
		l1.setBounds(124, 89, 195, 24);
		panel.add(l1);

		JLabel l2 = new JLabel("Password : ");
		l2.setBounds(124, 124, 195, 24);
		panel.add(l2);

		textField = new JTextField();
		textField.setBounds(210, 93, 157, 20);
		panel.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(210, 128, 157, 20);
		panel.add(passwordField);

		b1 = new JButton("Login");
		b1.addActionListener(this);
		b1.setForeground(new Color(46, 139, 87));
		b1.setBackground(new Color(250, 250, 210));
		b1.setBounds(149, 181, 93, 30);
		panel.add(b1);

		b2 = new JButton("Sign Up");
		b2.addActionListener(this);
		b2.setForeground(new Color(139, 69, 19));
		b2.setBackground(new Color(255, 235, 205));
		b2.setBounds(289, 181, 93, 30);
		panel.add(b2);

		b3 = new JButton("Forgot Password");
		b3.addActionListener(this);
		b3.setBounds(199, 231, 142, 30);
		panel.add(b3);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {
			Boolean status = false;
			try {
				Conn con = new Conn();
				String sql = "select * from account where username=? and password=?";
				PreparedStatement st = con.c.prepareStatement(sql);

				st.setString(1, textField.getText());
				st.setString(2, new String(passwordField.getPassword()));

				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					this.setVisible(false);
					new Loading().setVisible(true);
				} else
					JOptionPane.showMessageDialog(null, "Invalid Login...!");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (ae.getSource() == b2) {
			setVisible(false);
			Signup su = new Signup();
			su.setVisible(true);
		}
		if (ae.getSource() == b3) {
			setVisible(false);
			Forgot forgot = new Forgot();
			forgot.setVisible(true);
		}

	}

}
