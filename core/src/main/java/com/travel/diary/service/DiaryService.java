package com.travel.diary.service;

import com.travel.diary.entity.DiaryEntity;

public interface DiaryService extends GeneralService<DiaryEntity> {

	public void add(DiaryEntity diary);
}
