/**
 * A class to represent an available show
 * 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Shows {

    private Movie movie;
    private Theater theater;
    private int time;
    private int capacity;
    private int current;

    /**
     * Constructor for Show
     * @param movie
     * Movie
     * @param theater
     * Theater
     * @param time
     * int
     */
    public Shows(Movie movie, Theater theater, int time) {
        this.movie = movie;
        this.theater = theater;
        this.time = time;
        this.capacity = this.theater.getCap();
        this.current = 0;
    }

    /**
     * Returns Movie
     * @return Movie
     */
    public Movie getMov() {
        return this.movie;
    }

    /**
     * Returns Theater
     * @return Theater
     */
    public Theater getThea() {
        return this.theater;
    }

    /**
     * Returns time
     * @return int
     */
    public int getTime() {
        return this.time;
    }
    /**
     * Returns capacity
     * @return int
     */
    public int getCap() {
        return this.capacity;
    }

    /**
     * Returns current
     * @return int
     */
    public int getCur() {
        return this.current;
    }
    /**
     * Sets current
     * @param i
     * int
     */
    public void setCur(int i) {
        current = i;
    }
    
    /**
     * is Ticket of a show
     * @param t
     * Ticket
     * @return boolean
     */
    public boolean isTicket(Ticket t) {
        return (movie.getNum() == t.getMov())
                && (theater.getNum() == t.getThea()) &&
                (time == t.getTime());
    }
    /**
     * Returns whether the show has same movie and theater
     * @param s
     * Shows
     * @return boolean
     */
    public boolean isShow(Shows s) {
        return (theater.getNum() == s.getThea().getNum());
    }

    /**
     * Returns whether there is a show conflict with new show
     * @param s
     * Shows
     * @return boolean
     */
    public boolean conflict(Shows s) {
        int min = s.getTime();
        int max = s.getTime() + s.getMov().getRun();
        int start = time;
        int end = time + movie.getRun();
        return (((min >= start) && (min <= end)) || 
                ((max >= start) && (max <= end)));
        
    }
    /**
     * String for log report
     * @return String
     */
    public String conflictString() {
        String s = "The show with the movie '";
        String s1 = "' in theater '";
        String s2 = "' at the time '";
        String s3 = "' cannot be added due to another show conflict";
        return s + movie.title + s1 + theater.getLet() + s2 + getTime() + s3;
    }



}
