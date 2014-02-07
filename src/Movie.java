/**
 * A class to represent the movie 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Movie {

    /**
     * Title
     */
    public String title;
    private int runTime;
    private int movNum;
    /**
     * Constructor
     * @param title
     * String
     * @param runTime
     * int
     * @param movNum
     * int
     */
    public Movie(String title, int runTime, int movNum) {
        this.title = title;
        this.runTime = runTime;
        this.movNum = movNum;
    }

    /**
     * Returns runtime
     * @return int
     */
    public int getRun() {
        return this.runTime;
    }
    /**
     * Returns movie num
     * @return int
     */
    public int getNum() {
        return this.movNum;
    }
    
}
