package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 
 * @author hmuha03
 *
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result 
which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers 
for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} 
overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be 
merged and become {5, 8}
 */
public class MergeOverlappingIntervals {
	public static void main(String[] args) {
		Interval[] iArray = {new Interval(1, 3), new Interval(5, 7), new Interval(2, 4), new Interval(6, 8)};
		
		getMergedIntervals(iArray);
	}
	
	private static void getMergedIntervals(Interval[] iArray){
		
		Arrays.sort(iArray, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getStart() - o2.getStart();
			}
		});
		
		for (Interval interval : iArray) {
			System.out.println(interval);
		}
		
		Stack<Interval> stack = new Stack<Interval>();
		
		for(Interval currentInterval : iArray) {
			if(stack.isEmpty()) {
				stack.push(currentInterval);
			}
			else {
				Interval peekInterval = stack.peek();
				
				if(currentInterval.getStart() <= peekInterval.getEnd()) {
					Interval mergedInterval = new Interval(peekInterval.getStart(), currentInterval.getEnd());
					stack.pop();
					stack.push(mergedInterval);
				}
				else {
					stack.push(currentInterval);
				}
			}
			
		}
		
		for (Interval interval : stack) {
			System.out.println(interval);
		}

	}
}

class Interval {
	
	private int start;
	private int end;
	
	
	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
		public String toString() {
			
			return String.format("(%d,%d)", start, end);
		}
}
