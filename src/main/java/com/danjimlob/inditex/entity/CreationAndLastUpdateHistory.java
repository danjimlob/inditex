package com.danjimlob.inditex.entity;

import java.util.Date;

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

  @Column(name = "fecha_creacion", columnDefinition = "DATE")
  private Date creationDate;

  @Column(name = "usuario_creacion")
  private String creationUser;

  @Column(name = "fecha_modificacion", columnDefinition = "DATE")
  private Date modificationDate;

  @Column(name = "usuario_modificacion")
  private String modificationUser;
}
