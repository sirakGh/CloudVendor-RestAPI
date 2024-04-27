package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.response.ResponseHandler;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("get/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder(
                "Requested CloudVendor is given here.",
                HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }
    @GetMapping("/get")
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping("/add")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVender(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping("/update")
    public String updatedCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVender(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }
    @DeleteMapping("delete/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId")String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
