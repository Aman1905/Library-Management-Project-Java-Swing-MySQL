package libraryManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField search;
	private JButton b1, b2, b3;

	public static void main(String[] args) {
		new StudentDetails().setVisible(true);
	}

	public void student() {
		try {
			Conn con = new Conn();
			String sql = "select * from student";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			st.close();
			con.c.close();
		} catch (Exception e) {

		}
	}

	public StudentDetails() {
		setTitle("Student Details");
		setBounds(350, 200, 890, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 133, 805, 273);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				search.setText(table.getModel().getValueAt(row, 1).toString());
			}
		});
		table.setBackground(new Color(240, 248, 255));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);

		JButton b1 = new JButton("Search");
		b1.addActionListener(this);
		b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b1.setBounds(524, 89, 144, 33);
		contentPane.add(b1);

		JButton b2 = new JButton("Delete");
		b2.addActionListener(this);
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b2.setBounds(695, 89, 144, 33);
		contentPane.add(b2);

		JLabel l1 = new JLabel("Student Details");
		l1.setFont(new Font("Bookman Old Style", Font.BOLD, 26));
		l1.setBounds(250, 20, 400, 47);
		contentPane.add(l1);

		search = new JTextField();
		search.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		search.setBounds(158, 89, 306, 33);
		contentPane.add(search);
		search.setColumns(10);

		JButton b3 = new JButton("Back");
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		b3.setForeground(Color.GRAY);
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b3.setBounds(34, 89, 100, 33);
		contentPane.add(b3);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Student-Deatails",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
		panel.setBounds(10, 59, 848, 370);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);

		student();
	}

	public void actionPerformed(ActionEvent ae) {
		try {

			Conn con = new Conn();
			if (ae.getSource() == b1) {
				String sql = "select * from student where concat(name, student_id) like ?";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, "%" + search.getText() + "%");
				ResultSet rs = st.executeQuery();

				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				st.close();
			}

			if (ae.getSource() == b2) {
				String sql = "delete from student where name = '" + search.getText() + "'";
				PreparedStatement st = con.c.prepareStatement(sql);

				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.NO_OPTION) {

				} else if (response == JOptionPane.YES_OPTION) {
					int rs = st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted !!");
				} else if (response == JOptionPane.CLOSED_OPTION) {

				}
				st.close();

			}
			con.c.close();
		} catch (Exception e) {

		}
	}
}