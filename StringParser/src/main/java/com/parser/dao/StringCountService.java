/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class StringCountService {

    /**
     * @param args the command line arguments
     * test application
     */
    public static void main(String[] args) {
        StringCountBusinessLogic countBusinessLogic = new StringCountBusinessLogic();
        List<String> searchText = new ArrayList<String>();
        searchText.add("lorem");
        searchText.add("sem");
        searchText.add("ipsum");
        searchText.add("thisrandomstringwontbepresent");
        countBusinessLogic.countStringInPara(searchText);
        countBusinessLogic.topStringInPara(10);
    }
}
