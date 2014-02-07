import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Console Class
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class Console {
    private TicketSales ts = new TicketSales();

    /**
     * Main Method
     * @param args
     * String []
     */
    public static void main(String [] args) {
        Console c = new Console();
        c.menu();

    }

    /**
     * Main Menu
     */
    public void menu() {
        System.out.println("What would you like to do? \n");
        System.out.println("[1] Initialize Cinema \n");
        System.out.println("[2] Process Orders \n");
        System.out.println("[3] Print Sales Report \n");
        System.out.println("[4] Print Manger Report \n");
        System.out.println("[5] Print Log Report \n");
        System.out.println("[6] Exit Console");

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = "";
        int i = 0;
        try {

            s = br.readLine();

            i = Integer.parseInt(s);

            switch (i) {
                case 1:
                    initCin();
                    break;
                case 2:
                    processOrders();
                    break;
                case 3:
                    printSales();
                    break;
                case 4:
                    managerReport();
                    break;
    
                case 5:
                    printLog();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid Input");
                    menu();
            }
        } 
        catch (Exception e) {
            System.out.println("Invalid Input");
            initCin();
        }
    }

    /**
     * Initialize Cinema
     */
    public void initCin() {
        System.out.println("What would you like to do? \n");
        System.out.println("[1] Add Movie \n");
        System.out.println("[2] Add Theater \n");
        System.out.println("[3] Add Show \n");
        System.out.println("[4] Add Price \n");
        System.out.println("[5] Initialize by file \n");
        System.out.println("[6] Back To Menu");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = "";
        int i = 0;
        try {

            s = br.readLine();

            i = Integer.parseInt(s);

            switch (i) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    addTheater();
                    break;
                case 3:
                    addShow();
                    break;
                case 4:
                    addPrice();
                    break;
    
                case 5:
                    initByFile();
                    break;
                case 6:
                    menu();
                    break;
                default:
                    System.out.println("Invalid Input");
                    initCin();
            }
        } 
        catch (Exception e) {
            System.out.println("Invalid Input");
            initCin();
        }
    }

    /**
     * Adds movie
     */
    public void addMovie() {
        System.out.println("Please enter the movie title: \n");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String title = "";
        String runTimeS = "";

        try {
            title = br.readLine();
            System.out.println("Please enter the movie runtime: \n");
            runTimeS = br.readLine();
            ts.addMovie(title + ":" + runTimeS);
            System.out.println("Movie Successfully Added");
            initCin();
        } 
        catch (Exception e) {
            ts.log.add("Invalid Input given creating movie");
            System.out.println("Invalid Input");
            addMovie();
        }

    }

    /**
     * Adds Theater
     */
    public void addTheater() {
        System.out.println("Please enter the theater title: \n");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String title = "";
        String capacity = "";

        try {
            title = br.readLine();
            System.out.println("Please enter the Theater capacity: \n");
            capacity = br.readLine();
            ts.addTheater(title + ":" + capacity);
            System.out.println("Theater Successfully Added");
            initCin();
        } 
        catch (Exception e) {
            ts.log.add("Invalid Input given creating theater");
            System.out.println("Invalid Input");
            addTheater();
        }
    }

    /**
     * Adds Show
     */
    public void addShow() {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String movie = "";
        String theater = "";
        String time = "";

        try {

            if (ts.movies.size() == 0) {
                ts.log.add("Attempted to create show without " +
                        "first initializing a movie");
                System.out.println("Need to add a movie before" +
                        " making a show");
                initCin();
            } 
            else if (ts.theaters.size() == 0) {
                ts.log.add("Attempted to create show without first" +
                        " initializing a theater");
                System.out
                        .println("Need to add a theater before making" +
                                " a show");
                initCin();
            } 
            else {
                System.out.println("Please select movie number: \n");
                for (Movie m : ts.movies) {
                    int i = ts.movies.indexOf(m) + 1;
                    System.out.println("[" + i + "] " + m.title);
                }
                movie = br.readLine();

                System.out.println("Please enter the theater number: \n");

                for (Theater t : ts.theaters) {
                    int i = ts.theaters.indexOf(t) + 1;
                    System.out.println("[" + i + "] " + t.getLet());
                }
                theater = br.readLine();

                System.out.println("Please enter the time:");
                time = br.readLine();
                ts.addShow(movie + "," + theater + "," + time);
                System.out.println("Show Successfully Added");
                initCin();
            }
        }
        catch (Exception e) {
            ts.log.add("Invalid Input given creating show");
            System.out.println("Invalid Input");
            addShow();
        }
    }

    /**
     * Adds Price
     */
    public void addPrice() {
        System.out.println("Please enter the price type: \n");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String type = "";
        String cost = "";

        try {
            type = br.readLine();
            System.out.println("Please enter the cost: \n");
            cost = br.readLine();
            ts.addPrice(type + ":" + cost);
            System.out.println("Price Successfully Added");
            initCin();
        } 
        catch (Exception e) {
            ts.log.add("Invalid input given creating price");
            System.out.println("Invalid Input");
            addPrice();
        }
    }

    /**
     * Initialize by File
     */
    public void initByFile() {
        System.out.println("Please input filename exactly");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String file = "";
        try {
            file = br.readLine();
            ts.initCinema(file);
            System.out.println("Cinema Initialized Successfully");
            menu();
        } 
        catch (Exception e) {
            ts.log.add("Invalid file entry");
            System.out.println("Invalid file entry");
            initByFile();
        }
    }

    /**
     * Process Orders
     */
    public void processOrders() {
        System.out.println("How would you like to Process Orders? \n");
        System.out.println("[1] By File \n");
        System.out.println("[2] Manually \n");
        System.out.println("[3] Manger Report \n");
        System.out.println("[4] Back To Menu \n");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s = "";
        int i = 0;
        try {

            s = br.readLine();

            i = Integer.parseInt(s);

            switch (i) {
                case 1:
                    processByFile();
                    break;
                case 2:
                    processByHand();
                    break;
                case 3:
                    managerReport();
                    break;
                case 4:
                    menu();
                    break;
                default:
                    System.out.println("Invalid Input");
                    processOrders();
            }
        } 
        catch (Exception e) {
            System.out.println("Invalid Input");
            processOrders();
        }
    }

    /**
     * Process Orders By File
     */
    public void processByFile() {
        System.out.println("Please input filename exactly");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String file = "";
        try {
            file = br.readLine();
            ts.processOrders(file);
            System.out.println("Order[s] Processed Successfully");
            menu();
        } 
        catch (Exception e) {
            ts.log.add("Invalid file entry");
            System.out.println("Invalid file entry");
            processByFile();
        }
    }

    /**
     * Process Orders By Hand
     */
    public void processByHand() {
        for (Shows s : ts.shows) {
            System.out.println("[" + (ts.shows.indexOf(s) + 1) + "] "
                    + s.getMov().title + " : " + s.getTime());
        }
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String showS = "";
        int showN = 0;
        String movie = "";
        String theater = "";
        String time = "";
        Shows sho;
        String adult = "";
        String child = "";
        String senior = "";
        try {
            showS = br.readLine();
            showN = Integer.parseInt(showS);
            sho = ts.shows.get(showN);

            /*
             * if (ts.movies.size() == 0) {
             * ts.log.add("Attempted to process order without" +
             * " first initializing a movie"); System.out
             * .println("Need to add a movie before " + "processing an order");
             * initCin(); } else if (ts.theaters.size() == 0) {
             * ts.log.add("Attempted to process order without " +
             * "first initializing a theater"); System.out
             * .println("Need to add a theater before " +
             * "processing an order"); initCin(); } else {
             * System.out.println("Please select movie number: \n"); for (Movie
             * m : ts.movies) { int i = ts.movies.indexOf(m) + 1;
             * System.out.println("[" + i + "] " + m.title); } movie =
             * br.readLine();
             * 
             * System.out.println("Please enter the theater number: \n");
             * 
             * for (Theater t : ts.theaters) { int i = ts.theaters.indexOf(t) +
             * 1; System.out.println("[" + i + "] " + t.getLet()); } theater =
             * br.readLine();
             * 
             * System.out.println("Please enter the time:"); time =
             * br.readLine();
             */

            System.out.println("Number of Adult tickets:");
            adult = br.readLine();

            System.out.println("Number of Child tickets:");
            child = br.readLine();

            System.out.println("Number of Senior tickets:");
            senior = br.readLine();

            movie = "" + sho.getMov().getNum();
            theater = "" + sho.getThea().getNum();
            time = "" + sho.getTime();

            ts.processOrders(movie + "," + theater + "," + time + "," + adult
                    + "," + child + "," + senior);
            System.out.println("Order Processed Successfully");
            processOrders();

        }
        catch (Exception e) {
            ts.log.add("Invalid Input given creating show");
            System.out.println("Invalid Input");
            processByHand();
        }
    }

    /**
     * Manager Report
     */
    public void managerReport() {
        System.out.println(ts.managerReport());
        menu();
    }

    /**
     * Print Sales
     */
    public void printSales() {
        System.out.println(ts.reportSales());
        System.out.println("Enter any Key To Continue");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            br.readLine();
            menu();
        } 
        catch (Exception e) {
            menu();
        }

    }

    /**
     * Print Log
     */
    public void printLog() {
        System.out.println(ts.logReport());
        menu();
        
    }


}
