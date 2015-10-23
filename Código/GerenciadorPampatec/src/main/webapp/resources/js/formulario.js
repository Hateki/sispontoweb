// This file is autogenerated via the `commonjs` Grunt task. You can require() this file in a CommonJS environment.


var precisaSalvar = false;

/*
 * Funções de exibição de Informações
 * relativa as funcionalidades dos botões
 */

/*
 * Funções de Retorno de etapas no 
 * formulário de Envio de Plano de Negócio
 */

function retornaPrimeiraParte() {
    $("#formularioParte02").fadeOut(1);
    $("#formularioParte01").fadeIn(1);
}
function retornaSegundaParte() {
    $("#formularioParte03").fadeOut(1);
    $("#formularioParte02").fadeIn(1);
}
function retornaTerceiraParte() {
    $("#formularioParte04").fadeOut(1);
    $("#formularioParte03").fadeIn(1);
}
function retornaQuartaParte() {
    $("#formularioParte05").fadeOut(1);
    $("#formularioParte04").fadeIn(1);
}
function retornaQuintaParte() {
    $("#formularioParte06").fadeOut(1);
    $("#formularioParte05").fadeIn(1);
}

/*
 * Fim das funções de retorno de etapas do formulário --------------------------
 */

/*
 * Início das funções de exibição das próximas
 * etapas do formulário de Envio do Plano de Negócio
 */

function exibeSegundaParte() {
    $("#formularioParte01").fadeOut(1);
    $("#formularioParte02").fadeIn(1);
}
function exibeTerceiraParte() {
    $("#formularioParte02").fadeOut(1);
    $("#formularioParte03").fadeIn(1);
}
function exibeQuartaParte() {
    $("#formularioParte03").fadeOut(1);
    $("#formularioParte04").fadeIn(1);
}
function exibeQuintaParte() {
    $("#formularioParte04").fadeOut(1);
    $("#formularioParte05").fadeIn(1);
}
function exibeSextaParte() {
    $("#formularioParte05").fadeOut(1);
    $("#formularioParte06").fadeIn(1);
}

/*
 * Fim das funções de exibição
 * das próximas etapas do fomulário
 * de envio do plano de negócio
 * -----------------------------------------------------------------
 */

function carregaFeedBack() {
    var feedBack = document.getElementById("formulario_cadastro_projeto:modal-feedBackSalvar");
    feedBack.setAttribute("class", "modal-feedBackSalvar modal-feedBackSalvar-in");
}

function fechaFeedBack() {
    var feedBack = document.getElementById("formulario_cadastro_projeto:modal-feedBackSalvar");
    feedBack.style.display = "none";
}

function  verificarCampos() {
    verificaContatos();
    verificaNegocio();
    verificaAnaliseMercado();
    verificarProdutoServico();
    verificaGestaoPessoas();
    verificaPlanoFinanceiro();
}



function verificaContatos() {
    var empresaProjeto = document.getElementById("formulario_cadastro_projeto:empresaProjeto");
    var tabContato = document.getElementById("tabContato");
    mudarCor(empresaProjeto, tabContato);
}

function verificaNegocio() {
    var segmentoDeClientes = document.getElementById("formulario_cadastro_projeto:segmentoDeClientes");
    var propostaDeValor = document.getElementById("formulario_cadastro_projeto:propostaDeValor");
    var atividadesChave = document.getElementById("formulario_cadastro_projeto:atividadesChave");
    var tabNegocio = document.getElementById("tabNegocio");
    var listaCampos = new Array();
    listaCampos[0] = segmentoDeClientes;
    listaCampos[1] = propostaDeValor;
    listaCampos[2] = atividadesChave;
    mudarCorLista(listaCampos, tabNegocio);

}

