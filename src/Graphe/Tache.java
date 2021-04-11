package Graphe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Tache extends Graphe_orienter_value {

	public Tache() {
		super();
}

	public Tache(int[] Fs, int[] Aps, int[] D) {
		super(Fs, Aps, D);
	}

	public Tache(int[][] m, int val) {
		super(m, val);
	}
	void saisirMatrice(int [][]matrice)
	{
		Graphe_orienter_value g=new Graphe_orienter_value(matrice,100);
		this.setAps(g.getAps());
		this.setFs(g.getFs());
		this.setD(g.getD());
	}
	void saisir()
	{
		System.out.print("Donnez le nombre de taches : ");
		Scanner myInput = new Scanner( System.in );
		int nombreSommet=myInput.nextInt()+1;
		int [][]matrice=new int [nombreSommet+1][nombreSommet+1];
		for(int i=1;i<matrice.length;i++)
		{matrice[i][0]=i;
			for(int j=1;j<matrice.length;j++)
			{
				matrice[i][j]=100;
			}
		}
		System.out.print("Ordonner vos tache dans l'ordre cronologiaue et prioritaire");
		
		
		int nombreArc=0;
		for(int i=1;i<nombreSommet;i++)
		{
			System.out.print("\nDonnez la durre de la tache "+i+" : ");
			int poid=myInput.nextInt();
			System.out.print("Donnez le nombre des sucsseure de la tache "+i+" : ");
			int k=myInput.nextInt();
			for(int j=0;j<k;j++)
			{
				System.out.print("Donnez le numero de la tache  : entre(1-"+(nombreSommet-1)+") ");
				int suivant=myInput.nextInt();
				matrice[i+1][suivant]=poid;
				nombreArc++;
			}
			
		}
		boolean c,b=true;
		for(int i=2;i<nombreSommet;i++)
		{b=true;
		int j;
			for( j=2;i<nombreSommet&& b ;j++)
			{
				if(matrice[j][i]!=0)b=false;
				
			}
			if(b)
			{
				matrice[1][j]=1;
				nombreArc++;
			}
			
		}
		matrice[0][0]=nombreSommet;
		matrice[0][1]=nombreArc;
		Graphe_orienter_value g=new Graphe_orienter_value(matrice,100);
		this.setAps(g.getAps());
		this.setFs(g.getFs());
		this.setD(g.getD());
	}
	void ordonnancement(int []fp,int []app , int []d, int []fpc, int []appc, int []lc)
	{
		int NombreSommet= app[0];

	    for(int i=1;i<=NombreSommet;i++)
	    {
	        lc[i]=0;
	    }
	    int kc, t, lg;
	    lc[1] = 0;
	    fpc[1] = 0;
	    appc[1] = 1;
	    kc = 1;
	    for(int s = 2;s <= NombreSommet;s++)
	    {
	        lc[s] = 0;
	        appc[s] = kc+1;
	        for (int k = app[s];(t = fp[k]) != 0;k++)
	            {
	                lg = lc[t] + d[t];
	               
	                if (lg >= lc[s])if (lg > lc[s])
	                    {
	                        lc[s] = lg;
	                        kc = appc[s];
	                        fpc[kc] = t;
	                    }
	                    else
	                    {
	                        kc++;
	                        fpc[kc] = t;
	                    }
	            }
	        kc++ ;
	        fpc[kc] = 0;
	    }
	    fpc[0] = kc;
	}
	String cheminCritique()
	{
		int []fs=getFs();
		int []aps=getAps();
		int []d=getD();
		FpAppD graphe=new FpAppD(fs,aps , 100,d );
		fs=graphe.getFp();
		aps=graphe.getApp();
		for(int i=2;i<aps.length;i++)
		{
			aps[i]-=1;
		}
		
		d=graphe.getD();
		int []fpc;
		int []appc;
		int []lc;
		int NombreSommet= aps[0], taillFp= fs[0];
	    fpc = new int[taillFp+1];
	    appc = new int[NombreSommet+1];
	    appc[0] = NombreSommet;
	    lc = new int[NombreSommet+1];
	    lc[0] = NombreSommet;
	    ordonnancement(fs, aps, d, fpc, appc, lc);
	    StringBuilder data=new StringBuilder();
	    int indexFpc;
	    indexFpc=appc[appc.length-1];
	    int x=appc.length-1;
	    data.append(" "+x);
	    	while(fpc[indexFpc]!=0)
	    	{
	    		
	    		data.append(" "+fpc[indexFpc]);
	    		indexFpc=appc[fpc[indexFpc]];
	    	}
	  String []f=data.toString().split(" ");
	  data=new StringBuilder();
	  data.append("[");
	  for(int i=f.length-1;i>0;i--)
	  {
		  data.append(f[i]+",");
	  }
	  data.append("]");
	   return data.toString();
	}
	void AfficherCheminCritiqueConsole()
	{
		System.out.println(cheminCritique());
	}
	void AfficherCheminCritiqueText()
	{
		JFrame frame1 = new JFrame();
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 259, 173, 119);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(200, 200, 500, 300);
		frame1.getContentPane().add(textArea);
		textArea.setText(cheminCritique()	);
		textArea.setEditable(false);
		frame1.setVisible(true);
	}
}
