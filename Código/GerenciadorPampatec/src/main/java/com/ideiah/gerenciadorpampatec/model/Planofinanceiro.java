package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Planofinanceiro generated by hbm2java
 */
public class Planofinanceiro  implements java.io.Serializable {


     private int idPlanoFinanceiro;
     private String fontesReceita;
     private String estruturaCusto;
     private String investimentoInicial;
     private Set projetos = new HashSet(0);
     private Set custos = new HashSet(0);

    public Planofinanceiro() {
    }

	
    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
    }
    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto, String investimentoInicial, Set projetos, Set custos) {
       this.idPlanoFinanceiro = idPlanoFinanceiro;
       this.fontesReceita = fontesReceita;
       this.estruturaCusto = estruturaCusto;
       this.investimentoInicial = investimentoInicial;
       this.projetos = projetos;
       this.custos = custos;
    }
   
    public int getIdPlanoFinanceiro() {
        return this.idPlanoFinanceiro;
    }
    
    public void setIdPlanoFinanceiro(int idPlanoFinanceiro) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
    }
    public String getFontesReceita() {
        return this.fontesReceita;
    }
    
    public void setFontesReceita(String fontesReceita) {
        this.fontesReceita = fontesReceita;
    }
    public String getEstruturaCusto() {
        return this.estruturaCusto;
    }
    
    public void setEstruturaCusto(String estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }
    public String getInvestimentoInicial() {
        return this.investimentoInicial;
    }
    
    public void setInvestimentoInicial(String investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }
    public Set getProjetos() {
        return this.projetos;
    }
    
    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }
    public Set getCustos() {
        return this.custos;
    }
    
    public void setCustos(Set custos) {
        this.custos = custos;
    }




}


