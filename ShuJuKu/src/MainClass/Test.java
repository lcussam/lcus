package MainClass;
import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

 

import domain.Student;

import mysqlutils.JDBCUtils;
public class Test
{
	private static void updateDate() 
	{        
		System.out.println("�޸�MySQL���ݿ�����");        
		String sql = "update student set sname = 'amy' where sname = 'tom'";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("�޸ĳɹ���");        
		} 
		catch (Exception e) 
		{            
			// TODO Auto-generated catch block            
			e.printStackTrace();        
		}    
	}
	/**

     * ɾ������

     */
	private static void deleteData() 
	{        
		System.out.println("ɾ��MySQL���ݿ�����");        
		String sql = "delete from student where sname = 'tom'";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("ɾ���ɹ���");        
		} 
		catch (Exception e) 
		{            
			// TODO Auto-generated catch block           
			e.printStackTrace();        
		}    
	}
	/**

     * ��������

     */
	private static void insertData() 
	{        
		System.out.println("����MySQL���ݿ�����");        //����ע��Sno����ñ��ظ�������û�����������ظ�Ҳûɶ��ϵ        
		String sql = "insert into student (sno, sname, sage, ssex) values (4, 'tom', 18, 'Ů')";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("����ɹ���");        
		} catch (Exception e) 
		{            
			// TODO Auto-generated catch block            
			e.printStackTrace();        
		}    
	}
	 /**

     * ��ѯ����

     */
	private static void selectData() 
	{        
		System.out.println("��ѯMySQL���ݿ�����");        
		String sql = "select * from student";        
		List<Student> list = new ArrayList<Student>();        
		try 
		{            
			ResultSet rs = JDBCUtils.select(sql);            
			while (rs.next()) 
		{                
				list.add(new Student(rs.getInt("sno"), rs.getString("sname"), rs.getInt("sage"), rs.getString("ssex")));            
		}            
			for (int i = 0; i < list.size(); i++) 
			{                
				System.out.println(list.get(i));            
			}        
		} catch (Exception e) 
		{            
			// TODO Auto-generated catch block            
			e.printStackTrace();        
		}    
	}
}