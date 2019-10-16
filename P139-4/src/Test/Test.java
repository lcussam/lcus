package Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import zuoye.WebContent;
public class Test
{
	 public  static void main(String args[]){
		 String s="";
		 List<String> list;
		 try {
		 s=WebContent.getOneHtml("http://www.w3.org/Consortium/Member/List");
		} catch (MalformedURLException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		WebContent wc=new WebContent();

		list=wc.getLink(s);
		for(int i=0;i<list.size();i++){
		System.out.println("========="+list.get(i));
		}
		 }
}
