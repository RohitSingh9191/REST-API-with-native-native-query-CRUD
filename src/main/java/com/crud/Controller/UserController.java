package com.crud.Controller;

import com.crud.Data.Entity.Employee;
import com.crud.Model.RequestBody.EmployeeRequest;
import com.crud.Model.ResponseBody.EmployeeResponse;
import com.crud.Service.impService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class UserController {

    @Autowired
    private impService service;

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveData(@RequestBody EmployeeRequest employeeRequest) {
        return service.saveEmpData(employeeRequest);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllRecord() {
        return service.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) {
        return service.getRecord(id);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<EmployeeResponse> updateData(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest) {
        return service.updateEmpData(id, employeeRequest);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Employee> deleteById(@PathVariable int id) {
        return service.deleteRecord(id);
    }
}
