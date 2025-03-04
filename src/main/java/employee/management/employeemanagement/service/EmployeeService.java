package employee.management.employeemanagement.service;

import employee.management.employeemanagement.model.Employee;
import employee.management.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setEmailAddress(employeeDetails.getEmailAddress());
            employee.setContactNumber(employeeDetails.getContactNumber());
            employee.setEmployeeCode(employeeDetails.getEmployeeCode());
            employee.setDesignation(employeeDetails.getDesignation());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setDateOfJoining(employeeDetails.getDateOfJoining());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}