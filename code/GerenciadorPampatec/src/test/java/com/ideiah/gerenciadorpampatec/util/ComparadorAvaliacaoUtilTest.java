/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maicon Alves
 */
public class ComparadorAvaliacaoUtilTest {
    
    public ComparadorAvaliacaoUtilTest() {
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
     * Teste para o comparador de datas ComparadorAvaliacaoUtil.
     */
    @Test
    public void testCompare() {
        System.out.println("ComparadorAvaliacaoUtil");
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        
        o1.setDataAvaliacao(null);
        o2.setDataAvaliacao(null);
        ComparadorAvaliacaoUtil instance = new ComparadorAvaliacaoUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Teste para o comparador de datas ComparadorAvaliacaoUtil.
     */
    @Test
    public void testCompare2() {
        System.out.println("ComparadorAvaliacaoUtil2");
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        o1.setDataAvaliacao(new Date());
        Date data = new Date();
        data.setHours(8);
        o2.setDataAvaliacao(data);
        ComparadorAvaliacaoUtil instance = new ComparadorAvaliacaoUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertNotSame(expResult, result);
        
    }
    
}
