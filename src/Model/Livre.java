/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aanthony
 */
public class Livre {
    public String titre;
    public String auteur;
    public Etudiant etudiant;
    
    
    public String toString(){
        return "Livre titre: "+this.titre + "\n Livre auteur: "+ this.auteur+ "\n Etudiant qui a emprunter le livre: "+etudiant == null? "ma 7adan " : this.etudiant.toString();
    }
    
    public Livre(String titre, String auteur){
        this.titre = titre;
        this.auteur = auteur;
        this.etudiant = null;
        
    }
    
    public void addEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
}
