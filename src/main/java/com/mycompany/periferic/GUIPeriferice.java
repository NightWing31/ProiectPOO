package com.mycompany.periferic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIPeriferice extends JFrame {

    private final JComboBox<String> comboBoxPeriferice;
    private final JTextField textCriteriu;
    private final JCheckBox checkBoxConditie;
    private final JLabel labelConditie;
    private final JTextArea textAreaRezultate;

    private ArrayList<Tastatura> tastaturi;
    private ArrayList<Mouse> mouseuri;
    private ArrayList<CameraVideo> camere;
    private ArrayList<Microfon> microfoane;

    public GUIPeriferice() {
        setTitle("Filtrare Periferice");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initData();

        // Panoul de sus
        JPanel panelSus = new JPanel();
        panelSus.add(new JLabel("Tip periferic:"));
        comboBoxPeriferice = new JComboBox<>(new String[]{"Tastatura", "Mouse", "Camera Video", "Microfon"});
        comboBoxPeriferice.addActionListener(e -> actualizeazaLabelConditie());
        panelSus.add(comboBoxPeriferice);

        // Panoul de mijloc
        JPanel panelMijloc = new JPanel(new GridLayout(2, 3));
        panelMijloc.add(new JLabel("Sistem de operare compatibil: (ex: Windows, Linux, MacOS):"));
        textCriteriu = new JTextField();
        panelMijloc.add(textCriteriu);

        labelConditie = new JLabel("Conditie suplimentară pentru fiecare categorie: ");
        panelMijloc.add(labelConditie);

        checkBoxConditie = new JCheckBox("Activat");
        panelMijloc.add(checkBoxConditie);

        // Panoul de jos
        JPanel panelJos = new JPanel(new BorderLayout());
        textAreaRezultate = new JTextArea(5,5);
        textAreaRezultate.setEditable(false);
        panelJos.add(new JScrollPane(textAreaRezultate), BorderLayout.CENTER);

        JButton butonAfisare = new JButton("Afiseaza");
        butonAfisare.addActionListener(e -> afiseazaRezultate());
        panelJos.add(butonAfisare, BorderLayout.SOUTH);

        // Adăugare panouri
        add(panelSus, BorderLayout.NORTH);
        add(panelMijloc, BorderLayout.CENTER);
        add(panelJos, BorderLayout.SOUTH);
    }

    private void initData() {
    tastaturi = new ArrayList<>();
    tastaturi.add(new Tastatura("Logitech", "G915", 799.99, "Windows, MacOS, Linux", "QWERTY", true, "Bluetooth"));
    tastaturi.add(new Tastatura("Razer", "BlackWidow", 699.99, "Windows, Linux", "QWERTY", true, "USB"));
    tastaturi.add(new Tastatura("Corsair", "K70 RGB", 599.99, "Windows, MacOS", "QWERTY", true, "USB"));
    tastaturi.add(new Tastatura("HyperX", "Alloy FPS", 499.99, "Windows, Linux", "QWERTY", false, "USB"));
    tastaturi.add(new Tastatura("SteelSeries", "Apex Pro", 849.99, "Windows, MacOS", "QWERTY", true, "Bluetooth"));
    tastaturi.add(new Tastatura("Logitech", "K380", 299.99, "Windows, MacOS, Linux", "QWERTY", false, "Bluetooth"));
    tastaturi.add(new Tastatura("Microsoft", "Sculpt Ergonomic", 399.99, "Windows", "QWERTY", false, "USB"));
    tastaturi.add(new Tastatura("Roccat", "Vulcan 120", 749.99, "Windows", "QWERTY", true, "USB"));
    tastaturi.add(new Tastatura("Ducky", "One 2 Mini", 499.99, "Windows, Linux", "QWERTY", false, "USB"));
    tastaturi.add(new Tastatura("Anne Pro", "2", 429.99, "Windows, MacOS, Linux", "QWERTY", true, "Bluetooth"));

    mouseuri = new ArrayList<>();
    mouseuri.add(new Mouse("Logitech", "MX Master 3", 499.99, "Windows, MacOS, Linux", 4000, 7, true));
    mouseuri.add(new Mouse("Razer", "Viper Ultimate", 799.99, "Windows, MacOS, Linux", 20000, 6, true));
    mouseuri.add(new Mouse("SteelSeries", "Rival 600", 599.99, "Windows, MacOS", 12000, 8, false));
    mouseuri.add(new Mouse("Corsair", "Dark Core RGB", 699.99, "Windows, MacOS, Linux", 18000, 8, true));
    mouseuri.add(new Mouse("Logitech", "G502", 399.99, "Windows, Linux", 16000, 11, false));
    mouseuri.add(new Mouse("HyperX", "Pulsefire FPS Pro", 349.99, "Windows, MacOS", 16000, 6, false));
    mouseuri.add(new Mouse("Roccat", "Kone AIMO", 499.99, "Windows", 16000, 10, true));
    mouseuri.add(new Mouse("Microsoft", "Arc Mouse", 299.99, "Windows, Linux", 1000, 2, true));
    mouseuri.add(new Mouse("Razer", "Basilisk X", 399.99, "Windows, MacOS", 16000, 6, true));
    mouseuri.add(new Mouse("Logitech", "M330 Silent", 199.99, "Windows, MacOS, Linux", 1000, 3, false));

    camere = new ArrayList<>();
    camere.add(new CameraVideo("Logitech", "C920", 399.99, "Windows, MacOS, Linux", 1080, 30, true));
    camere.add(new CameraVideo("Razer", "Kiyo", 599.99, "Windows", 1080, 60, true));
    camere.add(new CameraVideo("Microsoft", "LifeCam HD-3000", 249.99, "Windows, Linux", 720, 30, false));
    camere.add(new CameraVideo("Logitech", "Brio", 899.99, "Windows, MacOS", 2160, 30, true));
    camere.add(new CameraVideo("AverMedia", "PW513", 849.99, "Windows, MacOS", 2160, 60, false));
    camere.add(new CameraVideo("Razer", "Kiyo Pro", 999.99, "Windows, Linux", 1080, 60, true));
    camere.add(new CameraVideo("Logitech", "StreamCam", 749.99, "Windows, MacOS", 1080, 60, true));
    camere.add(new CameraVideo("Elgato", "Facecam", 999.99, "Windows", 1080, 60, false));
    camere.add(new CameraVideo("Microsoft", "LifeCam Studio", 499.99, "Windows, Linux", 1080, 30, false));
    camere.add(new CameraVideo("Aukey", "PC-LM1E", 299.99, "Windows, MacOS", 1080, 30, false));

    microfoane = new ArrayList<>();
    microfoane.add(new Microfon("Blue", "Yeti", 599.99, "Windows, MacOS, Linux", -38, "USB", true));
    microfoane.add(new Microfon("Rode", "NT-USB Mini", 449.99, "Windows, MacOS", -45, "USB", false));
    microfoane.add(new Microfon("Shure", "MV7", 999.99, "Windows, MacOS, Linux", -38, "USB", true));
    microfoane.add(new Microfon("HyperX", "QuadCast", 749.99, "Windows, MacOS", -36, "USB", true));
    microfoane.add(new Microfon("Elgato", "Wave 3", 899.99, "Windows, Linux", -35, "USB", true));
    microfoane.add(new Microfon("Samson", "G-Track Pro", 649.99, "Windows, MacOS", -39, "USB", true));
    microfoane.add(new Microfon("Blue", "Snowball", 349.99, "Windows, MacOS", -40, "USB", false));
    microfoane.add(new Microfon("Audio-Technica", "AT2020USB+", 799.99, "Windows, MacOS, Linux", -37, "USB", false));
    microfoane.add(new Microfon("Razer", "Seiren X", 549.99, "Windows, MacOS", -40, "USB", true));
    microfoane.add(new Microfon("Fifine", "K669B", 199.99, "Windows, MacOS, Linux", -38, "USB", false));
}


    private void actualizeazaLabelConditie() {
        String tipPeriferic = (String) comboBoxPeriferice.getSelectedItem();
        switch (tipPeriferic) {
            case "Tastatura" -> labelConditie.setText("Condiție suplimentară (Iluminare):");
            case "Mouse" -> labelConditie.setText("Condiție suplimentară (Wireless):");
            case "Camera Video" -> labelConditie.setText("Condiție suplimentară (Microfon integrat):");
            case "Microfon" -> labelConditie.setText("Condiție suplimentară (Conferință):");
        }
    }

    private void afiseazaRezultate() {
        String tipPeriferic = (String) comboBoxPeriferice.getSelectedItem();
        String criteriu = textCriteriu.getText();
        boolean conditie = checkBoxConditie.isSelected();

        textAreaRezultate.setText("");

        switch (tipPeriferic) {
            case "Tastatura" -> {
                for (Tastatura t : tastaturi) {
                    if (t.getCompatibilitateSO().contains(criteriu) && t.isIluminare() == conditie) {
                        textAreaRezultate.append(t.obtineDetalii() + "\n");
                    }
                }
            }
            case "Mouse" -> {
                for (Mouse m : mouseuri) {
                    if (m.getCompatibilitateSO().contains(criteriu) && m.isWireless() == conditie) {
                        textAreaRezultate.append(m.obtineDetalii() + "\n");
                    }
                }
            }
            case "Camera Video" -> {
                for (CameraVideo c : camere) {
                    if (c.getCompatibilitateSO().contains(criteriu) && c.haveMicrofonn() == conditie) {
                        textAreaRezultate.append(c.obtineDetalii() + "\n");
                    }
                }
            }
            case "Microfon" -> {
                for (Microfon mic : microfoane) {
                    if (mic.getCompatibilitateSO().contains(criteriu) && mic.isConferinta() == conditie) {
                        textAreaRezultate.append(mic.obtineDetalii() + "\n");
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPeriferice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPeriferice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPeriferice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPeriferice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            GUIPeriferice gui = new GUIPeriferice();
            gui.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
