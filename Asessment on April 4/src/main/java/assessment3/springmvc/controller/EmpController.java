package assessment3.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import assessment3.springmvc.model.EmpDTO;
import assessment3.springmvc.service.EmpService;
import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    // Redirect root to viewall
    @GetMapping("/")
    public String home() {
        return "redirect:/viewall";
    }

    @GetMapping("/viewall")
    public String viewAllEmployees(Model model) {
        model.addAttribute("employees", empService.getAllEmployees());
        return "viewall";
    }

    @GetMapping("/edit/{eid}")
    public String showEditForm(@PathVariable("eid") Integer eid, Model model) {
        EmpDTO empDto = empService.getEmployeeById(eid);
        model.addAttribute("employee", empDto);
        return "edit";
    }

    @PostMapping("/edit/{eid}")
    public String updateEmployee(@PathVariable("eid") Integer eid,
                                 @Valid @ModelAttribute("employee") EmpDTO empDto,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            empDto.setId(eid); // Ensure ID stays populated for the view
            return "edit";
        }
        
        empService.saveEmployee(empDto);
        redirectAttributes.addFlashAttribute("successMessage", "Employee Edited Successfully");
        return "redirect:/viewall";
    }

    @GetMapping("/delete/{eid}")
    public String deleteEmployee(@PathVariable("eid") Integer eid, RedirectAttributes redirectAttributes) {
        empService.deleteEmployee(eid);
        redirectAttributes.addFlashAttribute("successMessage", "Employee Deleted Successfully");
        return "redirect:/viewall";
    }
}