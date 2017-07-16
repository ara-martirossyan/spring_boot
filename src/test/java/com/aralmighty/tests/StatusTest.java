package com.aralmighty.tests;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aralmighty.App;
import com.aralmighty.model.Status;
import com.aralmighty.model.StatusDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {
	
	@Autowired
	private StatusDao statusDao;
	
	@Test
	public void testStatusSave() {
		Status status = new Status("This is a status update.");
		statusDao.save(status);
		
		assertNotNull("Non-null ID", status.getId());
		assertNotNull("Non-null ID", status.getAddedAt());
		
		Status statusRetrieved = statusDao.findOne(status.getId());
		assertEquals("Matching Status", status, statusRetrieved);
	}
	
	@Test
	public void testFindLatest() {
		
		Calendar calendar = Calendar.getInstance();
		
		Status lastStatus = null;
		
		for(int i=0; i<10; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			Status status = new Status("Status update " + i, calendar.getTime());
			
			statusDao.save(status);
			
			lastStatus = status;
		}
		
		Status retrieved = statusDao.findFirstByOrderByAddedAtDesc();
		
		assertEquals("Latest status update", lastStatus, retrieved);
	}
}
