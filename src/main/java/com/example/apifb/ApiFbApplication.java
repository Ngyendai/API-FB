package com.example.apifb;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Category;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApiFbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFbApplication.class, args);
        String accessToken = "EAAN0hNCNDD0BAJQRdGuEJqt3J2NJzLwtthZC8pw6dzAtZAQijKmvFTKqBgt2LyxD6bu2v8MHDRrRBvXx35uwj72RQQeyEgZCAr4rvN3fwX0wksYadQGfSiJT4iRTkGzZBva24hEoTPk2xT2NZAlJfcGrdhhiOZC2GSAItOc9Mmwk2rtfexsv2DmkIiBbpgFMBxxZBlM5XfVKPP6ZAZCeyeQeVr4MZC3yl2FTQpvokj4KRhZBpxO6lspYZBva";
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_12_0);
        Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
//        User me = fbClient.fetchObject("me", User.class);
//        System.out.println(me.getName());
//        System.out.println(me.getName());
       // System.out.println(me.getLanguages().get(0).getName());
        Category category = fbClient.fetchObject("category", Category.class);
        System.out.println(category.getName());
        int counter = 0;
        for(List<Post> page: result){
            for(Post aPost : page){
                System.out.println(aPost.getMessage());
                System.out.println("fb.com/" + aPost.getId());
                counter++;
            }
            System.out.println("No of Results: " + counter);
        }


    }

}
