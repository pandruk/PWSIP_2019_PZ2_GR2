package com.yolo.service.impl;

import com.yolo.model.TimeTable;
import com.yolo.repository.TimeTableRepository;
import com.yolo.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TimeTableServiceImpl implements TimeTableService {
    
    @Autowired
    private TimeTableRepository timeTableRepository;

    @Override
    public TimeTable save(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    @Override
    public Boolean delete(int id) {
        if (timeTableRepository.existsById(id)) {
            timeTableRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public TimeTable update(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable findById(int id) {
        return timeTableRepository.findById(id).get();
    }

    @Override
    public List<TimeTable> findAll() {
        return (List<TimeTable>) timeTableRepository.findAll();
    }

    @Override
    public List<TimeTable> findBetween(int start, int end) {
        return timeTableRepository.findBetween(start, end);
    }
}
