/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Biblioteque;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Aanthony
 */
public class Controller {
    Biblioteque biblioteque;
    JFrame mainFrame ;
    
    JLabel titreLabel , auteurLabel , etudiantLabel;
    JTextArea titreField , auteurField , etudiantField ;
    JButton enregistrer , preter , rendre , quitter;
    
    
    JPanel boxPanel;
    GridLayout gridLayout;
    JPanel titrePanel , auteurPanel , etudiantPanel , buttonsPanel;
    public Controller(Biblioteque biblioteque){
        this.biblioteque = biblioteque;
        
        mainFrame = new JFrame();
        gridLayout = new GridLayout(4,0);
        boxPanel = new JPanel(gridLayout);
        mainFrame.add(boxPanel);
        
        titreLabel = new JLabel("tire");
        auteurLabel = new JLabel("auteur");
        etudiantLabel = new JLabel("etudiant");
        
        titreField = new JTextArea(1,25);
        auteurField = new JTextArea(1,25);
        etudiantField = new JTextArea(1,25);
        titrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        auteurPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        etudiantPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        titrePanel.add(titreLabel);titrePanel.add(titreField);
        auteurPanel.add(auteurLabel);auteurPanel.add(auteurField);
        etudiantPanel.add(etudiantLabel);etudiantPanel.add(etudiantField);
        
        boxPanel.add(titrePanel);boxPanel.add(auteurPanel);boxPanel.add(etudiantPanel);
        
        enregistrer = new JButton("enregistrer");
        preter = new JButton("preter");
        rendre = new JButton("rendre");
        quitter = new JButton("quitter");
        
        enregistrer.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent ae) {enregistrer();}});
        
        preter.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent ae) {preter();}});
        
        rendre.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent ae) {rendre();}});
        
        quitter.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent ae) { quitter(); } });

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.add(enregistrer);buttonsPanel.add(preter);buttonsPanel.add(rendre);buttonsPanel.add(quitter);
        
        boxPanel.add(buttonsPanel);
        
        mainFrame.pack();
        mainFrame.setTitle("eliane");
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(350, 350);
        
        
        
    }
    
    public void enregistrer() {
        try {
            String titre = ""+titreField.getText();
            String auteur  = ""+ auteurField.getText();
            if(titre.length() <= 0 || auteur.length() <= 0){
                System.out.println("livre ou auteur cant be empty");
            }else{
                biblioteque.enregister(""+titreField.getText() ,""+ auteurField.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        try{
            
            String etudiant = ""+etudiantField.getText();
            if(etudiant.length() <= 0){
                System.out.println("etudiant cant be empty");
            }else {
                biblioteque.inscrire(etudiant);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void preter(){
        
        try {
            String titre = ""+titreField.getText();
            String etudiant = ""+etudiantField.getText();
            if(titre.length() <= 0 || etudiant.length() <= 0){
                System.out.println("livre ou etudiant cant be empty");
            }else{
                biblioteque.preter(titre, etudiant);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public void rendre(){
        
        try {
            String titre = ""+titreField.getText();
            String etudiant = ""+etudiantField.getText();
            if(titre.length() <= 0 || etudiant.length() <= 0){
                System.out.println("livre ou etudiant cant be empty");
            }else{
                biblioteque.rendre(titre, etudiant);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public void quitter(){
        System.exit(0);
    }
    
}
