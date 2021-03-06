package ssp.string_proc;

import java.util.regex.Matcher;
/*
 * 문자열 혹은 문자가 숫자, 영어, 한글인지 판단
 * 
 * 정규식을 사용한 문자 유효성 체크
 * 
 */
import java.util.regex.Pattern;

public class DecideCharType_RegularExpression {

    public static void main(String[] args) {
        String sentence = "azA*Z019 아이폰***6를 샀는데 iphone5보다% 이쁘지는 않더라";
        String[] words = sentence.split(" ");
        
        for(String word : words) {
            System.out.println(word + "=>" + getType(word));
        }

        System.out.println(StringReplace(sentence));
    
    
    }    
	
    //정확한 방법
    //================================================================================================
    public static boolean getType(String string) {
        return Pattern.matches("^[0-9a-zA-Z가-힣]*$", string);	// 숫자 소문자 대문자 한글 인지 판단
    }
    //================================================================================================
    
    
  //특수문자 제거 하기 (replaceAll)
    public static String StringReplace(String str){      
       String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
       str =str.replaceAll(match, "");	// 주의 공백이 아니고 null "" 임
       return str;
    }

    //연속 스페이스 제거
    public static String continueSpaceRemove(String str){
     String match2 = "\\s{2,}";
     str = str.replaceAll(match2, " ");
     return str;
    }

 //이메일 유효성
    public static boolean isEmailPattern(String email){
     Pattern pattern=Pattern.compile("\\w+[@]\\w+\\.\\w+");
     Matcher match=pattern.matcher(email);
     return match.find();
    }
  



    // 특수문자, 기호는 체크안함, 특수문자 없다는 가정
    public static String getType(String word, boolean p) {
        boolean numeric = false;
        boolean alpha = false;
        boolean korean = false;
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);

// 간단하게 숫자인지 판단            
if(Character.isDigit(word.charAt(i)))
    numeric = true;
            
            // 숫자
            if(index >= 48 && index <= 57) {
                numeric = true;
            // 대문자
            } else if(index >= 65 && index <= 90) {
                alpha = true;
            // 소문자    
            } else if(index >= 97 && index <= 122) {
                alpha = true;
            
            } else {
                korean = true;
            }
        }    
        
        if(numeric)
            sb.append("숫자");
        
        if(alpha) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("영문");
        }
        
        if(korean) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("한글");
        }
        
        return sb.toString();
    }
}



