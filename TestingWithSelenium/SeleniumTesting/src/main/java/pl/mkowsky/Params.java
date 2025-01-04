package pl.mkowsky;

public class Params {

    public String homePage;
    public boolean checkSubPages = false;

    Params(){}

    Params(String homePage, boolean checkSubPages){
        this.homePage = homePage;
        this.checkSubPages = checkSubPages;
    }
}
