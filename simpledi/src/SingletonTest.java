public class SingletonTest {

	// 1. private static 멤버변수 생성
	private static SingletonTest obj = new SingletonTest();

	// 2. private 생성자 : 외부에서 객체 생성 불가
	private SingletonTest() {
	}

	// 3. 만들어진 객체를 반환하는 public 메소드 생성
	public static SingletonTest getInstance() {
		return obj;
	}
	
}
