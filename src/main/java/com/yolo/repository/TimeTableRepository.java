package com.yolo.repository;

import com.yolo.model.Task;
import com.yolo.model.TimeTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeTableRepository extends CrudRepository<TimeTable, Integer> {

    @Query("from TimeTable t where t.id BETWEEN  :start and :end")
    List<TimeTable> findBetween(@Param("start") int start, @Param("end") int end);

}
