package java9;

import java.util.function.Function;

public class FunctionTest {
	static Function<Integer, Integer> cube = new Function<Integer, Integer>() {
	{
		System.out.println("CUBE");
	}
	@Override
	public Integer apply(Integer t) {
			System.out.println("in cube");
			return t * t * t;
		}
	};
	  
	public static void main(String[] args) {
		  System.out.format("%d", cube.apply(2));
	}
	
}