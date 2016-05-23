package com.unity6d.krs.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.unity6d.krs.dao.PanoConfigDao;
import com.unity6d.krs.model.PanoConfig;
import com.unity6d.krs.util.db.DaoUtil;
@Repository
public class PanoConfigDaoImpl implements PanoConfigDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int add(PanoConfig panoConfig) {
		String sql = "insert into t_pano_config(user_id,pano_id,config,create_time,update_time) values (?,?,?,now(),now())";
		int id = 0;
		try {
			id = DaoUtil.executeWithGenKey(jdbcTemplate, sql, panoConfig.userId,panoConfig.panoId,panoConfig.config);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return id;
	}

	@Override
	public PanoConfig query(int id) {
		String sql = "select * from t_pano_config where id = ? ";
		try {
			PanoConfig panoConfig = jdbcTemplate.queryForObject(sql,new Object[]{id}, PANO_CONFIG);
			return panoConfig;
		} catch (Exception e) {
			return null;
		}
	}
	
	private static RowMapper<PanoConfig> PANO_CONFIG = new RowMapper<PanoConfig>() {
		
		public PanoConfig mapRow(ResultSet row, int i) throws SQLException {
			PanoConfig panoConfig = new PanoConfig();
			panoConfig.id = row.getInt("id");
			panoConfig.userId = row.getInt("user_id");
			panoConfig.panoId = row.getInt("pano_id");
			panoConfig.config = row.getString("config");
			panoConfig.createTime = row.getTimestamp("create_time");
			panoConfig.updateTime = row.getTimestamp("update_time");
			return panoConfig;
		}
	};
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(PanoConfig panoConfig) {
		String sql = "update t_pano_config set config = ? ,update_time = now() where id = ? ";
		jdbcTemplate.update(sql, panoConfig.config,panoConfig.id);
	}
}
