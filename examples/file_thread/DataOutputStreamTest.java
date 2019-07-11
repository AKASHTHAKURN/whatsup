package ssp.file;

import java.io.*;

public class DataOutputStreamTest {
  public static void main(String[] args) {
    FileOutputStream fos = null;
    DataOutputStream dos = null;

    try {
      fos = new FileOutputStream("data.bin");
      dos = new DataOutputStream(fos);
   
      dos.writeBoolean(true);
      //Writes the specified byte (the low eight bits of the argument b) to the underlying output stream
      dos.write(5);
      dos.writeByte((byte)5);
      dos.writeInt(100);
      dos.writeDouble(200.5);
      dos.writeUTF("Hi., Santaclaus.AlexanderII.Ahn...");
   
      System.out.println("저장하였습니다.");
    } catch(Exception ex) {
      System.out.println(ex);
    } finally {
      try {
        fos.close();
      } catch (IOException e) {}
      try {
        dos.close();
      } catch (IOException e) {}
    }
  }
}