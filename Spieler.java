import java.util.Scanner;
/**
 * Die Klasse Spieler erweitert die Klasse Person und beschreibt, wie der Spieler das Spiel spielt.
 */
public class Spieler extends Person 
{
    /*Konstruktor*/
    private String name;

    public Spieler(String name)
    {
        this.name = name;
    }
    /* Methoden */
    /**
     * Diese Methode gibt zunächst eine entscheidungsfrage auf der 
     * Konsole aus und gibt anschließend die Benutzereingabe zurück
     * @return entscheidung
     */
    public boolean entscheide(){
        if(gibAktErgebnis() < 21)
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Möchtest du weiterspielen? // j = Ja und n = Nein");
            String eingabe = s.next();
            if(eingabe=="j")
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * Diese Methode gibt den Namen des Spielers zurück
     * @return name
     */
    public String gibName()
    {
        return this.name;
    }

    /**
     * Diese Methode überschreibt die abstrakte Methode spielen() in dern Klasse Person. Sie
     * legt fest, wie der Spieler bei seinem Zug spielt.
     */
    public void spielen()
    {

    }
}//Ende Klasse: Spieler

