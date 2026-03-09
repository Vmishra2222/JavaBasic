package com.example.demo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    //SAMPLE DATA
    List<Topic> topics = new ArrayList<>(
            Arrays.asList(
                    new Topic("101", "Vaibhav", "57"),
                    new Topic("102", "Vineet", "66"),
                    new Topic("103", "Vikash", "64")
            )
    );

    //    localhost:8080/topics
    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topics;
    }

    // localhost:8080/topics/101
    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id) {
        Optional<Topic> foundTopic = topics
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst(); // <--- Ensure this semicolon is here!

        if (foundTopic.isPresent()) {
            return foundTopic.get();
        } else {
            return new Topic("N/A", "N/A", "N/A");
        }
    }
}
}
