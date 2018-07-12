import java.util.Arrays;
public class Powerset {

	public static void main(String[] args) {
		char[] subsets = new char[] {'a','b','c'};
		printAllSubsets(subsets);
	}
	
	public static void printAllSubsets(char[] array) {
		char[] output = new char[array.length];
		
		pASHelper(array,0,output,0);
	}
	
	public static void pASHelper(char[] array,int read,char[] output, int write) {
		System.out.println("output ="+ Arrays.toString(output)+"read ="+read+"write ="+write);
		if(read==array.length) {
			System.out.print("{");
			for (int i=0; i< write;i++){
				System.out.print(output[i]);
			}
			System.out.println("}");
			System.out.println("^ final output\n");
			return;
		}
		pASHelper(array,read+1,output,write);
		
		output[write] = array[read];
		
		pASHelper(array,read+1,output,write+1);
	}

}
