package Graphe;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class MainFraim extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MainFraim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGraphe_Orienter = new JButton("Graphe Orienter");
		btnGraphe_Orienter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Graphe_Orienter frame = new Gestion_Graphe_Orienter();
				frame.setVisible(true);
				
			}
		});
		btnGraphe_Orienter.setBounds(81, 71, 138, 21);
		contentPane.add(btnGraphe_Orienter);
		
		JButton btnGraphe_Nom_Orienter = new JButton("Graphe Nom Orienter");
		btnGraphe_Nom_Orienter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Graphe_Nom_Orienter frame = new Gestion_Graphe_Nom_Orienter();
				frame.setVisible(true);
			}
		});
		btnGraphe_Nom_Orienter.setBounds(81, 127, 138, 21);
		contentPane.add(btnGraphe_Nom_Orienter);
		
		JButton btnNewButton_2 = new JButton("Tache");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/AllKings/projet-graph-algo").toURI()); } catch (Exception e1) {} 
			}
		});
		btnNewButton_2.setBounds(81, 169, 138, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Arbre");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion_Arbre frame = new Gestion_Arbre();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(81, 215, 138, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Aide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/AllKings/projet-graph-algo").toURI()); } catch (Exception e1) {} 
			}
		});
		btnNewButton.setBounds(105, 288, 85, 21);
		contentPane.add(btnNewButton);
	}
}
