package ssp.string_proc;

import java.util.regex.Matcher;
/*
 * ���ڿ� Ȥ�� ���ڰ� ����, ����, �ѱ����� �Ǵ�
 * 
 * ���Խ��� ����� ���� ��ȿ�� üũ
 * 
 */
import java.util.regex.Pattern;

public class DecideCharType_RegularExpression {

    public static void main(String[] args) {
        String sentence = "azA*Z019 ������***6�� ��µ� iphone5����% �̻����� �ʴ���";
        String[] words = sentence.split(" ");
        
        for(String word : words) {
            System.out.println(word + "=>" + getType(word));
        }

        System.out.println(StringReplace(sentence));
    
    
    }    
	
    //��Ȯ�� ���
    //================================================================================================
    public static boolean getType(String string) {
        return Pattern.matches("^[0-9a-zA-Z��-�R]*$", string);	// ���� �ҹ��� �빮�� �ѱ� ���� �Ǵ�
    }
    //================================================================================================
    
    
  //Ư������ ���� �ϱ� (replaceAll)
    public static String StringReplace(String str){      
       String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
       str =str.replaceAll(match, "");	// ���� ������ �ƴϰ� null "" ��
       return str;
    }

    //���� �����̽� ����
    public static String continueSpaceRemove(String str){
     String match2 = "\\s{2,}";
     str = str.replaceAll(match2, " ");
     return str;
    }

 //�̸��� ��ȿ��
    public static boolean isEmailPattern(String email){
     Pattern pattern=Pattern.compile("\\w+[@]\\w+\\.\\w+");
     Matcher match=pattern.matcher(email);
     return match.find();
    }
  



    // Ư������, ��ȣ�� üũ����, Ư������ ���ٴ� ����
    public static String getType(String word, boolean p) {
        boolean numeric = false;
        boolean alpha = false;
        boolean korean = false;
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);

// �����ϰ� �������� �Ǵ�            
if(Character.isDigit(word.charAt(i)))
    numeric = true;
            
            // ����
            if(index >= 48 && index <= 57) {
                numeric = true;
            // �빮��
            } else if(index >= 65 && index <= 90) {
                alpha = true;
            // �ҹ���    
            } else if(index >= 97 && index <= 122) {
                alpha = true;
            
            } else {
                korean = true;
            }
        }    
        
        if(numeric)
            sb.append("����");
        
        if(alpha) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("����");
        }
        
        if(korean) {
            if(sb.length() > 0)
                sb.append(",");
            sb.append("�ѱ�");
        }
        
        return sb.toString();
    }
}



