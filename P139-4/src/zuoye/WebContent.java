package zuoye;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class WebContent
{
	public static String getOneHtml(String urlString) throws MalformedURLException, IOException{
		 InputStreamReader in=new InputStreamReader(new URL(urlString).openStream(),"gb2312");
		 StringBuilder input=new StringBuilder();
		 int ch;
		 while((ch=in.read())!=-1)input.append((char)ch);
		 //System.out.println("----"+input);
		 return input.toString();
		 }
		 public  List<String> getLink(String s){
		 String regex;
		 List<String> list=new ArrayList<String>(); 
		 regex = "<a href=\"http://www.edu.cn/(.*)\">\\w+</a>";
		 


		 Pattern pa=Pattern.compile(regex,Pattern.DOTALL);
		 Matcher ma=pa.matcher(s);
		 while(ma.find()){
		 list.add(ma.group());
		 }
		 return list;
		 }
}
