package Graphe;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class Arbre extends Graphe_orienter_value {

	public Arbre() {
		super();
	}

	public Arbre(int[] Fs, int[] Aps, int[] D) {
		super(Fs, Aps, D);
	}

	public Arbre(int[][] m, int val) {
		super(m, 0);
	}
	public Arbre(int[][] m) {
		super(decdPrufer(prufer(m)),0);
	}
	public static int[] prufer(int [][]a)
	{
		int []prf;
		for(int i=1;i<a.length;i++)
		{a[i][0]=0;
			for(int j=1;j<a.length;j++)
			{
				if(a[i][j]!=0)a[i][0]++;
			}
		}
		int nb_som = a[0][0];
		prf = new int[nb_som-2];
		prf[0] = nb_som-2;
		int k = 0;
		while (k < nb_som-2)
		{	int i = 1;
			for (; a[i][0] != 1; i++);
			int j=1;
			for (; a[i][j] != 1; j++);
			prf[k++]=j;
			a[i][j]=0;
			a[j][i]=0;
			a[i][0]=0;
			a[j][0]--;
		}
		return prf;
	}
	static int [][] decdPrufer( int []t)
	{
	    int NombreSommet=t.length+2;
	   int [][] Mat=new int[NombreSommet+1][NombreSommet+1];
	    

	    for(int i=0;i<=NombreSommet;i++)
	    {
	        for(int j=0;j<=NombreSommet;j++)
	        {
	         Mat[i][j]=0;
	        }
	    }
	    
	    Mat[0][0]=NombreSommet;
	    int []sommet =new int [NombreSommet+1];
	  int[] b=new int [NombreSommet+1];
	  for (int i = 1; i <= NombreSommet; i++)
	  {
	    sommet[i]=0;
	    b[i]=i;
	  }
	  
	  for (int i = 0; i <NombreSommet-2 ; i++)
	  {
	    sommet[t[i]]+=1;
	    
	  }
	  
	  int nb=0;
	  
	  for (int i = 0; i < NombreSommet-2; i++)
	  {
	    int j = 1;
	    while ( (b[j]==-1 || sommet[j]!=0) && j<=NombreSommet ){j++;}
	    if(j<=NombreSommet)
	    {Mat[j][t[i]]=1;nb++;
	    Mat[t[i]][j]=1;nb++;
	    sommet[t[i]]--;
	    b[j]=-1;}
	  }

	  int i=1;
	  while ( b[i]==-1 && i<=NombreSommet){i++;}

	    int  j=b[i];
	  i++;
	  while ( b[i]==-1 && i<=NombreSommet ){i++;}
	int q=b[i];
	   Mat[j][q]=1;nb++;
	  Mat[q][j]=1;nb++;
	  Mat[0][1]=nb;
	  
	  return Mat;
	}
	public Arbre(int[]t)
	{
		super(decdPrufer(t),0);
	}
	public static Arbre ArbreFromFicher()
	{
		JFileChooser file=new JFileChooser();
		int reponse=file.showOpenDialog(null);
		String nomFicher="";
		if(reponse==JFileChooser.APPROVE_OPTION)
		{
			nomFicher=file.getSelectedFile().getAbsolutePath();
			
		}
		try
		{
			FileReader file1=new FileReader(nomFicher);
			BufferedReader in = new BufferedReader(file1);
			String line;
			int []t=null;
			if ((line = in.readLine()) != null)
				{
				
				String []tabelEment=line.split(" ");
				
				t=new int[tabelEment.length];
			    t[0]=tabelEment.length;
			    for(int j=0;j<tabelEment.length;j++)
		        {
		         t[j]=Integer.parseInt(tabelEment[j]);
		        }
				}
			in.close();
			
			Arbre b=new Arbre(t);
			
			return b;
			}
		catch (Exception e) {
			System.out.println("Problem fichier");
		}
		return null;
	}
}
