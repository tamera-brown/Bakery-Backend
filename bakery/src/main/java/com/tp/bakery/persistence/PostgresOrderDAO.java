package com.tp.bakery.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresOrderDAO implements OrderDAO{
    @Autowired
    private JdbcTemplate template;



}
