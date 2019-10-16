package ZuoYe;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Client
{
	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("127.0.0.1",888);		
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader = new BufferedReader(reader);
		Scanner input= new Scanner(System.in);
	
		PrintWriter writer = new PrintWriter(socket.getOutputStream());	
		boolean f=true;
		String name=null;
		String toName=null;
		int temp=0;
		int i=0;
		int logout=0; 
		
		while(f){
			 
			String str=null;
			if(i==3){
				
			}else{
				System.out.print("运行结果:");
				i=input.nextInt();
			}
			
			 if(i==1){
				 System.out.print("消息:");
				 String str1=input.next(); 
				 str="<register  name=xu"+str1+"ok/>";
				 writer.println(str);
				 writer.flush();	
				 String echo= buffer_reader.readLine();
				 System.out.println("成功:"+echo);
			 }else if(i==2){
				 System.out.print("消息:");
				 String str1=input.next(); 
				 name=str1;
				 str="<login  name=xu"+str1+"ok/> ";
				 writer.println(str);
				 writer.flush();	
				 String echo= buffer_reader.readLine();
				 System.out.println("失败�:"+echo);
			 }else if(i==3){
				 String message=null;
				 if(temp==0){
					 System.out.print("结果:");
					 toName=input.next();
					 System.out.print("消息("+name+"):");	
					 message=input.next();
					 temp=1;
				 }else{
					 System.out.print("消息("+name+"):");	
					 message=input.next();
				 }	
				 if(message.equals("logout")){
					 logout=1;
				 }else{
					 str="<message from=xu"+name+"xu"+" to=zhang"+toName+"xu"+"  message=zhang"+message+"xu/>";
					 writer.println(str);
					 writer.flush();	
					 String echo= buffer_reader.readLine();
					 System.out.println(toName+":"+echo);
					 }			 			 
			 }
			 if(i==4||logout==1){
				 str="<logout  name=xu"+name+"ok/";
				 writer.println(str);
				 writer.flush();	
				 String response = buffer_reader.readLine();
		         System.out.println("成功:"+ response);
				 f=false;
			 }
		 }	
		writer.close(); 
		buffer_reader.close(); 
		socket.close(); 
	}
	 public static void FileInformation(String texts){
			JFrame showInfo=new JFrame();
			JPanel jp=new JPanel();
			JTextArea text=new JTextArea(20,20);
			text.append(texts+"\n");
			jp.add(text);
			showInfo.add(jp);
			
			showInfo.setTitle("成功");
			showInfo.setVisible(true);
			showInfo.setSize(300,200);
			showInfo.setLocation(500, 500);
			showInfo.setDefaultCloseOperation(1);
	}
}
