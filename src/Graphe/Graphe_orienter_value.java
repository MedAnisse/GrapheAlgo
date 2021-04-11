package Graphe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

@SuppressWarnings("deprecation")
public class Graphe_orienter_value {
	private int []fs;
	private int []aps;
	private int []d;
	protected int  []pilch;
	protected int  []prem;
	protected int  []ro;
	protected int  []num;
	protected int  []cfc;
	protected boolean []EstDansLaPile;
	protected boolean []EstMarquer;
	protected int []pile;
	protected int p;
	protected int k;
	public Graphe_orienter_value()
	{
		fs=new int[2];
		fs[0]=1;
		fs[1]=0;
		aps=new int[2];
		aps[0]=1;
		aps[1]=1;
		d=new int[2];
		d[0]=1;
		d[1]=0;
	}
	public Graphe_orienter_value(int [][]m,int val)
	{
		int NombreSommet=m[0][0];
	    int NombreArc=m[0][1];
	    fs=new int [NombreSommet+NombreArc+1];
	    aps=new int[NombreSommet+1];
	    fs[0]=NombreSommet+NombreArc;
	    d=new int [NombreSommet+NombreArc+1];
	    d[0]=NombreSommet+NombreArc;
	    aps=new int[NombreSommet+1];
	    aps[0]=NombreSommet;
	    int indexFs=1;
	    int indexAps=indexFs;
	    
	    for(int i=1;i<=NombreSommet;i++)
	    {
	        aps[indexAps]=indexFs;
	        for(int j=1;j<=NombreSommet;j++)
	        {
	            if(m[i][j]!=val)
	            {
	                fs[indexFs]=j;
	                d[indexFs]=m[i][j];
	                indexFs++;
	            }
	        }
	        fs[indexFs]=0;
	        d[indexFs]=0;
	        indexFs++;
	        indexAps++;
	    }
	    
	}
	public Graphe_orienter_value(int []Fs,int []Aps,int []D)
	{
		fs=Fs;
		aps=Aps;
		if(D==null)
		{
			d=new int [fs[0]+1];
		    d[0]=fs[0];
		    for(int i=0;i<fs.length;i++)
		    {
		    	
		    	if(fs[i]!=0)
		    	{
		    		d[i]=1;
		    	}
		    	else
		    	{
		    		d[i]=fs[i];
		    	}
		    }
		}
		else
		{
			d=D;
		}
	}
	public int [][] ToMatrice(int val)
	{
		int [][]matrice;
		int NombreSommet=aps[0];
	    int NombreArc=fs[0]-NombreSommet;
	   
	    if(NombreSommet>0)
	    { matrice=new int [NombreSommet+1][NombreSommet+1];
	    for(int i=0;i<matrice.length;i++)
	    {
	    	for(int j=0;j<matrice.length;j++)
		    {
		    	matrice[i][j]=val;
		    	matrice[i][0]=i;
		    }
	    }
	    	int indexFs;
	        for(int i=1;i<=aps[0];i++)
	        {
	            indexFs=aps[i];
	            while(fs[indexFs]!=0)
	            {
	            	matrice[i][fs[indexFs]]=d[indexFs];
	                indexFs++;
	            }

	        }
	        matrice[0][0]=NombreSommet;
	        matrice[0][1]=NombreArc;
	    		return matrice;
	}
	    return null;
	    }
	public int[] getFs() {
		return fs;
	}
	public int[] getAps() {
		return aps;
	}
	public int[] getD() {
		return d;
	}
	public void setFs(int[] fs) {
		this.fs = fs;
	}
	public void setAps(int[] aps) {
		this.aps = aps;
	}
	public void setD(int[] d) {
		this.d = d;
	}
	public void init()
	{
		int NombreSommet=aps[0]+1;
		pilch=new int [NombreSommet+1];
		prem=new int [NombreSommet+1];
		ro=new int [NombreSommet+1];
		num=new int [NombreSommet+1];
		cfc=new int [NombreSommet+1];
		EstDansLaPile=new boolean [NombreSommet+1];
		pile=new int [NombreSommet+1];
		p=0;
		k=0;
		for(int i=0;i<=NombreSommet;i++)
		{
			pilch[i]=0;
			prem[i]=0;
			ro[i]=0;
			num[i]=0;
			cfc[i]=0;
			EstDansLaPile[i]=false;
			pile[i]=0;
			
		}
		pilch[0]=0;
		prem[0]=NombreSommet;
		ro[0]=NombreSommet;
		num[0]=NombreSommet;
		pile[0]=NombreSommet;
	}
	public int [] Distance(int sommet)
	{
		int []TablDist;
		int NombreSommet=aps[0];
		TablDist=new int[NombreSommet+1];
	    TablDist[0]=aps[0];
	    for(int i=1;i<=aps[0];i++)
	    {
	        TablDist[i]=-1;

	    }
	    TablDist[sommet]=0;
	    int []file=new int [NombreSommet+1];
	    int distance=1;
	    int indexFs;
	    int debut=1,courant=0,fin=1;
	    file[debut]=sommet;
	    while(courant<fin)
	    {
	        for(int i=courant+1;i<=debut;i++)
	        {
	            indexFs=aps[file[i]];
	            while(fs[indexFs]!=0)
	            {
	                if(TablDist[fs[indexFs]]==-1)
	                {
	                   TablDist[fs[indexFs]]=distance;
	                    fin++;
	                   file[fin]=fs[indexFs];

	                }
	                indexFs++;
	            }

	        }
	        courant=debut;
	        debut=fin;

	        distance++;
	    }

		return TablDist;
	}
	public int [][] DistanceMatrice(int val)
	{int [][]matriceDistance;
		int NombreSommet=aps[0];
		matriceDistance=new int [NombreSommet+1][NombreSommet+1];
		for(int i=0;i<matriceDistance.length;i++)
	    {
	    	for(int j=0;j<matriceDistance.length;j++)
		    {
		    	matriceDistance[i][j]=val;
		    	
		    }
	    }
	    for(int i=1;i<=NombreSommet;i++)
	    {
	    	matriceDistance[i]= Distance(i);
	    }
		return matriceDistance;
		
	}
	public int [] NombreDePredecesseurs()
	{
	    int NombreSommet=aps[0];
	    int []TabNombreDePredecesseurs=new int [NombreSommet+1];
	    TabNombreDePredecesseurs[0]=NombreSommet;
	    int indexFs;
	    for(int i=1;i<=aps[0];i++)
	    {TabNombreDePredecesseurs[i]=0;}
	    for(int i=1;i<=aps[0];i++)
	    {
	        indexFs=aps[i];
	        while(fs[indexFs]!=0)
	        {
	            TabNombreDePredecesseurs[fs[indexFs]]+=1;
	            indexFs++;
	        }

	    }
	    return TabNombreDePredecesseurs;
	}
	public void Rang(int [] result, int [] prem,int []pred)
	{
		int []ddi=this.NombreDePredecesseurs();
	    int NombreSommet=aps[0];
	    int k=0;
	    int sommet=1;
	    for(int i=0;i<=NombreSommet;i++)
	    {
	    	prem[i]=0;
	    	pred[i]=0;
	        result[i]=-1;
	    }
	    result[0]=NombreSommet;
	    for(int i=1;i<=NombreSommet;i++)
	    {
	        if(ddi[i]==0)
	        {
	            empiler(pred,i);
	            result[i]=k;
	        }
	    }
	    int j;
	    while(pred[0]!=0)
	    {
	    	empiler(prem,pred[0]);
	        
	        sommet=prem[0];
	        pred[0]=0;
	        while(sommet!=0)
	        {
	                j=aps[sommet];

	                while(fs[j]!=0)
	                {
	                    ddi[fs[j]]-=1;
	                    if(ddi[fs[j]]==0)
	                    {
	                    	empiler(pred,fs[j]);
	                        result[fs[j]]=result[sommet]+1;
	                       
	                    }

	                    j+=1;
	                }

	                sommet=pred[sommet];

	            }

	    }
	}
	public int [][] FortementConexGlobal()
	{init();
		FortementConex(1);
		int i=2;
		while(i<=aps[0])
		{
			while(cfc[i]!=0 && i<=aps[0])
			{i++;}
			if(i<=aps[0]&& cfc[i]==0)
			{
				FortementConex(i);
			}
			if(cfc[i]!=0)
			{
				i++;
			}
		}
		//System.out.println("k= "+cfc[0]);
		for(int j=1;j<=aps[0];j++)
		{
			//System.out.print(cfc[j]+" ");
		}
		int[][] matriceIntermidaire=new int [cfc[0]+1][cfc[0]+1];
		for(int i1=0;i1<matriceIntermidaire.length;i1++)
	    {
	    	for(int j=0;j<matriceIntermidaire.length;j++)
		    {
	    		matriceIntermidaire[i1][j]=0;
		    }
	    }
		int b=0;
		int [][] m=ToMatrice(0);
		for(int s=1;s<=aps[0];s++)
		{
			for(int j=s+1;j<=aps[0];j++)
			{
				if(cfc[s]!=cfc[j])
				{
					if(m[s][j]==1)
					{
						matriceIntermidaire[cfc[s]][cfc[j]]=1;
						b++;
					}
					else
					{
						if(m[j][s]==1)
						{
							matriceIntermidaire[cfc[j]][cfc[s]]=1;
							b++;
						}
					}
				}
			}
		}
		matriceIntermidaire[0][0]=cfc[0];
		matriceIntermidaire[0][1]=b;
		int []f=new int [cfc[0]+1];
		int []f1=new int [cfc[0]+1];
		for( i=0;i<f.length;i++)
		{
			f[i]=0;
		}
		for( i=1;i<cfc.length;i++)
		{
			if(f[cfc[i]]<10&&f[cfc[i]]==0)f[cfc[i]]=i;
			else
			{
				f[cfc[i]]=f[cfc[i]]*10+i;
			}
			f1[cfc[i]]=cfc[i];
		}
		for( i=1;i<matriceIntermidaire.length;i++)
		{
			matriceIntermidaire[i][0]=f[f1[i]];
		}
		return matriceIntermidaire;
	}
	
