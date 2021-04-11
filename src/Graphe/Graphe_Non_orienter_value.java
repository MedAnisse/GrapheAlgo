package Graphe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Graphe_Non_orienter_value extends Graphe_orienter_value{

	public Graphe_Non_orienter_value() {
		super();
		
	}

	public Graphe_Non_orienter_value(int[] Fs, int[] Aps, int[] D) {
		super(Fs, Aps, D);
		
	}

	public Graphe_Non_orienter_value(int[][] m, int val) {
		super(m, val);
		
	}
	public int [][] Kruskal()
	{
		int [][]matrice=super.ToMatrice(100);
		GrapheKruskal g, t;
		g=new GrapheKruskal();
		t=new GrapheKruskal();
		GrapheKruskal.saisie(g,matrice,100);
		int n = g.nombreSommet;
		int []prem = new int[n + 1];
		int []pilch = new int[n + 1];
		int []cfc = new int[n + 1];
		int []NbElem = new int[n + 1];
		for(int i=1; i<=n;i++)
		{
			prem[i] = i;
			pilch[i] = 0;
			cfc[i] = i;
			NbElem[i] = 1;
		}
		GrapheKruskal.trier(g);
		GrapheKruskal.kruskal(g, t, prem, pilch, cfc,NbElem);
		int [][]k1=GrapheKruskal.ToMatrice(t,100);
		k1[0][0]=k1.length-1;
		for(int i=1;i<k1.length;i++)
		{
			k1[i][0]=i;
		}
		for(int i=1;i<k1.length;i++)
		{
			for(int j=1;j<k1.length;j++)
			{
				if(k1[i][j]==0)
				{
					k1[i][j]=100;
				}
			}
		}
		return k1;
	}	
	 public void afficherGraphe()
	{int [][]matrice=ToMatrice(100);
		JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
		for(int i=1;i<matrice.length;i++)
		{
			matrice[i][0]=i;
		}
		matrice[0][0]=matrice.length-1;
		
		applet.init(matrice);
		JFrame frame1 = new JFrame();
        JButton btnNewButton23 = new JButton("retour");
        btnNewButton23.setBounds(10, 27, 85, 21);
        btnNewButton23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame1.setVisible(false);
			}
		});
        frame1.getContentPane().add(btnNewButton23);
        frame1.getContentPane().add(applet);
        frame1.setTitle("Graphe Valuer");
        frame1.pack();
        frame1.setVisible(true);
	}
	
}

