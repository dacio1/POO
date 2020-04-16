/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clientes.Cliente;
import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import onibus.OnibusExistenteException;
import poltronas.Poltrona;
import vendas.Venda;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanVenda implements Serializable {

    @EJB
    private Fachada fachada;
    private Venda venda;
    private long viagemSelecionada;
    private Cliente cliente;
    private Poltrona poltrona;

    public ManagedBeanVenda() {
        this.venda = new Venda();
    }

    public Venda getVenda() {
        return venda;
    }

    public long getViagemSelecionada() {
        return viagemSelecionada;
    }

    public void setViagemSelecionada(long viagemSelecionada) {
        this.viagemSelecionada = viagemSelecionada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public List<Venda> listarVendasCliente(Cliente cliente) throws ErroInternoException{
        try{
            return this.fachada.listarVendasCliente(cliente);
        } catch (ErroInternoException e){
            throw e;
        }
    }
    public String cadastrarVenda() throws OnibusExistenteException, ErroInternoException {
        try {
            this.venda.setId_cliente(cliente);
            this.venda.setId_poltrona(poltrona);
            this.venda.setId_viagem(this.fachada.buscarViagem(viagemSelecionada));
            this.venda.setData(new Date());
            this.fachada.adicionar(this.venda);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Venda realizada com sucesso");
            contexto.addMessage(null, msg);
            this.venda = new Venda();
            this.poltrona = new Poltrona();
            return "voucher.xhtml";
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
        } catch (ViagemInexistenteException ex) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Viagem Inexistente", " A viagem selecionada não existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }

}
