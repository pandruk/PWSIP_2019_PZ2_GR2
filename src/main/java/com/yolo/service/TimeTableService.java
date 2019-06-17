package com.yolo.service;

import com.yolo.model.Task;
import com.yolo.model.TimeTable;

import java.util.List;

public interface TimeTableService {

    TimeTable save(TimeTable timeTable);

    Boolean delete(int id);

    TimeTable update(TimeTable timeTable);

    TimeTable findById(int id);

    List<TimeTable> findAll();

    List<TimeTable> findBetween(int start, int end);
}
