package dev.study.service;

import java.util.List;

import dev.study.model.Note;


public interface StudyService {
	List<Note> findAll();

	Note save(Note study);

	List<Note> update(Note study);
	
}