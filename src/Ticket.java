/**
 * A class to represent the ticket purchase
 * 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Ticket {

    private int movie;
    private int theater;
    private int time;
    private int adult;
    private int child;
    private int senior;
    private int total;

    /**
     * Constructor for Ticket
     * 
     * @param movie
     *            int
     * @param theater
     *            int
     * @param time
     *            int
     * @param adult
     *            int
     * @param child
     *            int
     * @param senior
     *            int
     * @param total
     *            int
     */
    public Ticket(int movie, int theater, int time, int adult, int child,
            int senior, int total) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
        this.adult = adult;
        this.child = child;
        this.senior = senior;
        this.total = total;
    }
    /**
     * Ticket blank for manager
     * @param m
     * Movie
     * @param t
     * Theater
     * @param time
     * int
     * @param r
     * int
     * @return Ticket
     */
    public static Ticket manager(Movie m, Theater t, int time, int r) {
        return new Ticket(m.getNum(), t.getNum(), time, 0, 0, 0, r);
    }
    /**
     * Compare semi equality of tickets
     * @param t
     * Ticket
     * @return boolean
     */
    public boolean ticketComp(Ticket t) {
        return (this.movie == t.movie) &&
                (this.theater == t.theater) &&
                (this.time == t.time);
    }

    /**
     * Returns total
     * 
     * @return int
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * Sets total
     * 
     * @param t
     *            int
     */
    public void setTotal(int t) {
        total = t;

    }

    /**
     * Returns theater num
     * 
     * @return int
     */
    public int getThea() {
        return this.theater;
    }

    /**
     * Returns adult
     * 
     * @return int
     */
    public int getA() {
        return this.adult;
    }
    /**
     * Sets adult 
     * @param i
     * int
     */
    public void setA(int i) {
        this.adult = i;
    }

    /**
     * Returns child
     * 
     * @return int
     */
    public int getC() {
        return this.child;
    }
    /**
     * Sets child
     * @param i
     * int
     */
    public void setC(int i) {
        this.child = i;
    }

    /**
     * Returns senior
     * 
     * @return int
     */
    public int getS() {
        return this.senior;
    }
    /**
     * Sets senior
     * @param i
     * int
     */
    public void setS(int i) {
        this.senior = i;
    }
    /**
     * Returns movie num
     * @return int
     */
    public int getMov() {
        return this.movie;
    }
    /**
     * Returns time
     * @return int
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Returns string rep of ticket
     * 
     * @return String
     */
    public String toString() {
        return "" + movie + "," + theater + "," + time + "," + adult + ","
                + child + "," + senior + "," + total;
    }
    /**
     * Dumb toString for manager
     * @param mT
     * String
     * @param tT
     * String
     * @return String
     */
    public String manString(String mT, String tT) {
        return "" + mT + "," + tT + "," + time + "," + total + "," + adult + ","
                + child + "," + senior;
    }
}
