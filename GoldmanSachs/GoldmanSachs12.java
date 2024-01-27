/**
 * QUES 12 -> Run Length Encoding (GFG)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class GfG {
	public static String encode(String str) {
	    StringBuilder sb = new StringBuilder();
	    char lastChar = str.charAt(0);
	    int count = 1;
	    if(str.length() == 1) {
	        sb.append(lastChar);
	        sb.append(count);
	        return sb.toString();
	    }
	    for(int i=1;i<str.length();i++) {
	        if(str.charAt(i) != lastChar) {
	            sb.append(lastChar);
	            sb.append(count);
	            lastChar = str.charAt(i);
	            count = 1;
	        } else {
	            count++;
	        }
	        if(i == str.length() - 1) {
	            sb.append(lastChar);
	            sb.append(count);
	        }
	    }
	    return sb.toString();
	}
}