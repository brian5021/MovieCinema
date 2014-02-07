import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A class for the ticket sales for the movie system
 * 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class TicketSales {

    /**
     * List of available shows
     */
    public ArrayList<Shows> shows = new ArrayList<Shows>();
    /**
     * List of movies
     */
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    /**
     * List of theaters
     */
    public ArrayList<Theater> theaters = new ArrayList<Theater>();
    /**
     * List of prices
     */
    public ArrayList<Price> prices = new ArrayList<Price>();
    /**
     * List of sales
     */
    public ArrayList<Ticket> sales = new ArrayList<Ticket>();
    /**
     * Initial string
     */
    public List<String> init = new ArrayList<String>();
    /**
     * Order Strings
     */
    public List<String> orders = new ArrayList<String>();
    /**
     * List of log
     */
    public List<String> log = new ArrayList<String>();
    /**
     * Manager report string
     */
    public String manager = "";
    private boolean movie = false;
    private boolean theater = false;
    private boolean show = false;
    private boolean price = false;
    private boolean successInit = true;
    private boolean successOrders = true;
    private int report = 1;

    /**
     * Method to initialize the movie system
     * 
     * @param fileName
     *            String
     */
    void initCinema(String fileName) {

        File f = new File(fileName);
        Scanner sc;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                init.add(sc.nextLine());
            }
        } 
        catch (FileNotFoundException e) {
            successInit = false;
        }

        // init = Files.readAllLines(Paths.get(fileName),
        // StandardCharsets.UTF_8);

        for (String s : init) {
            create(s);
        }
    }

    /**
     * Method to process orders
     * 
     * @param fileName
     *            String
     */
    void processOrders(String fileName) {
        File f = new File(fileName);
        Scanner scan;
        try {
            scan = new Scanner(f);
            while (scan.hasNextLine()) {
                orders.add(scan.nextLine());
            }
        } 
        catch (FileNotFoundException e) {
            successOrders = false;
        }
        for (String s : orders) {
            if (s.equals("report")) {
                managerHelper();
            }
            else {
                order(s);
            }
        }
    }
    /**
     * Webcrap
     * @return boolean
     */
    boolean dumb() {
        return (successInit == successOrders);
    }

    /**
     * Reports Sales
     * 
     * @return String
     */
    String reportSales() {
        String out = "";
        for (Ticket t : sales) {
            out = out + t.toString() + "\n";
        }
        return out;
    }

    /**
     * Manager Report
     * 
     * @return String
     */
    String managerReport() {

        return manager;
    }

    /**
     * Log report
     * 
     * @return String
     */
    String logReport() {
        String out = "";
        for (String s : log) {
            out = out + s + "\n";
        }
        return out;
    }

    /**
     * Creates all classes from files
     * 
     * @param s
     * String
     */
    void create(String s) {
        if (s.equals("Movies")) {
            movie = true;

        } 
        else if (s.equals("Theaters")) {
            movie = false;
            theater = true;
        } 
        else if (s.equals("Shows")) {
            theater = false;
            show = true;
        } 
        else if (s.equals("Prices")) {
            show = false;
            price = true;
        } 
        else if (s.equals("End")) {
            price = false;

        }
        if (movie && !(s.equals("Movies"))) {
            addMovie(s);
        }
        if (theater && !(s.equals("Theaters"))) {
            addTheater(s);
        }
        if (show && !(s.equals("Shows"))) {
            addShow(s);
        }

        if (price && !(s.equals("Prices"))) {
            addPrice(s);
        }
    }

    /**
     * Specifically creates movie
     * 
     * @param s
     *            String
     */
    void addMovie(String s) {
        String[] h = s.split(":");
        int x = h.length;
        int run = Integer.valueOf(h[x - 1]);

        String out = "";
        for (int i = 0; i < x - 1; i++) {
            out = out + h[i];
        }
        int number = movies.size() + 1;
        Movie m = new Movie(out, run, number);
        movies.add(m);
    }

    /**
     * Specifically creates Theater
     * 
     * @param s
     *            String
     */
    void addTheater(String s) {
        String[] h = s.split(":");
        String letter = h[0];
        int number = Integer.valueOf(h[1]);
        int num = theaters.size() + 1;
        Theater th = new Theater(letter, num, number);
        theaters.add(th);
    }

    /**
     * Specifically creates show
     * 
     * @param s
     *            String
     */
    void addShow(String s) {
        String[] h = s.split(",");
        int movie1 = Integer.valueOf(h[0]);
        Movie m = movies.get(movie1 - 1);
        int theater1 = Integer.valueOf(h[1]);
        Theater t = theaters.get(theater1 - 1);
        int time = Integer.valueOf(h[2]);

        Shows show2 = new Shows(m, t, time);
        if (noConflict(show2)) {
            shows.add(show2);
        }
        else {
            log.add(show2.conflictString());
        }
    }
    /**
     * Returns no conflict boolean
     * @param s
     * Shows
     * @return boolean
     */
    boolean noConflict(Shows s) {
        boolean b = true;
        for (Shows sh : shows) {
            if (sh.isShow(s) && sh.conflict(s)) {
                b = false;
            }
        }
        return b;
    }

    /**
     * Specifically creates price
     * 
     * @param s
     *            String
     */
    void addPrice(String s) {
        String[] h = s.split(":");
        String type = h[0];
        int typeNum = prices.size() + 1;
        int c = Integer.valueOf(h[1]);

        Price p = new Price(type, typeNum, c);
        prices.add(p);
    }

    /**
     * Stores order history
     * 
     * @param s
     *            String
     */
    void order(String s) {

        Ticket t = ticket(s);
        if (purchaseOkay(t)) {
            sales.add(t);
            theaterUp(t);
        } 
        else {
            t.setTotal(0);
            sales.add(t);

        }
    }

    /**
     * Creates purchased ticket
     * 
     * @param s
     *            String
     * @return Ticket
     */
    Ticket ticket(String s) {
        String[] h = s.split(",");
        ArrayList<Integer> it = new ArrayList<Integer>();
        for (int i = 0; i < h.length; i++) {
            it.add(Integer.valueOf(h[i]));
        }
        int z = (it.get(3) * prices.get(0).getCost())
                + (it.get(4) * prices.get(1).getCost())
                + (it.get(5) * prices.get(2).getCost());

        Ticket t = new Ticket(it.get(0), it.get(1), it.get(2), it.get(3),
                it.get(4), it.get(5), z);
        return t;
    }

    /**
     * Checks to see if sold out
     * 
     * @param t
     * Ticket
     * @return boolean
     */
    boolean purchaseOkay(Ticket t) {
        Shows show1 = new Shows(new Movie("", 0, 0),
                new Theater("", 0, 0), 0);
        for (Shows sh : shows) {
            if (sh.isTicket(t)) {
                show1 = sh;
                break;
            }
        }
        int sum = t.getA() + t.getC() + t.getS();
        return (sum + show1.getCur() <= show1.getCap());

    }

    /**
     * Updates the theater
     * 
     * @param t
     *            Ticket
     */
    void theaterUp(Ticket t) {
        Shows show1 = new Shows(new Movie("", 0, 0),
                new Theater("", 0, 0), 0);
        for (Shows sh : shows) {
            if (sh.isTicket(t)) {
                show1 = sh;
                break;
            }
        }
        
        int sum = t.getA() + t.getC() + t.getS();
        show1.setCur(show1.getCur() + sum);
    }
    
    /**
     * Manager report helper
     */
    void managerHelper() {
        ArrayList<Ticket> man = new ArrayList<Ticket>();

        for (Shows s : shows) {
            int remain = s.getCap(); // - s.getCur();
            Ticket t = Ticket.manager(s.getMov(), s.getThea(),
                    s.getTime(), remain);
            man.add(t);
        }
        for (Ticket s : sales) {
            for (Ticket m : man) {
                if ((s.ticketComp(m)) && (s.getTotal() != 0)) {
                    m.setA(m.getA() + s.getA());
                    m.setC(m.getC() + s.getC());
                    m.setS(m.getS() + s.getS());
                }
            }
        }

        String out = "";
        String mT = "";
        String tT = "";
        for (Ticket t : man) {
            for (Shows s : shows) {
                if (s.isTicket(t)) {
                    mT = s.getMov().title;
                    tT = s.getThea().getLet();
                }
            }
            out = out + t.manString(mT, tT) + "\n";
        }
        int o = report;
        report = report + 1;
        manager = manager + "Report " + o + "\n" + out;
    }

}
