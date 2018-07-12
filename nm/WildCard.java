import java.util.Scanner;

public class WildCard{
  public static void main(String[] args){
    //Scanner s = new Scanner(System.in);

    //System.out.println("Hello "+);
    //wildCard("1?");
    wildCard("1?0?");
  }


  public static void wildCard(String string){
    wildCard(string,0);
  }

  // Since we have to print ALL, means treverse whole tree, not need to return anything

  public static void wildCard(String string,int index){

    if(index >= string.length()){
      System.out.println(string);
    }else if (string.charAt(index) == '?' ){
      wildCard(replaceCharAt(string,index,'0'), index+1);
      wildCard(replaceCharAt(string,index,'1'), index+1);
    }else{
      wildCard(string, index+1);
    }
  }
  // #CharArrayToString
  public static String replaceCharAt(String string,int index, char ch){
    char[] chars = string.toCharArray();
    chars[index] = ch;
    return String.valueOf(chars);
  }

}
