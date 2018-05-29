package com.travel.diary.entity;

import java.io.Serializable;

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
public class DiaryPhotoEntity implements Serializable {

	private static final long serialVersionUID = 6296350462776631301L;

	@Id
	private String userId;

	@Id
	private String diaryId;

	@Id
	private String photoId;

	@Id
	private String groupId;
}
