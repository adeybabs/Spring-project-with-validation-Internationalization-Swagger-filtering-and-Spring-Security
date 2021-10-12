package com.SocialMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class SocialMediaController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/social-media")
    public String socialMedia(){
        return "Welcome to my social media!";
    }
    @GetMapping(path = "/social-media-bean")
    public SocialMediaBean socialMediaBean(){
        return new SocialMediaBean("Welcome to my social media!");
    }

    ///social-media/path-variable/adey
    @GetMapping(path = "/social-media/path-variable/{name}")
    public SocialMediaBean socialMediaPathVariable(@PathVariable String name){
        return new SocialMediaBean(String.format("Welcome to my social media, %s", name));
    }

    @GetMapping(path = "/social-media-internationalized")
    public String socialMediaInternationalized(@RequestHeader(name ="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null, locale);
    }
}
