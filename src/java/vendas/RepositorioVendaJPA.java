/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import clientes.Cliente;
import index.ErroInternoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import viagens.Viagem;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class RepositorioVendaJPA implements RepositorioVenda {

    @PersistenceContext
    private EntityManager em;

    public RepositorioVendaJPA() {
        this.em = Persistence.createEntityManagerFactory("AutoviacaoPasaPU2").createEntityManager();
    }

    @Override
    public void adicionar(Venda ven) throws ErroInternoException {
        try {
            this.em.persist(ven);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }

    }

    public List<Venda> listarVendasCliente(Cliente cliente) throws ErroInternoException {
        try {
            TypedQuery<Venda> query = this.em.createQuery("SELECT v FROM Venda v WHERE v.id_cliente = :cliente", Venda.class);
            query.setParameter("cliente", cliente);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public Venda buscarVenda(long codigo) throws ErroInternoException, VendaInexistenteException {
        try {
            Venda v = this.em.find(Venda.class, codigo);
            if (v == null) {
                throw new VendaInexistenteException();
            }
            return v;
        } catch (VendaInexistenteException ex) {
            throw ex;
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    @Override
    public List<Venda> vendasPorViagem(long id_viagem) throws ErroInternoException {
        try {
            TypedQuery<Venda> query = this.em.createQuery("SELECT v FROM Venda v WHERE v.id_viagem = :id_viagem ", Venda.class);
            query.setParameter("id_viagem", id_viagem);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }
}
