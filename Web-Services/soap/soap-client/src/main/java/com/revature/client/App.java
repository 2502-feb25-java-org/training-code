package com.revature.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.soap.ServiceEndpointInterface;

public class App {

	public static void main(String[] args) {
		//http://170.41.34.124:8081/....
		String url = "http://localhost:8085/soap-service/endpoint";
		
		JaxWsProxyFactoryBean beanFactory
			= new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(ServiceEndpointInterface.class);
		beanFactory.setAddress(url);
		
		//CONSUME!
		
		ServiceEndpointInterface service 
			 = (ServiceEndpointInterface) beanFactory.create();
		System.out.println(service.readData());
		
	}
}
