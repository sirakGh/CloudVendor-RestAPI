package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CloudVendorService cloudVendorService;

    CloudVendor cloudVendor1;
    CloudVendor cloudVendor2;

    List<CloudVendor> cloudVendorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendor1 = new CloudVendor("1", "Amazon", "USA","123-456-7890");
        cloudVendor2 = new CloudVendor("2", "GCP", "Eritrea","000-777-5555");
        cloudVendorList.add(cloudVendor1);
        cloudVendorList.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCloudVendorDetails_success() throws Exception{
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendor1);
        this.mockMvc.perform(get("/cloudvendor/get/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendors() throws Exception{
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor/get")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createCloudVendorDetails() {
    }

    @Test
    void updatedCloudVendorDetails() {
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Success");
        this.mockMvc.perform(delete("/cloudvendor/delete/1")).andDo(print()).andExpect(status().isOk());
    }
}