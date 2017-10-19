package Chat0;


import java.util.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;



public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	
	public static List<Client> clients = new ArrayList<Client>();
	public static void main(String[] args) {
		

		new ChatServer().start();
		
	}

	public void start() {
		try {
			 ss = new ServerSocket(8888);
			 started = true;
		}catch (BindException e) {
				System.out.println("�˿�ʹ����");
				System.out.println("��ر���س����������з�����");
				System.exit(0);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
System.out.println("a client connnented");//�������
				new Thread(c).start();
				clients.add(c);
			
				//dis.close();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class Client implements Runnable{
		private Socket s;
		private DataInputStream dis = null;
		private boolean  bConnected = false;
		private DataOutputStream dos = null;
		public Client(Socket s) {
			this.s=s;
			try {
				dis = new DataInputStream( s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String str){
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				clients.remove(this);
				System.out.println("�Է��˳��ˣ�");
				//e.printStackTrace();
			}
		}
		
		public void run() {
			Client c = null;
			try{
				while (bConnected) {
					String	str = dis.readUTF();
	System.out.println(str);
					for (int i = 0; i < clients.size(); i++) {
						 c = clients.get(i);
						c.send(str);
					}
//					/*
//					for(Iterator<Client> it = clients.iterator(); it.hasNext();){
//						Client c =it.next();
//						c.send(str);
//					}
//					*/
				} 
			}catch (SocketException e) {
					
					System.out.println("a client quit");
					
			}catch (EOFException e) {
					System.out.println("client close");			
			}catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						if(dis != null)dis.close();
						if (dos != null) dos.close();
						if (s != null) {
							s.close();
							s=null;
							
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
					
						
				}
			}
		
		}
}

