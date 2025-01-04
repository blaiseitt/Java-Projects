package pl.mkowsky;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BrokenLinks {

    public static List<String> lookForBrokenLinks(String homePage, boolean checkSubPages){
        List<String> brokenLinks = new LinkedList<>();
        String currentURL = "";

        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(homePage);

        List<String> allLinks = webDriver.findElements(By.tagName("a")).stream().map(link -> link.getAttribute("href")).collect(Collectors.toList());
        ListIterator<String> allLinksIterator = allLinks.listIterator();
        while(allLinksIterator.hasNext()){
            currentURL = allLinksIterator.next();
            System.out.println("Currently checking: " + currentURL);

            if(currentURL == null || currentURL.isEmpty()){
                System.out.println(currentURL + " is empty.");
                continue;
            }

            if(isUrlBroken(currentURL)){
                brokenLinks.add(currentURL);
                continue;
            }

            if(checkSubPages && !homePage.equals(currentURL)){
                List<String> subPages = lookForBrokenLinks(currentURL, false);
                brokenLinks.addAll(subPages);
            }


        }
        webDriver.close();
        webDriver.quit();
        return brokenLinks;
    }

    private static boolean isUrlBroken(String homePage){
        HttpURLConnection httpURLConnection = null;
        int responseCode = 200;
        boolean isUrlBroken = true;

        try {
            httpURLConnection = (HttpURLConnection) new URL(homePage).openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            responseCode = httpURLConnection.getResponseCode();
            if(responseCode >= 400) isUrlBroken = true;
            else isUrlBroken = false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isUrlBroken;
    }

}
