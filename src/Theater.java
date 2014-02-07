/**
 * A class to represent the theater
 * 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Theater {

    private int screenNum;
    private String screenLet;
    private int capacity;
    private int current;

    /**
     * Constructor for Theater
     * @param screenLet
     * String
     * @param screenNum
     * int
     * @param capacity
     * int
     */
    public Theater(String screenLet, int screenNum, int capacity) {
        this.screenLet = screenLet;
        this.screenNum = screenNum;
        this.capacity = capacity;
        this.current = 0;
    }

    /**
     * Returns screenNum
     * @return int
     */
    public int getNum() {
        return this.screenNum;
    }

    /**
     * Returns capacity
     * @return int
     */
    public int getCap() {
        return this.capacity;
    }

    /**
     * Returns screenLet
     * @return String
     */
    public String getLet() {
        return this.screenLet;
    }
    /**
     * Returns capacity of theater
     * @return int
     */
    public int getCur() {
        return this.current;
    }

}
