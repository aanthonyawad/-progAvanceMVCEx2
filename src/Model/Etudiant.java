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
public class Etudiant {
    public String nom;
    public Etudiant(String nom){
        this.nom = nom;
    }
    public String toString(){
        return "Le nom de l'etudiant est: "+this.nom;
    }
}
