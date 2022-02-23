import java.util.Random;
/**
 * Die Klasse Würfel stellt mit ihren Methoden einen sechsseitigen Würfel dar.
 */
public class Wuerfel 
{
    /* Attribute */
    private int aktWert;
    /*Konstruktor*/
    public Wuerfel()
    {
    }
    /* Methoden */
    /** 
     * Diese Methode liefert den aktuellen Wert von aktWert
     * @return liefert aktWert 
     */
    public int gibAktWert(){
        
    }

    /**  
     * Diese Methode wuerfelt eine neue Zahl zwischen 1 und 6 und weißt sie dem aktWert zu.
     */
    public void wuerfeln()
    {
        
    }

    /**
     * Diese Methode gibt eine Zufallszahl zwischen 1 und 6 zurück
     */
    public int erzeugeZufallszahl()
    {
        Random r = new Random();
        return r.nextInt(6)+1;
    }

    /**
     * Diese Methode setzt den aktWert auf den Parameterwert aus wert
     */
    private void setzeAktWert(int  wert)
    {
        
    }

}//Ende Klasse: Wuerfel

