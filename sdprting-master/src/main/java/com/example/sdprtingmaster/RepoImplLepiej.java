package com.example.sdprtingmaster;

import org.springframework.stereotype.Component;

@Component
public class RepoImplLepiej {

    private RepoImpl repo;
    private Conf conf;

    public void wiekszyChuj() {
        repo.chuj();
    }

    public RepoImpl getRepo() {
        return repo;
    }

    public void setRepo(RepoImpl repo) {
        this.repo = repo;
    }

    public Conf getConf() {
        return conf;
    }

    public void setConf(Conf conf) {
        this.conf = conf;
    }

    public RepoImplLepiej(RepoImpl repo, Conf conf) {
        this.repo = repo;
        this.conf = conf;
    }
}
