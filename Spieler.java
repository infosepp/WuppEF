import java.util.Scanner;
/**
 * Die Klasse Spieler erweitert die Klasse Person und beschreibt, wie der Spieler das Spiel spielt.
 */
public class Spieler extends Person 
{
    /*Konstruktor*/
    public Spieler()
    {
    }
    /* Methoden */
    /**
     * Diese Methode gibt zunächst eine entscheidungsfrage auf der 
     * Konsole aus und gibt anschließend die Benutzereingabe zurück
     * @return entscheidung
     */
    public boolean entscheide(){
        Scanner s = new Scanner(System.in);
        System.out.println("Möchtest du weiterspielen?");
        String eingabe = s.next();
        if(eingabe=="Ja")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Diese Methode überschreibt die abstrakte Methode spielen() in dern Klasse Person. Sie
     * legt fest, wie der Spieler bei seinem Zug spielt.
     */
    public void spielen()
    {
        for(int i = 0; i < 3; i = i + 1)
        {
            wuerfel.wuerfeln();
            int ergebnis = wuerfel.gibAktWert();
            setzeAktErgebnis(addiere(ergebnis, gibAktErgebnis()));
        }
        while(entscheide() == true && gibAktErgebnis() < 21)
        {
            wuerfel.wuerfeln();
            int ergebnis = wuerfel.gibAktWert();
            setzeAktErgebnis(addiere(ergebnis, gibAktErgebnis()));
        }
    }
}//Ende Klasse: Spieler

