package com.travel.diary.service.impl;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.diary.entity.DiaryEntity;
import com.travel.diary.repositories.DiaryRepository;
import com.travel.diary.service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryRepository diaryRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void add(DiaryEntity diary) {
		diaryRepository.save(diary);
	}

}
