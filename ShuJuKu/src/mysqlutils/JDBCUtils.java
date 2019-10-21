package mysqlutils;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCUtils
{
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";// ���������� 
	private static final String DBNAME = "school";// ���ݿ��� 
	private static final String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME;// ����URL    
	private static final String DBUSER = "root";// ���ݿ��û���   
	private static final String DBPASSWORD = "tjw19951105";// ���ݿ����� 
	private static Connection conn = null; 
	private static PreparedStatement ps = null; 
	private static ResultSet rs = null;    
	/*     * ��ȡ���ݿ�����     */  
	public static Connection getConnection() 
	{     
		try {   
			Class.forName(DBDRIVER);// ע������  
			conn = (Connection) DriverManager.getConnection(DBURL, DBUSER,                    DBPASSWORD);// ������Ӷ���     
			System.out.println("�ɹ�����MYSQL��������");   
			} catch (ClassNotFoundException e) 
		{// �����������޷��ҵ��쳣    
				System.out.println("�Ҳ���MYSQL��������");     
				System.out.println(e.toString());    
				e.printStackTrace();     
		}
		catch (SQLException e) 
		{
			// ����SQL�쳣       
			e.printStackTrace();    
		}        
		return conn;   
		}
	 public static ResultSet select(String sql) throws Exception 
	 {    
		 try
		 {       
			 conn = getConnection();  
			 ps = (PreparedStatement) conn.prepareStatement(sql); 
			 rs = ps.executeQuery(sql);  
			 return rs;      
			 } 
		 catch (SQLException sqle)
		 {           
			 throw new SQLException("select data Exception: "                    + sqle.getMessage()); 
		}
		 catch (Exception e)
		 {         
			 throw new Exception("System error: " + e.getMessage()); 
			 }   
		 }
	 /*

	     * ��ɾ�ľ������������

	     */
	 public static void updata(String sql) throws Exception
	 {      
		 try 
		 {     
			 conn = getConnection(); 
			 ps = (PreparedStatement) conn.prepareStatement(sql); 
			 ps.executeUpdate();  
			 } 
		 catch (SQLException sqle) 
		 {            
			 throw new SQLException("insert data Exception: "                    + sqle.getMessage());
			 } 
		 finally
		 {    
			 try
			 {                
				 if (ps != null) 
			 {                   
					 ps.close();     
			}           
				 } 
			 catch (Exception e)
			 {                
				 throw new Exception("ps close exception: " + e.getMessage());  
				 }         
			 try
			 {                
				 if (conn != null)
				 {                    
					 conn.close();      
					 }            
				 } 
			 catch (Exception e)
			 {                
				 throw new Exception("conn close exception: " + e.getMessage()); 
				 }      
			 }    
		 }
}