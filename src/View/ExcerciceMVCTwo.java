/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Biblioteque;

/**
 *
 * @author Aanthony
 */
public class ExcerciceMVCTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteque biblio = new Biblioteque();
        
        NombreLivre nbLivre = new NombreLivre();
        TableEmprunt  table= new TableEmprunt();
        nbLivre.init(biblio);
        table.init(biblio);
        Controller controller = new Controller(biblio) ;
        
    }
    
}
