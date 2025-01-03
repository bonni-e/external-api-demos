package model;

public class MfaRequestDTO {

	private String organization = "0001";
	private String userName;
	private String identity;
	private String loginType = "5";
	private String loginTypeLevel;
	private String phoneNo;
	private String telecom;

	private String simpleAuth = "1";
	private boolean is2Way = true;
	private TwoWayInfo twoWayInfo;

	public MfaRequestDTO() {

	}
	
	public MfaRequestDTO(String userName, String identity, String loginTypeLevel, String phoneNo,
			String telecom) {
		this.userName = userName;
		this.identity = identity;
		this.loginTypeLevel = loginTypeLevel;
		this.phoneNo = phoneNo;
		this.telecom = telecom;
	}
	
	public MfaRequestDTO(DriverLicenseDetailRequestDTO requestDto) {
		this.userName = requestDto.getUserName();
		this.identity = requestDto.getIdentity();
		this.loginTypeLevel = requestDto.getLoginTypeLevel();
		this.phoneNo = requestDto.getPhoneNo();
		this.telecom = requestDto.getTelecom();
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

	public String getSimpleAuth() {
		return simpleAuth;
	}

	public void setSimpleAuth(String simpleAuth) {
		this.simpleAuth = simpleAuth;
	}

	public boolean isIs2Way() {
		return is2Way;
	}

	public void setIs2Way(boolean is2Way) {
		this.is2Way = is2Way;
	}

	public TwoWayInfo getTwoWayInfo() {
		return twoWayInfo;
	}

	public void setTwoWayInfo(TwoWayInfo twoWayInfo) {
		this.twoWayInfo = twoWayInfo;
	}

}
