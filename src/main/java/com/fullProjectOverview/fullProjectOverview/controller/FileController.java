package com.fullProjectOverview.fullProjectOverview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fullProjectOverview.fullProjectOverview.dao.FileDao;
import com.fullProjectOverview.fullProjectOverview.service.FileService;

@RestController
public class FileController {

	@Autowired
	FileService fileService;

	@PostMapping("/file")
	public ResponseEntity<?> handleFileDao(@RequestParam("multiPartFile") MultipartFile multiPartFile) {

		FileDao fileDao = fileService.uploadFile(multiPartFile);
		return new ResponseEntity<>(fileDao, HttpStatus.OK);
	}

	@GetMapping("/file/{fileId}")
	public ResponseEntity<ByteArrayResource> handleGetFileDao(@PathVariable("fileId") Integer fileId) {

		FileDao fileDao = fileService.getFile(fileId);
		ByteArrayResource resource = new ByteArrayResource(fileDao.getFileData());

		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" + fileDao.getFileName() + "\"");
		httpHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

		return ResponseEntity.ok().headers(httpHeader).contentLength(fileDao.getFileData().length).body(resource);
	}
}
