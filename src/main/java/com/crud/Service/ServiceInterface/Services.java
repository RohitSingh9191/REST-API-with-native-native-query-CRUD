package com.crud.Service.ServiceInterface;


import com.crud.Data.Entity.Employee;
import com.crud.Model.RequestBody.EmployeeRequest;
import com.crud.Model.ResponseBody.EmployeeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface Services {
    ResponseEntity<EmployeeResponse> saveEmpData(EmployeeRequest employeeRequest);

    ResponseEntity<List<Employee>> getAllData();

    ResponseEntity<Employee> getRecord(int id);

    ResponseEntity<EmployeeResponse> updateEmpData(int id,EmployeeRequest employeeRequest);

    ResponseEntity deleteRecord(int id);
}
