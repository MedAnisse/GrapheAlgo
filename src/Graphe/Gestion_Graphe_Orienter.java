package Graphe;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Gestion_Graphe_Orienter extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSommetASupprimer;
	private JTextField textFieldSommet_SourceA;
	private JTextField textFieldSommet_DestinationA;
	private JTextField textFieldPoid;
	private JTextField textFieldSommet_SourceS;
	private JTextField textFieldSommet_DestinationS;
	private Graphe_orienter_value graphe;
	private int Val;
	

	/**
	 * Create the frame.
	 */
	public Gestion_Graphe_Orienter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textFieldSommetASupprimer = new JTextField();
		textFieldSommetASupprimer.setBounds(315, 112, 184, 19);
		contentPane.add(textFieldSommetASupprimer);
		textFieldSommetASupprimer.setColumns(10);
		
		textFieldSommet_SourceA = new JTextField();
		textFieldSommet_SourceA.setColumns(10);
		textFieldSommet_SourceA.setBounds(315, 187, 184, 19);
		contentPane.add(textFieldSommet_SourceA);
		
		textFieldSommet_DestinationA = new JTextField();
		textFieldSommet_DestinationA.setColumns(10);
		textFieldSommet_DestinationA.setBounds(315, 235, 184, 19);
		contentPane.add(textFieldSommet_DestinationA);
		
		textFieldPoid = new JTextField();
		textFieldPoid.setText("1");
		textFieldPoid.setColumns(10);
		textFieldPoid.setBounds(315, 283, 184, 19);
		contentPane.add(textFieldPoid);
		
		textFieldSommet_SourceS = new JTextField();
		textFieldSommet_SourceS.setColumns(10);
		textFieldSommet_SourceS.setBounds(315, 331, 184, 19);
		contentPane.add(textFieldSommet_SourceS);
		
		textFieldSommet_DestinationS = new JTextField();
		textFieldSommet_DestinationS.setColumns(10);
		textFieldSommet_DestinationS.setBounds(315, 387, 184, 19);
		contentPane.add(textFieldSommet_DestinationS);
		
		JLabel lblNewLabel = new JLabel("Sommet Source");
		lblNewLabel.setBounds(358, 170, 100, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblSommetDestination = new JLabel("Sommet Destination");
		lblSommetDestination.setBounds(358, 212, 100, 13);
		contentPane.add(lblSommetDestination);
		
		JLabel lblNewLabel_Poid = new JLabel("Poid");
		lblNewLabel_Poid.setBounds(358, 259, 100, 13);
		contentPane.add(lblNewLabel_Poid);
		
		JLabel lblNewLabel_1 = new JLabel("Sommet Source");
		lblNewLabel_1.setBounds(344, 313, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSommetDestination_1 = new JLabel("Sommet Destination");
		lblSommetDestination_1.setBounds(344, 364, 100, 13);
		contentPane.add(lblSommetDestination_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sommet A Supprimer");
		lblNewLabel_2.setBounds(325, 93, 144, 13);
		contentPane.add(lblNewLabel_2);
		JButton btnImporterMatrice = new JButton("Importer Matrice");
		btnImporterMatrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphe=new Graphe_orienter_value(Graphe_orienter_value.MatriceFromFichier(),Val);
			}
		});
		btnImporterMatrice.setBounds(22, 31, 184, 21);
		contentPane.add(btnImporterMatrice);
		btnImporterMatrice.setEnabled(false);
		JButton btnImporterFsapsd = new JButton("Importer FsAps|D");
		btnImporterFsapsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				graphe= Graphe_orienter_value.GrapheFromFichier();
			}
		});
		btnImporterFsapsd.setBounds(22, 62, 184, 21);
		contentPane.add(btnImporterFsapsd);
		btnImporterFsapsd.setEnabled(false);
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
		btnAfficherMatrice.setBounds(22, 93, 184, 21);
		contentPane.add(btnAfficherMatrice);
		btnAfficherMatrice.setEnabled(false);
		JButton btnAfficherFsApsD = new JButton("Afficher FsApsD");
		btnAfficherFsApsD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					graphe.afficherFsApsDConsole();
					graphe.afficherFsApsText();
				}
			}
		});
		btnAfficherFsApsD.setBounds(22, 124, 184, 21);
		contentPane.add(btnAfficherFsApsD);
		btnAfficherFsApsD.setEnabled(false);
		JButton btnAfficherGraphe = new JButton("Afficher Graphe");
		btnAfficherGraphe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					graphe.afficherGraphe();
				}
			}
		});
		btnAfficherGraphe.setBounds(22, 155, 184, 21);
		contentPane.add(btnAfficherGraphe);
		btnAfficherGraphe.setEnabled(false);
		JButton btnAfficherDistance = new JButton("Afficher Distance");
		btnAfficherDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					if(graphe.TypeGraphe()==0)
					{
						Graphe_orienter_value.afficheMatriceConsole(graphe.DistanceMatrice(Val));
						Graphe_orienter_value.afficheMatricetext(graphe.DistanceMatrice(Val), " Matrice des distance");
						
					}
				}
			}
		});
		btnAfficherDistance.setBounds(22, 186, 184, 21);
		contentPane.add(btnAfficherDistance);
		btnAfficherDistance.setEnabled(false);
		JButton btnAfficherRang = new JButton("Afficher Rang");
		btnAfficherRang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int n=graphe.getAps()[0];
					int []rang=new int[n+1];
					int []prem=new int[n+1];
					int []pred=new int[n+1];
					graphe.Rang(rang, prem, pred);
					Graphe_orienter_value.afficheTabConsole(rang);
					Graphe_orienter_value.afficheTabText(" Le Grand des sommet ", rang);
				}
			}
		});
		btnAfficherRang.setBounds(22, 220, 184, 21);
		contentPane.add(btnAfficherRang);
		btnAfficherRang.setEnabled(false);
		JButton btnAfficherMatriceDjikstra = new JButton("Afficher Matrice Djikstra");
		btnAfficherMatriceDjikstra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					if(graphe.TypeGraphe()==1)
					{
					int[][]m=graphe.Matdijkstra(Val);
						Graphe_orienter_value.afficheMatriceConsole(m);
						Graphe_orienter_value.afficheMatricetext(m, " Matrice de dijkstra");
					}
				}
			}
		});
		btnAfficherMatriceDjikstra.setBounds(22, 251, 184, 21);
		contentPane.add(btnAfficherMatriceDjikstra);
		btnAfficherMatriceDjikstra.setEnabled(false);
		JButton btnFortementConnex = new JButton("FortementConnex");
		btnFortementConnex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					if(graphe.TypeGraphe()==0)
					{
					int[][]m=graphe.FortementConexGlobal();
						Graphe_orienter_value.afficheMatriceConsole(m);
						Graphe_orienter_value.afficherGrapheFromMatrice(m, Val, null);
						Graphe_orienter_value.afficheMatricetext(m, " Matrice de FortementConex");
					}
				}
			}
		});
		btnFortementConnex.setBounds(22, 282, 184, 21);
		contentPane.add(btnFortementConnex);
		btnFortementConnex.setEnabled(false);
		JButton btnAjouterSommet = new JButton("Ajouter Sommet");
		btnAjouterSommet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					graphe.AjouterSommet();
				}
				else
				{
					graphe=new Graphe_orienter_value();
					graphe.AjouterSommet();
				}
			}
		});
		btnAjouterSommet.setBounds(315, 31, 184, 21);
		contentPane.add(btnAjouterSommet);
		btnAjouterSommet.setEnabled(false);
		JButton btnSupprimerSommet = new JButton("Supprimer Sommet");
		btnSupprimerSommet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int sommet=Integer.valueOf(textFieldSommetASupprimer.getText());
					graphe.SupprimerSommet(sommet, Val);
					System.out.println("lala");
				}
			}
		});
		btnSupprimerSommet.setBounds(315, 62, 184, 21);
		contentPane.add(btnSupprimerSommet);
		btnSupprimerSommet.setEnabled(false);
		JButton btnAjouterArc = new JButton("Ajouter Arc");
		btnAjouterArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int source=Integer.valueOf(textFieldSommet_SourceA.getText());
					int destination=Integer.valueOf(textFieldSommet_DestinationA.getText());
					int poid=Integer.valueOf(textFieldPoid.getText());
					graphe.AjouterArc(Val, source, destination, poid);
				}
			}
		});
		btnAjouterArc.setBounds(315, 139, 184, 21);
		contentPane.add(btnAjouterArc);
		btnAjouterArc.setEnabled(false);
		JButton btnSupprimerArc = new JButton("Supprimer Arc");
		btnSupprimerArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(graphe!=null)
				{
					int source=Integer.valueOf(textFieldSommet_SourceS.getText());
					int destination=Integer.valueOf(textFieldSommet_DestinationS.getText());
					
					graphe.SupprimerArc(Val, source, destination);
				}
			}
		});
		btnSupprimerArc.setBounds(22, 329, 184, 21);
		contentPane.add(btnSupprimerArc);
		
		
		btnSupprimerArc.setEnabled(false);
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRetour.setBounds(22, 401, 85, 21);
		contentPane.add(btnRetour);
		
		JButton btnNewButton = new JButton("Aide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { Desktop.getDesktop().browse(new URL("https://github.com/AllKings/projet-graph-algo").toURI()); } catch (Exception e1) {} 
			}
		});
		btnNewButton.setBounds(121, 401, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNonValuer = new JButton("Non Value");
		JButton btnValuer = new JButton("Value");
		
		btnNonValuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNonValuer.setBackground(Color.GREEN);
				btnValuer.setBackground(Color.GRAY);
				btnNonValuer.setEnabled(false);
				btnValuer.setEnabled(false);
				btnImporterMatrice.setEnabled(true);
				btnImporterFsapsd.setEnabled(true);
				btnAfficherMatrice.setEnabled(true);
				btnAfficherFsApsD.setEnabled(true);
				btnAfficherGraphe.setEnabled(true);
				btnAfficherDistance.setEnabled(true);
				btnAfficherRang.setEnabled(true);
				btnAfficherMatriceDjikstra.setEnabled(true);
				btnFortementConnex.setEnabled(true);
				btnAjouterSommet.setEnabled(true);
				btnSupprimerSommet.setEnabled(true);
				btnAjouterArc.setEnabled(true);
				btnSupprimerArc.setEnabled(true);
				Val=0;
			}
		});
		
		btnNonValuer.setBounds(231, 443, 100, 21);
		contentPane.add(btnNonValuer);
		
		btnValuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNonValuer.setBackground(Color.GRAY);
				btnValuer.setBackground(Color.GREEN);
				btnNonValuer.setEnabled(false);
				btnValuer.setEnabled(false);
				btnImporterMatrice.setEnabled(true);
				btnImporterFsapsd.setEnabled(true);
				btnAfficherMatrice.setEnabled(true);
				btnAfficherFsApsD.setEnabled(true);
				btnAfficherGraphe.setEnabled(true);
				btnAfficherDistance.setEnabled(true);
				btnAfficherRang.setEnabled(true);
				btnAfficherMatriceDjikstra.setEnabled(true);
				btnFortementConnex.setEnabled(true);
				btnAjouterSommet.setEnabled(true);
				btnSupprimerSommet.setEnabled(true);
				btnAjouterArc.setEnabled(true);
				btnSupprimerArc.setEnabled(true);
				Val=100;
			}
		});
		
		btnValuer.setBounds(359, 443, 99, 21);
		contentPane.add(btnValuer);
		
	}
}
