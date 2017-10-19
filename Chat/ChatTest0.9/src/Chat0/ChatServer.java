package Chat0;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.text.StyledEditorKit.BoldAction;

public class ChatServer {
	
	
	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		try {
			 ss = new ServerSocket(8888);
		}catch (BindException e) {
				System.out.println("�˿�ʹ����");
				System.out.println("��ر���س����������з�����");
				System.exit(0);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try{
			started = true;
			while (started) {
				boolean bconnected = false;
				 s = ss.accept();
System.out.println("a client connnented");//�������
				bconnected = true;
				 dis = new DataInputStream(s.getInputStream());
				while(bconnected){
					String str = dis.readUTF();
					System.out.println(str);
				}
				//dis.close();
			}
		}catch (EOFException e) {
			// TODO: handle exception
			System.out.println("client close");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dis != null)dis.close();
				if (s != null) s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
