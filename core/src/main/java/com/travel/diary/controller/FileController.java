package com.travel.diary.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.diary.entity.PhotoEntity;
import com.travel.diary.service.DiaryService;
import com.travel.diary.service.PhotoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileController {

	@Autowired
	private DiaryService diaryService;

	@Autowired
	private PhotoService photoService;

	@Autowired
	private String destinationDir;

	private ObjectMapper mapper = new ObjectMapper();

	@PostMapping(value = "/upload")
	@ResponseBody
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile sourceFile)
			throws IllegalStateException, IOException {
		String sourceFileName = sourceFile.getOriginalFilename();
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		File destinationFile;
		String destinationFileName;
		do {
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
			destinationFile = new File(destinationDir + destinationFileName);
		} while (destinationFile.exists());
		destinationFile.getParentFile().mkdirs();
		sourceFile.transferTo(destinationFile);
		PhotoEntity entity = new PhotoEntity();
		entity.setPhotoId(generateId());
		entity.setFileName(sourceFile.getOriginalFilename());
		photoService.add(entity);
		String str = mapper.writeValueAsString(entity);
		log.info(str);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

	private String generateId() {
		long time = System.currentTimeMillis();
		Random rand = new Random(100000);
		String randStr = String.valueOf(time) + String.valueOf(Math.abs(rand.nextInt()));
		return randStr;
	}

}
