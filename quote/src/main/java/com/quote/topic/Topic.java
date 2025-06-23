package com.quote.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class Topic {

    @Bean
    public NewTopic quoteCreated()
    {
        return TopicBuilder.name("quote-accepted").build();
    }
}
