package com.travel.diary.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.diary.entity.DiaryEntity;
import com.travel.diary.service.DiaryService;

import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class HomeController {

	@Autowired
	private DiaryService diaryService;

	@Value("${travel.file.directory}")
	private String destinationDir;

	private ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/test")
	@ResponseBody
	public String home(Model model) throws Exception {
		DiaryEntity entity = new DiaryEntity();
		entity.setDiaryName("test123");
		entity.setDiaryId("test1111");
		diaryService.add(entity);
		return mapper.writeValueAsString(entity);
	}

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
		UploadAttachmentResponse response = new UploadAttachmentResponse();
		response.setFileName(sourceFile.getOriginalFilename());
		response.setFileSize(sourceFile.getSize());
		response.setFileContentType(sourceFile.getContentType());
		response.setAttachmentUrl("http://localhost:8080/attachments/" + destinationFileName);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@NoArgsConstructor
	@Data
	private static class UploadAttachmentResponse {
		private String fileName;
		private long fileSize;
		private String fileContentType;
		private String attachmentUrl;
	}

}
