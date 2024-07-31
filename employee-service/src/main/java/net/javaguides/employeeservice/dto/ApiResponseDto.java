package net.javaguides.employeeservice.dto;

public class ApiResponseDto {
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;

	public ApiResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto) {
		super();
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
	}

	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

}
