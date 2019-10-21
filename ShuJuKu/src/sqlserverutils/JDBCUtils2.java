package sqlserverutils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils2
{
	 private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// ����������
	 private static final String DBNAME = "school";// ���ݿ���
	 private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName="+DBNAME;// ����URL
	 private static final String DBUSER = "sa";// ���ݿ��û���
	 private static final String DBPASSWORD = "tjw19951105";// ���ݿ�����
	 private static Connection conn = null;
	 private static PreparedStatement ps = null;
	 private static ResultSet rs = null;
	 /*

	     * ��ȡ���ݿ�����

	     */
	 public static Connection getConnection() 
	 {    
		 try 
		 {    
			 Class.forName(DBDRIVER);// ע������    
			 conn = DriverManager.getConnection(DBURL,DBUSER,                    DBPASSWORD);// ������Ӷ���
			 System.out.println("�ɹ�����SQL Server��������");  
		} 
		 catch (ClassNotFoundException e)
		 {
			 // �����������޷��ҵ��쳣    
			 System.out.println("�Ҳ���SQL Server��������");     
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
			 rs = ps.executeQuery();        
			 return rs;     
		} 
		 catch (SQLException sqle)
		 {            
			 throw new SQLException("select data Exception: "                    + sqle.getMessage()); 
		} catch (Exception e) 
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