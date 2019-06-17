package com.yolo.repository;

import com.yolo.model.Uwaga;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UwagaRepository extends CrudRepository<Uwaga, Integer> {

    //@Query("from Task t where t.status=:status")
//    List<Uwaga> findByStatus(String status);

//    List<Uwaga> findByUserIdAndStatus(int userId, String status);

 /*   @Query("from Task t where t.userId=:userId and  t.status=:status")
    List<Task> findByUserIdStatus(@Param("userId") int userId, @Param("status") String status);*/

    //    @Query("from Task t where t.id BETWEEN  :start and :end")
    @Query("from Uwaga u where u.id BETWEEN  :start and :end")
    List<Uwaga> findBetween(@Param("start") int start, @Param("end") int end);

}