	void FortementConex(int sommet)
	{
	    p++;

	    num[sommet]=p;
	    ro[sommet]=p;
	    empiler(pile,sommet);
	    EstDansLaPile[sommet]=true;
	    int i=aps[sommet];
	    while(fs[i]!=0)
	    {
	        if(num[fs[i]]==0)
	        {
	            FortementConex(fs[i]);
	            if(ro[fs[i]]<ro[sommet])
	            {
	                ro[sommet]=ro[fs[i]];
	            }
	        }
	        else
	        {
	            if(num[fs[i]]<ro[sommet] && EstDansLaPile[fs[i]])
	            {
	                ro[sommet]=num[fs[i]];
	            }
	        }
	        i++;
	    }
	    if(ro[sommet]==num[sommet])
	    {
	        k++;
	        int element=pile[0];
	        
	        while(num[element]>=num[sommet])
	        {
	          
	            element=depiler(pile);
	            EstDansLaPile[element]=false;
	            empiler(pilch,element);
	            cfc[element]=k;
	            element=pile[0];

	        }
	        prem[k]=pilch[0];
	        pilch[0]=0;
	    }

	    cfc[0]=k;
	}
	static void empiler(int [] pile,int valeur)
	{
	    pile[valeur]=pile[0];
	    pile[0]=valeur;
	}
	static int depiler(int [] pile)
	{
	    int sommet=pile[0];
	    pile[0]=pile[sommet];
	    return sommet;
	}
	public void AjouterSommet()
	{
		int []Fs1=new int [fs.length+1];
		int []D1=new int [d.length+1];
		int []Aps1=new int [aps.length+1];
		for(int i=0;i<fs.length;i++)
		{
			Fs1[i]=fs[i];
			D1[i]=d[i];
		}
		for(int i=0;i<aps.length;i++)
		{
			Aps1[i]=aps[i];
		}
		
		Fs1[0]=Fs1.length-1;
		D1[0]=D1.length-1;
		Aps1[0]=Aps1.length-1;
		Fs1[fs.length]=0;
		D1[d.length]=0;
		Aps1[aps.length]=fs.length;
		fs=Fs1;
		aps=Aps1;
		d=D1;
	}
	public void SupprimerSommet(int index,int val)
	{int [][]m=ToMatrice(val);
		int [][]t=new int [m[0][0]][m[0][0]];
		if(index==m[0][0])
		{
			for(int i=0;i<m[0][0];i++)
			{
				for(int j=0;j<m[0][0];j++)
				{
					t[i][j]=m[i][j];
				}
			}
			int nb=0;
			for(int i=1;i<=m[0][0];i++)
			{
				if(m[index][i]!=val)nb++;//a modifier si change graphe orienter valuer 100
				if(m[i][index]!=val)nb++;
			}
			if(m[index][index]!=val)nb--;
			t[0][0]=m[0][0]-1;
			if(m[0][1]>0)t[0][1]=m[0][1]-nb;
			
			Graphe_orienter_value g=new Graphe_orienter_value(t, val);
			this.fs=g.getFs();
			this.aps=g.getAps();
			this.d=g.getD();
		}
		else
		{int nb=0;
			for(int i=1;i<=m[0][0];i++)
			{
				if(m[index][i]!=val)nb++;//a modifier si change graphe orienter valuer 100
				if(m[i][index]!=val)nb++;
			}
			if(m[index][index]!=0||m[index][index]!=100)nb--;
			t[0][0]=m[0][0]-1;
			
			
			for(int i=index;i<m[0][0];i++)
			{
				for(int j=1;j<=m[0][0];j++)
				{
					m[i][j]=m[i+1][j];
				}	
			}
			for(int i=1;i<m[0][0];i++)
			{
				for(int j=index;j<m[0][0];j++)
				{
					m[i][j]=m[i][j+1];
				}	
			}
			m[0][0]-=1;
			int [][]t1=new int [m[0][0]+1][m[0][0]+1];
			for(int i=0;i<=m[0][0];i++)
			{
				for(int j=0;j<=m[0][0];j++)
				{
					t1[i][j]=m[i][j];
					
				}
			}
			t1[0][0]=m[0][0];
			if(m[0][1]>0)t[0][1]=m[0][1]-nb;
			
			Graphe_orienter_value g=new Graphe_orienter_value(t1, val);
			this.fs=g.getFs();
			this.aps=g.getAps();
			this.d=g.getD();
		}
	}
	public void AjouterArc(int val,int source,int distination,int...poid)
	{
		if(source>aps[0]||source<1||distination>aps[0]||distination<1)
		{}
		else
		{int [][] matriceIntermeduare=ToMatrice(val);
		matriceIntermeduare[0][1]+=1;
			if(poid==null)
			{
				matriceIntermeduare[source][distination]=1;
			}
			else
			{
				matriceIntermeduare[source][distination]=poid[0];
				//System.out.println("poid="+poid[0]);
			}
			
			Graphe_orienter_value grapheIntermediere=new Graphe_orienter_value(matriceIntermeduare,val);
			fs=grapheIntermediere.getFs();
			aps=grapheIntermediere.getAps();
			d=grapheIntermediere.getD();
		}
	}
	public void SupprimerArc(int val,int source,int distination)
	{
		if(source>aps[0]||source<1||distination>aps[0]||distination<1)
		{}
		else
		{int [][] matriceIntermeduare=ToMatrice(val);
			
			matriceIntermeduare[0][1]-=1;
			matriceIntermeduare[source][distination]=val;
			
			Graphe_orienter_value grapheIntermediere=new Graphe_orienter_value(matriceIntermeduare,val);
			fs=grapheIntermediere.getFs();
			aps=grapheIntermediere.getAps();
			d=grapheIntermediere.getD();
		}
	}
	public int  TypeGraphe()
	{int k=0;
		for(int i=1;i<d.length;i++)
		{
			if(d[i]==1||d[i]==0 )
			{}
			else {k=1;break;}
		}
		return k;
	}
	public void afficherFsApsDConsole()
	{
		
		for(int i=0;i<fs.length-1;i++)
		{
			System.out.print(fs[i]+" ");
		}
		System.out.print(fs[fs.length-1]+"\n");
		for(int i=0;i<aps.length-1;i++)
		{
			System.out.print(aps[i]+" ");
		}
		if(TypeGraphe()==1)
		{
			System.out.print(aps[aps.length-1]+"\n");
			for(int i=0;i<d.length-1;i++)
			{
				System.out.print(d[i]+" ");
			}
			System.out.print(d[d.length-1]);
		}
		else
		{
			System.out.print(aps[aps.length-1]);
		}
		
	}
	public void afficherMatriceConsole()
	
