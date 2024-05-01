package com.thinkconstructive.restdemo.service;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;

import java.util.List;

public interface CloudVendorService {

    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getByVendorName(String vendorName);
    public List<CloudVendor> getAllCloudVendors();
    public String createCloudVender(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
}
