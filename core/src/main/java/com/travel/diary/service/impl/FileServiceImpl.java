package com.travel.diary.service.impl;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.diary.entity.PhotoEntity;
import com.travel.diary.service.FileService;
import com.travel.diary.service.PhotoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private String destinationDir;

	@Autowired
	private PhotoService photoService;

	private static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public String doProcess(MultipartFile sourceFile) throws Exception {
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
		return str;
	}

	private String generateId() {
		long time = System.currentTimeMillis();
		Random rand = new Random(100000);
		String randStr = String.valueOf(time) + String.valueOf(Math.abs(rand.nextInt()));
		return randStr;
	}
}