	{int [][]matriceIntermediaire;
	if(TypeGraphe()==1)
			{matriceIntermediaire=ToMatrice(1000);}
	else
		{matriceIntermediaire=ToMatrice(0);}
		for(int i=0;i<matriceIntermediaire.length;i++)
		{
			for(int j=0;j<matriceIntermediaire.length;j++)
			{
				System.out.print(matriceIntermediaire[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	public void afficherFsApsText()
	{int val;
	if(TypeGraphe()==1)val=100;
	else val=0;
		StringBuilder data=new StringBuilder();
		  for(int i=0;i<getFs()[0];i++)
		  {
			  data.append(getFs()[i]+" ");
		  }
		  data.append(getFs()[getFs()[0]]+"\n");
		  for(int i=0;i<getAps()[0];i++)
		  {
			  data.append(getAps()[i]+" ");
		  }
		  if(val==1)
		  {
		  data.append(aps[getAps()[0]]+"\n");
		  for(int i=0;i<getD()[0];i++)
		  {
			  data.append(getD()[i]+" ");
		  }
		  data.append(getD()[getD()[0]] );
		  }
		  else
		  {
			  data.append(aps[getAps()[0]]);
		  }
		JFrame frame1 = new JFrame();
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 259, 173, 119);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(200, 200, 500, 300);
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 200, 85, 21);
		frame1.getContentPane().add(btnNewButton_1);
		frame1.getContentPane().add(textArea);
		textArea.setText(data.toString());
		textArea.setEditable(false);
		frame1.setVisible(true);
	}
	public void afficherMatriceText()
	{
		int val;
		if(TypeGraphe()==1)val=100;
		else val=0;
		int [][] matriceIntermediaire=ToMatrice(val);
		StringBuilder data=new StringBuilder();
		  for(int i=0;i<matriceIntermediaire.length;i++)
		  {
			  for(int j=0;j<matriceIntermediaire.length-1;j++)
			  {
			  data.append(matriceIntermediaire[i][j]+" ");
			  }
			  data.append(matriceIntermediaire[i][matriceIntermediaire.length-1]+"\n");
		  }
		  
		JFrame frame1 = new JFrame();
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 259, 173, 119);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(200, 200, 500, 300);
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 200, 85, 21);
		frame1.getContentPane().add(btnNewButton_1);
		frame1.getContentPane().add(textArea);
		textArea.setText(data.toString());
		textArea.setEditable(false);
		frame1.setVisible(true);
	}
	public static void afficheTabConsole(int...tab)
	{
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+" ");
		}
	}
	public static void afficheMatriceConsole(int[][]mat)
	{	
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat.length;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("\n");
		}
		
	}
	public static void afficheTabText(String message,int...tab)
	{
		StringBuilder data=new StringBuilder();
		data.append(message+" : ");
		  for(int i=0;i<tab.length-1;i++)
		  {
			  data.append(tab[i]+" ");
		  }
		  data.append(tab[tab[0]]);
		  JFrame frame1 = new JFrame();
			JTextArea textArea = new JTextArea();
			textArea.setBounds(60, 259, 173, 119);
			
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setBounds(200, 200, 500, 300);
			JButton btnNewButton_1 = new JButton("Retour");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame1.setVisible(false);
				}
			});
			btnNewButton_1.setBounds(10, 200, 85, 21);
			frame1.getContentPane().add(btnNewButton_1);
			frame1.getContentPane().add(textArea);
			textArea.setText(data.toString());
			textArea.setEditable(false);
			frame1.setVisible(true);
	}
	public static void afficheMatricetext(int[][]mat,String message)
	{	
		StringBuilder data=new StringBuilder();
		data.append(message+" : ");
		  for(int i=0;i<mat.length;i++)
		  {
			  for(int j=0;j<mat.length-1;j++)
			  {
			  data.append(mat[i][j]+" ");
			  }
			  data.append(mat[i][mat.length-1]+"\n");
		  }
		  
		JFrame frame1 = new JFrame();
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 259, 173, 119);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(200, 200, 500, 300);
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 200, 85, 21);
		frame1.getContentPane().add(btnNewButton_1);
		frame1.getContentPane().add(textArea);
		textArea.setText(data.toString());
		textArea.setEditable(false);
		frame1.setVisible(true);
		
	}
	public static void afficherGrapheFromMatrice(int[][]mat,int val,int...t)
	{
		JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
		applet.init(mat,val,t);
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
	public void afficherGraphe()
	{JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
		int [][]matriceIntermediaire;
		if(TypeGraphe()==1)
		{
			matriceIntermediaire=ToMatrice(100);
	        applet.init(matriceIntermediaire,100,0);
	        
		}
		else
		{
			matriceIntermediaire=ToMatrice(0);
			applet.init(matriceIntermediaire,0,0);
		}
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
	public void EnregistrerFsApsDFichier()
	{int val;
	if(TypeGraphe()==1)val=100;
	else val=0;
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  // save to file
		  StringBuilder data=new StringBuilder();
		  for(int i=0;i<getFs()[0];i++)
		  {
			  data.append(getFs()[i]+" ");
		  }
		  data.append(getFs()[getFs()[0]]+"\n");
		  for(int i=0;i<getAps()[0];i++)
		  {
			  data.append(getAps()[i]+" ");
		  }
		  if(val==1)
		  {
		  data.append(aps[getAps()[0]]+"\n");
		  for(int i=0;i<getD()[0];i++)
		  {
			  data.append(getD()[i]+" ");
		  }
		  data.append(getD()[getD()[0]] );
		  }
		  else
		  {
			  data.append(aps[getAps()[0]]);
		  }
		  FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			 BufferedWriter bw = new BufferedWriter(fw);
			   bw.write(data.toString());
			   bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		}
	}
	public static Graphe_orienter_value GrapheFromFichier()
	{int k=0;
	int []fs=null;
	int [] aps=null;
	int [] d=null;
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
			if ((line = in.readLine()) != null)
				{
				String []tabelEment=line.split(" ");
				int tailleFs=Integer.parseInt(tabelEment[0]);
				fs=new int[tailleFs+1];
			    fs[0]=tailleFs;
			    for(int j=1;j<=tailleFs;j++)
		        {
		         fs[j]=Integer.parseInt(tabelEment[j]);
		        }
			    if ((line = in.readLine()) != null)
			    {
			    	String []tabelEment1=line.split(" ");
			    	int NombreSommet=Integer.parseInt(tabelEment1[0]);
			    	
			    	aps=new int [NombreSommet+1];
			        aps[0]=NombreSommet;
			        for(int j=1;j<=NombreSommet;j++)
			        {
			         aps[j]=Integer.parseInt(tabelEment1[j]);
			        }
			    }
			    if ((line = in.readLine()) != null)
			    {k=1;
			    	String []tabelEment1=line.split(" ");
			    	int NombreSommet=Integer.parseInt(tabelEment1[0]);
			    	
			    	d=new int [NombreSommet+1];
			        d[0]=NombreSommet;
			        for(int j=1;j<=NombreSommet;j++)
			        {
			         d[j]=Integer.parseInt(tabelEment1[j]);
			        }
			    }
				}
			in.close();
		}
		catch(Exception e)
		{
			 System.out.println ("probleme fichier");
		}
		return new Graphe_orienter_value(fs,aps,d);
	}
	public static int [][] MatriceFromFichier()
	
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
			line = in.readLine();
			String []tabelEment=line.split(" ");
			int tailleFs=Integer.parseInt(tabelEment[1]);
			int NombreSommet=Integer.parseInt(tabelEment[0]);
			int [][]matrice=new int[NombreSommet+1][NombreSommet+1];
		    for(int i=2;i<=NombreSommet;i++)
		    {
		    	matrice[0][i]=0;
		    	matrice[i][0]=i;
		    }
		    for(int i=1;i<=NombreSommet;i++)
		    {
		    	line = in.readLine();
		    	String []tabelEment1=line.split(" ");
		    	for(int j=0;j<=NombreSommet;j++)
			    {
		    		matrice[i][j]=Integer.parseInt(tabelEment1[j]);
			    }
		    }	
			in.close();
			matrice[0][0]=NombreSommet;
			matrice[0][1]=tailleFs;
			return matrice;
				
		}
		catch(Exception e)
		{
			 System.out.println ("probleme fichier");
			
		}
		
		return null;
		
	}
	public void EnregistrerMatriceFichier()
	{int val;
		if(TypeGraphe()==1)val=100;
		else val=0;
		int [][] matriceIntermediaire=ToMatrice(val);
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  // save to file
		  StringBuilder data=new StringBuilder();
		  for(int i=0;i<=matriceIntermediaire[0][0];i++)
		  {
			  for(int j=0;j<matriceIntermediaire[0][0];j++)
			  {
			  data.append(matriceIntermediaire[i][j]+" ");
			  }
			  data.append(matriceIntermediaire[i][matriceIntermediaire[0][0]]+"\n");
		  }
		  
		  FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			 BufferedWriter bw = new BufferedWriter(fw);
			   bw.write(data.toString());
			   bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		}
		
	}
	int minDistance(int NombreDeSommet,int []dist, boolean []marquer)
	{
	    int minS = Integer.MAX_VALUE, min_index=0;
	    int i;
	    for ( i = 1; i <dist.length; i++)
	        if (marquer[i] == false && dist[i] <= minS)
	        { minS = dist[i];
	    		min_index = i;}

	    return min_index;
	}
	int[] dijkstra(int [][]mat, int src)
	{
		int []pred;
	    int NombreDeSommet=mat[0][0];
	    int[] dist=new int [NombreDeSommet+1];
	    pred=new int[NombreDeSommet+1];
	    pred[0]=NombreDeSommet;
	    boolean []marquer=new boolean [NombreDeSommet+1];
	    dist[0] = NombreDeSommet;
	    int i;
	    for ( i = 1; i <= NombreDeSommet; i++)
	    { dist[i] = Integer.MAX_VALUE-100;
	    	marquer[i] = false;
	        dist[src] = 0;
	    }
	        for (int j = 1; j <= NombreDeSommet; j++)
	            {

	                int u = minDistance(NombreDeSommet,dist, marquer);
	                
	                marquer[u] = true;
	               
	                for (int v = 1; v <= NombreDeSommet; v++)
	                 {
	                	
	                   if (!marquer[v] && dist[u] != Integer.MAX_VALUE-100  &&(dist[u] + mat[u][v]) < dist[v])
	                        {
	                            dist[v] = dist[u] + mat[u][v];
	                           
	                            pred[v]=u;
	                        }
	                 }

	    }
	        return pred;

	}
	public int [][] Matdijkstra(int val)
	{
		if(val!=0)
		{
			int [][] entrer=ToMatrice(val);
			int [][] sortie=ToMatrice(val);
			boolean t=false;
		
			for(int i=0;i<entrer.length;i++)
			{
				for(int j=0;j<entrer.length;j++)
				{
					if(entrer[i][j]<0)
					{
						
						t=true;
						break;
					}
				}	
			}
			if(!t)
			{
				for(int i=1;i<=entrer[0][0];i++)
				{
					sortie[i]=dijkstra(entrer,i);
				}
				return sortie;
			}
		}
		
	return null;
	}
	
}
