package com.jt.servlets.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.jt.servlets.utils.DbConnection;
/**
 * BeanListHandler    将查询结果的每一行封装到user对象，然后再存入List集合
 * ColumnListHandler  将查询结果的指定列的数据封装到List集合中
 * MapHandler         将查询结果的第一行数据封装到map结合（key==列名，value==列值）
 * BeanHandler        将查询结果的第一行数据，封装到user对象
 * <p>
 * ①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
 * ②ArrayListHandler   将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
 * ⑥MapHandler         将查询结果的第一行数据封装到map结合（key==列名，value==列值）
 * ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
 * ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
 * ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
 * ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果
 */
public class CategoryDao implements ICommonDao{

	public List<Integer> findAll(String cid) {
		 String sql = "select i.id from product p, productimage i where i.pid=p.id and p.id in "
		 		+ "(select id from product where cid=? )";
		 List<Integer> ce = null;
	        try {
	            ce = DbConnection.getInstance()//返回的是个Integer集合list,不管你范型里设的是什么
	                    .getQueryRunner()
	                    .query(sql, new ColumnListHandler<Integer>(),cid);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return ce;
	}
	

}
