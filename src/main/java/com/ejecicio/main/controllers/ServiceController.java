package com.ejecicio.main.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ejecicio.main.models.Attendance;
import com.ejecicio.main.models.Employee;
import com.ejecicio.main.repos.AttendanceRepository;
import com.ejecicio.main.repos.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class ServiceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    /**
     * Lista de empleados
     * 
     * @return
     */
    @GetMapping(value = "/empleados")
    @Transactional
    public Iterable<Employee> getEmpleados() {
        return employeeRepository.getEmployees_();
    }

    /**
     * Asistencias por empleados
     * 
     * @param param
     * @param id
     * @return
     */
    @GetMapping(value = "/empleados/{id}/asistencias")
    @Transactional
    public Iterable<Attendance> getAsistenciasEmpleado(@PathVariable(name = "id") int id) {
        return attendanceRepository.getAttendanceById(id);
    }

    /**
     * Agrega empleado
     * 
     * @param param
     * @return
     */
    @PostMapping(value = "/empleados")
    public ResponseEntity<String> postEmpleado(@RequestBody Employee entity) {
        int res;
        if ((res = employeeRepository.insertEmployee(entity.getLastName(), entity.getName())) != -1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Elemento insertado con id " + res);
        }

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Elemento no insertado\n");
    }

    /**
     * Agrega asistencia por empleado
     * 
     * @param entity
     * @param id
     * @return
     */
    @PostMapping(value = "/empleados/{id}/asistencias")
    public ResponseEntity<String> registraAsistencias(@RequestBody Attendance entity, @PathVariable int id) {
        int res;
        if ((res = attendanceRepository.insertAttendance(entity.getAttended(), entity.getDate(), id)) == -2) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El elemento ya existe");
        } else if (res == -1) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Elemento no insertado\n");    
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Elemento insertado con id " + res);
    }

}
