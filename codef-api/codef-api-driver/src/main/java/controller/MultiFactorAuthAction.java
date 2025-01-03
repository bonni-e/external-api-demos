package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DriverLicenseDetailRequestDTO;
import model.MfaRequestDTO;
import model.TwoWayInfo;
import util.AuthTokenProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import org.json.JSONObject;

@WebServlet("/mfa")
public class MultiFactorAuthAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream in = request.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}

		JSONObject reqObj = new JSONObject(builder.toString());
		JSONObject data = reqObj.getJSONObject("data");
		JSONObject auth = reqObj.getJSONObject("auth");

		String jti = auth.getString("jti");
		long twoWayTimestamp = auth.getLong("twoWayTimestamp");

		DriverLicenseDetailRequestDTO reqDto = new DriverLicenseDetailRequestDTO(data);

		TwoWayInfo twoWayInfo = new TwoWayInfo();
		twoWayInfo.setJti(jti);
		twoWayInfo.setTwoWayTimestamp(twoWayTimestamp);

		MfaRequestDTO requestDto = new MfaRequestDTO(reqDto);
		requestDto.setTwoWayInfo(twoWayInfo);

		String result = ApiRequestHandler.executeFallbackRequest(requestDto);

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(result);
		response.getWriter().flush();
	}

}
