/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import clientes.CadastroClientes;
import clientes.Cliente;
import clientes.ClienteExistenteException;
import clientes.ClienteInexistenteException;
import empresas.CadastroEmpresa;
import empresas.Empresa;
import empresas.EmpresaExistenteException;
import empresas.EmpresaInexistenteException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import onibus.CadastroOnibus;
import onibus.Onibus;
import onibus.OnibusExistenteException;
import onibus.OnibusInexistenteException;
import poltronas.CadastroPoltrona;
import poltronas.Poltrona;
import poltronas.PoltronaIndisponivelException;
import poltronas.PoltronaInexistenteException;
import vendas.CadastroVenda;
import vendas.Venda;
import vendas.VendaInexistenteException;
import viagens.CadastroViagem;
import viagens.Cidades;
import viagens.Viagem;
import viagens.ViagemExistenteException;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class Fachada implements Serializable {

    @EJB
    private CadastroClientes cadCliente;
    @EJB
    private CadastroEmpresa empresa;
    @EJB
    private CadastroOnibus cadOnibus;
    @EJB
    private CadastroPoltrona poltrona;
    @EJB
    private CadastroVenda venda;
    @EJB
    private CadastroViagem viagem;

    public Fachada() {

    }

    public void adicionar(Cliente cliente) throws ErroInternoException, ClienteExistenteException, ClienteInexistenteException {
        this.cadCliente.adicionar(cliente);
    }

    public Cliente buscarCliente(long id_cliente) throws ClienteInexistenteException, ErroInternoException {
        return this.cadCliente.buscarCliente(id_cliente);
    }

    public void atualizar(Cliente c) throws ClienteInexistenteException, ErroInternoException {
        this.cadCliente.atualizar(c);
    }

    public void remover(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        this.cadCliente.remover(id_cliente);
    }

    public Cliente loginCliente(String cpf, String senha) throws ErroInternoException, ClienteInexistenteException {
        return this.cadCliente.loginCliente(cpf, senha);
    }

    public List<Cliente> listaCliente(Cliente cliente) throws ErroInternoException {
        return this.cadCliente.listaClientes(cliente);
    }

    public void adicionar(Empresa ep) throws ErroInternoException, EmpresaExistenteException {
        this.empresa.adicionar(ep);

    }

    public List<Empresa> listaEmpresa() throws ErroInternoException {
        return this.empresa.listaEmpresa();
    }

    public void remove(long Id_empresa) throws EmpresaInexistenteException, ErroInternoException {
        this.empresa.remove(Id_empresa);
    }

    public Empresa buscarEmpresa(long Id_empresa) throws EmpresaInexistenteException, ErroInternoException {
        return this.empresa.buscarEmpresa(Id_empresa);
    }

    public void atualizar(Empresa ep) throws EmpresaInexistenteException, ErroInternoException {
        this.empresa.atualizar(ep);
    }

    public Empresa loginEmpresa(String cnpj, String senha) throws ErroInternoException, EmpresaInexistenteException {
        return this.empresa.loginEmpresa(cnpj, senha);
    }
    
    public List<Viagem> listarViagens (Empresa empresa) throws ErroInternoException{
        return this.empresa.listarViagens(empresa);
    }

    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException {
        this.cadOnibus.cadastrar(onibus);
    }

    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
        return this.cadOnibus.buscarOnibus(id_onibus);
    }

    public List<Onibus> listaOnibus(Empresa empresa) throws ErroInternoException, OnibusInexistenteException {
        return this.cadOnibus.listaOnibus(empresa);
    }

    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException {
        this.cadOnibus.editar(onibus);
    }

    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
        this.cadOnibus.excluir(id_onibus);
    }

    public void adicionar(Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException {
        this.poltrona.adicionar(p);
    }

    public List<Poltrona> listar(long id_viagem) throws ErroInternoException {
        return this.poltrona.listar(id_viagem);
    }

    public Poltrona buscarPoltrona(long id_poltrona) throws ErroInternoException, PoltronaInexistenteException {
        return this.poltrona.buscarPoltrona(id_poltrona);
    }

    public void adicionar(Venda venda) throws ErroInternoException {
        this.venda.adicionar(venda);
    }

    public Venda buscarVenda(long id) throws ErroInternoException, VendaInexistenteException {
        return this.venda.buscarVenda(id);
    }

    public List<Venda> vendasPorViagem(long id_viagem) throws ErroInternoException, VendaInexistenteException {
        return this.venda.vendasPorViagem(id_viagem);
    }

    public void adicionar(Viagem v) throws ErroInternoException, ViagemExistenteException {
        this.viagem.adicionar(v);
    }

    public void removeViagem(long Id_viagem) throws ViagemInexistenteException, ErroInternoException {
        this.viagem.removeViagem(Id_viagem);
    }

    public Viagem buscarViagem(long Id_viagem) throws ViagemInexistenteException, ErroInternoException {
        return this.viagem.buscarViagem(Id_viagem);
    }

    public void atualizar(Viagem v) throws ViagemInexistenteException, ErroInternoException {
        this.viagem.atualizar(v);
    }

    public List<Viagem> consultaViagens(Cidades origem, Cidades destino, Date data) throws ErroInternoException, ViagemInexistenteException {
        return this.viagem.consultaViagens(origem, destino, data);
    }

    public List<Long> poltronasCompradas(Viagem viagem) throws ErroInternoException {
        return this.poltrona.poltronasCompradas(viagem);
    }

    public List<Venda> listarVendasCliente(Cliente cliente) throws ErroInternoException {
        return this.venda.listarVendasCliente(cliente);
    }
}
