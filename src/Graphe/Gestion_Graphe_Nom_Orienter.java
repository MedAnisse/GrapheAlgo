package Graphe;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Gestion_Graphe_Nom_Orienter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Sommet_A_Supprimer;
	private JTextField textField_Sommet_SourceA;
	private JTextField textField_Sommet_DestinationA;
	private JTextField textField_Poid;
	private JTextField textField_Sommet_SourceS;
	private JTextField textField_Sommet_DestinationS;
	private Graphe_Non_orienter_value graphe;

	

	/**
	 * Create the frame.
	 */
	public Gestion_Graphe_Nom_Orienter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImporterMatrice = new JButton("Importer Matrice");
		btnImporterMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [][]mat1=Graphe_Non_orienter_value.MatriceFromFichier();
				 graphe=new Graphe_Non_orienter_value(mat1,100);
			}
		});
		btnImporterMatrice.setBounds(23, 26, 184, 21);
		contentPane.add(btnImporterMatrice);
		
		JButton btnImporterFsapsd = new JButton("Importer FsAps|D");
		btnImporterFsapsd.setEnabled(false);
		btnImporterFsapsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnImporterFsapsd.setBounds(23, 57, 184, 21);
		contentPane.add(btnImporterFsapsd);
		
		JButton btnAfficherMatrice = new JButton("Afficher Matrice");
		btnAfficherMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					graphe.afficherMatriceConsole();
					graphe.afficherMatriceText();
				}
			}
		});
		btnAfficherMatrice.setBounds(23, 88, 184, 21);
		contentPane.add(btnAfficherMatrice);
		
		JButton btnAfficherFsApsD = new JButton("Afficher FsApsD");
		btnAfficherFsApsD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAfficherFsApsD.setBounds(23, 119, 184, 21);
		contentPane.add(btnAfficherFsApsD);
		btnAfficherFsApsD.setEnabled(false);
		JButton btnAfficherGraphe = new JButton("Afficher Graphe");
		btnAfficherGraphe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)graphe.afficherGraphe();
			}
		});
		btnAfficherGraphe.setBounds(23, 150, 184, 21);
		contentPane.add(btnAfficherGraphe);
		
		JLabel lblSommetDestination_1 = new JLabel("Sommet Destination");
		lblSommetDestination_1.setBounds(332, 343, 100, 13);
		contentPane.add(lblSommetDestination_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sommet Source");
		lblNewLabel_1.setBounds(332, 292, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Poid");
		lblNewLabel_1_1.setBounds(346, 238, 100, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblSommetDestination = new JLabel("Sommet Destination");
		lblSommetDestination.setBounds(346, 191, 100, 13);
		contentPane.add(lblSommetDestination);
		
		JLabel lblNewLabel = new JLabel("Sommet Source");
		lblNewLabel.setBounds(346, 149, 100, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnAjouterArc = new JButton("Ajouter Arc");
		btnAjouterArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int source=Integer.valueOf(textField_Sommet_SourceA.getText());
				int destination=Integer.valueOf(textField_Sommet_DestinationA.getText());
				int poid=Integer.valueOf(textField_Poid.getText());
				graphe.AjouterArc(100, source, destination, poid);
				graphe.AjouterArc(100, destination,source, poid);
				
			}
		});
		btnAjouterArc.setBounds(303, 118, 184, 21);
		contentPane.add(btnAjouterArc);
		
		JLabel lblNewLabel_2 = new JLabel("Sommet A Supprimer");
		lblNewLabel_2.setBounds(353, 72, 104, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_Sommet_A_Supprimer = new JTextField();
		textField_Sommet_A_Supprimer.setColumns(10);
		textField_Sommet_A_Supprimer.setBounds(303, 91, 184, 19);
		contentPane.add(textField_Sommet_A_Supprimer);
		
		JButton btnSupprimerSommet = new JButton("Supprimer Sommet");
		btnSupprimerSommet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int s=Integer.valueOf(textField_Sommet_A_Supprimer.getText());
					graphe.SupprimerSommet(s, 100);
				}
			}
		});
		btnSupprimerSommet.setBounds(303, 41, 184, 21);
		contentPane.add(btnSupprimerSommet);
		
		JButton btnAjouterSommet = new JButton("Ajouter Sommet");
		btnAjouterSommet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					graphe.AjouterSommet();
				}
				else
				{
					graphe=new Graphe_Non_orienter_value();
					graphe.AjouterSommet();
				}
			}
		});
		btnAjouterSommet.setBounds(303, 10, 184, 21);
		contentPane.add(btnAjouterSommet);
		
		textField_Sommet_SourceA = new JTextField();
		textField_Sommet_SourceA.setColumns(10);
		textField_Sommet_SourceA.setBounds(303, 166, 184, 19);
		contentPane.add(textField_Sommet_SourceA);
		
		textField_Sommet_DestinationA = new JTextField();
		textField_Sommet_DestinationA.setColumns(10);
		textField_Sommet_DestinationA.setBounds(303, 214, 184, 19);
		contentPane.add(textField_Sommet_DestinationA);
		
		textField_Poid = new JTextField();
		textField_Poid.setText("1");
		textField_Poid.setColumns(10);
		textField_Poid.setBounds(303, 262, 184, 19);
		contentPane.add(textField_Poid);
		
		textField_Sommet_SourceS = new JTextField();
		textField_Sommet_SourceS.setColumns(10);
		textField_Sommet_SourceS.setBounds(303, 310, 184, 19);
		contentPane.add(textField_Sommet_SourceS);
		
		textField_Sommet_DestinationS = new JTextField();
		textField_Sommet_DestinationS.setColumns(10);
		textField_Sommet_DestinationS.setBounds(303, 366, 184, 19);
		contentPane.add(textField_Sommet_DestinationS);
		
		JButton btnSupprimerArc = new JButton("Supprimer Arc");
		btnSupprimerArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int source=Integer.valueOf(textField_Sommet_SourceS.getText());
					int destination=Integer.valueOf(textField_Sommet_DestinationS.getText());
					
					graphe.SupprimerArc(100, source, destination);
				}
			}
		});
		btnSupprimerArc.setBounds(10, 308, 184, 21);
		contentPane.add(btnSupprimerArc);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRetour.setBounds(10, 380, 85, 21);
		contentPane.add(btnRetour);
		
		JButton btnAfficherKruskal = new JButton("Afficher Kruskal");
		btnAfficherKruskal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{int [][]k=graphe.Kruskal();
				Graphe_Non_orienter_value.afficheMatriceConsole(k);
				Graphe_Non_orienter_value.afficheMatricetext(k, " Matrice des distance les plus courte ");
				}
			}
		});
		btnAfficherKruskal.setBounds(23, 187, 184, 21);
		contentPane.add(btnAfficherKruskal);
		
		JButton btnNewButton = new JButton("Aide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/AllKings/projet-graph-algo").toURI()); } catch (Exception e1) {} 
			}
		});
		btnNewButton.setBounds(121, 380, 85, 21);
		contentPane.add(btnNewButton);
	}
}
