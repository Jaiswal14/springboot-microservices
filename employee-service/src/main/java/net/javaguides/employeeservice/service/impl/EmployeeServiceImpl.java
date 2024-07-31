package net.javaguides.employeeservice.service.impl;

//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	//private RestTemplate restTemplate;
	//private WebClient webClient;
	private APIClient apiClient;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
		super();
		this.employeeRepository = employeeRepository;
		this.apiClient = apiClient;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		Employee savedEmployee = employeeRepository.save(employee);

		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
//		ResponseEntity<DepartmentDto> responseDepartmentDto = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode()
//			, DepartmentDto.class);
//		
//		DepartmentDto departmentDto = responseDepartmentDto.getBody();
		
//		DepartmentDto departmentDto = webClient.get()
//			.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//			.retrieve()
//			.bodyToMono(DepartmentDto.class)
//			.block();
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());		
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		ApiResponseDto apiResponseDto = new ApiResponseDto(
					employeeDto,
					departmentDto
				);
		
		return apiResponseDto;
	}

}
