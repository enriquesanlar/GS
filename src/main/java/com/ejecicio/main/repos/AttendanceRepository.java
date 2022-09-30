package com.ejecicio.main.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejecicio.main.models.Attendance;

@Repository
public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
    @Procedure
    int insertAttendance(boolean attended, Date date, int employee);

    @Procedure
    List<Attendance> getAttendanceById(int id);
}
