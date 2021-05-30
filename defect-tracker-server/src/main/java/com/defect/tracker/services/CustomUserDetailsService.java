package com.defect.tracker.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.defect.tracker.data.entities.CustomUserDetails;
import com.defect.tracker.data.entities.Employee;
import com.defect.tracker.data.repositories.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employeeOpt = employeeRepository.findByEmail(username);
		employeeOpt
		.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		/*UserDetails user=Employee.withUserName(employeeOpt.get().getEmail())
				.password(employeeOpt.get().getPassword())
				.authorities("USER").build;
				return user;*/

       /* Collection role=list.stream()
        .collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(employee.getEmail(),employee.getPassword(),role);*/
		return employeeOpt
			.map(CustomUserDetails::new).get();
	}

}
