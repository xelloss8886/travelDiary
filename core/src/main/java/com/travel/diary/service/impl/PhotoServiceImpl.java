package com.travel.diary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.diary.entity.PhotoEntity;
import com.travel.diary.repositories.PhotoRepository;
import com.travel.diary.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	@Override
	public void add(PhotoEntity entity) {
		photoRepository.saveAndFlush(entity);
	}

}
