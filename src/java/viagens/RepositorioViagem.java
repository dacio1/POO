/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viagens;

import index.ErroInternoException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sabrina Moreira
 */
@Local
public interface RepositorioViagem extends Serializable{
    
    public void adicionar(Viagem v) throws ErroInternoException, ViagemExistenteException;
    
    public void removerViagem(long id_viagem) throws ErroInternoException, ViagemInexistenteException;
    
    public void atualizar(Viagem v) throws ErroInternoException,ViagemInexistenteException;
    
    public Viagem buscarViagem (long id_viagem) throws ErroInternoException, ViagemInexistenteException;
    
    public List<Viagem> consultaViagens(Cidades origem, Cidades destino, Date data) throws ErroInternoException, ViagemInexistenteException;
    

}
    
           