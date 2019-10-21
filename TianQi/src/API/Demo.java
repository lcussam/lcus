package API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class Demo
{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String STATION_Id_C;
		
		Scanner input = new Scanner(System.in);	
		STATION_Id_C = input.nextLine();
		
		String startTime;
		System.out.println("����ʱ�䣺����ʽΪ��YYYYMMDD��");
		startTime = input.nextLine();

		
		
		String urlStr = "http://t.weather.sojson.com/api/weather/city/101030100";
		URL url = new URL(urlStr);
		StringBuffer document = new StringBuffer();
		URLConnection conn = url.openConnection();//URL����
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));//��ȡ������
		String line = null;
		while ((line = reader.readLine()) != null){ 
			document.append(line); 
		}
		reader.close();
		
		JSONObject json =JSONObject.fromObject(document.toString());  
        JSONArray ja = JSONArray.fromObject(json.get("DS"));//��DS����Ϊ�й���������������JSON������Ӧ�����������Σ����߿�������֤
		Map<String,Class<Weather>> map = new HashMap<String,Class<Weather>>();
		map.put("list",Weather.class);
		List<Weather> list = JSONArray.toList(ja,Weather.class,map);//�����л�Ϊ��������
		int i=0;
		System.out.println("վ���"+"   "+"Сʱ"+"   "+"�¶�");
		for(Weather w:list) {
			System.out.println(STATION_Id_C+"   "+i+":00"+"   "+w.getTEM());
			i++;
		}
	}
}