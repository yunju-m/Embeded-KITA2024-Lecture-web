package springjpa.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springjpa.domain.Person;
import springjpa.service.PersonService;

public class PersonMain {

	private ApplicationContext context;
	private PersonService personService;

	public PersonMain() {
		context = new GenericXmlApplicationContext("classpath:/springjpa/conf/applicationContext.xml");
	}

	public static void main(String[] args) {

		PersonMain personMain = new PersonMain();

		personMain.personService = (PersonService) personMain.context.getBean("personServiceImpl", PersonService.class);

		try {
	         // insertPerson
	         Person person = new Person(0, "홍길동", 20, null);
	         personMain.personService.insertPerson(person);
	         
	         // getPersonList
	         //System.out.println(personMain.personService.getPersonList());
	         
	         // getPerson
	         //System.out.println(personMain.personService.getPerson(1));
	         
	         // updatePerson
	         //Person person = new Person(1, "권율", 50, null);
	         //personMain.personService.updatePerson(person);
	         
	         // deletePerson
	         //personMain.personService.deletePerson(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
