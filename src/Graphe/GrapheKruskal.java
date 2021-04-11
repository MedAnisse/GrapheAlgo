package Graphe;

import java.util.Scanner;

public class GrapheKruskal {
		public GrapheKruskal() {
			super();
			this.nombreSommet = 0;
			this.nombrearetes = 0;
			this.tab = null;
		}
		public int nombreSommet;
		public int nombrearetes;
		public Arete [] tab;
	
	static void  saisie(GrapheKruskal g)
	{Scanner myInput = new Scanner( System.in );
		int s, t;
		Arete ar;
		System.out.println("Saisie d'un graphe non oriente value arete par arete ");
		System.out.println("Donnez le nombre de sommets : ");
		g.nombreSommet=myInput.nextInt();

		do
		{
			System.out.println("Donnez le nombre d'aretes : ");
			g.nombrearetes=myInput.nextInt();
		} while (g.nombrearetes < g.nombreSommet);

		g.tab = new Arete[g.nombrearetes];

		System.out.println("Saisissez les " +g.nombrearetes+ " aretes");
		for (int i = 0; i < g.nombrearetes; i++)
		{
			System.out.println( "arete n " + 4 + " :");
			do
			{
				System.out.println("extremite 1 (entre 1 et " + g.nombreSommet + " ) : ");
				s=myInput.nextInt();
				
			} while ((s < 1) && (s > g.nombreSommet));
			do
			{
				System.out.println("extremite 2 (entre 1 et " +g.nombreSommet +" ) : ");
				t=myInput.nextInt();
			}while ((t < 1) && (t > g.nombreSommet));
			
			System.out.println("Poids de l'arete : ");
			ar=new Arete(s, t, myInput.nextInt());
			g.tab[i]=ar;
		}
	}
	static void affichage(GrapheKruskal g)
	{
		for (int i = 0; i < g.nombrearetes; i++)
			System.out.println("Arete No "+ (i+1) +" : ("+g.tab[i].s +" , "+ g.tab[i].t +")  ---  "+ g.tab[i].poid);
	}
	static void trier(GrapheKruskal g)
	{
		Arete p;
		for (int i = 0; i < g.nombrearetes - 1; i++)
			for (int j = i + 1; j < g.nombrearetes; j++)
				if ((g.tab[j].poid < g.tab[i].poid) || (g.tab[j].poid == g.tab[i].poid && g.tab[j].s < g.tab[i].t) || (g.tab[j].poid == g.tab[i].poid && g.tab[j].t < g.tab[i].t))
				{
					p = g.tab[j];
					g.tab[j] = g.tab[i];
					g.tab[i] = p;
				}
	}

	static void fusionner(int i, int j, int []prem, int []pilch, int []cfc, int []NbElem)

	{
		if (NbElem[i] < NbElem[j])
		{
			int aux = i;
			i = j;
			j = aux;
		}
		int s = prem[j];
		cfc[s] = i;
		while (pilch[s] != 0)
		{
			s = pilch[s];
			cfc[s] = i;
		}
		pilch[s] = prem[i];
		prem[i] = prem[j];
		NbElem[i] += NbElem[j];
	}

	static void kruskal(GrapheKruskal g, GrapheKruskal t, int []prem, int []pilch, int []cfc, int []NbElem)
	{
		t.tab = new Arete[g.nombreSommet-1];
		int x; 
		int y; 
		int i = 0, j = 0;
		while (j < g.nombreSommet-1)
		{
			Arete ar = g.tab[i];
			x = cfc[ar.s];
			y = cfc[ar.t];
			if (x != y)
			{
				t.tab[j++] = g.tab[i];
				fusionner(x, y, prem, pilch, cfc, NbElem);
			}
			i++;
		}
		t.nombreSommet = g.nombreSommet;
		t.nombrearetes = g.nombreSommet - 1;
	}
	public static int [][] ToMatrice(GrapheKruskal g,int val){
		int [][]matrice;
		matrice=new int [g.nombreSommet+1][g.nombreSommet+1];
		for(int i=1;i<matrice.length;i++)
		{
			for(int j=1;j<matrice.length;j++)
			{
				matrice[i][i]=val;
			}
		}
		for(int i=0;i<g.nombrearetes;i++)
		{
			matrice[g.tab[i].s][g.tab[i].t]=g.tab[i].poid;
			matrice[g.tab[i].t][g.tab[i].s]=g.tab[i].poid;
		}
		matrice[0][0]=g.nombreSommet;
		matrice[0][1]=g.nombrearetes*2;
		return matrice;
	}
	static void  saisie(GrapheKruskal g,int [][]matrice,int val)
	{
		g.nombreSommet=matrice[0][0];
		do
		{
			g.nombrearetes=matrice[0][1]/2;
		} while (g.nombrearetes < g.nombreSommet);
		g.tab = new Arete[g.nombrearetes];
		int k=0;
		for (int i = 1; i <matrice.length; i++)
		{
			for(int j=i+1;j<matrice.length;j++)
			{
				if(matrice[i][j]!=val)
				{
					
					g.tab[k]=new Arete(i, j, matrice[i][j]);
					k++;
				}
			}
			
		}
	}
}
