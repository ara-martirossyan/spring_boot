package com.aralmighty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aralmighty.model.Status;
import com.aralmighty.model.StatusDao;

@Service
public class StatusService {
	
	public final static int PAGESIZE = 3;
	
	@Autowired
	private StatusDao statusDao;
	
	public void save(Status status) {
		statusDao.save(status);
	}
	
	public Status getLatest() {
		return statusDao.findFirstByOrderByAddedAtDesc();
	}
	
	public void delete(Long id) {
		statusDao.delete(id);
	}
	
	public Status findById(Long id) {
		Status status = statusDao.findOne(id);
		return status;
	}
	
	public Page<Status> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "addedAt");
		return statusDao.findAll(request);
	}
	
}
