
/**
 * Created by asad.alim on 7/1/18.
 */
public class PrintAllSubsets {

    public void printAllSubsets(char [] array){
        char [] output = new char[array.length];
        printAll(array,0,output,0);
    }

    public void printAll(char[] array, int read, char[] output, int write) {
        if (read == array.length) {
            System.out.print("{");
            for (int i=0; i< write;i++){
               System.out.print(output[i]);
            }
            System.out.println("}");
            return;
        }

        //Not Select
        printAll(array, read+1,output,write);
        output[write] = array[read];

        //Select
        printAll(array,read+1,output,write+1);
    }

    public static void main(String[] args) {
        PrintAllSubsets app = new PrintAllSubsets();
        app.printAllSubsets(new char[]{'a','b','c'});
    }
}

