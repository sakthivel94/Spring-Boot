package com.sample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.Entity.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {

}
