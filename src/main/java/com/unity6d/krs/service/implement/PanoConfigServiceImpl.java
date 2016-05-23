package com.unity6d.krs.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unity6d.krs.dao.PanoConfigDao;
import com.unity6d.krs.model.PanoConfig;
import com.unity6d.krs.service.PanoConfigService;
@Service
public class PanoConfigServiceImpl implements PanoConfigService{
	@Autowired
	PanoConfigDao panoConfigDao;
	@Override
	public int add(PanoConfig panoConfig) {
		return panoConfigDao.add(panoConfig);
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public void update(PanoConfig panoConfig) {
		panoConfigDao.update(panoConfig);
	}

	@Override
	public PanoConfig query(int id) {
		return panoConfigDao.query(id);
	}
	
}
