package com.edu.util;

public class ActionForward {
	private String nextPath;
	private boolean isRedirect;
	
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	@Override
	public String toString() {
		return "ActionForward [nextPath=" + nextPath + ", isRedirect=" + isRedirect + "]";
	}
	
	
}
