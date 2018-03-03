package com.repository;

import com.entity.IpAddress;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IpRepository extends PagingAndSortingRepository<IpAddress, Long> {
}
