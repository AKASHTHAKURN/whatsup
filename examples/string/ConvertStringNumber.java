package ssp.string_proc;

public class ConvertStringNumber {

	public static void main(String[] args) {

		/*****************************************/
		/*
		 * Summary
		 */
		
		// �⺻�� -> ���ڿ�
		String str;
		str = String.valueOf(100);
		str = String.valueOf(10.5);
		
		
		// ���ڿ� -> �⺻��
		int n1 = Integer.valueOf("1024");
		int n2 = Integer.parseInt("1966");
		
		/*****************************************/
		
		/*
		 * �⺻�� -> ���ڿ�
		 */
		// static String valueOf(Object o)
		// boolean b, char c, int i, long l, float f, double d, Objec o
		// ���ڿ��� ��ȯ�Ͽ� ��ȯ�Ѵ�, ������������ toString()�� ȣ���� ����� ��ȯ�Ѵ�
		System.out.println(String.valueOf(true));		// boolean
		System.out.println(String.valueOf('a'));		// char
		System.out.println(String.valueOf(100));		// int
		System.out.println(String.valueOf(100L));		// long
		System.out.println(String.valueOf(10.1f));		// float
		System.out.println(String.valueOf(10.1d));		// double
		
		/*
		 * �������� ������ȯ�Ͽ� -> ���ڿ�
		 */
		// public static String toHexString(int i)
		// ������ 16���� ������ ��ȯ
		// ��Ʈ�� �迭 �ʱ�ȭ ���
		String[] st = new String[3];
		st[0] = Integer.toHexString(255).toUpperCase();
		st[1] = Integer.toBinaryString(100);
		st[2] = Integer.toOctalString(16);
		for(String ss : st) System.out.println(ss);

		/*
		 * ���ڿ� -> ������
		 */
		int i1	= Integer.valueOf("255");
		int	i2 	= Integer.valueOf("ff", 16);	// radix

		System.out.println("i2 = " + i2);
		
		/*
		 * ���ڿ� -> �⺻��
		 */
		int 	i 	= Integer.parseInt("1024");
		boolean b 	= Boolean.parseBoolean("true"); 
		byte 	bt 	= Byte.parseByte("10");
		short 	s 	= Short.parseShort("20");
		long 	l 	= Long.parseLong("50000000");
		float	f 	= Float.parseFloat("10.2");
		double	d 	= Double.parseDouble("10.2");
		
		/*
		 * ���� -> �⺻��, ���ڴ� substring�� ����Ͽ� String �ѱ��ڷ� ���� ó���ϴ°� ����
		 */
		i = Character.digit('5', 10); // radix, ���ڰ� �ƴҰ�� -1�� ��ȯ��

		/*
		 * ��¥ ��ȯ
		 */
		java.util.Date dt = new java.util.Date();
		String date = String.valueOf(dt);
		System.out.println(dt);

	}

}
