package model;

import org.json.JSONObject;

public class DriverLicenseDetailRequestDTO {

	private String organization = "0001";
	private String userName;
	private String identity;
	private String loginType = "5";
	private String loginTypeLevel;
	private String phoneNo;
	private String telecom;

	public DriverLicenseDetailRequestDTO() {

	}

	public DriverLicenseDetailRequestDTO(String userName, String identity, String loginTypeLevel, String phoneNo,
			String telecom) {
		this.userName = userName;
		this.identity = identity;
		this.loginTypeLevel = loginTypeLevel;
		this.phoneNo = phoneNo;
		this.telecom = telecom;
	}

	public DriverLicenseDetailRequestDTO(JSONObject data) {
		this.userName = data.getString("userName");
		this.identity = data.getString("identity");
		this.loginTypeLevel = data.getString("loginTypeLevel");
		this.phoneNo = data.getString("phoneNo");
		this.telecom = data.getString("telecom");
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginTypeLevel() {
		return loginTypeLevel;
	}

	public void setLoginTypeLevel(String loginTypeLevel) {
		this.loginTypeLevel = loginTypeLevel;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

}
