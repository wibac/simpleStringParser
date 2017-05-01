package com.parser.model;

import java.util.List;
import java.util.Map;

public class Counts{
	List<Map<String,Integer>> counts;
	public void setCount(List<Map<String,Integer>> counts){
		this.counts = counts;
	}
	public List<Map<String,Integer>> getCount(){
		return counts;
	}
}