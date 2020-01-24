
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class XifraVigenereAdvanced extends XifraVigenere {

    @Override
    protected char[][] matriuVigenere(char[][] mV){
        Character[] abecedari = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        List<Character> abcrand = Arrays.asList(abecedari);
        Collections.shuffle(abcrand);
        System.out.println("TAULA VIGENERE AVANÇADA");

        // En aquest cas per que sigui aleatori el que faig es desordenar l'array abecedari per a que es col·loquin de manera distinta a l'hora
        // de realitzar el bucle.
        // La resta del programa funciona igual que la funció original creada a la clase XifraVigenere, trobarás més informació de la mateixa al
        // metode matriuVigenere de la clase anteriorment mencionada
        mV = new char [abcrand.size()][];

        for(int r = 0; r < abcrand.size(); r++)
        {
            mV[r] = new char[abcrand.size()];

            for(int c = 0; c < abcrand.size(); c++)
            {
                if((r+c)>=abcrand.size()) mV[r][c] = abcrand.get(r+c-abcrand.size());
                else mV[r][c] = abcrand.get(r+c);
                System.out.printf(String.valueOf("|"+mV[r][c]));
            }
            System.out.println("||");
        }
        return mV;
    }
}