package pl.dmcs.buarzej.service;

public interface ReCaptchaService {
    boolean verify(String captcha);
}
