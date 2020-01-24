
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
    	
    	//Exercici 1
    	 
    	//Cesar();
    	
    	//Exercici 2
    	/*
    	Scanner sc = new Scanner(System.in);
    	String sig;
    	do {
    		
	        ProgramaPrincipal();
	        System.out.println("Vols continuar?(S/N)");
	        
	        sig = sc.nextLine().trim().toUpperCase();
	        
    	}while(sig.equals("S"));
    	sc.close();
    	*/
    	
    	
    	
    }
    
    public static void Cesar(){

        Xifrador n1 = new XifraCesar();
        Scanner sc = new Scanner(System.in);
        String frase;
        final int NUM = 1;
        int resp = 0;
        System.out.println("Entra el text:");

        frase = sc.nextLine().trim();

        // Aqui es realitza el xifrat.
        frase = n1.xifrar(frase);
        System.out.println("El text xifrat es " + frase);
        
        do
        {
            System.out.println("Per desxifrar polsa 1");
            
            try {
            	
                resp = Integer.valueOf(sc.nextLine());
                
            }catch (NumberFormatException e){
            	
                System.out.println("t'has equivocat.");
                
            }
        } while (resp != NUM);

        // Aqui es realitza el desxifrat.
        frase = n1.desxifrar(frase);

        System.out.println("El text pla es '" + frase + "'");
        

    }
    
    public static void VigenereClassic(){
    	
        Scanner sc = new Scanner(System.in);
        int eleccio2=0;
        String frase, clau;
        Xifrador n2 = new XifraVigenere();

        System.out.println("Entra el text:");
        frase = sc.nextLine().trim();
        
        System.out.println("Entra la clau:");
        clau = sc.nextLine().trim();

        // Aqui es realitza el xifrat.
        frase = n2.xifrar(frase,clau);
        System.out.println("El text xifrat es " + frase);

        do
        {
            System.out.println("Per desxifrar(clau:"+clau+") polsa 1");
            
            try {
            	
                eleccio2 = Integer.valueOf(sc.nextLine());
                if(eleccio2!=1) throw new NumberFormatException();
                
            }catch (NumberFormatException e){
            	
                System.out.println("t'has equivocat.");
                
            }
            
        } while (eleccio2 != 1);
        
        // Aqui es realitza el desxifrat.
        frase = n2.desxifrar(frase,clau);
        System.out.println("El text pla es '" + frase + "'");
        

    }
    
    public static void VigenereAvancat(){

        Scanner sc = new Scanner(System.in);
        int eleccio2=0;
        String frase, clau;
        Xifrador n2 = new XifraVigenereAdvanced();

        System.out.println("Entra el text:");
        frase = sc.nextLine().trim();
        
        System.out.println("Entra la clau:");
        clau = sc.nextLine().trim();

        frase = n2.xifrar(frase,clau);
        System.out.println("El text xifrat es " + frase);

        do
        {
        	
            System.out.println("Per desxifrar (clau:"+clau+") polsa 1");
            
            try {
            	
                eleccio2 = Integer.valueOf(sc.nextLine());
                if(eleccio2!=1) throw new NumberFormatException();
                
            }catch (NumberFormatException e){
            	
                System.out.println("t'has equivocat.");
                
            }
            
        } while (eleccio2 != 1);
        
        // Aqui es realitza el desxifrat.
        frase = n2.desxifrar(frase,clau);
        System.out.println("El text pla es '" + frase + "'");
        
    }
    
    public static void ProgramaPrincipal(){
    	
        Scanner sc = new Scanner(System.in);
        String eleccio;

        do{
        	
            System.out.println("En quin metode de xifrat vols treballar:");
            System.out.println("1. Cèsar");
            System.out.println("2. Vigenère Clàssic");
            System.out.println("3. Vigenère Avançat");
            System.out.println("4. Tancar Programa");
            eleccio = sc.next().trim();
            
            switch(Integer.parseInt(eleccio)){
	            case 1:
	                Cesar();
	                break;
	            case 2:
	                VigenereClassic();
	                break;
	            case 3:
	                VigenereAvancat();
	                break;
	            case 4:
	            	System.out.println("Adeu");
	            	System.exit(0);
	            	break;
	            default:
	            	System.out.println("Opció Incorrecta");
	            	break;
            }

        }while(!eleccio.equals("1") && !eleccio.equals("2") && !eleccio.equals("3"));

    }
}
