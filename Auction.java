import java.util.ArrayList;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    public void close()
    {
        for(Lot lot : lots) {
            if (lot.getHighestBid() == null){
                System.out.println("El articulo:" + lot.getDescription() + " no tiene puja.");
            }else{
                String nombre = (lot.getHighestBid().getBidder().getName());
                System.out.println("Articulo:" + lot.getDescription() + " - Pujador mas alto:" + nombre + " - Puja:" + lot.getHighestBid().getValue());
            }
        }
    }
    
    public ArrayList<Lot> getUnsoId(){
        ArrayList<Lot> lotes = new ArrayList<Lot>();
        for(Lot lot : lots) {
            if (lot.getHighestBid() == null){
                lotes.add(lot);              
            }
        }
        return lotes;
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   selectedLot.getHighestBid().getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        Lot lotes = null;
        if((lotNumber > 0) && (lotNumber < nextLotNumber)) {
            for(Lot lot : lots) {
                if (lot.getNumber() == lotNumber){
                    lotes = lot;
                }
            }
        }
        else {
            System.out.println("Lote numero: " + lotNumber + " no existe.");
        }
        return lotes;
    }
    
    /** 
    * Elimina el lote con el n�mero de lote especificado.
    * @param number El n�mero del lote que hay que eliminar,
    * @return El lote con el n�mero dado o null si no existe tal lote.
    */
    public Lot removeLot(int number){
        Lot lotes = null;
        boolean existe = false;
        if((number > 0) && (number < nextLotNumber)) {
            for(Lot lot : lots) {
                if (lot.getNumber() == number){
                    existe = true;
                    lotes = lot;
                }
            }
            if (existe == true){
                lots.remove(lotes);
            }
        }
        else {
            System.out.println("Lote numero: " + number + " no existe.");
        }
        return lotes;
    }
}
