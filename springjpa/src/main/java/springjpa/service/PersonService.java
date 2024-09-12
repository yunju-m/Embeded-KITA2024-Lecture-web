package springjpa.service;

import java.util.List;

import springjpa.domain.Person;

public interface PersonService {

	public abstract List<Person> getPersonList();

	public abstract Person getPerson(int pid);

	public abstract int insertPerson(Person person);

	public abstract int updatePerson(Person person);

	public abstract int deletePerson(int pid);

}