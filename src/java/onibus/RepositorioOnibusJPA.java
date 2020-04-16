/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus;

import index.ErroInternoException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import empresas.Empresa;

/**
 *
 * @author Arthur
 */
@Stateless
public class RepositorioOnibusJPA implements RepositorioOnibus, Serializable {

    @PersistenceContext
    private EntityManager em;
    
    public RepositorioOnibusJPA() {
        this.em = Persistence.createEntityManagerFactory("AutoviacaoPasaPU2").createEntityManager();
    }

    @Override
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException {
        try {
            this.em.persist(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
        Onibus onibus = buscarOnibus(id_onibus);
        try {
            this.em.remove(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
               try {
            Onibus onibus = this.em.find(Onibus.class, id_onibus);
            if (onibus == null) {
                throw new OnibusInexistenteException();
            }
            return onibus;
        } catch (OnibusInexistenteException ex) {
            throw ex;
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException {
        buscarOnibus(onibus.getId_onibus());
        try {
            this.em.merge(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }
    
    @Override
        public List<Onibus> listaOnibus(Empresa empresa) throws ErroInternoException {
            TypedQuery<Onibus> listarOnibus = this.em.createQuery("SELECT o FROM Onibus o WHERE o.empresa = :empresa ", Onibus.class);
            listarOnibus.setParameter("empresa", empresa);
            return listarOnibus.getResultList();
        }

}
