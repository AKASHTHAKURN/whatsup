package ssp.file;

import java.io.*;

public class DataInputStreamTest {
  public static void main(String[] args) {
    FileInputStream fis = null;
    DataInputStream dis = null;

    try {
      fis = new FileInputStream("data.bin");
      dis = new DataInputStream(fis);
   
      /*
       * 저장한 순서대로 읽어오지 않으면 Exception 발생한다
       */
      boolean b  = dis.readBoolean();
      int     b2 = dis.read();
      byte    b3 = dis.readByte();
      int     i  = dis.readInt();
      double  d  = dis.readDouble();
      String  s  = dis.readUTF();
   
      System.out.println("boolean: " + b);
      System.out.println("int    : " + b2);
      System.out.println("byte   : " + b3);
      System.out.println("int    : " + i);
      System.out.println("double : " + d);
      System.out.println("String : " + s);
    } catch(Exception ex) {
      System.out.println(ex);
    } finally {
      try {
        fis.close();
      } catch (IOException e) {}
      try {
        dis.close();
      } catch (IOException e) {}
    }
  }
}