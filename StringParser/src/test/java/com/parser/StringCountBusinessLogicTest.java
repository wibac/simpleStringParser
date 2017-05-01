/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser;

import java.util.*;
import org.junit.*;

import com.parser.dao.StringCountBusinessLogic;

import static org.junit.Assert.*;

public class StringCountBusinessLogicTest {

    public StringCountBusinessLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of countStringInPara method, of class StringCountBusinessLogic.
     */
    @Test
    public void testCountStringInPara() {
        System.out.println("countStringInPara");
        List<String> textList = new ArrayList<>();
        textList.add("lorem");
        textList.add("sem");
        textList.add("ipsum");
        textList.add("nahimilega");
        StringCountBusinessLogic instance = new StringCountBusinessLogic();
        LinkedHashMap<String, Integer> expResult = new LinkedHashMap<>();
        expResult.put("lorem", 8);
        expResult.put("sem", 4);
        expResult.put("ipsum", 11);
        expResult.put("nahimilega", 0);
        LinkedHashMap<String, Integer> result = instance.countStringInPara(textList);

        assertEquals(expResult.size(), result.size());
        for (Map.Entry<String, Integer> value : expResult.entrySet()) {
            Integer actualValue = result.get(value.getKey());
            assertNotNull(actualValue);
            assertEquals(value.getValue(), actualValue);
        }

    }

    /**
     * Test of topStringInPara method, of class StringCountBusinessLogic.
     */
    @Test
    public void testTopStringInPara() {
        System.out.println("topStringInPara");
        Integer count = 5;
        StringCountBusinessLogic instance = new StringCountBusinessLogic();
        StringBuilder expResult = new StringBuilder();
        expResult.append("vel"+ "|" + 17 + "\n");
        expResult.append("eget"+ "|" + 17 + "\n");
        expResult.append("sed"+ "|" + 16 + "\n");
        expResult.append("in"+ "|" + 15 + "\n");
        expResult.append("et"+ "|" + 14 + "\n");
        String result = instance.topStringInPara(count);
        assertEquals(expResult.toString(), result);
    }
}
