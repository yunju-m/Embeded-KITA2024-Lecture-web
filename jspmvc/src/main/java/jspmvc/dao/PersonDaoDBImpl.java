package jspmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspmvc.util.ConnectionUtil;
import jspmvc.vo.Person;

public class PersonDaoDBImpl implements PersonDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public PersonDaoDBImpl() {
		conn = ConnectionUtil.getConnection();
	}

	@Override
	public List<Person> listPerson(List<Person> personList) throws Exception {
		String sql = " SELECT * FROM PERSON ORDER BY PID DESC ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		personList = new ArrayList<Person>();
		while (rs.next()) {
			Person person = new Person(
					rs.getInt("pid"),
					rs.getString("pname"),
					rs.getInt("page")
					);
			personList.add(person);
		}
		return personList;
	}

	@Override
	public Person getPerson(List<Person> personList, int pid) throws Exception {
		String sql = " SELECT * FROM PERSON WHERE PID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		rs = pstmt.executeQuery();
		Person person = null;
		if (rs.next()) {
			person = new Person(
					rs.getInt("pid"),
					rs.getString("pname"),
					rs.getInt("page")
					);
		}
		return person;
	}

	@Override
	public List<Person> registPerson(List<Person> personList, Person person) throws Exception {
		String sql = " INSERT INTO PERSON VALUES(SEQ_PERSON.NEXTVAL, ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, person.getName());
		pstmt.setInt(2, person.getAge());
		pstmt.executeUpdate();
		personList.add(person);
		return personList;
	}

	@Override
	public List<Person> updatePerson(List<Person> personList, Person personBefore, Person personAfter)
			throws Exception {
		String sql = " UPDATE PERSON SET PNAME = ?, PAGE = ? WHERE PID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, personAfter.getName());
		pstmt.setInt(2, personAfter.getAge());
		pstmt.setInt(3, personAfter.getPid());
		pstmt.executeUpdate();
		Person removePerson = null;
		// list의 요소를 제거할 때 list 순회를 끝내고 제거한다!!
		// 한번에 하면 정상 작동x
		for (Person person : personList) {
			if (person.getPid() == personBefore.getPid()) {
				removePerson = person;
			}
		}
		personList.remove(removePerson);
		personList.add(personAfter);
		return personList;
	}

	@Override
	public List<Person> deletePerson(List<Person> personList, int pid) throws Exception {
		String sql = " DELETE FROM PERSON WHERE PID = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		pstmt.executeUpdate();
		personList.remove(getPerson(personList, pid));
		Person removePerson = null;
		// list의 요소를 제거할 때 list 순회를 끝내고 제거한다!!
		for (Person person : personList) {
			if (person.getPid() == pid) {
				removePerson = person;
			}
		}
		personList.remove(removePerson);
		return personList;
	}

}
