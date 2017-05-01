package com.parser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parser.dao.StringCountBusinessLogic;
import com.parser.model.Counts;
import com.parser.model.SearchText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/counter-api")
public class RestApi {

	@Autowired
	StringCountBusinessLogic parser;
	
	@RequestMapping(path="/search",method = RequestMethod.POST)
	@ResponseBody
	public Counts getCount(@RequestBody SearchText obj){
		System.out.println("searching for " + obj.toString());
		Counts count = new Counts();
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		list.add(parser.countStringInPara(obj.getTags()));
		count.setCount(list);
		return count;
	}
	
	@RequestMapping(path="/top/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getTopCount(@PathVariable(value="id") Integer id){
		System.out.println("id : " + id);
		return parser.topStringInPara(id);
	}
	
}