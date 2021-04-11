package Graphe;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner myInput = new Scanner( System.in );
		System.out.print("\n ---------------------------------Consol---------------------- 1 --------------\n\n");
		System.out.print("\n ---------------------------------Graphique------------------- 2 ---------------\n");
		int i=myInput.nextInt();
				if(i==1)
				{Tache t=null;boolean b=true;
					while(b)
					{
						System.out.print("\n -----------------------------------------------------------------------------\n\n");
						System.out.print("\n ---------------------------------Home------------------------- 1 ---------------\n");
						System.out.print("\n ----------------------------Saisir tache---------------------- 2 ---------------\n");
						System.out.print("\n ---------------------AfficherCheminCritiqueText--------------- 3 ---------------\n");
						System.out.print("\n ---------------------------------Exit------------------------- 4 ---------------\n");
						System.out.print("\n\n -----------------------------------------------------------------------------\n");
						System.out.print("\n\n Saisi un numero entre 1 et 4 : \n");
						int k=myInput.nextInt();
						switch (k) {
						case 1: {break;}
						case 2:{
							t=new Tache();
							t.saisir();
							break;
						}
						case 3:
						{
							if(t!=null)t.AfficherCheminCritiqueConsole();
							break;
						}
						case 4:
							{b=false;
								break;}
						default:
							System.out.println("num entre 1 et 4");
						}
					}
				}
				else
				{
					MainFraim frame = new MainFraim();
					frame.setVisible(true);
				}

	}

}
