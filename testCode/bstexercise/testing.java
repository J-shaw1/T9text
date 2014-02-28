package bstexercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class testing {

	private Bst t1;
	private Bst t2;
	private Bst t3;
	private Bst t4;
	private Bst t5;
	private Bst t6;
	private Bst t7;
	private Bst t8;
	private Bst t9;
	private Bst t10;
	private Bst t11;
	private Bst t12;

	@BeforeMethod
	public void setup() {

		t1 = new Empty();
		t2 = t1.insert(34);
		t3 = t2.insert(16);
		t4 = t3.insert(58);
		t5 = t4.insert(7);
		t6 = t5.insert(20);
		t7 = t6.insert(50);
		t8 = t7.insert(64);
		t9 = t8.insert(1);
		t10 = t9.insert(8);
		t11 = t10.insert(37);
		t12 = t11.insert(15);

	}

	public void isEmptyTest() {
		assertEquals(true, t1.isEmpty());
		assertEquals(false, t2.isEmpty());
		assertEquals(false, t3.isEmpty());

	}

	public void smallerTest() {
		assertEquals(true, t1.smaller(5));
		assertEquals(false, t2.smaller(5));
		assertEquals(false, t12.smaller(-1));
		assertEquals(true, t12.smaller(100));
		assertEquals(false, t12.smaller(40));
	}

	public void biggerTest() {
		assertEquals(true, t1.bigger(5));
		assertEquals(true, t2.bigger(5));
		assertEquals(true, t12.bigger(-1));
		assertEquals(false, t12.bigger(100));
		assertEquals(false, t12.bigger(40));
	}

	public void hasTest() {
		assertEquals(false, t1.has(7));
		assertEquals(true, t2.has(34));
		assertEquals(false, t2.has(60));
		assertEquals(true, t12.has(7));
		assertEquals(false, t12.has(36));
	}

	public void findTest() {
		assertEquals(null, t1.find(5));

		Bst findTest = new Empty().insert(58).insert(50).insert(64).insert(37);
		assertEquals(findTest.toString(), t12.find(58).toString());
	}

	public void insertTest() {
		// Dosnt seem right to test using the predefined trees as that uses the
		// insert method
		assertEquals(new Leaf(5).toString(), t1.insert(5).toString());
		assertEquals(new Fork(5, new Leaf(2), new Leaf(10)).toString(), t1
				.insert(5).insert(10).insert(2).toString());

	}

	public void deleteTest() {

		Bst deleteTest = t1.insert(34).insert(15).insert(58).insert(7)
				.insert(20).insert(50).insert(64).insert(1).insert(8)
				.insert(37);

		assertEquals(deleteTest.toString(), t12.delete(16).toString());
	}

	public void delete2Test() {
		// Uses the left most node from the right hand tree

		assertEquals(new Empty().toString(), t2.deleteSmallest().toString());

		Bst testDelete2 = new Empty().insert(34).insert(16).insert(58)
				.insert(8).insert(20).insert(50).insert(64).insert(1)
				.insert(15).insert(37);

		assertEquals(testDelete2.toString(), t12.delete2(7).toString());
	}

	public void smallestTest() {
		assertEquals(34, t2.smallest());
		assertEquals(1, t12.smallest());
	}

	public void deleteSmallestTest() {

		assertEquals(new Empty().toString(), t2.deleteSmallest().toString());

		Bst testDeleteSmallest = new Empty().insert(34).insert(16).insert(58)
				.insert(7).insert(20).insert(50).insert(64).insert(8)
				.insert(37).insert(15);

		assertEquals(testDeleteSmallest.toString(), t12.deleteSmallest()
				.toString());

	}

	public void largestTest() {
		assertEquals(34, t2.largest());
		assertEquals(64, t12.largest());
	}

	public void deleteLargestTest() {
		assertEquals(new Empty().toString(), t2.deleteLargest().toString());

		Bst testDeleteLargest = new Empty().insert(34).insert(16).insert(58)
				.insert(7).insert(20).insert(50).insert(1).insert(8).insert(37)
				.insert(15);

		assertEquals(testDeleteLargest.toString(), t12.deleteLargest()
				.toString());

	}

	public void sizeTest() {
		assertEquals(0, t1.size());
		assertEquals(1, t2.size());
		assertEquals(2, t3.size());
		assertEquals(11, t12.size());
	}

	public void heightTest() {
		assertEquals(-1, t1.height());
		assertEquals(0, t2.height());
		assertEquals(1, t4.height());
		assertEquals(4, t12.height());
	}

	public void toStringTest() {
		assertEquals("Empty", t1.toString());
		assertEquals("Leaf(34)", t2.toString());

		assertEquals(
				"Fork(34,Fork(16,Fork(7,Leaf(1),Fork(8,Empty,Leaf(15))),Leaf(20)),Fork(58,Fork(50,Leaf(37),Empty),Leaf(64)))",
				t12.toString());
	}

	public void saveInOrderTest() {

		int[] a = new int[t12.size()];
		int[] b = { 1, 7, 8, 15, 16, 20, 34, 37, 50, 58, 64 };

		t12.saveInOrder(a);

		// Check that at every array position the correct value is there.
		for (int i = 0; i < a.length; i++) {
			assertEquals(b[i], a[i]);
		}
	}

}