package functional;

import java.util.function.Function;

public class HighOrderFunction {
	public static void main(String[] args) {
		final Function<Integer, Function<Integer,Integer>> f = x -> y -> x + y;
        System.out.println("High order: " +  (f.apply(8)).apply(10));
	}
}
