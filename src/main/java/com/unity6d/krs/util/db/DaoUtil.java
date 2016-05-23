/**
 * 
 */
package com.unity6d.krs.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 * @author lanker
 */
public class DaoUtil {
	public static final int executeWithGenKey(JdbcTemplate jdbcTemplate,
			String sql,
			Object... parameters) throws Exception {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBCUtil.set(conn, ps, parameters);	
			ps.execute();
			rs=ps.getGeneratedKeys();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				throw new Exception("can not got generatedKeys");
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			JDBCUtil.closeResultSet(rs);
			JDBCUtil.closeStatement(ps);
			JDBCUtil.closeConnection(conn);
		}
	}
	public static final <T> T queryForObject(JdbcTemplate jdbcTemplate,String sql, RowMapper<T> rowMapper, Object... args){
		T c = null;
		try {
			c =  jdbcTemplate.queryForObject(sql, rowMapper,args[0]);
		} catch (Exception e) {
			
		}
		return c;
	}
}
