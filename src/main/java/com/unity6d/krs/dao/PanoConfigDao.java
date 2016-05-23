package com.unity6d.krs.dao;

import com.unity6d.krs.model.PanoConfig;

public interface PanoConfigDao {
	public int add(PanoConfig panoConfig);
	public void delete(int id);
	public void update(PanoConfig panoConfig);
	public PanoConfig query(int id);
}
