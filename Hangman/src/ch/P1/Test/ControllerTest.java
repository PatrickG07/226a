package ch.P1.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void testlenght() {
		String word = "test";
		assertEquals(4, word.length());
	}
}
