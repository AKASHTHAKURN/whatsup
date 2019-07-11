package ssp.string_proc;

import java.util.regex.Matcher;
/*
 * ¹®ÀÚ¿­ È¤Àº ¹®ÀÚ°¡ ¼ýÀÚ, ¿µ¾î, ÇÑ±ÛÀÎÁö ÆÇ´Ü
 * 
 * Á¤±Ô½ÄÀ» »ç¿ëÇÑ ¹®ÀÚ À¯È¿¼º Ã¼Å©
 * 
 */
import java.util.regex.Pattern;

public class DecideCharType_RegularExpression {

    public static void main(String[] args) {
        String sentence = "azA*Z019 ¾ÆÀÌÆù***6¸¦ »ò´Âµ¥ iphone5º¸´Ù% ÀÌ»ÚÁö´Â ¾Ê´õ¶ó";
        String[] words = sentence.split(" ");
        
        for(String word : words) {
            System.out.println(word + "=>" + getType(word));
        }

        System.out.println(StringReplace(sentence));
    
    
    }    
	
    //Á¤È®ÇÑ ¹æ¹ý
    //================================================================================================
    public static boolean getType(String string) {
        return Pattern.matches("^[0-9a-zA-Z°¡-ÆR]*$", string);	// ¼ýÀÚ ¼Ò¹®ÀÚ ´ë¹®ÀÚ ÇÑ±Û ÀÎÁö ÆÇ´Ü
    }
    //================================================================================================
    
    
  //Æ¯¼ö¹®ÀÚ Á¦°Å ÇÏ±â (replaceAll)
    public static String StringReplace(String str){      
       String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
       str =str.replaceAll(match, "");	// ÁÖÀÇ °ø¹éÀÌ ¾Æ´Ï°í null "" ÀÓ
       return str;
    }

    //¿¬¼Ó ½ºÆäÀÌ½º Á¦°Å
    public static String continueSpaceRemove(String str){
     String match2 = "\\s{2,}";
     str = str.replaceAll(match2, " ");
     return str;
    }

 //ÀÌ¸ÞÀÏ À¯È¿¼º
    public static boolean isEmailPattern(String email){
     Pattern pattern=Pattern.compile("\\w+[@]\\w+\\.\\w+");
     Matcher match=pattern.matcher(email);
     return match.find();
    }
  



    // Æ¯¼ö¹®ÀÚ, ±âÈ£´Â Ã¼Å©¾ÈÇÔ, Æ¯¼ö¹®ÀÚ ¾ø´Ù´Â °¡Á¤
    public static String getType(String word, boolean p) {
        boolean numeric = false;
        boolean alpha = false;
        boolean korean = false;
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);

// °£´ÜÇÏ°Ô ¼ýÀÚÀÎÁö ÆÇ´Ü            
if(Character.isDigit(word.charAt(i)))
    numeric = true;
            
            // ¼ýÀÚ
            if(index >= 48 && index <= 57) {
                numeric = true;
            // ´ë¹®ÀÚ
            } else if(index >= 65 && index <= 90) {
                alpha = true;
            // ¼Ò¹®ÀÚ    
            } else if(index >= 97 && index <= 122) {
                alpha = true;
            
            } else {
                korean = true;
            }
        }    
        
        if(numeric)
            sb.append("¼ýÀÚ");
        
        if(alpha) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("¿µ¹®");
        }
        
        if(korean) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("ÇÑ±Û");
        }
        
        return sb.toString();
    }
}



