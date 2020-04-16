/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author Dacio
 */
public class ClienteExistenteException extends Exception {
    public ClienteExistenteException(){
        super("O cliente já está cadastrado!");
    }
}
