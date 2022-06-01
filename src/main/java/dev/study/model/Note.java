package dev.study.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복 적용
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
@Entity
public class Note {
	
	@Id
	@Column(name="note_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	@Column(name="note_title",nullable=false)
	private String noteTitle;
	@Column(name="note_description",nullable=false)
	private String noteDescription;
	@Column(name="note_date",nullable=false)
	private LocalDate noteDate;
	@Column(name="is_release",nullable=false)
	private boolean isrelease;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	
}
