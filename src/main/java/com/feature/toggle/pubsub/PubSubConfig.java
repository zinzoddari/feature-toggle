package com.feature.toggle.pubsub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
class PubSubConfig {

    @Bean
    public ChannelTopic toggleUpdateTopic() {
        return new ChannelTopic("toggle.update");
    }

    @Bean
    public MessageListenerAdapter toggleUpdateListenerAdapter(final PubSubSubscriber subscriber) {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(subscriber, "handleMessage");
        adapter.setSerializer(new StringRedisSerializer());

        return adapter;
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            final RedisConnectionFactory connectionFactory,
            final MessageListenerAdapter toggleUpdateListenerAdapter,
            final ChannelTopic toggleUpdateTopic
    ) {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(toggleUpdateListenerAdapter, toggleUpdateTopic);

        return container;
    }
}
