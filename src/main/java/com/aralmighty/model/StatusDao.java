package com.aralmighty.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDao extends PagingAndSortingRepository<Status, Long> {
	Status findFirstByOrderByAddedAtDesc();
}
