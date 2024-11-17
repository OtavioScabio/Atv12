package com.example.atv12;

import java.util.List;

public interface ICRUDDao <T>{

    long insert(T obj);
    int update(T obj);
    int delete(long id);
    T findById(long id);
    List<T> findAll();
}

