package com.company.db.repository;

public interface DbTable <T>{

    T getItemByToken(String userToken);
    T addItem(T item);
    T update(T item);
}
