package ssp.string_proc;
/*
 *  String 클래스에 없는 추가, 변경, 삭제 기능이 있다
 */
class  StringBuffer_Exam {
	public static void main(String[] args) {

		// sb를 생성해서 sb2, sb3에 대입하므로 모든값이 같다
		// append, insert, replace, delete 가 가능
		
		StringBuffer sb  = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		sb.append('4').append(56);
		
		StringBuffer sb3 = sb.append(78);			
		sb3.append(9.0);

		System.out.println("sb ="+sb);
		System.out.println("sb2="+sb2);
		System.out.println("sb3="+sb3);

		System.out.println("sb ="+sb.deleteCharAt(10));
		System.out.println("sb ="+sb.delete(3,6));
		System.out.println("sb ="+sb.insert(3,"abc"));
		System.out.println("sb ="+sb.replace(6, sb.length(), "END"));

		System.out.println("capacity="+sb.capacity());
		System.out.println("length="+sb.length());

		// StringBuilder는 StringBuffer에서 쓰레드의 동기화만 제거됨, 사용법은 동일
		StringBuilder sbd  = new StringBuilder("01");
		sbd.append('4').append(56);
		System.out.println("StringBuilder sbd ="+sbd);
	}
}
