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
     private String custosfixos;
     private String custosvariaveis;
     
    public Planofinanceiro() {
    }

	
    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto) {
        this.idPlanoFinanceiro = idPlanoFinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
    }
    public Planofinanceiro(int idPlanoFinanceiro, String fontesReceita, String estruturaCusto, String investimentoInicial, String custosFixos, String custosVariaveis) {
       this.idPlanoFinanceiro = idPlanoFinanceiro;
       this.fontesReceita = fontesReceita;
       this.estruturaCusto = estruturaCusto;
       this.investimentoInicial = investimentoInicial;
       this.projetos = projetos;
       
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

    /**
     * @return the custosfixos
     */
    public String getCustosfixos() {
        return custosfixos;
    }

    /**
     * @param custosfixos the custosfixos to set
     */
    public void setCustosfixos(String custosfixos) {
        this.custosfixos = custosfixos;
    }

    /**
     * @return the custosvariaveis
     */
    public String getCustosvariaveis() {
        return custosvariaveis;
    }

    /**
     * @param custosvariaveis the custosvariaveis to set
     */
    public void setCustosvariaveis(String custosvariaveis) {
        this.custosvariaveis = custosvariaveis;
    }

    




}


