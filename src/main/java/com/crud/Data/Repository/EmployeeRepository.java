package com.crud.Data.Repository;

import com.crud.Data.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(nativeQuery = true,value = "select * from employee_details  where id=:id")
    public Employee FindById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM employee_details WHERE id =:id")
    public void DeleteById(@Param("id") int id);
}
