package Graphe;

import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Gestion_Arbre extends JFrame {

	private JPanel contentPane;
	private Arbre arbre;

	

	/**
	 * Create the frame.
	 */
	public Gestion_Arbre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImporterMatrice = new JButton("Importer Matrice");
		btnImporterMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [][]mat=Graphe_orienter_value.MatriceFromFichier();
				arbre=new Arbre(mat);
			}
		});
		btnImporterMatrice.setBounds(23, 10, 184, 21);
		contentPane.add(btnImporterMatrice);
		
		JButton btnAfficherMatrice = new JButton("Afficher Matrice");
		btnAfficherMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arbre!=null)
				{
					arbre.afficherMatriceConsole();
					arbre.afficherMatriceText();
				}
			}
		});
		btnAfficherMatrice.setBounds(23, 72, 184, 21);
		contentPane.add(btnAfficherMatrice);
		
		JButton btnImporterPrufer = new JButton("Importer Prufer");
		btnImporterPrufer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arbre=Arbre.ArbreFromFicher();
			}
		});
		btnImporterPrufer.setBounds(23, 41, 184, 21);
		contentPane.add(btnImporterPrufer);
		
		JButton btnAfficherPrufer = new JButton("Afficher Prufer");
		btnAfficherPrufer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arbre!=null)
				{
					int []k=Arbre.prufer(arbre.ToMatrice(0));
					Graphe_orienter_value.afficheTabText("Prufer",k);
					Graphe_orienter_value.afficheTabConsole(k);
				}
			}
		});
		btnAfficherPrufer.setBounds(23, 103, 184, 21);
		contentPane.add(btnAfficherPrufer);
		
		JButton btnAfficherGraphe = new JButton("Afficher Graphe");
		btnAfficherGraphe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arbre!=null)Graphe_orienter_value.afficherGrapheFromMatrice(arbre.ToMatrice(0), 0,2);
			}
		});
		btnAfficherGraphe.setBounds(23, 134, 184, 21);
		contentPane.add(btnAfficherGraphe);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRetour.setBounds(10, 364, 85, 21);
		contentPane.add(btnRetour);
		
		JButton btnNewButton = new JButton("Aide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/AllKings/projet-graph-algo").toURI()); } catch (Exception e1) {} 
			}
		});
		btnNewButton.setBounds(122, 364, 85, 21);
		contentPane.add(btnNewButton);
		
	}

}
