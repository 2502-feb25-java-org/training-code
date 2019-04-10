package com.revature.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface
		="com.revature.soap.ServiceEndpointInterface")
public class Service implements ServiceEndpointInterface{
	
	static List<String> strings 
		= new ArrayList<String>();
	static int count = 0;
	
	static {
		strings.add("hello soap");
		strings.add("This is a soap service");
		strings.add("pretend that we are getting data from db");
	}

	@Override
	public String readData() {
		return strings.get(count++%(strings.size()));
	}

	@Override
	public double doMath() {
		return Math.random();
	}

	@Override
	public void addData(String str) {
		strings.add(str);
	}

}
