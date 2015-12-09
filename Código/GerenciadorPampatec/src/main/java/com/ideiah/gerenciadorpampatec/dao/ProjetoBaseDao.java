/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.model.ProjetoBase;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author AndersonR
 */
public class ProjetoBaseDao extends Dao implements Serializable {

    public boolean salvar(ProjetoBaseDao projetoBase) {
        return super.salvar(projetoBase);
    }
    
    public ProjetoBase buscarPorStatus(int status) {
        return (ProjetoBase) buscarObjetoCriteriaINT("status", status, ProjetoBase.class);
    }
    
    public ArrayList<ProjetoBase> buscar() {
        return (ArrayList<ProjetoBase>) buscarObjetos(ProjetoBase.class);
    }
    
    public ArrayList<ProjetoBase> buscarPorReferencia(Projeto pb) {
        return (ArrayList<ProjetoBase>) buscarObjetoCriteria("projetoReferencia", pb, ProjetoBase.class);
    }
}
