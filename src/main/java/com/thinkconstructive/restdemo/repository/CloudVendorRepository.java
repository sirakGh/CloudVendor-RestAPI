package com.thinkconstructive.restdemo.repository;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    List<CloudVendor> findByVendorName(String vendorName);

}
