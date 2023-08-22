package com.crud.Service;

import com.crud.Data.Entity.Employee;
import com.crud.Data.Repository.EmployeeRepository;
import com.crud.Model.RequestBody.EmployeeRequest;
import com.crud.Model.ResponseBody.EmployeeResponse;
import com.crud.Service.ServiceInterface.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class impService implements Services {

    @Autowired
    private EmployeeRepository repository;


    @Override
    public ResponseEntity<EmployeeResponse> saveEmpData(EmployeeRequest employeeRequest) {
        Employee emp=new Employee();
        emp.setName(employeeRequest.getName());
        emp.setDepartment(employeeRequest.getDepartment());
        emp.setTechknowledgy(employeeRequest.getTechknowledgy());
        emp.setSalory(employeeRequest.getSalory());

        EmployeeResponse response=new EmployeeResponse();
        response.setMsg("Record save successfully");
        repository.save(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Override
    public ResponseEntity<List<Employee>> getAllData() {

        List<Employee> list=repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Override
    public ResponseEntity getRecord(int id) {
        Employee emp=repository.FindById(id);
        if(emp!=null){
            return ResponseEntity.status(HttpStatus.OK).body(emp);
        }else {
            EmployeeResponse response=new EmployeeResponse();
            response.setMsg("Record dose not exist in table");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @Override
    public ResponseEntity<EmployeeResponse> updateEmpData(int id,EmployeeRequest employeeRequest) {
        Employee emp=new Employee();
        emp.setName(employeeRequest.getName());
        emp.setDepartment(employeeRequest.getDepartment());
        emp.setTechknowledgy(employeeRequest.getTechknowledgy());
        emp.setSalory(employeeRequest.getSalory());
        emp.setId(id);

        EmployeeResponse response=new EmployeeResponse();
        Employee empRecord=repository.FindById(id);
        if(empRecord!=null) {
            response.setMsg("Record update successfully");
            repository.save(emp);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            response.setMsg("Record dose not exist by id = "+id);
            repository.save(emp);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Override
    public ResponseEntity deleteRecord(int id) {
        Employee emp=repository.FindById(id);

        if(emp!=null){
         repository.DeleteById(id);
          //  repository.deleteById(id);
            EmployeeResponse response=new EmployeeResponse();
            response.setMsg("Record has been delete successfully ");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            EmployeeResponse response=new EmployeeResponse();
            response.setMsg("Record dose not exist in table");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
