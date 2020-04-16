/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens;

import empresas.Empresa;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import onibus.Onibus;

/**
 *
 * @author Sabrina Moreira
 */
@Entity
public class Viagem implements Serializable {

    private Cidades origem;
    private Cidades destino;
    private List<Cidades> listaCidades;
    private Date hora;
    private Date data;
    private Onibus onibus;
    private Empresa empresa;
    private long id_viagem;
    private double valor;

    public Viagem() {

    }

    public Viagem(Cidades origem, Cidades destino, Date hora, Date data, Onibus onibus, Empresa empresa, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.hora = hora;
        this.data = data;
        this.onibus = onibus;
        this.empresa = empresa;
        this.valor = valor;
    }

    /*public void set(Viagem v){
     this.destino= v.destino;
     this.data = v.data;
     this.hora = v.hora;
     this.origem = v.origem;
     this.id_viagem = v.id_viagem;
     this.onibus = v.onibus;
     this.empresa = v.empresa;
        
     }*/
    @Enumerated(EnumType.STRING) 
    public Cidades getOrigem() {
        return origem;
    }

    public void setOrigem(Cidades origem) {
        this.origem = origem;
    }

    @Enumerated(EnumType.STRING) 
    public Cidades getDestino() {
        return destino;
    }

    public void setDestino(Cidades destino) {
        this.destino = destino;
    }

    @Temporal(TemporalType.TIME)
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Temporal(TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne
    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(long id_viagem) {
        this.id_viagem = id_viagem;
    }

    @ManyToOne
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toString() {
        return super.toString() + "\n" + this.data + "\n" + this.destino + "/n" + this.hora + "\n" + this.onibus + "/n" + this.id_viagem + "\n" + this.origem + "\n" + this.empresa + "\n" + this.valor;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (Viagem.class != o.getClass()) {
            return false;
        }
        Viagem v = (Viagem) o;
        return (this.data.equals(v.data) && this.destino.equals(v.destino) && this.hora.equals(v.hora) && this.origem.equals(v.origem) && this.onibus.equals(v.onibus) && this.empresa.equals(v.empresa) && super.equals(o));

    }

    @Transient
    public List<Cidades> getListaCidades() {
        return Arrays.asList(Cidades.values());
    }

    public void setListaCidades(List<Cidades> listaCidades) {
        this.listaCidades = listaCidades;
    }
}
