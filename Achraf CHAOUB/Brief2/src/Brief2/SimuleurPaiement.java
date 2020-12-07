package Brief2;
import java.util.Scanner;

public class SimuleurPaiement {

	// fonction pour calculer le salaire Extra c'est d'ajouter le demi salaire des heures supp car les heures sup sont deja calculées.
	public static double tarifExtra(int heure,double tarif) {
		return (heure * tarif)/2;
	}
	// fonction pour calculer le salaire Ordinaire 	
	public static double tarifOridinaire(int heure,double tarif) {
		return heure * tarif;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int heure = 0;
		double tarif = 0;
		String nom;
		String prenom;
		double salaire = 0;
			
		Scanner  inputTarif = null;
		Scanner  inputHeure =null;
		Scanner  inputPrenom =null;
		Scanner  inputNom =null;
		
			
		try {
				
			inputTarif  = new Scanner(System.in);
			inputHeure = new Scanner(System.in);
			inputPrenom = new Scanner(System.in);
			inputNom = new Scanner(System.in);
				
			int DiffHeure;
				
			System.out.println("--------------------Calculez votre indemnisation-------------------- ");
				
			System.out.print("Entrez votre nom : \t");
			nom = inputNom.nextLine().toUpperCase();
				
			System.out.print("Entrez votre prenom : \t");
			prenom = inputPrenom.nextLine();
				
			System.out.println(" \n \t \t Bienvenue " + nom +"\n");
				
				
			System.out.println("Combien des heures avez vous travailler cette semaine ?");
			heure = inputHeure.nextInt();
				
				
			//condition l'heure doit etre dans l'intervalle [1,60[ 
			if((heure <60) && (heure>=1)){
				//demander à l'utilisateur de saisir le tarif 
				System.out.println("Entrez le tarif :");
				tarif = inputTarif.nextDouble();
					
				/* Condition des heures supp*/
				if(heure>40) {
						
					DiffHeure =  heure - 40;
					salaire = tarifOridinaire(heure, tarif)+tarifExtra(DiffHeure, tarif);
						
				}
				else { // le cas des heures oridinaires (-40h)
					salaire = tarifOridinaire(heure, tarif);
				}
				System.out.println("votre indemnisation est de "+salaire+ " MAD");
					
			}else // le cas d'un nombre des heures supperieur a 60 ou bien inferieur a 1
				System.out.println("informations erronés ! ");
				
			}
			// la clause finally pour vider la memoire et aussi pour les fermer les inputs Scanner
			finally {
			    if((inputHeure!=null)||(inputTarif!=null)||(inputPrenom!=null)||(inputNom!=null)) {
			    	inputHeure.close();
			    	inputTarif.close();
			    	inputNom.close();
			    	inputPrenom.close();
			    }
			}
		}
}
	
