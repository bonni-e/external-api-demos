package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DriverLicenseDetailRequestDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;

import org.json.JSONObject;

@WebServlet("/service")
public class FormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		InputStream in = request.getInputStream();
		StringBuilder builder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String line;
		while ((line = br.readLine()) != null) {
			builder.append(line);
		}

		JSONObject reqObj = new JSONObject(builder.toString());

		String userName = reqObj.getString("userName");
		String identity = reqObj.getString("identity");
		String phoneNo = reqObj.getString("phoneNo");
		String loginTypeLevel = reqObj.getString("loginTypeLevel");
		String telecom = reqObj.getString("telecom");
		String loginType = "5";

		DriverLicenseDetailRequestDTO reqDto = new DriverLicenseDetailRequestDTO(userName, identity, loginTypeLevel,
				phoneNo, telecom);
		reqObj = new JSONObject(reqDto);

		Map<String, Object> dataMap = ApiRequestHandler.sendPrimaryApiRequest(reqDto);
		JSONObject resObj = new JSONObject(dataMap);

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		OutputStream out = response.getOutputStream();
		out.write(resObj.toString().getBytes());
		out.flush();
	}
	
}
