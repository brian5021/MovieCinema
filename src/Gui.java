//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//
///**
// * A class for the graphical user interface
// * 
// * @author Brian Cox
// * @version (12-04-2013)
// */
//@SuppressWarnings("serial")
//public class Gui extends JFrame {
//    private TicketSales ts;
//
//    private ArrayList<JButton> buttonsM = new ArrayList<JButton>();
//    private ArrayList<JButton> buttonsT = new ArrayList<JButton>();
//    private ArrayList<JButton> buttonsP = new ArrayList<JButton>();
//    private ArrayList<JLabel> labelsP = new ArrayList<JLabel>();
//    private ArrayList<Integer> ticketsQ = new ArrayList<Integer>();
//
//    private JLabel label;
//    private JLabel blank4;
//
//    private JMenuBar menubar;
//    private JMenu file;
//    private JMenuItem sales;
//    private JMenuItem initialize;
//    private JMenuItem updateSystem;
//    private JMenuItem reportSales;
//
//    private final static int GUI_WIDTH = 500;
//    private final static int GUI_HEIGHT = 500;
//    final JFrame f = new JFrame();
//
//    private int movieSelect;
//    private Theater theaterSelect;
//    private int timeSelect;
//
//    /**
//     * Main method for gui
//     * 
//     * @param args
//     *            String
//     */
//    public static void main(String args[]) {
//        Gui gui = new Gui();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setSize(GUI_WIDTH, GUI_HEIGHT); // gui.pack()
//        gui.setVisible(true);
//        gui.setTitle("Cox Movieplex Emporium");
//    }
//
//    /**
//     * Constructor for Gui
//     */
//    public Gui() {
//
//        ts = new TicketSales();
//        ts.initCinema("cinema.txt");
//
//        label = new JLabel("Movie Selection");
//        label.setFont(new Font("Monotype Corsiva", 1, 30));
//        add(label);
//
//        movieSet();
//
//        menubar = new JMenuBar();
//        setJMenuBar(menubar);
//
//        file = new JMenu("file");
//        menubar.add(file);
//
//        sales = new JMenu("Sales Menu");
//        file.add(sales);
//
//        initialize = new JMenu("Initialize");
//        file.add(initialize);
//
//        updateSystem = new JMenu("Update System");
//        file.add(updateSystem);
//
//        reportSales = new JMenu("Report Sales");
//        file.add(reportSales);
//
//    }
//
//    /**
//     * Sets up the movie buttons for gui
//     */
//    public void movieSet() {
//        for (Movie m : ts.movies) {
//            JButton b = new JButton(m.title);
//            Event e = new Event();
//            add(b);
//            b.addActionListener(e);
//            buttonsM.add(b);
//
//        }
//        setLayout(new GridLayout(ts.movies.size() + 1, 1));
//    }
//
//    /**
//     * Sets up the time for the GUI
//     * 
//     * @param e
//     *            ActionEvent
//     */
//    public void timeSet(ActionEvent e) {
//        for (int i = 0; i < buttonsM.size(); i++) {
//            remove(buttonsM.get(i));
//            buttonsM.get(i).removeAll();
//        }
//        JButton clicked = (JButton) e.getSource();
//
//        for (JButton z : buttonsM) {
//            if (clicked.equals(z)) {
//                movieSelect = buttonsM.indexOf(z) + 1;
//                for (Shows s : ts.shows) {
//                    if (s.getMov().getNum() == movieSelect) {
//                        JButton t = new JButton("" + s.getTime());
//                        Event2 ev = new Event2();
//                        add(t);
//                        t.addActionListener(ev);
//                        buttonsT.add(t);
//                    }
//                }
//            }
//        }
//        setLayout(new GridLayout(buttonsT.size() + 1, 1));
//
//    }
//
//    /**
//     * Sets up the ability to select quantity of tickets
//     * 
//     * @param ev
//     *            ActionEvent
//     */
//    public void quantitySet(ActionEvent ev) {
//        for (int i = 0; i < buttonsT.size(); i++) {
//            remove(buttonsT.get(i));
//            buttonsT.get(i).removeAll();
//        }
//        remove(label);
//
//        JButton clicked = (JButton) ev.getSource();
//
//        Shows s = ts.shows.get(buttonsT.indexOf(clicked));
//        theaterSelect = s.getThea();
//        timeSelect = s.getTime();
//        initQuantity();
//
//        setLayout(new GridLayout(labelsP.size() + 1, 4));
//
//    }
//
//    /**
//     * Initializes the buttons for quantity
//     */
//    public void initQuantity() {
//        for (Price p : ts.prices) {
//            EventDown evD = new EventDown();
//            EventUp evU = new EventUp();
//
//            JLabel tic = new JLabel(p.getType() + ":");
//            tic.setFont(new Font("Monotype Corsiva", 1, 30));
//            add(tic);
//            JLabel tac = new JLabel("$" + p.getCost());
//            tac.setFont(new Font("Monotype Corsiva", 1, 30));
//            add(tac);
//
//            JButton down = new JButton("-");
//            down.addActionListener(evD);
//            add(down);
//            buttonsP.add(down);
//
//            int i = 0;
//            ticketsQ.add(i);
//
//            JLabel q = new JLabel("" + i);
//            add(q);
//            labelsP.add(q);
//
//            JButton up = new JButton("+");
//            up.addActionListener(evU);
//            add(up);
//            buttonsP.add(up);
//        }
//        EventC con = new EventC();
//        JLabel blank1 = new JLabel("Confirm");
//        add(blank1);
//        JLabel blank2 = new JLabel("Purchase");
//        add(blank2);
//        JButton confirm = new JButton("Click");
//        confirm.addActionListener(con);
//        add(confirm);
//        JLabel blank3 = new JLabel("Total: ");
//        add(blank3);
//        blank4 = new JLabel("$0");
//        add(blank4);
//
//    }
//
//    /**
//     * ActionListener for selecting movie
//     * 
//     * @author Brian Cox
//     * @version (12-04-2013)
//     */
//    public class Event implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            label.setText("Times");
//            label.setFont(new Font("Monotype Corsiva", 1, 30));
//            timeSet(e);
//        }
//    }
//
//    /**
//     * ActionListener for selecting a time
//     * 
//     * @author Brian Cox
//     * @version (12-04-2013)
//     */
//    public class Event2 implements ActionListener {
//        public void actionPerformed(ActionEvent ev) {
//            label.setText("Tickets");
//            label.setFont(new Font("Monotype Corsiva", 1, 30));
//            quantitySet(ev);
//        }
//    }
//
//    /**
//     * ActionListener for selecting down quantity
//     * 
//     * @author Brian Cox
//     * @version (12-04-2013)
//     */
//    public class EventDown implements ActionListener {
//        public void actionPerformed(ActionEvent evD) {
//            JButton clicked = (JButton) evD.getSource();
//            int click = buttonsP.indexOf(clicked);
//            int math = (int) (Math.ceil(click / 2));
//            JLabel q = labelsP.get(math);
//            int i = ticketsQ.get(math);
//            if (i != 0) {
//                i = i - 1;
//                ticketsQ.set(math, i);
//            }
//
//            q.setText("" + i);
//
//        }
//    }
//
//    /**
//     * ActionListener for selecting up quantity
//     * 
//     * @author Brian Cox
//     * @version (12-04-2013)
//     */
//    public class EventUp implements ActionListener {
//        public void actionPerformed(ActionEvent evU) {
//            JButton clicked = (JButton) evU.getSource();
//            int click = buttonsP.indexOf(clicked);
//            int math = (int) (Math.ceil(click / 2));
//            JLabel q = labelsP.get(math);
//            int i = ticketsQ.get(math);
//            i = i + 1;
//            ticketsQ.set(math, i);
//            q.setText("" + i);
//        }
//    }
//
//    /**
//     * ActionListener for confirming purchase
//     * 
//     * @author Brian Cox
//     * @version (12-04-2013)
//     */
//    public class EventC implements ActionListener {
//        public void actionPerformed(ActionEvent con) {
//            int a = ticketsQ.get(0);
//            int b = ticketsQ.get(1);
//            int c = ticketsQ.get(2);
//
//            ts.order("" + movieSelect + "," + theaterSelect.getNum() + ","
//                    + timeSelect + "," + a + "," + b + "," + c);
//            Ticket t = ts.sales.get(ts.sales.size() - 1);
//            blank4.setText("$" + t.getTotal());
//
//        }
//    }
//
//}
