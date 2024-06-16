package com.fullProjectOverview.fullProjectOverview.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer FileId;
	private String FileName;
	private byte[] fileData;
	private String FileType;

	public FileDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFileId() {
		return FileId;
	}

	public void setFileId(Integer fileId) {
		FileId = fileId;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileType() {
		return FileType;
	}

	public void setFileType(String fileType) {
		FileType = fileType;
	}

}
