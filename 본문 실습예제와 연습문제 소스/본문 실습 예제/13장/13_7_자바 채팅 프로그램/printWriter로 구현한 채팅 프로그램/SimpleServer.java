package ch13.ex4;

import java.io.*;
import java.net.*;

public class SimpleServer{
	public static void main(String[] args){
		 InputStream is;
		 BufferedReader br_in;
		 BufferedReader br_out;
		 BufferedWriter bw;
		 PrintWriter pw=null;
		 OutputStream os;
		 ServerSocket serverSocket;
		 Socket s1=null;
		 String inMessage=null;
		 String outMessage=null;
		try{
			serverSocket= new ServerSocket(5434);
			System.out.println("서버 실행 중...");
			//클라이언트의 접속을 인지 시에 accept()메소드를 호출해서 소켓 객체를 생성한다.
			s1= serverSocket.accept();
			is=s1.getInputStream();
			os = s1.getOutputStream();
			
			br_out=new BufferedReader(new InputStreamReader(System.in));
			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw=new PrintWriter(bw,true); //자동으로 flush 한다.
			pw.println("server: 접속을 환영합니다.");
			while(true){
				
				inMessage=br_in.readLine();
				System.out.println(inMessage);
				
				outMessage=br_out.readLine();
				if(outMessage.equals("exit"))
					break;
				pw.println("server: "+outMessage);
			}
			pw.close();
			s1.close();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}

