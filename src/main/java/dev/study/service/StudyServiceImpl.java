package dev.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.study.model.Note;
import dev.study.repository.StudyRepository;

@Service
public class StudyServiceImpl implements StudyService{
	
	@Autowired
	private StudyRepository repository;

	public List<Note> findAll() {
//		System.out.println("service class findAll() called!");
		// 비즈니스 로직 작성 부분
		// DB 접근해서 데이터 조회-> service가 하지 않고, DAO, Repository가 한다
		return repository.findAll();
		
		// JDBC에서는 ORM 처리가 필요함.↓
		/*
		 * String sql = "SELECT * FROM mouse";
		 * 
		 * Mouse m = new Mouse();
		 * m.setName(rs.getString("name")); // Object(Mouse) - Relation(Mouse table) Mapping
		 * */
	}
	
	public Note save(Note study) {
		
		return repository.save(study);
	}
	
	public List<Note> update(Note study){
		// 기존의 순수 JPA Hibernate
		// Todo todo = em.find(Todo.class, 1L);
		
		// Id값에 의해서 데이터 조회 SELECT * FROM todo WHERE = id
		final Optional<Note> foundTodo =  repository.findById(study.getId());
		// Optional 타입의 의미 : 간단하게는 NullPointer 예외를 방지하기 위함
		// 전달된 인자값 중 id 값이 null일 경우 예외발생하니까
		
		foundTodo.ifPresent(newStudy -> {//id값에 의한 엔티티가 존재하면(ifPresent)
			newStudy.setDate(study.getDate());
			newStudy.setDescription(study.getDescription());
			newStudy.setTitle(study.getTitle());
			// 지역변수 todo : update할 새로운 데이터
			// newTodo : update완료 후 DB에 persist할 데이터
			
			repository.save(newStudy); //em.persist()
		});
		
		return repository.findAll(); //업데이트 되었는지 확인 겸 전체데이터 반환
	}

}
