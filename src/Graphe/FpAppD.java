package Graphe;

public class FpAppD {
	
		private int []fp;
		private int []app;
		private int []d;
		public int[] getFp() {
			return fp;
		}
		public int[] getApp() {
			return app;
		}
		public int[] getD() {
			return d;
		}
		public void setFp(int[] fp) {
			this.fp = fp;
		}
		public void setApp(int[] app) {
			this.app = app;
		}
		public void setD(int[] d) {
			this.d = d;
		}
		public FpAppD(int[] Fs, int[] Aps,int val,int...D)
		{
			
			int NombreSommet=Aps[0];
		    int []TabNombreDePredecesseurs=new int[NombreSommet+1];
		    TabNombreDePredecesseurs[0]=NombreSommet;
		    int indexFs;
		    for(int i=1;i<=Aps[0];i++)
		    {TabNombreDePredecesseurs[i]=0;}
		    for(int i=1;i<=Aps[0];i++)
		    {
		        indexFs=Aps[i];
		        while(Fs[indexFs]!=0)
		        {
		            TabNombreDePredecesseurs[Fs[indexFs]]+=1;
		            indexFs++;
		        }

		    }
		    app=new int[NombreSommet+1];
		    app[0]=NombreSommet;
		    app[1]=1;
		    for(int i=2;i<=NombreSommet;i++)
		    {int j=i-1;
		       app[i]=app[j]+ TabNombreDePredecesseurs[j]+1;
		    }
		    int taillFs=Fs[0];
		    fp=new int[taillFs+1];
		    fp[0]=taillFs;
		    int indexFp;
		   for(int i=1;i<=Aps[0];i++)
		    {
		        indexFs=Aps[i];
		        while(Fs[indexFs]!=0)
		        {
		            indexFp=app[Fs[indexFs]];
		          fp[indexFp]=i;
		          app[Fs[indexFs]]+=1;
		          indexFs++;
		        }

		    }
		    for(int i=1;i<=Aps[0];i++)
		    {
		    fp[app[i]]=0;
		    }
		    d=new int[NombreSommet+1];
		    d[0]=NombreSommet;
		    for(int i=1;i<d.length;i++)
		    {
		    	d[i]=D[Aps[i]];
		    }
		 
	}

}
