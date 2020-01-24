import java.text.Normalizer;

public class XifraVigenere extends Xifrador{
    char[][] mV;
    public XifraVigenere(){
        mV = this.matriuVigenere(mV);
    };
    @Override
	public String xifrar(String frase, String clau){
        String fraseclau = "";
        String fraseXifrada = "";
        int cclau = 0;
        boolean lowercase = false;
        
        
        
        try {
        	//Elimina els accents.
            frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
            frase = frase.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        	
            // En cas de que la clau contigui espais, fa que et llençi una excepció i no puguis continuar.
            if(!clau.matches("\\S+")) throw new Exception("Error: No hi pot haber espais a la clau");
            // Aquest bucle s'encarrega de generar un altre String que s'adapti a la llargada de la frase que vols xifrar amb la clau seleccionada
            // EXEMPLE FRASE:HOLAQUETAL CLAU:PROBA FRASECLAU: PROBAPROBA
            for (int i = 0; i < frase.length(); i++) {
            	
                if (frase.charAt(i) == ' ') {
                    fraseclau += " ";
                    continue;
                }else if(!Character.isLetter(clau.charAt(cclau))) throw new Exception("Error: La clau només pot contenir lletres alfabetiques");
                
                fraseclau += String.valueOf(clau.charAt(cclau)).toUpperCase();
                cclau++;
                
                if (cclau >= clau.length()) cclau = 0;

            }
            // Aquest bucle s'encarregar de xifrar el missatge a partir de la frase i de la fraseclau(Generada al bucle anterior)

            for (int i = 0; i < fraseclau.length(); i++) {
                // En cas de contenir espais, ignora aquest espais i els deixa dins la frase sense xifrar.
                // Si també conté caracters que no son de l'abecedari, també els ignora.
                // EXEMPLE: FRASEPERXIFRAR: HOLA@ QUETAL FRASEXIFRADA(clau:HACKER): OONK@ HBEVKP
            	
                if (fraseclau.charAt(i) == ' ') {
                	
                    fraseXifrada += " ";
                    continue;
                    
                }else if (!Character.isLetter(frase.charAt(i))){
                	
                    fraseXifrada += frase.charAt(i);
                    continue;
                    
                }
                
                // Aquest bucle primer ananitza la primera columna de la matriu bidimensional, i quan té la posició de la lletra(Fraseperxifrar)
                // entra al segon bucle, on s'analitza en quina fila es localitza la posició de la lletra(fraseclau) per fer la xifració
                // quan es té la posició de les dues s'agafa la lletra que es troba en la columna i fila seleccionada. aquesta lletra s'afegeix a
                // l'string que conté la frase totalmente xifrada.
                
                for (int fil = 0; fil < mV.length; fil++) {
                	
                    // En cas de que la paraula estigui en Minuscules, les transforma en majuscules(linea 46) per xifrarles i despres les torna a fer minuscules
                    // EXEMPLE: FRASEPERXIFRAR: Hola QueTal FRASEXIFRADA(clau:HACKER): Oonk HbeVkp
                	
                    if(Character.isLowerCase(frase.charAt(i))) lowercase = true;
                    else lowercase = false;
                    
                    if (mV[fil][0] == Character.toUpperCase(frase.charAt(i))) {

                        for (int col = 0; col < mV[fil].length; col++) {

                            if (mV[0][col] == fraseclau.charAt(i)) {

                                if(lowercase) fraseXifrada += String.valueOf(mV[fil][col]).toLowerCase();
                                else fraseXifrada += String.valueOf(mV[fil][col]);
                            }

                        }

                    }

                }

            }
            
        }catch (Exception e){
        	
            System.out.println(e.getMessage());
            System.exit(1);
            
        }
        finally {
        	
        	System.out.println("Frase Clau: "+fraseclau);
            // Finalment et retorna la frase xifrada
            return fraseXifrada;
            
        }
    }
    
    @Override
	public String desxifrar(String frase, String clau){
        String fraseclau = "";
        String frasedesXifrada = "";
        int cclau = 0;
        boolean lowercase = false;
        // El codi de desxifrar es molt similar al de xifrar amb algunes diferencies amb algunes diferencies que et destacaré
        // a continuació.
        try {
            if(!clau.matches("\\S+")) throw new Exception("Error: No hi pot haber espais a la clau");

            // Segueix la mateixa metodologia que el metode xifrar
            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) == ' ') {
                    fraseclau += " ";
                    continue;
                }
                if(!Character.isLetter(clau.charAt(cclau))) throw new Exception("Error: La clau només pot contenir lletres alfabetiques");
                fraseclau += String.valueOf(clau.charAt(cclau)).toUpperCase();
                cclau++;
                if (cclau >= clau.length()) cclau = 0;

            }
            // En aquest cas, analitza la primera matriu buscant la lletra de la fraseclau, despres analitza la segona matriu per localitzar
            // la posició on es troba la lletra encriptada, i amb les dues obté la lletra de la primera columna, que sería la lletra desencriptada
            // La resta del bucle treballa amb la mateixa metodologia que en el metode xifrar
            for (int i = 0; i < fraseclau.length(); i++) {
                if (fraseclau.charAt(i) == ' ') {
                    frasedesXifrada += " ";
                    continue;
                }else if (!Character.isLetter(frase.charAt(i))){
                    frasedesXifrada += frase.charAt(i);
                    continue;
                }
                for (int fil = 0; fil < mV.length; fil++) {
                    if(Character.isLowerCase(frase.charAt(i))) lowercase = true;
                    else lowercase = false;

                    if (mV[fil][0] == fraseclau.charAt(i)) {

                        for (int col = 0; col < mV[fil].length; col++) {

                            if (mV[fil][col] == Character.toUpperCase(frase.charAt(i))){
                            	
                                if(lowercase) frasedesXifrada += String.valueOf(mV[0][col]).toLowerCase();
                                else frasedesXifrada += String.valueOf(mV[0][col]);
                                
                            }

                        }

                    }

                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            // Finalment et retorna la frase desxifrada
            return frasedesXifrada;
        }
    }

    protected char[][] matriuVigenere(char[][] mV){

        //Aquest metode agafa l'array 'abecedari' i s'encarrega de posicionar cada paraula al lloc on l'hi correspón dins d'una nova matriu bidimensional denominada mV

        char [] abecedari = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        System.out.println("TAULA VIGENERE");
        mV = new char [abecedari.length][];
        for(int r = 0; r < abecedari.length; r++)
        {
            mV[r] = new char[abecedari.length];

            for(int c = 0; c < abecedari.length; c++)
            {
                // Si la suma de r i c es més gran que la mida de l'array abecedari, li resta la llargada de abecedari per a que no es surti del index maxim que té l'array abecedari.
                if((r+c)>=abecedari.length) mV[r][c] = abecedari[r+c-abecedari.length];
                else mV[r][c] = abecedari[r+c];
                System.out.printf(String.valueOf("|"+mV[r][c]));
            }
            System.out.println("||");
        }
        return mV;
    }
}