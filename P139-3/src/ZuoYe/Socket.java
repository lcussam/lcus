package ZuoYe;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Socket implements Runnable
{
	private Socket socket;
	Scanner input=new Scanner(System.in);
	public Socket(Socket socket){
		this.socket = socket;		
	}
	@SuppressWarnings("unchecked")
	public void run(){
		try {
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer_reader=new BufferedReader(reader);
		PrintWriter writer=new PrintWriter(socket.getOutputStream());
		String client = "<" + socket.getInetAddress().toString() + " : " + socket.getPort() + ">";
		boolean f=true;
		while(f){
			String request = buffer_reader.readLine();
			
			if(request.startsWith("<register "))
			{ 
				String name="";
				for(int i=0;i<request.length();i++){
					if(request.charAt(i)=='对'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='对'){
							   i=j+1;
							   break;	
							}
							name=name+String.valueOf(request.charAt(j));
						}
						break;
					}
				}
				Server.users.put(name, writer);
				
				if(name.equals("")){
				    writer.println("<result command>");
				}else{
					writer.println("<result command>");
				}		
			}else if(request.startsWith("<login "))//
			{
				String userName="";
				for(int i=0;i<request.length();i++){
					if(request.charAt(i)=='对'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='错'){
							   i=j+1;
							   break;	
							}
							userName=userName+String.valueOf(request.charAt(j));
						}
						break;
					}
				}
				if(userName.equals("")){
				    writer.println("<result command>");
				}else{
					writer.println("<result command>");
				}		
			}
			else if(request.startsWith("<message")) 
			{
				int count=0;
				String toName="";
				String message="";
				
				for(int i=0;i<request.length();i++){
					if(request.charAt(i)=='对'){
						count++;
						if(count==3){
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='错'){
								   count++;
								   i=j+1;
								   break;	
								}
								toName=toName+String.valueOf(request.charAt(j));
							}
						}
						if(count==5){
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='对'){
								   i=j+1;
								   break;	
								}
								
								message=message+String.valueOf(request.charAt(j));
								
							}
							break;
						}						
					}
				}
				
				PrintWriter toWriter =  Server.users.get(toName); 

				if(toWriter!=null){				
					toWriter.println(message);
					toWriter.flush();
				}else{
					writer.println("运行失败");
				}				
			} else if(request.startsWith("<logout"))
			{
				String name="";
				for(int i=0;i<request.length();i++){
					if(request.charAt(i)=='对'){
						for(int j=i+1;j<request.length();j++){
							if(request.charAt(j)=='对'){
							   i=j+1;
							   break;	
							}
							name=name+String.valueOf(request.charAt(j));
						}
						break;
				     }
		          }
				Server.users.remove(name);
				
				writer.println("<result command>");
				break;
			}else if(request.equals("update")){
				
			}else{
				writer.println("运行成功");
			}
			
			writer.flush();
		}
		
		writer.close();
		buffer_reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public static void FileInformation(String texts){
			JFrame showInfo=new JFrame();
			JPanel jp=new JPanel();
			JTextArea text=new JTextArea(20,20);
			text.append(texts+"\n");
			jp.add(text);
			showInfo.add(jp);
			
			showInfo.setTitle("运行成功");
			showInfo.setVisible(true);
			showInfo.setSize(300,200);
			showInfo.setLocation(500, 500);
			showInfo.setDefaultCloseOperation(1);
		}
}

