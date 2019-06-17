package com.yolo.service.impl;

import com.yolo.model.Uwaga;
import com.yolo.repository.UwagaRepository;
import com.yolo.service.UwagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UwagaServiceImpl implements UwagaService {

    @Autowired
    private UwagaRepository uwagaRepository;

    @Override
    public Uwaga save(Uwaga uwaga) {
        return uwagaRepository.save(uwaga);
    }

    @Override
    public Boolean delete(int id) {
        if (uwagaRepository.existsById(id)) {
            uwagaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Uwaga update(Uwaga uwaga) {
        return uwagaRepository.save(uwaga);
    }

    @Override
    public Uwaga findById(int id) {
        return uwagaRepository.findById(id).get();
    }

    @Override
    public List<Uwaga> findAll() {
        return (List<Uwaga>) uwagaRepository.findAll();
    }

//    @Override
//    public List<Uwaga> findByStatus(String status) {
//        return uwagaRepository.findByStatus(status);
//    }

//    @Override
//    public List<Uwaga> findByUserIdStatus(int userId, String status) {
//        return uwagaRepository.findByUserIdAndStatus(userId, status);
//    }

    @Override
    public List<Uwaga> findBetween(int start, int end) {
        return uwagaRepository.findBetween(start, end);
    }
}
