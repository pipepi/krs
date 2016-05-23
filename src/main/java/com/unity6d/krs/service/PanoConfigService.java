package com.unity6d.krs.service;

import com.unity6d.krs.model.PanoConfig;

public interface PanoConfigService {
	public int add(PanoConfig panoConfig);
	public void delete(int id);
	public void update(PanoConfig panoConfig);
	public PanoConfig query(int id);
}
