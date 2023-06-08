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
        while(this.gibAktErgebnis() < 19)
        {
            this.wuerfel.wuerfeln();
            this.setzeAktErgebnis(addiere(this.gibAktErgebnis(), this.wuerfel.gibAktWert()));
            System.out.println("Der Croupier hat aktuell eine "+gibAktErgebnis());
            warte();
        }
    }
}//Ende Klasse: Croupier