function verificaAnaliseMercado() {
    var relacoComClientes = document.getElementById("formulario_cadastro_projeto:relacoComClientes");
    var parceriasChaves = document.getElementById("formulario_cadastro_projeto:parceriasChaves");
    var canais = document.getElementById("formulario_cadastro_projeto:canais");
    var recursosPrincipais = document.getElementById("formulario_cadastro_projeto:recursosPrincipais");
    var concorrentes = document.getElementById("formulario_cadastro_projeto:concorrentes");
    var tabAnaliseMercado = document.getElementById("tabAnaliseMercado");
    var listaCampos = new Array();
    listaCampos[0] = relacoComClientes;
    listaCampos[1] = parceriasChaves;
    listaCampos[2] = canais;
    listaCampos[3] = recursosPrincipais;
    listaCampos[4] = concorrentes;
    mudarCorLista(listaCampos, tabAnaliseMercado);
}

function verificarProdutoServico() {
    var tecnologiaProcessos = document.getElementById("formulario_cadastro_projeto:tecnologiaProcessos");
    var potencialInovacaoTecnologica = document.getElementById("formulario_cadastro_projeto:potencialInovacaoTecnologica");
    var aplicacoes = document.getElementById("formulario_cadastro_projeto:aplicacoes");
    var dificuldadesEsperadas = document.getElementById("formulario_cadastro_projeto:dificuldadesEsperadas");
    var interacaoEmpresaUniversidade = document.getElementById("formulario_cadastro_projeto:interacaoEmpresaUniversidade");
    var interacaoEmpresaComunidadeGoverno = document.getElementById("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno");
    var infraestrutura = document.getElementById("formulario_cadastro_projeto:infraestrutura");
    var tabProdutoServico = document.getElementById("tabProdutoServico");
    var listaCampos = new Array();

    listaCampos[0] = tecnologiaProcessos;
    listaCampos[1] = potencialInovacaoTecnologica;
    listaCampos[2] = aplicacoes;
    listaCampos[3] = dificuldadesEsperadas;
    listaCampos[4] = interacaoEmpresaUniversidade;
    listaCampos[5] = interacaoEmpresaComunidadeGoverno;
    listaCampos[6] = infraestrutura;
    mudarCorLista(listaCampos, tabProdutoServico);
    verificarPreenchimentoRadioButton();
}

function verificaGestaoPessoas() {
    var participacaoAcionaria = document.getElementById("formulario_cadastro_projeto:participacaoAcionaria");
    var potencialEmprego = document.getElementById("formulario_cadastro_projeto:potencialEmprego");
    var tabGestaoPessoas = document.getElementById("tabGestaoPessoas");
    var listaCampos = new Array();
    listaCampos[0] = participacaoAcionaria;
    listaCampos[1] = potencialEmprego;
    mudarCorLista(listaCampos, tabGestaoPessoas);
}

function verificaPlanoFinanceiro() {
    var fontesDeReceita = document.getElementById("formulario_cadastro_projeto:fontesDeReceita");
    var estruturaCustos = document.getElementById("formulario_cadastro_projeto:estruturaCustos");
    var investimentoInicial = document.getElementById("formulario_cadastro_projeto:investimentoInicial");
    var custosfixos = document.getElementById("formulario_cadastro_projeto:custosfixos");
    var custosvariaveis = document.getElementById("formulario_cadastro_projeto:custosvariaveis");
    var tabPlanoFinanceiro = document.getElementById("tabPlanoFinanceiro");
    var listaCampos = new Array();

    listaCampos[0] = fontesDeReceita;
    listaCampos[1] = estruturaCustos;
    listaCampos[2] = investimentoInicial;
    listaCampos[3] = custosfixos;
    listaCampos[4] = custosvariaveis;

    mudarCorLista(listaCampos, tabPlanoFinanceiro);
}

function mudarCorLista(listaCampos, tab) {
    var flagCompleto = false;
    for (var i = 0; i < listaCampos.length; i++) {
        if (verificaPreenchimento(listaCampos[i])) {
            flagCompleto = true;
        } else {
            flagCompleto = false;
            break;
        }
    }

    if (flagCompleto) {
        tab.style.color = "green";
    } else {
        tab.style.color = "red";
    }
}

function verificaContatos() {
    var empresaProjeto = document.getElementById("formulario_cadastro_projeto:empresaProjeto");
    var tabContato = document.getElementById("tabContato");
    mudarCor(empresaProjeto, tabContato);
}

