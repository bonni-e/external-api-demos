package util;

import java.util.Base64;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ApiKeyManager {

	public static String getBasicAuthHeader() {
		try {
			Context init = new InitialContext();
			Context ctx = (Context) init.lookup("java:comp/env");

			String clientId = (String) ctx.lookup("codef/clientId");
			String clientSecret = (String) ctx.lookup("codef/clientSecret");

			// 클라이언트아이디, 시크릿코드 Base64 인코딩
			String auth = clientId + ":" + clientSecret;
			byte[] authEncBytes = Base64.getEncoder().encode(auth.getBytes());
			String authStringEnc = new String(authEncBytes);
			String authHeader = "Basic " + authStringEnc;

			return authHeader;

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
