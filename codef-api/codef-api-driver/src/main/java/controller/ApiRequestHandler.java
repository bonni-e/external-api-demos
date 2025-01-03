package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletResponse;
import model.DriverLicenseDetailRequestDTO;
import model.MfaRequestDTO;
import util.AuthTokenProvider;

public class ApiRequestHandler {
	public static Map<String, Object> sendPrimaryApiRequest(DriverLicenseDetailRequestDTO reqDto) throws IOException {
		JSONObject reqObj = new JSONObject(reqDto);

		String uri = "https://development.codef.io/v1/kr/public/ef/driver-license/detail";

		URL url = new URL(uri);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");

		String token = AuthTokenProvider.getCodefApiToken();
		con.setRequestProperty("Authorization", token);
		con.setRequestProperty("Content", "application/json");

		con.setDoOutput(true);
		con.setDoInput(true);

		OutputStream out = con.getOutputStream();
		out.write(reqObj.toString().getBytes());
		out.flush();
		out.close();

		if (con.getResponseCode() == HttpServletResponse.SC_OK) {
			InputStream in = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder builder = new StringBuilder();

			String line = "";
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}

			br.close();
			con.disconnect();

			if (builder.length() > 2) {
				String resStr = URLDecoder.decode(builder.toString(), "UTF-8");

				JSONObject resObj = new JSONObject(resStr);

				JSONObject resData = resObj.getJSONObject("data");

				String jti = resData.getString("jti");
				long twoWayTimestamp = resData.getLong("twoWayTimestamp");

				Map<String, Object> dataMap = new HashMap<>();
				dataMap.put("jti", jti);
				dataMap.put("twoWayTimestamp", twoWayTimestamp);

				return dataMap;
			}
		}
		return null;
	}

	public static String executeFallbackRequest(MfaRequestDTO requestDto) throws IOException {
		JSONObject reqObj = new JSONObject(requestDto);

		String uri = "https://development.codef.io/v1/kr/public/ef/driver-license/detail";
		String token = AuthTokenProvider.getCodefApiToken();

		URL url = new URL(uri);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");

		con.setRequestProperty("Authorization", token);
		con.setRequestProperty("Content", "application/json");

		con.setDoOutput(true);
		con.setDoInput(true);

		OutputStream out = con.getOutputStream();
		out.write(reqObj.toString().getBytes());
		out.flush();
		out.close();

		InputStream in = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}

		br.close();
		con.disconnect();

		String result = URLDecoder.decode(builder.toString(), "utf-8");
		return result;
	}
}
