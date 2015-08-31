package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Endereco generated by hbm2java
 */
public class Endereco  implements java.io.Serializable {


     private int idEndereco;
     private String bairro;
     private String rua;
     private Integer numero;
     private String complemento;
     private Set empreendedors = new HashSet(0);

    public Endereco() {
    }

	
    public Endereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public Endereco(int idEndereco, String bairro, String rua, Integer numero, String complemento, Set empreendedors) {
       this.idEndereco = idEndereco;
       this.bairro = bairro;
       this.rua = rua;
       this.numero = numero;
       this.complemento = complemento;
       this.empreendedors = empreendedors;
    }
   
    public int getIdEndereco() {
        return this.idEndereco;
    }
    
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    public Integer getNumero() {
        return this.numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public Set getEmpreendedors() {
        return this.empreendedors;
    }
    
    public void setEmpreendedors(Set empreendedors) {
        this.empreendedors = empreendedors;
    }




}


