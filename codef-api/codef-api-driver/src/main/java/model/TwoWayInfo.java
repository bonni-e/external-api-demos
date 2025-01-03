package model;

public class TwoWayInfo {

	private int jobIndex;
	private int threadIndex;
	private String jti;
	private long twoWayTimestamp;

	public int getJobIndex() {
		return jobIndex;
	}

	public void setJobIndex(int jobIndex) {
		this.jobIndex = jobIndex;
	}

	public int getThreadIndex() {
		return threadIndex;
	}

	public void setThreadIndex(int threadIndex) {
		this.threadIndex = threadIndex;
	}

	public String getJti() {
		return jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public long getTwoWayTimestamp() {
		return twoWayTimestamp;
	}

	public void setTwoWayTimestamp(long twoWayTimestamp) {
		this.twoWayTimestamp = twoWayTimestamp;
	}

}
