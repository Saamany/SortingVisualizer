import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Saam Eymany
 * @version 1.0
 * @since 2021-07-25
 */

public class Menu extends JFrame {

    private JComboBox algorithmComboBox, anzahlComboBox, tempoComboBox;
    private JLabel algLabel, anzahlLabel, tempoLabel;
    private JLabel vergleicheLabel, vergleiche;
    private JPanel angabenTogetherPanel, angabenPanel, buttonPanel;
    private JButton sortButton, infoButton;
    private JTextArea cases;
    FlowLayout fl = new FlowLayout();
    Bubblesort b = new Bubblesort();
    Quicksort q = new Quicksort();
    Mergesort m = new Mergesort();


    Menu() {
        super("Sortier-Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));
        setSize(800, 800);
        setLayout(fl);            //Set up flow layout
        setResizable(false);      //Cannot change form size
        setLocationRelativeTo(null);//Center display

        String algListe[] = {"", "Bubblesort", "Quicksort",
                "Mergesort"};
        String anzahlListe[] = {"", "10", "20",
                "30", "40"};
        String tempoListe[] = {"", "lansam", "normal",
                "schnell"};

        algLabel = new JLabel("Algorythmen: ");
        algorithmComboBox = new JComboBox(algListe);

        anzahlLabel = new JLabel("  Anzahl Zahlen:");
        anzahlComboBox = new JComboBox(anzahlListe);

        tempoLabel = new JLabel(" Geschwindigkeit: ");
        tempoComboBox = new JComboBox(tempoListe);

        vergleicheLabel = new JLabel("Anzahl Vergleiche: ");
        vergleiche = new JLabel();

        cases = new JTextArea();
        cases.setEditable(false);
        cases.setSize(50, 20);


        infoButton = new JButton("info cases");
        sortButton = new JButton("sorting");


        angabenPanel = new JPanel(new GridLayout(2, 4));
        angabenPanel.add(algLabel);
        angabenPanel.add(anzahlLabel);
        angabenPanel.add(tempoLabel);
        angabenPanel.add(vergleicheLabel);
        angabenPanel.add(algorithmComboBox);
        angabenPanel.add(anzahlComboBox);
        angabenPanel.add(tempoComboBox);
        angabenPanel.add(vergleiche);


        buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(infoButton);
        buttonPanel.add(sortButton);


        angabenTogetherPanel = new JPanel(new FlowLayout());
        angabenTogetherPanel.add(angabenPanel);
        angabenTogetherPanel.add(buttonPanel);

        //Hier wird das ausgewählte Algorythmus sortiert
        sortButton.addActionListener(e -> {
            generateAndSet();
            if (algorithmComboBox.getSelectedIndex() == 1) {
                b.sort();
                vergleiche.setText(String.valueOf(b.getCompares()));
                b.deleteCompares();
            } else if (algorithmComboBox.getSelectedIndex() == 2) {
                q.sort();
                vergleiche.setText(String.valueOf(q.getCompares()));
                q.deleteCompares();
            } else if (algorithmComboBox.getSelectedIndex() == 3) {
                m.sort();
                vergleiche.setText(String.valueOf(m.getCompares()));
                m.deleteCompares();
            }
        });

        //Hier wird den Klassen die Schnelligkeit weitergegeben
        tempoComboBox.addActionListener(e -> {
            String x = "";
            if (tempoComboBox.getSelectedIndex() == 1) {
                x = "langsam";

            } else if (tempoComboBox.getSelectedIndex() == 2) {
                x = "normal";
            } else if (tempoComboBox.getSelectedIndex() == 3) {
                x = "schnell";
            }
            b.setSelectedTempo(x);
            q.setSelectedTempo(x);
            m.setSelectedTempo(x);
        });

        //setzt die Cases, des ausgewählten Algorythmus in einem JTextarea
        infoButton.addActionListener(e -> {
            if (algorithmComboBox.getSelectedIndex() == 1) {
                cases.setText("Best Case = O(n)\n" + "Average Case = O(n^2)\t\n" + "Worst Case = O(n^2)\t\n");
            } else if (algorithmComboBox.getSelectedIndex() == 2) {
                cases.setText("Best Case = O(n log(n))\n" + "Average Case = O(n log(n))\n" + "Worst Case = O(n^2)\t\n");
            } else if (algorithmComboBox.getSelectedIndex() == 3) {
                cases.setText("Best Case = O(n log(n))\t\n" + "Average Case = O(n log(n))\n" + "Worst Case = O(n log(n))\n");
            } else if (algorithmComboBox.getSelectedIndex() <= 0) {
                cases.setText("Sie müssen ein Algorythmus wählen!");
            }
        });

        //Hier wird ein neues Frame erstellt und es zeigt die Cases des ausgewählten Algorythmus
        infoButton.addActionListener(e -> {
            JFrame jf = new JFrame("Cases" + " " + algorithmComboBox.getSelectedItem());
            jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            jf.setSize(400, 100);
            jf.setResizable(false);
            jf.add(cases);
            jf.setVisible(true);
        });


        this.getContentPane().add(angabenTogetherPanel, BorderLayout.NORTH);
        setVisible(true);

        Graphics g = getGraphics();
        b.g = g;
        q.g = g;
        m.g = g;


    }

    /**
     * Diese Methode bestimmt die Länge des Arrays
     * Generiert einen gemischten Array
     * und gibt die Werte dem ausgewählten Klasse weiter
     */
    public void generateAndSet() {
        int[] num = new int[0];
        int x = anzahlComboBox.getSelectedIndex();
        if (x == 1) {
            num = new int[]{5, 4, 6, 1, 7, 8, 9, 3, 2, 10};
            arrayMix(num);


        } else if (x == 2) {
            num = new int[]{13, 7, 18, 17, 19, 10, 3, 4, 14,
                    6, 15, 12, 1, 2, 20, 11, 5, 16, 8, 9};
            arrayMix(num);


        } else if (x == 3) {
            num = new int[]{23, 13, 21, 25, 7, 18, 27, 28,
                    17, 19, 10, 22, 3, 29, 4, 14, 6, 15, 12,
                    1, 2, 30, 20, 11, 5, 24, 16, 8, 26, 9};
            arrayMix(num);

        } else if (x == 4) {
            num = new int[]{33, 18, 28, 39, 40, 12, 36, 24,
                    1, 20, 7, 22, 32, 10, 6, 14, 26, 16, 29,
                    17, 30, 27, 19, 3, 34, 13, 15, 38, 31,
                    5, 35, 21, 37, 23, 8, 25, 4, 9, 11, 2};
            arrayMix(num);

        }

        int count = 0;
        if (anzahlComboBox.getSelectedIndex() == 1) {
            count = 10;
        } else if (anzahlComboBox.getSelectedIndex() == 2) {
            count = 20;
        } else if (anzahlComboBox.getSelectedIndex() == 3) {
            count = 30;
        } else if (anzahlComboBox.getSelectedIndex() == 4) {
            count = 40;
        }


        if (algorithmComboBox.getSelectedIndex() == 1) {
            b.setSelectedArrayLength(count);
            b.setArray(num);

        }
        if (algorithmComboBox.getSelectedIndex() == 2) {
            q.setSelectedArrayLength(count);
            q.setArray(num);

        }
        if (algorithmComboBox.getSelectedIndex() == 3) {
            m.setSelectedArrayLength(count);
            m.setArray(num);
        }
    }

    /**
     * @param zahlen ist das Array, den man gewählt hat
     * @return den gemischten Array
     */
    private int[] arrayMix(int[] zahlen) {
        int tmp;
        int rand;
        Random r = new Random();
        for (int i = 0; i < zahlen.length; i++) {
            rand = r.nextInt(zahlen.length);
            tmp = zahlen[i];
            zahlen[i] = zahlen[rand];
            zahlen[rand] = tmp;
        }
        return zahlen;
    }

    public static void main(String[] args) {
        new Menu();
    }


}
