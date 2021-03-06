package ch12.ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//문자열 속에 문자열 검색하는 예제
public class MovieTest3 {
	public static void getMovieInfo(String movie){
		File file = new File("movieInfo.txt");
		boolean isExist=false;
		isExist=movie.matches(".*액션.*");
		//isExist=movie.matches("(?i).*액션.*");//대소문자 구분없이 문자열 속에 문자열 검색
		
		
		if(isExist==true){
			try {
				System.out.println(movie);
				PrintWriter out = new PrintWriter(new FileWriter(file,true));		
					out.println(movie); 
				out.close();
			} catch (IOException e) {
				System.out.println("IOException");
			}
		}
		
	}
	public static void main(String args[]) {
		File file = new File("movie.txt"); 
		try {
			//node계열 FileReader가 파일에서 char 데이터를 읽어들인후, 다시 BufferedReader로 전달한다.
			BufferedReader in = new BufferedReader(new FileReader(file)); 

			String s;
			s = in.readLine();//버퍼에 개행문자가 입력되는지를 확인한 후, 개행문자앞에 입력된 문자열을 버퍼에서 출력한다.
			while (  s != null) {
		//		System.out.println(s);
				getMovieInfo(s);
				s = in.readLine();
			}
			in.close();
		} catch(FileNotFoundException e1) {
			System.out.println("File not found");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	} 
}
