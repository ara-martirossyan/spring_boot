package com.aralmighty.model;

public class FileInfo {
	
	private String basename;
	private String extesion;
	private String subDirectory;
	private String baseDirectory;
	
	public FileInfo(String basename, String extesion, String subDirectory, String baseDirectory) {
		this.basename = basename;
		this.extesion = extesion;
		this.subDirectory = subDirectory;
		this.baseDirectory = baseDirectory;
	}

	public String getBasename() {
		return basename;
	}

	public void setBasename(String basename) {
		this.basename = basename;
	}

	public String getExtesion() {
		return extesion;
	}

	public void setExtesion(String extesion) {
		this.extesion = extesion;
	}

	public String getSubDirectory() {
		return subDirectory;
	}

	public void setSubDirectory(String subDirectory) {
		this.subDirectory = subDirectory;
	}

	public String getBaseDirectory() {
		return baseDirectory;
	}

	public void setBaseDirectory(String baseDirectory) {
		this.baseDirectory = baseDirectory;
	}

	@Override
	public String toString() {
		return "FileInfo [basename=" + basename + ", extesion=" + extesion + ", subDirectory=" + subDirectory
				+ ", baseDirectory=" + baseDirectory + "]";
	}
	
	
}
