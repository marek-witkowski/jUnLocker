import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {


    private static void createAndShowGUI() {

        String[] years = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010"};


        JFrame frame = new JFrame ("Odblokowywacz");
        JPanel panel = new JPanel ( );
        panel.setLayout (new BorderLayout ( ));


        JButton btnExit = new JButton ("Zakończ");
        JButton btnUnlock = new JButton ("Odblokuj");
        JComboBox cboChooseYear = new JComboBox (years);
        JTextField txtDocNumber = new JTextField ( );
        JLabel lbText = new JLabel ("Podaj dane dokumentu:");

        txtDocNumber.setColumns (20);

        btnUnlock.addActionListener (e -> {
            unlockFile(cboChooseYear.getSelectedItem ().toString (), txtDocNumber.getText ());
            txtDocNumber.setText ("");
        });

        btnExit.addActionListener (e -> {
            System.exit (0);
        });

        panel.add (lbText, BorderLayout.PAGE_START);
        panel.add (cboChooseYear, BorderLayout.LINE_START);
        panel.add (txtDocNumber, BorderLayout.CENTER);
        panel.add (btnUnlock, BorderLayout.LINE_END);
        panel.add (btnExit, BorderLayout.PAGE_END);


        frame.add (panel);
        frame.setSize (500, 200);
        frame.setLocation (400, 400);
        frame.setResizable (false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible (true);


    }


    private static void unlockFile(String yearNumber,String docNumber){

        String pathToFile = "L:\\progvat\\hl\\rch\\" + docNumber + yearNumber.substring (2,4) +  ".TMP";

        File fileToDelete = new File (pathToFile);

        fileToDelete.delete();




    }


    public static void main(String[] args) {


        javax.swing.SwingUtilities.invokeLater (new Runnable ( ) {
            public void run() {
                createAndShowGUI ( );
            }
        });
    }


}
