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
		System.out.println("修改MySQL数据库数据");        
		String sql = "update student set sname = 'amy' where sname = 'tom'";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("修改成功！");        
		} 
		catch (Exception e) 
		{            
			// TODO Auto-generated catch block            
			e.printStackTrace();        
		}    
	}
	/**

     * 删除数据

     */
	private static void deleteData() 
	{        
		System.out.println("删除MySQL数据库数据");        
		String sql = "delete from student where sname = 'tom'";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("删除成功！");        
		} 
		catch (Exception e) 
		{            
			// TODO Auto-generated catch block           
			e.printStackTrace();        
		}    
	}
	/**

     * 插入数据

     */
	private static void insertData() 
	{        
		System.out.println("插入MySQL数据库数据");        //这里注意Sno，最好别重复，不过没设置主键，重复也没啥关系        
		String sql = "insert into student (sno, sname, sage, ssex) values (4, 'tom', 18, '女')";        
		try 
		{            
			JDBCUtils.updata(sql);            
			System.out.println("插入成功！");        
		} catch (Exception e) 
		{            
			// TODO Auto-generated catch block            
			e.printStackTrace();        
		}    
	}
	 /**

     * 查询数据

     */
	private static void selectData() 
	{        
		System.out.println("查询MySQL数据库数据");        
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