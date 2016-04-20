/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ComentarioDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ideiah
 */
@ManagedBean
@ViewScoped
public class PreAvaliarPlanoBean implements Serializable {

    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private int resultadoPreAvaliacao;
    private int contAnterior;

    public PreAvaliarPlanoBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        ComentarioDao comentarioDao = new ComentarioDao();

        //Gambiarra para resolver o problema do usuário deixar a página.
        //Quando o usuário acessa a pagina de pré-avaliar ou atualiza a
        //página, o construtor é chamado adionando um ao contador de acessos do projeto.
        //Se ele sair pra qualquer página esse contrutor não será chamado.
        //Com isso é possível identificar quando a página foi atualizada, pois
        //o contador de acesso será incrementado quando isso acontecer.
        //Para saber se o status deve ser mudado ou não é necessessário comparar
        //o contador do projeto e o valor desse contador anteriormente(contAnterior). 
        projeto.setContAcesso(projeto.getContAcesso() + 1);
        contAnterior = projeto.getContAcesso();

        buscarComentarioProjeto(projeto);

        mudaStatus();

        if (comentarioProjeto == null) {
            comentarioProjeto = new ComentarioProjeto();
            comentarioProjeto.setProjeto(projeto);
            comentarioProjeto = comentarioDao.salvarRetornandoComentarioProjeto(comentarioProjeto);
        }
    }

    /**
     * Construtor da classe utilizado para testes, recebe um projeto como
     * parâmetro ao invés de pela sessão, assim os testes podem ser realizados
     *
     * @param proj
     */
    public PreAvaliarPlanoBean(Projeto proj) {
        this.projeto = proj;
        ComentarioDao comentarioDao = new ComentarioDao();

        buscarComentarioProjeto(proj);

        if (comentarioProjeto == null) {
            comentarioProjeto = new ComentarioProjeto();
            comentarioProjeto.setProjeto(proj);
            comentarioProjeto = comentarioDao.salvarRetornandoComentarioProjeto(comentarioProjeto);
        }
    }

    public void mudaStatus() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto.setStatus(Projeto.SENDO_AVALIADO);
        ProjetoDao dao = new ProjetoDao();
        dao.update(projeto);
        session.setAttribute("projetoSelecionado", projeto);
    }

    public void buscarComentarioProjeto(Projeto projetoSelecionado) {
        for (ComentarioProjeto comentarioProjeto : projetoSelecionado.getComentarioProjeto()) {
            if (comentarioProjeto.getStatus() == ComentarioProjeto.EM_ANDAMENTO) {
                this.comentarioProjeto = comentarioProjeto;
            }
        }
        if (comentarioProjeto != null) {
            if (projeto.getStatusTemp() == null) {
                resultadoPreAvaliacao = 99;
            } else {
                resultadoPreAvaliacao = projeto.getStatusTemp();
            }
        }
    }

    /**
     * <p>
     * Método para verificar qual o tipo de estágio a empresa se encontra.
     * </p>
     *
     * @return
     */
    public String verificaEstagioEvolucao() {
        String status = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        if (status.equals("Outro:")) {
            return projeto.getProdutoouservico().getEstagioEvolucao();
        } else {
            return status;
        }
    }

    /**
     * Muda o status do projeto em pré avaliação e redireciona para o início
     */
    public void mudaStatusRedirecionaInicio() {
        mudaStatusProjetoParaEmPreAvaliacao(projeto);
        loginBean.getInicioGerente();

    }

    public void mudaStatusRedirecionaLista() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //Gambiarra para resolver o problema do usuário deixar a página
        if (contAnterior == projeto.getContAcesso()) {
            mudaStatusProjetoParaEmPreAvaliacao(projeto);
            session.removeAttribute("projetoSelecionado");
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mudaStatusFazLogout() {
        mudaStatusProjetoParaEmPreAvaliacao(projeto);
        loginBean.fazLogout();
    }

    /**
     * Salva a preavaliao do projeto realizada pelo Gerente de Relacionamentos
     * para posterior continuar editando o mesmo.
     */
    public void salvar() {
        
        Date data = new Date(System.currentTimeMillis());
        projeto.setDataAvaliacao(data);

        ComentarioDao comentDao = new ComentarioDao();
        comentarioProjeto.setProjeto(projeto);
        comentDao.salvar(comentarioProjeto);
        
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.setStatusTemp(getResultadoPreAvaliacao());
        projetoDao.salvar(projeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteração foi salva com sucesso.");
        FacesContext.getCurrentInstance().addMessage("formulario_comentarpreavalizar:tituloMensagem", msg);
    }

    /**
     * <p>
     * Método para salvar o pré-projeto quando via botão salvar pré-avaliação.
     * </p>
     */
    public void salvarPreAvaliacao() {
        ComentarioDao comentDao = new ComentarioDao();
        comentarioProjeto.setProjeto(projeto);
        comentDao.salvar(comentarioProjeto);
        
        ProjetoDao projetoDao = new ProjetoDao();
        projeto.setStatusTemp(getResultadoPreAvaliacao());
        projetoDao.salvar(projeto);        

        getBuscarPlanoDeNegocio();
    }
    
    /**
     *
     * @param projSelect
     */
    public void mudaStatusProjetoParaSendoAvaliado(Projeto projSelect) {

        if (projSelect.getStatus() == Projeto.SUBMETIDO) {
            projSelect.setStatus(Projeto.SENDO_AVALIADO);
            ProjetoDao dao = new ProjetoDao();
            dao.update(projSelect);
        }
    }

    /**
     *
     * @param projSelect
     */
    public void mudaStatusProjetoParaEmPreAvaliacao(Projeto projSelect) {
        if (projSelect.getStatus() == Projeto.SENDO_AVALIADO) {
            projSelect.setStatus(Projeto.EM_PRE_AVALIACAO);
            ProjetoDao dao = new ProjetoDao();
            dao.update(projSelect);
        }
    }

    /**
     * <p>
     * Método que finaliza a avaliação do projeto, muda o seu status, bem como o
     * dos comentários.</p>
     */
    public void terminarPreAvaliacao() {
        if (validaAvaliacao()) {
            if (projeto.getStatus() == Projeto.SENDO_AVALIADO) {
                projeto.setStatus(getResultadoPreAvaliacao());
                
                mudaStatusComentarioProjetoFinalizar();
                
                ProjetoDao projDao = new ProjetoDao();
                projDao.salvar(projeto);
                
                getBuscarPlanoDeNegocio();
            }
        }
    }

    /**
     * <p>
     * Método para atualizar o status dos comentários ao finalizar a avaliação.
     * </p>
     */
    private void mudaStatusComentarioProjetoFinalizar() {
        ComentarioDao comentarioDao = new ComentarioDao();
        if (Objects.equals(comentarioProjeto.getProjeto().getIdProjeto(), projeto.getIdProjeto())) {
            comentarioProjeto.setStatus(ComentarioProjeto.FINALIZADO);
            comentarioDao.update(comentarioProjeto);
        }
    }

    /**
     * <p>
     * Redireciona para a página de lista de Planos de Negócio.
     * </p>
     */
    private void getBuscarPlanoDeNegocio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * <p>
     * Método responsável por preencher o campo Observações com a mensagem
     * pré-definida, de acordo com a seleção do usuário.
     * </p>
     */
    public void preencheCampoObservacao() {
        switch (resultadoPreAvaliacao) {
            case Projeto.NECESSITA_MELHORIA:
                comentarioProjeto.setConsideracoes("O seu plano de negócio precisa de ajustes. Leia os comentários de cada item preenchido do plano de negócio e faça as alterações necessárias.");
                break;
            case Projeto.ACEITO_PARA_AVALIACAO:
                comentarioProjeto.setConsideracoes("O seu plano de negócio foi aprovado. Aguarde o agendamento da entrevista.");
                break;
            case Projeto.REPROVADO:
                comentarioProjeto.setConsideracoes("O seu plano de negócio foi reprovado.");
                break;
            default:
                break;
        }
        salvar();
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

    public int getResultadoPreAvaliacao() {
        return resultadoPreAvaliacao;
    }

    public void setResultadoPreAvaliacao(int resultadoPreAvaliacao) {
        this.resultadoPreAvaliacao = resultadoPreAvaliacao;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }


    /**
     *
     * @return
     */
    public boolean campoObservacoesVazio(){
        boolean resultado;
        resultado = comentarioProjeto.getConsideracoes().equals("");
        return resultado;
    }

    /**
     * <p>
     * METODO PARA VALIDAR O PREENCHIMENTO DOS CAMPOS COMENTARIO NA AVALIAÇÃO DO PLANO.
     *O BOTAO TERMINAR AVALIAÇÃO FICARÁ ABILITADO SE E SOMENTE SE:
     * foi selecionado um dos campos aprovado, reprovado ou realizar ajustes
     * se o campo realizar ajustes for selecionado, é necessário existir ao menos um comentario
     *além das observações </p>
     * @return Quantidade de erros
     */
    public boolean validaAvaliacao(){
        int flag_erro = 0;
        //O campo observacoes precisa estar preenchido 
        // aprovado = 2, melhorias, = 7 reprovado, = 6
        
        // se o resultado da pre avaliação for melhorias, é necessário inserir comentários no plano
        if(resultadoPreAvaliacao == 7){
            if(comentarioProjeto.verificaCampos() == 0){
                FacesUtil.addErrorMessage("Você precisa comentar pelo menos um campo para pedir melhorias no plano de negócio.", 
                        "formulario_comentarpreavalizar:statusAvaliacao");
                flag_erro++;
            }
        }
        // se o resultado da pre avaliaçao for zero, significa que nenhum campo foi selecionado
        if(resultadoPreAvaliacao == 0){
            FacesUtil.addErrorMessage("Você precisa selecionar um status de Avaliação.", 
                        "formulario_comentarpreavalizar:statusAvaliacao");
            flag_erro++;
        }
       
        return flag_erro == 0;


    }

    /**
     * <p>
     * Método para mudar o status dos comentários automaticamente.
     * </p>
     */
    public void mudaStatusComentarioProjetoFilanizar() {

        if (comentarioProjeto.getProjeto().getIdProjeto() == projeto.getIdProjeto()) {
            comentarioProjeto.setStatus(2);
        }
    }

}
