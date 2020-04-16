/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import empresas.Empresa;
import index.ErroInternoException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Arthur
 */
@Stateless
public class CadastroOnibus {
    
    @EJB
    private RepositorioOnibus repOnibus;
    
    public CadastroOnibus(){
    }
    
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException{
        try {
            Onibus onibus2 = this.repOnibus.buscarOnibus(onibus.getId_onibus());
            if(onibus2 != null){
                throw new OnibusExistenteException();
            }       
        } catch (OnibusInexistenteException e){
            this.repOnibus.cadastrar(onibus);
        }
    }
    
    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        try{
            return this.repOnibus.buscarOnibus(id_onibus);
        }
        catch(ErroInternoException eie){
            throw new ErroInternoException(eie);
        }
    }
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException{
        this.repOnibus.editar(onibus);
    }
    
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        this.repOnibus.excluir(id_onibus);
    }
    
    public List<Onibus> listaOnibus(Empresa empresa) throws ErroInternoException, OnibusInexistenteException{
        return this.repOnibus.listaOnibus(empresa); 
    }
}
