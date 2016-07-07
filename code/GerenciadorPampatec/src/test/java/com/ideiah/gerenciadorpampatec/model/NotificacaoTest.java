/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unipampa
 */
public class NotificacaoTest {

    public NotificacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdNotificacao method, of class Notificacao.
     */
    @Test
    public void testConstrutorNotificacao() {
        System.out.println("getIdNotificacao");
        int idNotificacao = 0;
        Empreendedor empreendedor = new Empreendedor();
        Notificacao instance = new Notificacao(idNotificacao, empreendedor);
        assertNotNull(instance);
    }

    /**
     * Test of getIdNotificacao method, of class Notificacao.
     */
    @Test
    public void testConstrutorNotificacao2() {
        System.out.println("getIdNotificacao");
        int idNotificacao = 0;
        String descricao = "";
        Empreendedor empreendedor = new Empreendedor();
        Notificacao instance = new Notificacao(idNotificacao, descricao, empreendedor);
        assertNotNull(instance);
    }

    /**
     * Test of getIdNotificacao method, of class Notificacao.
     */
    @Test
    public void testGetIdNotificacao() {
        System.out.println("getIdNotificacao");
        Notificacao instance = new Notificacao();
        int expResult = 0;
        instance.setIdNotificacao(expResult);
        int result = instance.getIdNotificacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdNotificacao method, of class Notificacao.
     */
    @Test
    public void testSetIdNotificacao() {
        System.out.println("setIdNotificacao");
        int idNotificacao = 0;
        Notificacao instance = new Notificacao();
        instance.setIdNotificacao(idNotificacao);
    }

    /**
     * Test of getDescricao method, of class Notificacao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Notificacao instance = new Notificacao();
        String expResult = "";
        instance.setDescricao(expResult);
        String result = instance.getDescricao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescricao method, of class Notificacao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Notificacao instance = new Notificacao();
        instance.setDescricao(descricao);
    }

    /**
     * Test of getEmpreendedor method, of class Notificacao.
     */
    @Test
    public void testGetEmpreendedor() {
        System.out.println("getEmpreendedor");
        Notificacao instance = new Notificacao();
        Empreendedor expResult = new Empreendedor();
        instance.setEmpreendedor(expResult);
        Empreendedor result = instance.getEmpreendedor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmpreendedor method, of class Notificacao.
     */
    @Test
    public void testSetEmpreendedor() {
        System.out.println("setEmpreendedor");
        Empreendedor empreendedor = null;
        Notificacao instance = new Notificacao();
        instance.setEmpreendedor(empreendedor);
    }

    /**
     * Test of isVisualizado method, of class Notificacao.
     */
    @Test
    public void testIsVisualizado() {
        System.out.println("isVisualizado");
        Notificacao instance = new Notificacao();
        boolean expResult = false;
        instance.setVisualizado(expResult);
        boolean result = instance.isVisualizado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVisualizado method, of class Notificacao.
     */
    @Test
    public void testSetVisualizado() {
        System.out.println("setVisualizado");
        boolean visualizado = false;
        Notificacao instance = new Notificacao();
        instance.setVisualizado(visualizado);
    }

    /**
     * Test of getLink method, of class Notificacao.
     */
    @Test
    public void testGetLink() {
        System.out.println("getLink");
        Notificacao instance = new Notificacao();
        String expResult = "";
        instance.setLink(expResult);
        String result = instance.getLink();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLink method, of class Notificacao.
     */
    @Test
    public void testSetLink() {
        System.out.println("setLink");
        String link = "";
        Notificacao instance = new Notificacao();
        instance.setLink(link);
    }

}
