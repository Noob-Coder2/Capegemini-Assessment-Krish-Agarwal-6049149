package assessment3.springmvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import assessment3.springmvc.model.Emp;

public interface Repo extends JpaRepository<Emp, Integer> {
    List<Emp> findAll();
    Optional<Emp> findById(Integer id);
    void deleteById(Integer id);
}
