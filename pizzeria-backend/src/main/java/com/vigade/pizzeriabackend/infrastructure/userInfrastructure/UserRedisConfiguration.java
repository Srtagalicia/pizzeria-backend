package com.vigade.pizzeriabackend.infrastructure.userInfrastructure;

import com.vigade.pizzeriabackend.domain.userDomain.UserRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class UserRedisConfiguration {

  @Bean
  ReactiveRedisOperations<String, UserRedis> userRedisOperations(ReactiveRedisConnectionFactory factory) {
    Jackson2JsonRedisSerializer<UserRedis> serializer = new Jackson2JsonRedisSerializer<>(UserRedis.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, UserRedis> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
    RedisSerializationContext<String, UserRedis> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }
}