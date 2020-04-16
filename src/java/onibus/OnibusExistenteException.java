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
public class OnibusExistenteException extends Exception {
    
    public OnibusExistenteException(){
        super("Esse ônibus já está cadastrado no sistema.");
    }
    
}
