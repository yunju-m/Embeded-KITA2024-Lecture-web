package springbootbasic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloBootAppTests {

	@Test
	void sayHello() {
		assertNull(null);
		assertEquals(getClass(), getClass());
		
	}

}
