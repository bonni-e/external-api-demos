package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class AuthTokenProvider {
	
	public static String getCodefApiToken() throws IOException {
		String uri = "https://oauth.codef.io/oauth/token?grant_type=client_credentials&scope=read";

		URL url = new URL(uri);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String authHeader = ApiKeyManager.getBasicAuthHeader();

		con.setRequestProperty("Authorization", authHeader);
		con.setDoInput(true);
		con.setDoOutput(true);

		// 응답 코드 확인
		BufferedReader br = null;

		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}

		// 응답 바디 read
		String inputLine;
		StringBuffer responseStr = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			responseStr.append(inputLine);
		}
		
		br.close();
		con.disconnect();
		
		JSONObject resObj = new JSONObject(responseStr.toString());
		
		String accessToken = resObj.getString("access_token");
		return "Bearer " + accessToken;
	}

}
