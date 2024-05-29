package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class MyPostController {

    // /mypost/{}
    @GetMapping("/mypost/{id}")
    public Post getMyPost( @PathVariable("id") String id){

        String url="https://jsonplaceholder.typicode.com/posts/"+id;
        //fetch the data from the API
        RestClient rc= RestClient.create();
        Post res= rc.get().uri(url).retrieve().body(Post.class);
        //System.out.println("IN here"+res.getBody());
        return res;
    }
}
