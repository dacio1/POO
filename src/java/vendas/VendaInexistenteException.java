/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vendas;

/**
 *
 * @author Sabrina Moreira
 */
public class VendaInexistenteException extends Exception {
    public VendaInexistenteException(){
        super("A venda não existe!");
    }
    
}
