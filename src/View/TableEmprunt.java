/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Biblioteque;
import Model.Livre;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aanthony
 */
class TableEmprunt implements Observer{
    
        JFrame mainFrame ;
        JPanel panel;
        JLabel label;
        JTable table;
        private final String [] header = {"Titre","Auteur","Etudiant"};
        private String [][] columns;
        
    public TableEmprunt() {
        columns = new String [0][0];
        mainFrame = new JFrame();
        panel = new JPanel(new BorderLayout());
        label = new JLabel("Liste des Prets");
        table = new JTable(new DefaultTableModel(header,0));
        JScrollPane tableContainer = new JScrollPane(table);
        panel.add(label,BorderLayout.NORTH);
        panel.add(tableContainer,BorderLayout.CENTER);
        
        
        mainFrame.getContentPane().add(panel);
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
        Biblioteque biblio = (Biblioteque)o;
        ArrayList<Livre> livres = biblio.getLivreEmprunte();
        String [][] table = convertToTable(livres);
//        this.table = new JTable(table,header);
//        table.notify();
        
        
        DefaultTableModel model = new DefaultTableModel(table,header);
        this.table.setModel(model);
    }
    
    public String [][] convertToTable(ArrayList<Livre> livres){
        String [][] table= new String [livres.size()][3] ;
            
        for(int i =0 ; i<livres.size() ; i++){
            table[i][0] = livres.get(i).titre ;
            table[i][1] = livres.get(i).auteur;
            table[i][2] = livres.get(i).etudiant.nom;
            
        }
        
        return table;
    }
    
}
