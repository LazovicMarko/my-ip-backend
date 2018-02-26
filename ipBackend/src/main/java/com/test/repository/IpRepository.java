package com.test.repository;

import com.test.entity.IpAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IpRepository extends PagingAndSortingRepository<IpAddress, Long> {
}
