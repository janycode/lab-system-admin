package com.jerry.labsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * LabSystem应用
 *
 * @author Jerry(姜源)
 * @since 2026/02/22
 */
@SpringBootApplication
public class LabSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSystemApplication.class, args);
        System.out.println("args = " + Arrays.toString(args));
    }

}
