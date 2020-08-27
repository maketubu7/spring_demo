package com.make.service;

import com.make.model.lolHero;

import java.util.Collection;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
public interface HeroService {
    public abstract void createProduct(lolHero hero);
    public abstract void updateProduct(String name, lolHero hero);
    public abstract void deleteProduct(String name);
    public abstract Collection<lolHero> getHeros();
}
