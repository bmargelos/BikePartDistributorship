//creating a BikePart class

//import org.jetbrains.annotations.NotNull;

/**
 * This class stores information about a bike part
 * @author Brittany Margelos
 * @author BenjaminHichak
 * @author LuisMaldonado
 */

class BikePart {
    public String partName;
   public String partNumber;
   public double price, salesPrice;
   public boolean onSale;
   public int quantity;

    /**
     * This constructs a bike part that has a specified a part name, a part number,
     * the price, the sale price, whether the bike part is on sale, and it's quantity.
     * A string array called "temp" that when the info is passed through, it will split at the ",".
     * Each current object of the info constructor will be saved into a specific index of temp array
     * @param info stores all the biker part info
     *
     */

    public BikePart(String info) {
        String[] temp = info.split(",");
        this.partName = temp[0];
        this.partNumber = temp[1];
        this.price = Double.parseDouble(temp[2]);
        this.salesPrice = Double.parseDouble(temp[3]);
        if (onSale = temp[4].equals("true")){
            onSale=true;
        }
        else{
            onSale=false;
        }
        this.quantity = Integer.parseInt(temp[5]);
    }//end of BikePart constructor

    /**
     *To set a part name to bike part
     * @param partName a new bike part name
     */
    public void setName(String partName){
        this.partName=partName;
    }//end of setting partName

    /**
     * To set a part number to bike part
     * @param partNumber a new bike part number
     */
    public void setPartNum(String partNumber){

        this.partNumber=partNumber;
    }//end of setting partNumber

    /**
     * To set a price to bike part
     * @param price a new bike part price
     */
    public void setPrice(double price){

        this.price=price;
    }//end of setting price

    /**
     * To set a sales price to bike part
     * @param salesPrice a new bike part sales price
     */
    public void setPricesSales(double salesPrice){

        this.salesPrice=salesPrice;
    }//end of setting salesPrice

    /**
     * To set if bike part is on sale
     * @param onSale a new bike part that is on sale
     */
    public void setOnSale(boolean onSale){
        this.onSale=onSale;
    }//end of onSale


    /**
     * Sets the quantity of a bike part
     * @param quantity a new bike part quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }// end of set quantity

    /**
     *get bike part name
     * @return part name
     */
    public String getName(){
        return this.partName;
    }//end of GetName

    /**
     *get bike part number
     * @return part number
     */
    public String getPartNumber(){
        return this.partNumber;
    }//end of GetPartNumber

    /**
     *get bike part price
     * @return price
     */
    public double getPrice(){
        return this.price;
    }//end of GetPrice

    /**
     *get bike part sale price
     * @return sale price
     */
    public double getSalesPrice(){
        return this.salesPrice;
    }//end of GetPrice

    /**
     *get bike part on sale
     * @return true or false depending if bike part is on the sale
     */
    public boolean getOnSale() {
        return this.onSale;
    }// end of getOnSale

    /**
     * get bike part Quantity
     * @return quantity
     */
    public int getQuantity(){
        return this.quantity;
    }// end of getQuantity

}//end of BikePart class
