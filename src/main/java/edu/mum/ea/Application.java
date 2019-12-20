package edu.mum.ea;

import edu.mum.ea.controllers.AdvertController;
import edu.mum.ea.util.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.security.Principal;

@SpringBootApplication
public class Application {

    @Autowired
    ServletContext context;
    @Autowired
    AppProperties appProperties;

    @PostConstruct
    public void init() {
        File pictureUploadDirectory = new File(context.getRealPath("/") + appProperties.getPicture());
        File videoUploadDirectory = new File(context.getRealPath("/") + appProperties.getVideo());
        if(!pictureUploadDirectory.exists()) {
            pictureUploadDirectory.mkdirs();
        }

        if(!videoUploadDirectory.exists()) {
            videoUploadDirectory.mkdirs();
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
