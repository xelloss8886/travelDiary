package com.travel.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.travel.diary.entity.DiaryEntity;
import com.travel.diary.service.DiaryService;

@Controller
public class HomeController {

	@Autowired
	private DiaryService diaryService;

	@GetMapping("/")
	public String home(Model model) {
		DiaryEntity entity = new DiaryEntity();
		entity.setDiaryName("test123");
		entity.setDiaryId("test1111");
		diaryService.add(entity);
		return "";
	}
}
