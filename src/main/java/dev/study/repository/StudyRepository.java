package dev.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.study.model.Note;

@Repository
public interface StudyRepository extends JpaRepository<Note, Long>{// <Entity, PK type>

}
