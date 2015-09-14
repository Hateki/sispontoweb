/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean(name = "empreendedorBean")
@SessionScoped
public class EmpreendedorBean {

    private String outcome = "LoginEmpreendedor";
    private String userInput = "";
    private String senhaInput = "";
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String formacao;
    private String experiencia;
    private String competencia;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private Empreendedor empreendedor;
    private HttpSession session;
    
    public EmpreendedorBean(){
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void chamaCadastro() {
        System.out.println("Entrou no CHAMA CADASTRO da Bean");

        empreendedor = new Empreendedor();

        empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
        }
        
        else {
            empreendedor.setCpf(cpf);
            empreendedor.setFormacao(formacao);
            if (empreendedor.buscarPorEmail(email) != null) {
                FacesUtil.addErrorMessage("Email já cadastrado!", "formularioCadastro:email");
            } else {
                if (CpfUtil.isValidCPF(cpf) == false) {
                    FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
                } else {
                    empreendedor.setEmail(email);
                    empreendedor.setTelefone(telefone);
                    empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
                    empreendedor.setRua(rua);
                    empreendedor.setNumero(Integer.parseInt(numero));
                    empreendedor.setBairro(bairro);
                    empreendedor.setComplemento(complemento);
                    empreendedor.setExperiencia(experiencia);
                    empreendedor.setCompetencia(competencia);

                    if (empreendedor.cadastrarEmpreendedor(empreendedor)) {
                        FacesUtil.addSuccessMessage("Cadastro realizado com sucesso!", "formularioCadastro:botaoEnviar");
                        try {
                            LoginBean.MudarNome(empreendedor.getNome());
                            LoginBean.MudarSenha(empreendedor.getSenha());
                            LoginBean.MudarUser(empreendedor.getEmail());
                            session.setAttribute("empreendedor", empreendedor);
                            FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/view/homeEmpreendedor.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        FacesUtil.addErrorMessage("Cadastro não realizado.!", "formularioCadastro:botaoEnviar");
                    }
                }
            }
        }
    }

//    public void chamaLogin() {
//        empreendedor.fazLogin();
//    }
    /**
     * @return the senhaInput
     */
    public String getSenhaInput() {
        return senhaInput;
    }

    /**
     * @param senhaInput the senhaInput to set
     */
    public void setSenhaInput(String senhaInput) {
        this.senhaInput = senhaInput;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the formacao
     */
    public String getFormacao() {
        return formacao;
    }

    /**
     * @param formacao the formacao to set
     */
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the empreendedor
     */
    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    /**
     * @param empreendedor the empreendedor to set
     */
    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    /**
     * @return the experiencia
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the competencia
     */
    public String getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }
}
