import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DbTools {
	public static void Add(Man m)
	{
	Connection connect=null;
	PreparedStatement Statement=null;
	ResultSet rs = null;
	String MES="MES";
	String PJ="PJ";
	try {
		Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Success loading Mysql Driver1!");
	    }
	catch (Exception e) {
	         System.out.print("Error loading Mysql Driver!");
	         e.printStackTrace();
	    }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
	     Statement=connect.prepareStatement("SELECT * FROM user where username='MMMM'");
	     rs =Statement.executeQuery();
	     rs.next();
	     m.MESID=rs.getInt(9);
	     m.PJID=m.MESID;
	   }catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
	     Statement=connect.prepareStatement("update user set MESID = ? where username='MMMM'");
	     Statement.setLong(1,m.PJID+1);
	     Statement.executeUpdate();
	   }catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	try {
		Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Success loading Mysql Driver!");
	    }
	catch (Exception e) {
	         System.out.print("Error loading Mysql Driver!");
	         e.printStackTrace();
	    }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
	     Statement=connect.prepareStatement("INSERT INTO user VALUES"
	     		+ "(?,?,?,?,?,?,?,?,?,?)");
	     Statement.setString(1,m.username);
	     Statement.setLong(2,m.job);
	     Statement.setString(3,m.name);
	     Statement.setLong(4,m.sex);
	     Statement.setString(5,m.pwd);
	     Statement.setString(6,m.grade);
	     Statement.setString(7,m.subject);
	     Statement.setString(8,m.tel);
	     Statement.setLong(9,m.MESID);
	     Statement.setLong(10,m.PJID);
	     Statement.executeUpdate();
	   }catch (SQLException e) {
           e.printStackTrace();
       }finally
       {
           try {
               if(Statement!=null)
               {
            	   Statement.close();
               }
               if(connect!=null)
               {
                   connect.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
	MES+=String.valueOf(m.MESID);
	PJ+=String.valueOf(m.PJID);
	CreateTable(MES,PJ);
	 }
	
	private static void CreateTable(String mES,String pJ) {
		Connection connect=null;
		PreparedStatement Statement=null;
		
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
		     Statement=connect.prepareStatement("create table " + mES +" (frm varchar(20),DTA varchar(20),STR varchar(1000))");
		     System.out.println("create table " + mES +" (frm varchar(20),DTA varchar(20),STR varchar(1000))");
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                {
	                    Statement.close();
	                }
	                if(connect!=null)
	                {
	                    connect.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
		     Statement=connect.prepareStatement("create table  " + pJ +" (DTA varchar(20),STR varchar(2000),star int)");
		     System.out.println("create table  " + pJ +" (DTA varchar(20),STR varchar(2000),star int)");
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                {
	                    Statement.close();
	                }
	                if(connect!=null)
	                {
	                    connect.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	public static List Querry1(Man m)
	{
		return null;
	}
}