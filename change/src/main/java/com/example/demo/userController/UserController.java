package com.example.demo.userController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserModel;
import com.example.demo.userDto.UserDto;
import com.example.demo.userService.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public List<UserDto> getUsers() {
		return userService.getAll();
	}
	
	@PostMapping("/save")			
	public UserModel saveUsers(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable(value="id") long id) {
		userService.deleteUser(id);
	}

}
