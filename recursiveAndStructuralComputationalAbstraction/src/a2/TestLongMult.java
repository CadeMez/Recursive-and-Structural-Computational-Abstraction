package a2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLongMult {

	@Test
	public void test01_fromString() {
		String s = "123";
		ArrayList<Integer> exp = new ArrayList<>();
		exp.add(3);
		exp.add(2);
		exp.add(1);
		ArrayList<Integer> got = LongMult.fromString(s);
		assertEquals(exp, got);
	}
	
	
	@Test
	public void test02_toString() {
		String exp = "123";
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(2);
		a.add(1);
		String got = LongMult.toString(a);
		assertEquals(exp, got);
	}
	
	@Test
	public void test03a_getDigit() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(2);
		a.add(1);
		int exp = 3;
		int got = LongMult.getDigit(a, 0);  // the rightmost digit of 123
		assertEquals(exp, got);
	}
	
	@Test
	public void test03b_getDigit() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(2);
		a.add(1);
		int exp = 0;
		int got = LongMult.getDigit(a, 3);
		assertEquals(exp, got);
	}
	
	@Test
	public void test04_sum() {
		ArrayList<Integer> a = new ArrayList<>();  // 123
		a.add(3);
		a.add(2);
		a.add(1);
		
		ArrayList<Integer> b = new ArrayList<>();  // 98
		b.add(8);
		b.add(9);
		
		ArrayList<Integer> exp = new ArrayList<>();  // 221
		exp.add(1);
		exp.add(2);
		exp.add(2);
		
		ArrayList<Integer> got = LongMult.sum(a, b);
		assertEquals(exp, got);
	}
	
	@Test
	public void test05_multiplyDigit() {
		ArrayList<Integer> a = new ArrayList<>();  // 123
		a.add(3);
		a.add(2);
		a.add(1);
		
		int d = 2;
		
		ArrayList<Integer> exp = new ArrayList<>();  // 246
		exp.add(6);
		exp.add(4);
		exp.add(2);
		
		ArrayList<Integer> got = LongMult.multiplyDigit(a, d);
		assertEquals(exp, got);
	}
	
	@Test
	public void test06_multiply() {
		ArrayList<Integer> a = new ArrayList<>();  // 123
		a.add(3);
		a.add(2);
		a.add(1);
		
		ArrayList<Integer> b = new ArrayList<>();  // 987
		b.add(7);
		b.add(8);
		b.add(9);
		
		ArrayList<Integer> exp = new ArrayList<>();  // 121401
		exp.add(1);
		exp.add(0);
		exp.add(4);
		exp.add(1);
		exp.add(2);
		exp.add(1);
		
		ArrayList<Integer> got = LongMult.multiply(a, b);
		assertEquals(exp, got);
	}
}
