package com.example.sdprtingmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdprtingMasterApplication {

    private static Repo repo;

    @Autowired
    public SdprtingMasterApplication(Repo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SdprtingMasterApplication.class, args);
        System.out.println(repo.chuj());

        RepoImplEnhanced enhanced = new RepoImplEnhanced();
        enhanced.chuj();


        RepoImplLepiej lepiej = new RepoImplLepiej(new RepoImpl(), new Conf());
        lepiej.wiekszyChuj();


    }



}
