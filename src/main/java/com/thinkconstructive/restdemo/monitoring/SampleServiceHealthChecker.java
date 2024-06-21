package com.thinkconstructive.restdemo.monitoring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Controller
public class SampleServiceHealthChecker implements HealthIndicator {

    @Autowired
    private Environment environment;

    @Override
    public Health health()
    {
        try {
            if (isServiceUp()) {
                return Health.up().withDetail("Sample Service", "is working good").build();
            } else {
                return Health.down().withDetail("Sample Service", "is DOWN").build();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    private boolean isServiceUp() throws IOException {
        String address = environment.getProperty("sampleService.address");
        String port = environment.getProperty("sampleService.port");

        return isAddressReachable(address, Integer.parseInt(port), 3000);
    }

    private static boolean isAddressReachable(String address, int port, int timeout)
            throws IOException {
        Socket isSocket = new Socket();
        try {
            // Connects this socket to the server with a specified timeout value.
           // isSocket.connect(new InetSocketAddress(address, port), timeout);
            // Return true if connection successful
            return true;
        } finally {
            isSocket.close();
        }
    }

}
