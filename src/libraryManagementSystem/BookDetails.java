package libraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class BookDetails extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField search;
	private JButton b1, b2, b3;

	public static void main(String[] args) {
		new BookDetails().setVisible(true);
	}

	public void Book() {
		try {
			Conn con = new Conn();
			String sql = "select * from book";
			PreparedStatement st = con.c.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			st.close();
			con.c.close();
		} catch (Exception e) {

		}
	}

	public BookDetails() {
		setTitle("Book Details");
		setBounds(350, 200, 890, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 133, 802, 268);
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
		b1.setBounds(564, 89, 108, 33);
		contentPane.add(b1);

		JButton b2 = new JButton("Delete");
		b2.addActionListener(this);
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b2.setBounds(712, 89, 108, 33);
		contentPane.add(b2);

		JLabel l1 = new JLabel("Book Details");
		l1.setForeground(SystemColor.desktop);
		l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 30));
		l1.setBounds(302, 11, 400, 47);
		contentPane.add(l1);

		search = new JTextField();
		search.setForeground(new Color(47, 79, 79));
		search.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		search.setBounds(189, 89, 357, 33);
		contentPane.add(search);
		search.setColumns(10);

		JButton b3 = new JButton("Back");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
			}
		});
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		b3.setBounds(36, 89, 103, 33);
		contentPane.add(b3);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		panel.setBounds(10, 52, 849, 373);
		contentPane.add(panel);
		panel.setBackground(Color.WHITE);
		Book();
	}

	public void actionPerformed(ActionEvent ae) {
		try {

			Conn con = new Conn();
			if (ae.getSource() == b1) {

				String sql = "select * from book where concat(name, book_id) like ?";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, "%" + search.getText() + "%");
				ResultSet rs = st.executeQuery();

				table.setModel(DbUtils.resultSetToTableModel(rs));
				rs.close();
				st.close();

			}
			if (ae.getSource() == b2) {
				String sql = "delete from book where name = '" + search.getText() + "'";
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