function mudarCor(campo, tab) {
    if (verificaPreenchimento(campo)) {
        tab.style.color = "green";
    } else {
        tab.style.color = "red";
    }
}

function verificaPreenchimento(campo) {
    if (campo.value.trim() === "") {
        return false;
    } else {
        return true;
    }
}

window.onbeforeunload = function () {
    if (precisaSalvar) {
        return "Você têm alterações que ainda não foram salvas.Têm certeza que quer sair da página?";
    }
};

//trim completo
String.prototype.trim = function () {
    return this.replace(/^\s+|\s+$/g, "");
};


function verificarPreenchimentoRadioButton() {
    var elementos = document.getElementsByClassName('ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active');
    for (var i = 0; i < elementos.length; i++) {
        console.log("Deu");
    }
}

function percorrerArvoreObejetos(listaComponentes, pai, contador) {
    for (var i = 0; i < pai.children.length; i++) {
        if (pai.children[i].tagName === listaComponentes[contador]) {
            console.log("Nome da tag" + pai.children[i].tagName);
            console.log("Nome procurado" + listaComponentes[contador]);
            console.log(pai.children[i].className);
            if (contador === 5 && pai.children[i].className === "ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active") {
                console.log("DEEEEUUUUUUUUU");
            }
            contador++;
            percorrerArvoreObejetos(listaComponentes, pai.children[i], contador);
        }
    }
}




function infoSalvar() {
    $("#modalInfoSalvar").modal();
}

function confirmacaoDeEnvio() {
    $("#modalInfoDeEnvio").modal();
}

/**
 * Metodo que exibe ou esconde os campos de adicionar comentarios na realizar pré-avaliação
 * @param {type} id
 * @returns {undefined}
 */
function mostrarFeedBack(id) {
    var campo = document.getElementById(id);
    if ($(campo).hasClass("form-control campoFeedBackOn")) {
        $(campo).fadeOut(900);
        campo.setAttribute("class", "form-control campoFeedBack");
    } else {
        $(campo).fadeIn(900);
        campo.setAttribute("class", "form-control campoFeedBackOn");
    }
}

/**
 * Metodo que libera ou bloqueia componentes da tela conforme o status do projeto
 * @returns {undefined}
 */

function carregaPagina() {

    var etapa1 = document.getElementById("etapa1");
    var etapa2 = document.getElementById("etapa2");
    var etapa3 = document.getElementById("etapa3");
    var etapa4 = document.getElementById("etapa4");
    var etapa5 = document.getElementById("etapa5");

//        switch (andamentoProjeto) {
    switch (1) {
        case 0:
            etapa2.innerHTML = "<b>Pré-Avaliação</b>";
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active, etapaAtual");
            mostra_vertical_elaboracao();
            var botao_preavaliacao = document.getElementById("botao_elaboracao_editar");
            botao_preavaliacao.setAttribute("class", "botaoselecionado");

            break;
        case 1:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual");
            var botao_preavaliacao = document.getElementById("botao_preavaliacao");
            mostra_vertical_pre_avaliacao();
            botao_preavaliacao.setAttribute("class", "botaoselecionado");
            agoraVai('divPreVisualizar');
            break;
        case 2:
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            break;
        case 3:
            etapa5.innerHTML = "<b>Incubação</b>";
            break;
        case 4:
            etapa1.setAttribute("class", "active, etapaAtual");
            break;
        case 5:
            etapa3.innerHTML = "<b>Avaliação</b>";
            etapa4.innerHTML = "<b>Formalização</b>";
            etapa5.innerHTML = "<b>Incubação</b>";
            etapa1.setAttribute("class", "active");
            etapa2.setAttribute("class", "active, etapaAtual");
            var botao_preavaliacao = document.getElementById("botao_preavaliacao");
            mostra_vertical_pre_avaliacao();
            botao_preavaliacao.setAttribute("class", "botaoselecionado");
            break
    }
}

/**
 * Metodo que exibe o menu vertical da etapa elaboração
 */
