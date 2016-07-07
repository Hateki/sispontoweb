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
public class ComparadorCriacaoUtilTest {
    
    public ComparadorCriacaoUtilTest() {
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
     * Teste para comparação de data de criação nulla.
     */
    @Test
    public void testCompare() {
        System.out.println("ComparadorCriacaoUtil");
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        
        o1.setDataCriacao(null);
        o2.setDataCriacao(null);
        ComparadorCriacaoUtil instance = new ComparadorCriacaoUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
       
    }
    
    /**
     * Teste para comparação de data de criação .
     */
    @Test
    public void testCompare2() {
        System.out.println("ComparadorCriacaoUtil2");
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        
        o1.setDataCriacao(new Date());
        Date data = new Date();
        data.setHours(8);
        o2.setDataCriacao(data);
        ComparadorCriacaoUtil instance = new ComparadorCriacaoUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertNotSame(expResult, result);
       
    }
    
}
