/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

/**
 *
 * @author Arthur
 */
public class OnibusInexistenteException extends Exception {
    
    public OnibusInexistenteException(){
        super("Esse ônibus não está cadastrado no sistema.");
    }
    
}
