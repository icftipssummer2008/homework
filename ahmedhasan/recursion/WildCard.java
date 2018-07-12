
public class WildCard {
	public static void main(String[] args) {
        WildCard app = new WildCard();
        app.wildCard("1?0?");
    }
	
	
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

	    
	}
