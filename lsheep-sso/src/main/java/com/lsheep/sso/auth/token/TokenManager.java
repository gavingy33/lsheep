package com.lsheep.sso.auth.token;

public interface TokenManager {

	String create(TokenModel tokenModel);

	TokenModel query(String token);

	void refresh(String token, TokenModel tokenModel);

	void remove(String token);

}
