/**
 * A class to represent the price 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Price {

    private String type;
    private int typeNum;
    private int cost;
    /**
     * Constructor for Price
     * @param type
     * String
     * @param typeNum
     * int
     * @param cost
     * int
     */
    public Price(String type, int typeNum, int cost) {
        this.type = type;
        this.typeNum = typeNum;
        this.cost = cost;
    }

    /**
     * Returns the price
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Returns cost
     * @return int
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Returns Type Num
     * @return int
     */
    public int getTypeNum() {
        return this.typeNum;
    }
}
