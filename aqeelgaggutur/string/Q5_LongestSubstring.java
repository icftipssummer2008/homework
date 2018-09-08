public class Neuronym {
    public static void printAllNeuronyms(String s){
        if(s.length() < 5) return;
        for(int i = 1; i < s.length() - 2; i++){
            for(int j = i + 1; j < s.length() - 1; j++) {
                printIt(s, i, j);
            }
        }
    }

    public static void printIt(String s, int start, int end){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, start));
        sb.append(end - start + 1);
        sb.append(s.substring(end + 1, s.length()));
        System.out.println(sb.toString());
    }
}