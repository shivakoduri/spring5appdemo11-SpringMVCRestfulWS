package com.myprojects.spring.examples.SpringMVCRestWS.repositories;

import com.myprojects.spring.examples.SpringMVCRestWS.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
