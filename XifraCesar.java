import java.text.Normalizer;

public class XifraCesar extends Xifrador{
    private final int NXIF = 3;
    private final int NABC = 26;
    
    public XifraCesar() { }

    @Override
    public String xifrar(String frase)
    {
    	String frasexifrada ="";
        try
        {
            //Elimina els accents del String
        	frase = Normalizer.normalize(frase, Normalizer.Form.NFD);
            frase = frase.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            
            // bucle foreach que analitza cada lletra del String frase
            for (char letra: frase.toCharArray())
            {
                // Comproba en el vocabulari ASCII que siguin paraules
                // En cas negatiu, no xifra la lletra en questió
                // EXEMPLE: FRASEPERXIFRAR: ABcDe@ FRASEXIFRADA: XYzAb@
                if (letra >= 65 && letra <= 90)
                {
                    // En cas de que es surti del rang estipulat (65-90) l'hi suma el numero total de paraules al abecedari (26)
                    if (letra <= 67) frasexifrada += (char)(letra + NABC - NXIF);
                    else frasexifrada += (char)(letra - NXIF);
                }
                else if (letra >= 97 && letra <= 122)
                {
                    // En cas de que es surti del rang estipulat (97-122) l'hi suma el numero total de paraules al abecedari (26)
                    if (letra <= 99) frasexifrada += (char)(letra + NABC - NXIF);
                    else frasexifrada += (char)(letra - NXIF);
                }
                else frasexifrada += letra;
            }
            return frasexifrada;
        }catch(Exception e)
        {
            // En cas de que es produeixi un error amb el programa, et retorna la frase sense xifrar.
            System.out.println("No se ha podido cifrar");
            return frase;
        }
    }
    @Override
    public String desxifrar(String frase)
    {
        try
        {
            String frasedesxifrada = "";
            for (char letra: frase.toCharArray())
            {
                // Aquest programa segueix la mateixa metodologia que el metode xifrar pero variant un par de coses
                // que et mencionaré a continuació.
                if (letra >= 65 && letra <= 90)
                {
                    // En cas de que es surti del rang estipulat (65-90) l'hi resta el numero total de paraules al abecedari (26)
                    if (letra >= 88) frasedesxifrada += (char)(letra - NABC + NXIF);
                    else frasedesxifrada += (char)(letra + NXIF);
                }
                else if (letra >= 97 && letra <= 122)
                {
                    // En cas de que es surti del rang estipulat (97-122) l'hi resta el numero total de paraules al abecedari (26)
                    if (letra >= 120) frasedesxifrada += (char)(letra - NABC + NXIF);
                    else frasedesxifrada += (char)(letra + NXIF);
                }
                else frasedesxifrada += letra;
            }
            return frasedesxifrada;
        }
        catch (Exception e)
        {
            // En cas de que es produeixi un error amb el programa, et retorna la frase sense xifrar.
            System.out.println("No se ha podido descifrar");
            return frase;
        }
    }

}
