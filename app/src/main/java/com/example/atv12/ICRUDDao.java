package com.example.atv12;

import java.util.List;

//Otavio Gabriel Ribeiro Scabio - RA 1110482223043

public interface ICRUDDao <T>{

    long insert(T obj);
    int update(T obj);
    int delete(long id);
    T findById(long id);
    List<T> findAll();
}

