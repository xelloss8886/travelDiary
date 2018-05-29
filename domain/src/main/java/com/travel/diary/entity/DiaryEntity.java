package com.travel.diary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "diary")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntity {

	@Id
	@Column(name = "diaryId")
	private String diaryId;

	@Column(name = "diaryName")
	private String diaryName;

	@Column(name = "description")
	private String description;
}
