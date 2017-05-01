/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser.dao;

import java.io.File;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StringCountBusinessLogic {

	@Autowired
	Environment env;

	File file = new File("C:\\Users\\Waheeb\\Documents\\Paragraph.txt");

	public LinkedHashMap<String, Integer> countStringInPara(List<String> textList) {
		HashMap<String, Integer> stringIntegerMap = getMapOfStringCount();
		LinkedHashMap<String, Integer> counts = new LinkedHashMap<String, Integer>();
		for (String text : textList) {
			String textLower = text.toLowerCase();
			if (stringIntegerMap.containsKey(textLower)) {
				counts.put(text, stringIntegerMap.get(textLower));
			} else {
				counts.put(text, 0);
			}
		}
		System.out.println("\n*******************COUNT*******************\n");
		for (String key : counts.keySet()) {
			System.out.println(key + " " + counts.get(key));
			System.out.println("**********************");
		}
		System.out.println("\n*******************ENDCOUNT*******************\n");
		return counts;
	}

	public String topStringInPara(Integer count) {
		Map<String, Integer> stringIntegerMap = getMapOfStringCount();
		return sortByValue(stringIntegerMap, count);
	}


	/* This method will parse the text and build a map of string and their count.
	 * 
	 */
	private HashMap<String, Integer> getMapOfStringCount() {
		try {
			String para;
			try (Scanner s = new Scanner(file).useDelimiter("\\Z")) {
				para = s.next();
			}
			// System.out.println(para);
			// System.out.println();
			String onlyAlpha = para.replaceAll("[^A-Za-z\\s]+", "").toLowerCase();//delete all characters apart from alphabets and spaces
			// System.out.println(onlyAlpha);
			// System.out.println();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			String[] splitted = onlyAlpha.split("[\\s\\n]");//split the text into words
			int count;
			for (int i = 0; i < splitted.length; i++) {
				if (map.containsKey(splitted[i])) {
					count = map.get(splitted[i]);
					map.put(splitted[i], ++count);
				} else if (!splitted[i].equals("")) {
					map.put(splitted[i], 1);
				}
			}
			// for (String key : map.keySet()) {
			// System.out.println(key + " " + map.get(key));
			// System.out.println("**********************");
			// }
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//sort the map by value. This will be used to return top 10 strings
	private String sortByValue(Map<String, Integer> map, Integer count) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		StringBuilder csvResponse = new StringBuilder();
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue()) * -1;
			}
		});

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		// System.out.println("\n*******************SORTED*******************\n");
		// for (String key : sortedMap.keySet()) {
		// System.out.println(key + " " + sortedMap.get(key));
		// System.out.println("**********************");
		// }

		/*This program assumes that if top 2 or more strings have same count then 
		 * they will be part of the response if one of them is part of the response.
		 * Following is the code for the same.
		*/
		LinkedHashMap<String, Integer> topStringIntegerMap = new LinkedHashMap<String, Integer>();
		Iterator entries = sortedMap.entrySet().iterator();
		int addCount = 0;
		int lastCount = 0;
		boolean lastCountFlag = true;
		while (entries.hasNext() && (addCount < count || lastCountFlag)) {
			Entry<String, Integer> thisEntry = (Entry<String, Integer>) entries.next();
			if (addCount < count || lastCount == thisEntry.getValue()) {
				topStringIntegerMap.put(thisEntry.getKey(), thisEntry.getValue());
				csvResponse.append(thisEntry.getKey() + "|" + thisEntry.getValue() + "\n");
			}
			if (addCount >= count && lastCount != thisEntry.getValue()) {
				lastCountFlag = false;
			}
			lastCount = thisEntry.getValue();
			addCount++;
		}
		System.out.println("\n*******************TOP*******************\n");
		int topCount = 1;
		for (String key : topStringIntegerMap.keySet()) {
			System.out.println(topCount + " " + key + " " + topStringIntegerMap.get(key));
			System.out.println("**********************");
			topCount++;
		}
		System.out.println("Response " + csvResponse.toString());
		return csvResponse.toString();
	}
}
