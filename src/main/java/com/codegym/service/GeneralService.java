package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAll();
    Product findById(long id);
}
