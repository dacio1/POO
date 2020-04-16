/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import viagens.Viagem;

/**
 *
 * @author Dacio
 */
@Stateless
public class RepositorioPoltronasJPA implements RepositorioPoltronas {

    @PersistenceContext
    private EntityManager em;

    public RepositorioPoltronasJPA() {
        this.em = Persistence.createEntityManagerFactory("AutoviacaoPasaPU2").createEntityManager();
    }

    @Override
    public void adicionar(Poltrona p) throws ErroInternoException, PoltronaIndisponivelException {
        try {
            this.em.persist(p);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public Poltrona buscarPoltrona(long id_poltrona) throws ErroInternoException, PoltronaInexistenteException {
        try {
            Poltrona p = this.em.find(Poltrona.class, id_poltrona);
            if (p == null) {
                throw new PoltronaInexistenteException();
            }
            return p;
        } catch (PoltronaInexistenteException ex){
            throw ex;
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }

    }
    
    @Override
    public List<Long> poltronasCompradas(Viagem viagem) throws ErroInternoException{
        try {
            TypedQuery<Long> listaPoltronas = this.em.createQuery("SELECT p.numero_poltrona FROM Venda v, Poltrona p, Viagem vi WHERE v.id_poltrona.id_poltrona = p.id_poltrona "
                    + "AND v.id_viagem = :viagem", Long.class);
            listaPoltronas.setParameter("viagem", viagem);
            return listaPoltronas.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public List<Poltrona> listar(long id_viagem) throws ErroInternoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
