package com.fullProjectOverview.fullProjectOverview.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fullProjectOverview.fullProjectOverview.dao.FileDao;
import com.fullProjectOverview.fullProjectOverview.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	FileRepository fileRepository;

	public FileDao uploadFile(MultipartFile multiPartFile) {
		FileDao fileDao = new FileDao();
		fileDao.setFileName(multiPartFile.getOriginalFilename());
		fileDao.setFileType(multiPartFile.getContentType());
		try {
			fileDao.setFileData(multiPartFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileRepository.save(fileDao);
	}

	public FileDao getFile(Integer fileId) {

		return fileRepository.findById(fileId).orElse(null);

	}
}
