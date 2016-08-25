package yn.demorest;

import java.sql.*;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class dbhelpser {

	public static JSONObject Excutesql(String dburl,String dbuser,String dbpassword,String sql,String[] sqls[],String datasql){
		JSONObject result = new JSONObject();//返回对象
		//Connection con = null;//数据库连接对象
		PreparedStatement  pre = null;
	    ResultSet dbresult = null;
	    
	    //获取数据库信息
	    Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
        System.out.println("开始尝试连接数据库！");
        String url = dburl;//数据库连接
        String user = dbuser;// 数据库用户名
        String password = dbpassword;//用户密码
        
	    try(Connection con = DriverManager.getConnection(url, user, password))// 创建数据库连接
	    {
	    	System.out.println("连接成功！");
	       
	        if(sql!=null){
	        	 pre = con.prepareStatement(sql);
	        }
	        
	        if(datasql!=null){
	        	pre = con.prepareStatement(datasql);
	        }
	        
	        dbresult = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    /*
	    finally
	    {
	        try
	        {
	            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	            // 注意关闭的顺序，最后使用的最先关闭
	            if (result != null)
	                result.close();
	            if (pre != null)
	                pre.close();
	            if (con != null)
	                con.close();
	            System.out.println("数据库连接已关闭！");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    */
	    
		return result;
	}
}
