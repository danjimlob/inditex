package com.danjimlob.inditex.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Data
public class CreationAndLastUpdateHistory {

	@Column(name = "modificationDate", columnDefinition = "DATE")
	private LocalDateTime modificationDate;

	@Column(name = "modificationUser")
	private String modificationUser;
}
