/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Aanthony
 */
public class Biblioteque  extends Observable{
    ArrayList<Livre> biblio ;
    ArrayList<Etudiant> etu;
    ArrayList<Observer> observers;
    public Biblioteque(){
        this.biblio = new ArrayList<Livre>();
        this.etu = new ArrayList<Etudiant>();
        this.observers = new ArrayList<Observer>();
        
    }
    public void inscrire(String e) throws LivreException{
        Etudiant etudiant = this.etudiantFound(e);
        if(etudiant == null){
            this.etu.add(new Etudiant(e));
        }else {
            throw new LivreException("Etudiant deja inscrits");}
    }
    public void enregister(String titre , String auteur) throws LivreException{
        Livre livre = this.livreFound(titre);
        if(livre != null){
            throw new LivreException("Livre deja dans la biblioteque");
        }else {
            this.biblio.add(new Livre(titre, auteur));
            this.setChanged();
            this.notifyObservers();
        }
    }
    
    public Livre livreFound(String l){
        
        for(Livre livre: biblio){
            if(livre.titre.equalsIgnoreCase(l)){
                return livre;
            }
        }
        
        return null;
        
    }
    public Etudiant etudiantFound(String e){
        for(Etudiant etudiant: etu){
            if(etudiant.nom.equalsIgnoreCase(e)){
                return etudiant;
            }
        }
        return null;
    }
    
    public void preter(String l , String e) throws LivreException{
        Livre livre = this.livreFound(l);
        if(livre != null){
            Etudiant etudiant = this.etudiantFound(e);
            if(etudiant != null){
                if(livre.etudiant == null){
                    livre.etudiant = etudiant;
                    this.setChanged();
                    this.notifyObservers();
                }else {
                    throw new LivreException("livre deja preter");
                }
            }else {
                throw new LivreException("etudiant pas inscrit dans la biblio");
            }
        }else {
            throw new LivreException("Livre pas trouve dans la biblio");
        }
    }
    
    public void rendre(String l , String e) throws LivreException{
        
        Livre livre = this.livreFound(l);
           if(livre != null){
            Etudiant etudiant = this.etudiantFound(e);
            if(etudiant != null){
                if(livre.etudiant != null){
                    livre.etudiant = null;
                    this.setChanged();
                    this.notifyObservers();
                }else {
                    throw new LivreException("livre n'est pas preter");
                }
            }else {
                throw new LivreException("etudiant pas inscrit dans la biblio");
            }
        }else {
            throw new LivreException("Livre pas trouve dans la biblio");
        }
        
    }
    
    public void notifyObservers(){
        for(Observer o:this.observers){
            o.update(this , null);
        }
    }

    public int getDisponible() {
        int count = 0 ;
        
        for(Livre livre : biblio){
            if(livre.etudiant == null){
                count++;
            }
        }
        
      return count;
    }

    public int getPreter() {
        return biblio.size() - this.getDisponible();
    }
    
    public ArrayList<Livre> getLivreEmprunte(){
        ArrayList<Livre> livreEmprunter = new ArrayList<Livre>();
        for(Livre livre :biblio){
            if(livre.etudiant != null){
                livreEmprunter.add(livre);
            }
        }
        return livreEmprunter;
    }
    
    @Override
    public void addObserver(Observer o){
        this.observers.add(o);
    }
    
    
}
