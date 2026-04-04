package assessment3.springmvc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmpDTO {
    private Integer id;

    @NotBlank(message = "Employee name is required")
    @Pattern(regexp = "^[a-zA-Z]{3,25}$", message = "Name must contain only alphabets (3 to 25 characters)")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 500000, message = "Salary must be at most 500000")
    private Double sal;

    @FutureOrPresent(message = "Date of joining must be a current or future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate doj;

    @Pattern(regexp = ".*(hr|production).*", message = "Department must contain 'hr' or 'production'")
    private String dept;


    public EmpDTO() {
    }

    public EmpDTO(Integer id, String name, Double sal, LocalDate doj, String dept) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.doj = doj;
        this.dept = dept;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}
