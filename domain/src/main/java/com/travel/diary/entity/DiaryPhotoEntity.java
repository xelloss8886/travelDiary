package com.travel.diary.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diaryphoto")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DiaryPhotoEntity {

	@Id
	private String userId;

	@Id
	private String diaryId;

	@Id
	private String photoId;

	@Id
	private String groupId;
}
