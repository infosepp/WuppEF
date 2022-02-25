/**
 * Die Klasse Croupier erweitert die Klasse Person und beschreibt, wie der Croupier das Spiel spielt.
 */
public class Croupier extends Person 
{
    /*Konstruktor*/
    public Croupier()
    {
        
    }

    /*Methoden*/
    /**
     * 
     */
    public void spielen()
    {
        while(gibAktErgebnis()<17)
        {
           wuerfel.wuerfeln();
           int erg = wuerfel.gibAktWert();
           setzeAktErgebnis(addiere(erg, gibAktErgebnis()));
        }
    }
}//Ende Klasse: Croupier

