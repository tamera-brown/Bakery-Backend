package com.tp.bakery.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("ServiceTesting")
public class OrderInMemDAO implements OrderDAO{
}