function mostra_vertical_elaboracao() {
//    var etapa1 = document.getElementById("etapa1");
//    etapa1.setAttribute("class", "active, etapaAtual");

//    carregaPagina();

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "col-md-2 text-center bounceInLeft animated");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}
/**
 * Metodo que exibe o menu vertical da etapa Pré-Avalição
 */
function mostra_vertical_pre_avaliacao() {

//    var etapa2 = document.getElementById("etapa2");
//    etapa2.setAttribute("class", "active, etapaAtual");
//
//    var etapa1 = document.getElementById("etapa1");
//    etapa1.setAttribute("class", "active");

//    carregaPagina();

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}
function mostra_avaliacao() {
//    var etapa3 = document.getElementById("etapa3");
//    etapa3.setAttribute("class", "active, etapaAtual");
//
//    var etapa1 = document.getElementById("etapa1");
//    etapa1.setAttribute("class", "active");
//    var etapa2 = document.getElementById("etapa2");
//    etapa2.setAttribute("class", "active");

    carregaPagina();

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}
function mostra_formalizacao() {
//    var etapa4 = document.getElementById("etapa4");
//    etapa4.setAttribute("class", "active, etapaAtual");

//    var etapa1 = document.getElementById("etapa1");
//    etapa1.setAttribute("class", "active");
//    var etapa2 = document.getElementById("etapa2");
//    etapa2.setAttribute("class", "active");
//    var etapa3 = document.getElementById("etapa3");
//    etapa3.setAttribute("class", "active");

//    carregaPagina();

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "esconder-div");
}
function mostra_incubacao() {
//    var etapa5 = document.getElementById("etapa5");
//    etapa5.setAttribute("class", "active, etapaAtual");
//
//    var etapa1 = document.getElementById("etapa1");
//    etapa1.setAttribute("class", "active");
//    var etapa2 = document.getElementById("etapa2");
//    etapa2.setAttribute("class", "active");
//    var etapa3 = document.getElementById("etapa3");
//    etapa3.setAttribute("class", "active");
//    var etapa4 = document.getElementById("etapa4");
//    etapa4.setAttribute("class", "active");

//    carregaPagina();

    var divElaboracao = document.getElementById("vertical_etapa_elaboracao");
    divElaboracao.setAttribute("class", "esconder-div");
    var divPreAvaliacao = document.getElementById("vertical_etapa_pre_avaliacao");
    divPreAvaliacao.setAttribute("class", "esconder-div");
    var divAvaliacao = document.getElementById("vertical_etapa_avaliacao");
    divAvaliacao.setAttribute("class", "esconder-div");
    var divFormalizacao = document.getElementById("vertical_etapa_formalizacao");
    divFormalizacao.setAttribute("class", "esconder-div");
    var divIncubacao = document.getElementById("vertical_etapa_incubacao");
    divIncubacao.setAttribute("class", "col-md-2 text-center bounceInLeft animated");
}

/**
 * Função que bloqueia todos os campos da tela EnviarProjeto. Para o Empreendedor apenas poder visualizar e não editar.
 */
function bloquearCampos() {
    var d = document.getElementById('myTabContent').getElementsByTagName('input');
    var botaoOutro = document.getElementById('formulario_cadastro_projeto:estagioDeEvolucao');
    botaoOutro.disabled = "true";

    for (var i = 0; i < d.length; i++) {
//        alert(d[i].value);
        d[i].disabled = "true";
    }
    var d2 = document.getElementById('myTabContent').getElementsByTagName('textarea');
    for (var i = 0; i < d2.length; i++) {
//        alert(d[i].value);
        d2[i].disabled = "true";
    }
}

/**
 * Função para alternar entre as DIVS
 */
function agoraVai(referencia) {
//    div1 = document.querySelector(".classeDeTeste");
    div1 = document.getElementsByClassName("classeDeTeste");
    for (var i = 0; i < div1.length; i++) {
//        alert(d[i].value);
//        d2[i].disabled = "true";
        if (div1[i].getAttribute("id") === referencia) {
//            alert("achei");
            div1[i].setAttribute("class", "classeDeTeste col-md-10");
        } else {
            div1[i].setAttribute("class", "classeDeTeste esconder-div");
        }
    }
}
