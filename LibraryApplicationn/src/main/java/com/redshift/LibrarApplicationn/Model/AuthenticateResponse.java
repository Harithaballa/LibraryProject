package com.redshift.LibrarApplicationn.Model;

public class AuthenticateResponse {

	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticateResponse(String jwt) {
	//	super();
		this.jwt = jwt;
	}

	
}
