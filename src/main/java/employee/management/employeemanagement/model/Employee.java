package employee.management.employeemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email address is mandatory")
    @Column(unique = true)
    private String emailAddress;

    @Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits")
    @NotBlank(message = "Contact number is mandatory")
    private String contactNumber;

    @NotBlank(message = "Employee code is mandatory")
    @Column(unique = true)
    private String employeeCode;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @PastOrPresent(message = "Date of joining cannot be in the future")
    private LocalDate dateOfJoining;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
