package com.travel.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.diary.entity.DiaryEntity;
import com.travel.diary.service.DiaryService;

@Controller
public class HomeController {

	@Autowired
	private DiaryService diaryService;

	private ObjectMapper mapper = new ObjectMapper();

	@GetMapping("/")
	@ResponseBody
	public String home(Model model) throws Exception {
		DiaryEntity entity = new DiaryEntity();
		entity.setDiaryName("test123");
		entity.setDiaryId("test1111");
		diaryService.add(entity);
		return mapper.writeValueAsString(entity);
	}
}
