/*
* @author Peter Alagna
*/ 

package com.revature.util;

import com.revature.ajax.ClientMessage;

public final class ClientMessageUtil {
	public static final ClientMessage REGISTRATION_SUCCESSFUL = new ClientMessage("REGISTRATION SUCCESSFUL");
	public static final ClientMessage SOMETHING_WRONG = new ClientMessage("SOMETHING WENT WRONG");
	public static final ClientMessage INVALID_DATA = new ClientMessage("INVALID FORM DATA");
	public static final ClientMessage HERO_NOT_FOUND = new ClientMessage("HERO NOT FOUND");
}
