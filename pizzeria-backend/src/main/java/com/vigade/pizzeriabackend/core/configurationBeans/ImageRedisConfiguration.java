package com.vigade.pizzeriabackend.core.configurationBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ImageRedisConfiguration {

    @Bean
    ReactiveRedisOperations<String, byte[]> imageRedisOperations(ReactiveRedisConnectionFactory factory) {
        ByteSerializer byteSerializer = new ByteSerializer();

        RedisSerializationContext.RedisSerializationContextBuilder<String, byte[]> builder = RedisSerializationContext
                .newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, byte[]> context = builder.value(byteSerializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}