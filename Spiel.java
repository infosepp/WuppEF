/**
 * Die Klasse Spiel beschreibt die übergeordnete Logik des Wupp-Spiels.
 */
public class Spiel 
{
    /* Attribute */
    private Person aktuellerSpieler; // Spieler der im Moment an der Reihe ist.
    private Croupier croupier; 
    private int punkteSpieler;
    private Spieler spieler;
    private int punkteCroupier;

    /*Konstruktor*/
    public Spiel()
    {
        croupier = new Croupier();
        spieler = new Spieler();
        punkteCroupier = 0;
        punkteSpieler = 0;
        aktuellerSpieler = spieler;
    }

    /* Methoden */
    /** 
     * Diese Methode setzt den Attributwert von punkteCroupier 
     * auf den Wert aus pPunkteCroupier
     * @param pPunkteCroupier
     */
    public void setzePunkteCroupier(int  pPunkteCroupier)
    {
        punkteCroupier = pPunkteCroupier;
    }

    /**
     * Diese Methode liefert den aktuellen Spieler als Objekt 
     * @return liefert aktuellerSpieler 
     */
    public Person gibAktuellerSpieler()
    {
        return aktuellerSpieler;
    }

    /** 
     * Diese Methode setzt das Attribut aktuellerSpieler auf den 
     * übergebenen Wert aus pAktuellerSpieler
     * @param pAktuellerSpieler
     */
    public void setzeAktuellerSpieler(Person  pAktuellerSpieler)
    { 
        aktuellerSpieler = pAktuellerSpieler;
    }

    /**
     * Diese Methode druckt den aktuellen Punktestand auf der Konsole
     */
    public void druckePunktestand()
    {
        System.out.println("Punkte Croupier: "+gibPunkteCroupier()+" - Punkte Spieler:" +gibPunkteSpieler());
    }

    /**
     * Diese Methode wechselt den aktuellen Spieler auf der 
     * Grundlage der Belegung des Attributes aktuellerSpieler
     */
    public void spielerWechseln()
    {
        if(gibAktuellerSpieler().equals(croupier))
        {
            setzeAktuellerSpieler(spieler); 
        }
        else
        {
            setzeAktuellerSpieler(croupier);
        }

    }

    /**
     * Diese Methode gibt den Gesamtsieger als Objekt zurück                 
     * @return Person die gewonnen hat
     */
    public Person ermittleGesamtsieger()
    {
        if (gibPunkteSpieler()== 3)
        {
            return spieler;
        }
        if (gibPunkteCroupier()== 3)
        {
            return croupier;
        }
        druckePunktestand();
        return null;
    }

    /**
     * Diese Methode gibt den Rundensieger als Objekt zurück
     * @return Person die die Runde gewonnen hat
     */
    public Person ermittleRundensieger()
    {
       System.out.println(spieler.gibAktErgebnis()+":"+croupier.gibAktErgebnis());
        if(spieler.gibAktErgebnis() < 21 && croupier.gibAktErgebnis()>21 || spieler.gibAktErgebnis() > croupier.gibAktErgebnis())
       { 
           return spieler;
       }else{
           return croupier;
       }
       
    }
    
    

    /**
     * Diese Methode startet ein neues Spiel. In dieser Methode ist die 
     * Spiellogik implementiert.
     */

    public void starteSpiel()
    { 
        while(ermittleGesamtsieger() == null)
        {
            System.out.println("Nächste Runde");
            starteRunde();
            if(ermittleRundensieger().equals(spieler))
            {
                setzePunkteSpieler(gibPunkteSpieler()+1);
            }
            else
            {
                setzePunkteCroupier(gibPunkteCroupier()+1);
            }
            druckePunktestand();
        }
    }

    /**
     * Diese Methode startet eine Runde innerhalb eines Spiels
     */
    public void starteRunde()
    {
        spieler.spielen();
        spielerWechseln();
        croupier.spielen();
    }

    /**
     * Diese Methode beendet das Spiel und gibt auf der
     * Konsole ein Grußwort aus!
     */

    public void spielBeenden()
    { 
        System.out.println("Das Spiel wurde beendet, bis zum nächsten Mal!"); 
        if(ermittleGesamtsieger().equals(spieler))
        {
            druckePunktestand();
            System.out.println("Herzlichen Glückwunsh an den Spieler!");
        }
        else
        {
            druckePunktestand();
            System.out.println("Herzlichen Glückwunsh an die Bank!");
        }
    }

    /** 
     * Diese Methode liefert die Punkte des Spielers
     *@return liefert punkteSpieler 
     */
    public int gibPunkteSpieler()
    {
        return this.punkteSpieler;
    }

    /** 
     * Diese Methode setzt den Wert von punkteSpieler auf den
     * übergebenen Wert von pPunkteSpieler
     * @param pPunkteSpieler
     */
    public void setzePunkteSpieler(int  pPunkteSpieler)
    {
        this.punkteSpieler = pPunkteSpieler;
    }

    /**
     * Diese Methode gibt den Wert aus punkteCroupier aus 
     * @return liefert punkteCroupier 
     */
    public int gibPunkteCroupier()
    {
        return this.punkteCroupier;
    }

}//Ende Klasse: Spiel

