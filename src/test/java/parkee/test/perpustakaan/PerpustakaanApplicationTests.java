package parkee.test.perpustakaan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PerpustakaanApplicationTests {

	// @Test
	// void contextLoads() {
	// 	System.out.println("Hello");
	// }

	@Test
	void testPrint() {
		assertEquals(1, 1, 1, "equal");
	}

}
