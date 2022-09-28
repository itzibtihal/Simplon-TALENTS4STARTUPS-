package SoussHealthOnlineStore.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoussHealthOnlineStore.entity.Admin;
import SoussHealthOnlineStore.entity.Client;
import SoussHealthOnlineStore.entity.ERole;
import SoussHealthOnlineStore.entity.Role;
import SoussHealthOnlineStore.payload.request.LoginRequest;
import SoussHealthOnlineStore.payload.request.SignupRequest;
import SoussHealthOnlineStore.payload.response.JwtResponse;
import SoussHealthOnlineStore.payload.response.MessageResponse;
import SoussHealthOnlineStore.repository.RoleRepository;
import SoussHealthOnlineStore.repository.UserRepository;
import SoussHealthOnlineStore.security.jwt.JwtUtils;
import SoussHealthOnlineStore.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	  
	  
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	  
	  
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }
         
	   
						   
	    Admin admin = new Admin(
	    		signUpRequest.getEmail(),
	    		signUpRequest.getFullName(),
	    		encoder.encode(signUpRequest.getPassword()));
	    
	    
	    Client client = new Client(
	    		signUpRequest.getNom(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getPrenom(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getAdresse(),
	    		signUpRequest.getCin(),
	    		signUpRequest.getVille(),
	    		encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> eRoles = new HashSet<>();

	    if (strRoles == null) {
	    	 Role clientRole = roleRepository.findByName(ERole.CLIENT)
	    	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	    	      eRoles.add(clientRole);
	    	      client.setRoles(eRoles);
	  		    userRepository.save(client);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          eRoles.add(adminRole);
	          
	          admin.setRoles(eRoles);
	  	    userRepository.save(admin);
	         break;
	        case "client":
	          Role clientRole = roleRepository.findByName(ERole.CLIENT)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          eRoles.add(clientRole);
	          client.setRoles(eRoles);
			    userRepository.save(client);
	        }
	      });
	    }

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  

}
