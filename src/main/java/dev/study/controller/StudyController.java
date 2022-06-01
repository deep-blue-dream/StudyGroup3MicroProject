package dev.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.study.model.Study;
import dev.study.service.StudyService;

@RestController
@RequestMapping("api/v1") // localhost:8080:api/v1까지 작성해야 TodoController에 접근할 수 있음.
public class StudyController {
	
	@Autowired //필드를 통한 인젝션(주입,DI) 
	private StudyService todoService;
	
	
	@GetMapping
	public List<Study> findAll() {
		// 실제 DB에 접근해서 전체 Todo 가져오는 코드 작성
		return todoService.findAll();
	}
	
	@PostMapping
	public Study save(@RequestBody Study todo) {
		System.out.println(todo.getTitle()); //한 번 확인해보기
		// @RequestBody - 클라이언트에서 보낸 값을 Todo의 필드와 맵핑해서 객체 형태로 구성
//		return "save() called!";
		return todoService.save(todo);
	}
	
	@PutMapping
	public List<Study> update(@RequestBody Study todo){
//		System.out.println(todo);
//Todo(id=null, title=과자 먹기, description=과자를 먹는다, date=2022-03-06)
		return todoService.update(todo);
	}
	
}
