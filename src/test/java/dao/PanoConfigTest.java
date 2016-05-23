package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unity6d.krs.dao.PanoConfigDao;
import com.unity6d.krs.model.PanoConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml","classpath*:/spring-mvc.xml"})
public class PanoConfigTest {
	@Autowired
	PanoConfigDao panoConfigDao;
	//@Test@Rollback(false)
	public void addTest(){
		PanoConfig pc = new PanoConfig();
		pc.userId = 1;
		pc.panoId = 1;
		pc.config = "<hotspot name='to_scene_two' ath='0' atv='0' crr_scene='scene_one' onclick='loadscene(two);'/>";
		panoConfigDao.add(pc);
	}
	@Test
	public void queryTest(){
		PanoConfig pc =panoConfigDao.query(1);
		if(pc!=null){
			System.out.println(pc.panoId+" pano config =\n"+pc.config);
		}else{
			System.out.println("\nno pano config result\n");
		}
	}
}
