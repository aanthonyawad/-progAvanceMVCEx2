/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Biblioteque;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Aanthony
 */
public class NombreLivre implements Observer{
    
    JFrame mainFrame ;
    JPanel boxPanel , pretePanel , disponiblePanel;
    GridLayout gridLayout;
    JLabel preteLabel , disponibeleLabel ;
    JTextArea preteField , disponibeleField;
    
    public NombreLivre(){
        
        
        mainFrame = new JFrame();
        gridLayout = new GridLayout(4,0);
        boxPanel = new JPanel(gridLayout);
        mainFrame.add(boxPanel);
        
        pretePanel = new JPanel(new FlowLayout());
        disponiblePanel = new JPanel(new FlowLayout());
        
        preteLabel = new JLabel("Nombre de Livre Pretes");
        disponibeleLabel = new JLabel("Nombre de livre Disponible");
        preteField = new JTextArea(1,20);
        disponibeleField = new JTextArea(1,20);
        
        pretePanel.add(preteLabel);pretePanel.add(preteField);
        disponiblePanel.add(disponibeleLabel);disponiblePanel.add(disponibeleField);
        
        boxPanel.add(pretePanel);
        boxPanel.add(disponiblePanel);
        
        
        mainFrame.pack();
        mainFrame.setTitle("eliane");
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(350, 350);
        
    }
    public void init(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        Biblioteque b = (Biblioteque) o;
        this.disponibeleField.setText(""+b.getDisponible());
        this.preteField.setText(""+b.getPreter());
    }
   
}
