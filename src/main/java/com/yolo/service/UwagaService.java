package com.yolo.service;

import com.yolo.model.Uwaga;

import java.util.List;

public interface UwagaService {

    Uwaga save(Uwaga uwaga);

    Boolean delete(int id);

    Uwaga update(Uwaga uwaga);

    Uwaga findById(int id);

    List<Uwaga> findAll();

//    List<Uwaga> findByStatus(String status);

//    List<Uwaga> findByUserIdStatus(int userId, String status);

    List<Uwaga> findBetween(int start, int end);

}
