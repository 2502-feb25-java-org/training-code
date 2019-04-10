package com.revature.soap;

import javax.jws.WebService;

@WebService
public interface ServiceEndpointInterface {
	
	/*
	 * Service endpoint interface for our SOAP service
	 * 
	 * This interface and its functionality is what will 
	 * be exposed through our SOAP service; we will 
	 * consume its implemented functionality in our SOAP 
	 * client. 
	 */
	void addData(String str);
	String readData();
	double doMath();
	

}
