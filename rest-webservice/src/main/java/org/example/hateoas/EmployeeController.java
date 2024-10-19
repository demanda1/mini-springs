package org.example.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    EntityModel<Employee> getEmployee(@PathVariable(value = "id") Long id) {

        return  EntityModel.of(repository.findById(id).get(),
                linkTo(methodOn(EmployeeController.class).getEmployee(id)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("get all employees"));
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
