import junit.framework.TestCase;
import org.junit.Test;

/**
 * A class to test the movie system 
 * @author Brian Cox
 * @version (12-04-2013)
 */
public class CinemaTest extends TestCase {
    
    /**
     * Test Cinema
     */
    @Test
    public void testEverythingTest() {
        TicketSales ts = new TicketSales();
        ts.initCinema("webcatsucks.txt");
        ts.processOrders("updatetojava7youcavemen.txt");
        ts.initCinema("cinema.txt");
        ts.processOrders("orders.txt");
       
        
        Ticket t1 = new Ticket(1, 1, 960, 2, 0, 0, 20);
        
//        for (String s : ts.init) {
//            System.out.println(s);
//        }
        
//        for (Movie m : ts.movies) {
//            System.out.println(m.toString());
//        }
//        for (Theater t : ts.theaters) {
//            System.out.println(t.toString());
//        }
//        for (Shows s : ts.shows) {
//            System.out.println(s.toString());
//        }
//        for (Price p : ts.prices) {
//            System.out.println(p.toString());
//        }
        ts.dumb();
//        ts.order("1,1,960,400,400,400");
//        ts.addShow("1,1,970");
//        assertTrue("order test", ts.purchaseOkay(t1));
        assertTrue("test", ts.dumb());
        assertFalse("", new Price("A", 0, 0).getType().equals(""));
        assertEquals("Hello", new Price("", 0, 0).getTypeNum(), 0);
        assertEquals("", new Theater("A", 0, 0).getCur(), 0);
        
        System.out.println(ts.reportSales());
        System.out.println(ts.managerReport());
        System.out.println(ts.logReport());
//        for (String s : ts.orders) {
//          System.out.println(s);
//      }
        
        
        
        
        
        
        
        
          
        
    }

}
