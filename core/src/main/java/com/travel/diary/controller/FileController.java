package com.travel.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travel.diary.service.DiaryService;
import com.travel.diary.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FileController {

	@Autowired
	private DiaryService diaryService;

	@Autowired
	private FileService fileService;

	@PostMapping(value = "/upload")
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile sourceFile) throws Exception {
		return new ResponseEntity<>(fileService.doProcess(sourceFile), HttpStatus.OK);
	}

}
