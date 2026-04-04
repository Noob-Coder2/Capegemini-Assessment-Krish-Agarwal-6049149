package assessment3.springmvc.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=25)
    private String name;

    private Double sal;
    private LocalDate doj;
    private String dept;

    public Emp(){
        
    }

    public Emp(Integer id, String name, Double sal, LocalDate doj, String dept) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.doj = doj;
        this.dept = dept;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return sal;
    }
    public void setSalary(Double salary) {
        this.sal = salary;
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
