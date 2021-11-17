package com.vigade.pizzeriabackend.mysql;

import java.nio.charset.StandardCharsets;

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.mysql.util.URLParser;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class MySQLConfiguration extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        String url = "mysql://root:CbmWb9E4wVK2tI0dsixKiF94nRlpiSIa0niwEu4B@localhost:3306/pizzeria-backend_db";
        return new JasyncConnectionFactory(new MySQLConnectionFactory(
            URLParser.INSTANCE.parseOrDie(url, StandardCharsets.UTF_8)));
    }
    
}
