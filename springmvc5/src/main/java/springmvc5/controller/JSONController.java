package springmvc5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc5.domain.Person;

@Controller
public class JSONController {

	@RequestMapping("/personList.do")
	@ResponseBody
	public List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 20));
		personList.add(new Person("강감찬", 30));
		personList.add(new Person("이순신", 40));
		return personList;
	}
	
	@RequestMapping("/person.do")
	@ResponseBody
	public Person getPerson() {
		return new Person("홍길동", 20);
	}
	
}
