package com.revature.app;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.soap.UserRepositoryInterface;

public class App {

	public static void main(String[] args) {

		JaxWsProxyFactoryBean beanFactory = 
				new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(UserRepositoryInterface.class);
		beanFactory.setAddress("http://localhost:8081/soap-service-demo/user");
		
		UserRepositoryInterface repo = (UserRepositoryInterface) beanFactory.create();
		
		System.out.println(repo.getAll());
	}

}
