package org.example.nonrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Long id) {
        return  ResponseEntity.of(repository.findById(id));
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @PutMapping("/employees/{id}")
    Employee modifyEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee newEmployee){

        return repository.findById(id).map((employee)-> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        }).orElseGet(()-> repository.save(newEmployee));

    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable(value = "id") Long id){
        repository.deleteById(id);
    }
}
