package com.travel.diary.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String doProcess(MultipartFile sourceFile) throws Exception;
}
