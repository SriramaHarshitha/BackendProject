
package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Department name is required")
    private String departmentName;

    public DepartmentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
