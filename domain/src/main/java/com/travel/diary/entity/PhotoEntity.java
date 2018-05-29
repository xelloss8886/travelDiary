package com.travel.diary.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity {

	@Id
	private String photoId;

	private String fileName;

	private String pLocation;

	private String pTime;
}
