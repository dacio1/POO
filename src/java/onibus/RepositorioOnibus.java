/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import empresas.Empresa;
import index.ErroInternoException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arthur
 */
@Local
public interface RepositorioOnibus extends Serializable{
    
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException;
    
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException;
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException;
    
    public Onibus buscarOnibus(long id) throws ErroInternoException, OnibusInexistenteException;
    
    public List<Onibus> listaOnibus(Empresa empresa) throws ErroInternoException, OnibusInexistenteException;
}
