package mineracaodadoseleitorais;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import mineracaodadoseleitorais.dao.DAOTSE;
import mineracaodadoseleitorais.func.ComparaCandidatoEleitor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JList;

public class GUI {

	private JFrame frame;
	private DAOTSE dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		initialize();
		dao = new DAOTSE();
		dao.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnQuery = new JButton("Query");
		panel.add(btnQuery);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JList<String> candidatoList = new JList<String>();
		panel_1.add(candidatoList);
		
		JList<String> eleitoradoList = new JList<String>();
		panel_1.add(eleitoradoList);
		
		btnQuery.addActionListener(new ComparaCandidatoEleitor(candidatoList, eleitoradoList));
	}

}
