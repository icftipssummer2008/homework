/**
 * Created by asad.alim on 7/5/18.
 */
//  Input: 1?0?
//  Output: 1000, 1001, 1100, 1101

public class WildCard {
    public void wildCard(String input) {
        wildCardHelper(input,"");
    }
    private void wildCardHelper(String input,String soFar) {
        if (input.length() == 0)
            System.out.println(soFar);
        else {
            if (input.charAt(0) == '?') {
                wildCardHelper(input.substring(1),soFar + '0');
                wildCardHelper(input.substring(1),soFar + '1');
            }
            else
                wildCardHelper(input.substring(1),soFar+input.charAt(0));
        }

    }

    public static void main(String[] args) {
        WildCard app = new WildCard();
        app.wildCard("1?0?");
    }
}
