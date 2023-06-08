import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Nennen Sie ihren Namen!");
        String name = sc.next();
        croupier = new Croupier();
        spieler = new Spieler(name);
        punkteCroupier = 0;
        punkteSpieler = 0;
        aktuellerSpieler = spieler;
    }

    /* Methoden */
    /** 
     * Diese Methode setzt den Attributwert von punkteCroupier 
     * auf den Wert aus pPunkteCroupier
     * @param pPunkteCroupier
     * @author xenia und lucie
     */
    public void setzePunkteCroupier(int  pPunkteCroupier)
    {
        this.punkteCroupier = pPunkteCroupier;

    }

    /**
     * Diese Methode liefert den aktuellen Spieler als Objekt 
     * @return liefert aktuellerSpieler 
     * @author mia und marike
     */
    public Person gibAktuellerSpieler()
    {
        return this.aktuellerSpieler;
    }

    /** 
     * Diese Methode setzt das Attribut aktuellerSpieler auf den 
     * übergebenen Wert aus pAktuellerSpieler
     * @param pAktuellerSpieler 
     * @author lisa znd leonie
     */
    public void setzeAktuellerSpieler(Person  pAktuellerSpieler)
    { 
        this.aktuellerSpieler = pAktuellerSpieler;

    }

    /**
     * Diese Methode druckt den aktuellen Punktestand auf der Konsole
     * @author Mika
     * 
     */
    public void druckePunktestand()
    {
        System.out.println("-----------------Punktestand nach Spielen-----------------");
        System.out.println("Spieler \t "+punkteSpieler+" : "+punkteCroupier+" \t\t Croupier");
        System.out.println("-----------------Punktestand nach Wertung-----------------");        
        System.out.println("Spieler \t "+punkteSpieler+" : "+punkteCroupier+" \t\t Croupier");
        System.out.println("---------------------------------------------");
    }

    /**
     * Diese Methode wechselt den aktuellen Spieler auf der 
     * Grundlage der Belegung des Attributes aktuellerSpieler
     * @author Melvin und Finn(halb)
     */
    public void spielerWechseln()
    {
        if(aktuellerSpieler == spieler)
        {
            aktuellerSpieler = croupier;
        } 
        else
        {
            aktuellerSpieler = spieler;
        }
    }

    /**
     * Diese Methode gibt den Gesamtsieger als Objekt zurück                 
     * @return Person die gewonnen hat
     * @author Leander und Levin
     */
    public Person ermittleGesamtsieger()
    {
        if(punkteCroupier < punkteSpieler && punkteSpieler >= 3)
        {
            return spieler;
        }
        if(punkteSpieler < punkteCroupier && punkteCroupier >= 3)
        {
            return croupier;
        }
        return null;
    }

    /**
     * Diese Methode gibt den Rundensieger als Objekt zurück
     * @return Person die die Runde gewonnen hat
     */
    public Person ermittleRundensieger()
    {
        if(spieler.gibAktErgebnis() <= 21)
        {
            if(spieler.gibAktErgebnis() > croupier.gibAktErgebnis())
            {
                return spieler;
            }
        }
        return croupier;
    }


    /**
     * Diese Methode startet ein neues Spiel. In dieser Methode ist die 
     * Spiellogik implementiert.
     */

    public  void starteSpiel()
    { 
        System.out.println("\f");
        setzeAktuellerSpieler(spieler);
        while(ermittleGesamtsieger() == null)
        {
            starteRunde();
            druckePunktestand();
        }
        spielBeenden();
    }

    /**
     * Diese Methode startet eine Runde innerhalb eines Spiels
     */
    public void starteRunde()
    {
        System.out.println("\f");
        gibAktuellerSpieler().spielen();
        spielerWechseln();
        gibAktuellerSpieler().spielen();
        
        if(ermittleRundensieger() == spieler)
        {
            System.out.println("Herzlichen Glückwunsch "+spieler.gibName()+"! Sie haben die Runde gewonnen!" );
            setzePunkteSpieler(punkteSpieler+1);
        }
        else
        {
            System.out.println("Herzlichen Glückwunsch Croupier! Die Bank hat die Runde gewonnen!" );
            setzePunkteCroupier(punkteCroupier+1);
        }
    }

    /**
     * Diese Methode beendet das Spiel und gibt auf der
     * Konsole ein Grußwort aus!
     */
    public void spielBeenden()
    { 
        System.out.println("\f");
        druckePunktestand();
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

