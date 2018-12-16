package TestUnit;
import static org.junit.Assert.*;
import org.junit.Test;
import codebase.Codewars;
import codebase.Codeforces;

public class UnitTest {
	
	Codewars obj = new Codewars();
	Codeforces obj2 = new Codeforces();
	/**
	 *This method test the equality of value of correct output and the output of user-created method findSmallest() in the Codewars class in terms of value.
	 */
	@Test
	public void testFindSmallestValue() {
		int[] numbers1 = {1,2,3,4,5};
		int[] numbers2 = {10,20,30,40,50};
		int[] numbers3 = {100,220,378,4187,5090};
		int[] numbers4 = {1,200,3000,40000,5000000};
		int[] numbers5 = {100,20,300,400,5};
		String toReturn = "value";
		assertEquals(1, obj.findSmallest(numbers1, toReturn));
		assertEquals(10, obj.findSmallest(numbers2, toReturn));
		assertEquals(100, obj.findSmallest(numbers3, toReturn));
		assertEquals(1, obj.findSmallest(numbers4, toReturn));
		assertEquals(5, obj.findSmallest(numbers5, toReturn));
	}
	/**
	 *This method test the equality of value of correct output and the output of user-created method findSmallest() in the Codewars class in terms of index.
	 */
	@Test
	public void testFindSmallestIndex() {
		int[] numbers1 = {1,2,3,4,5};
		int[] numbers2 = {10,20,30,40,50};
		int[] numbers3 = {100,220,378,4187,5090};
		int[] numbers4 = {1,200,3000,40000,5000000};
		int[] numbers5 = {100,20,300,400,5};
		String toReturn = "index";
		assertEquals(0, obj.findSmallest(numbers1, toReturn));
		assertEquals(0, obj.findSmallest(numbers2, toReturn));
		assertEquals(0, obj.findSmallest(numbers3, toReturn));
		assertEquals(0, obj.findSmallest(numbers4, toReturn));
		assertEquals(4, obj.findSmallest(numbers5, toReturn));
	}
	/**
	 * This method test the equality of value of correct output and the output of user-created method getCount() in the Codewars class.
	 */
	@Test
	public void testGetCount() {
		assertEquals(2,obj.getCount("hello"));
		assertEquals(3,obj.getCount("hello"));
		assertEquals(5,obj.getCount("aaaaa"));
		assertEquals(6,obj.getCount("aaaaa"));
	}
	/**
	 * This method test the equality of value of correct output and the output of user-created method makeReadable() in the Codewars class.
	 */
	@Test
	public void testMakeReadable() {
		assertEquals("01:00:00", obj.makeReadable(100));
		assertEquals("02:00:00", obj.makeReadable(100));
		assertEquals("12:00:00", obj.makeReadable(1200));
		assertEquals("12:00:00", obj.makeReadable(1300));
		
	}

	/**
	 * This method test the equality of value of correct output and the output of user-created method crazyComputer() in the Codeforces class.
	 */
	@Test
	public void testCrazyComputer() {
		assertEquals(0,obj2.crazyComputer(10,2,1));
		assertEquals(1,obj2.crazyComputer(10,2,1));
		assertEquals(2,obj2.crazyComputer(10,2,1));
		assertEquals("asda",obj2.crazyComputer(10,2,1));
		assertEquals("@#!%",obj2.crazyComputer(10,2,1));
	}

	/**
	 * This method test the equality of value of correct output and the output of user-created method trickyAlchemy() in the Codeforces class.
	 */
	@Test
	public void testTrickyAlchemy() {
		assertEquals(0,obj2.trickyAlchemy(3,4,1,1,1));
		assertEquals(0,obj2.trickyAlchemy(1,1,1,1,1));
		assertEquals(1,obj2.trickyAlchemy(5,10,5,10,5));
		assertEquals(10,obj2.trickyAlchemy(10,10,10,10,10));
		
	}

	/**
	 * This method test the equality of value of correct output and the output of user-created method waterMelon() in the Codeforces class.
	 */
	@Test
	public void testWaterMelon() {
		assertEquals("YES", obj2.waterMelon(6));
		assertEquals("NO", obj2.waterMelon(6));
		assertEquals("YES", obj2.waterMelon(5));
		assertEquals("no", obj2.waterMelon(5));
		assertEquals("yes", obj2.waterMelon(123124));
		
	}


}
