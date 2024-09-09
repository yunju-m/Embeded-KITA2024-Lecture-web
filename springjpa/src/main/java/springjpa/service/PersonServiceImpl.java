package springjpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import springjpa.dao.PersonDao;
import springjpa.domain.Person;

public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	@Transactional
	public List<Person> getPersonList() {
		return personDao.getPersonList();
	}

	@Override
	@Transactional
	public Person getPerson(int pid) {
		return personDao.getPerson(pid);
	}

	@Override
	@Transactional
	public int insertPerson(Person person) {
		return personDao.insertPerson(person);
	}

	@Override
	@Transactional
	public int updatePerson(Person person) {
		return personDao.updatePerson(person);
	}

	@Override
	@Transactional
	public int deletePerson(int pid) {
		return personDao.deletePerson(pid);
	}

}
