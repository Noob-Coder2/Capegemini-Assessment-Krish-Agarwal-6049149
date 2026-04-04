package assessment3.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assessment3.springmvc.model.Emp;
import assessment3.springmvc.model.EmpDTO;
import assessment3.springmvc.repository.Repo;

@Service
public class EmpService {

    @Autowired
    private Repo repo;

    public List<EmpDTO> getAllEmployees() {
        return repo.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    public EmpDTO getEmployeeById(Integer id) {
        Emp emp = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        return convertToDto(emp);
    }

    public void saveEmployee(EmpDTO EmpDto) {
        Emp emp = convertToEntity(EmpDto);
        repo.save(emp);
    }

    public void deleteEmployee(Integer id) {
        repo.deleteById(id);
    }

    // Utility methods for mapping between Entity and DTO
    private EmpDTO convertToDto(Emp emp) {
        return new EmpDTO(emp.getId(), emp.getName(), emp.getSalary(), emp.getDoj(), emp.getDept());
    }

    private Emp convertToEntity(EmpDTO dto) {
        return new Emp(dto.getId(), dto.getName(), dto.getSal(), dto.getDoj(), dto.getDept());
    }
}