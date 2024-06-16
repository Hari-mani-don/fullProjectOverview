package com.fullProjectOverview.fullProjectOverview.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fullProjectOverview.fullProjectOverview.configure.DataBaseService;
import com.fullProjectOverview.fullProjectOverview.dao.Image;
import com.fullProjectOverview.fullProjectOverview.dao.User;
import com.fullProjectOverview.fullProjectOverview.service.UserManagementService;

@Controller
public class UserManagementController {

	@Autowired
	UserManagementService userManagementService;

	@Autowired
	DataBaseService dataBaseService;

	@PostMapping("/users")
	public ResponseEntity<User> handleCreateUser(@RequestBody User user) {
		userManagementService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PutMapping("/users")
	public ResponseEntity<User> handleUpdateUser(@RequestParam(name = "id") Integer id, @RequestBody User user) {
		userManagementService.updateUser(id, user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")

	public void handleDeleteUser(@PathVariable Integer id) {
		userManagementService.deleteUser(id);
	}

	@GetMapping("/users/r/{id}")
	@ResponseBody
	public User handleRetriveByUserId(@PathVariable Integer id) {
		return userManagementService.retriveByUserId(id);
	}

	@GetMapping("/image/users")
	public ModelAndView handleFindAllUser() {
		ModelAndView model = new ModelAndView("nex");

		RestTemplate rest = new RestTemplate();
		String url = "http://localhost:8080/users/r/5";

		User user = rest.getForObject(url, User.class);

		System.err.println("id" + user.getUserId());
		System.err.println("id" + user.getUserName());
		System.err.println("id" + user.getEmail());
		System.err.println("id" + user.getPassword());

		List<User> list = userManagementService.findAll();
		model.addObject("list", list);
		return model;
	}

	@GetMapping("/users/{id}")
	public User handleFindByName(@PathVariable Integer id) {
		return userManagementService.findByHellos(id);
	}

//	@GetMapping("/users/ids")
//	public String handleFindByHello() {
//		return userManagementService.findByHelloss();
//	}

//	@GetMapping("/users/profiles")
//	public User handleFindByProfile(@RequestParam Integer userId) {
//		return userManagementService.findByProfileId(userId);
//	}

	@PostMapping("/image/images")
	public ResponseEntity<?> handleImage(@ModelAttribute("file") MultipartFile file) {

		Image image = userManagementService.addImage(file);
		return new ResponseEntity<>(image, HttpStatus.OK);
	}

	@GetMapping("/image/{imageId}")
	@ResponseBody
	public ModelAndView handleGetImage(@RequestParam(name = "download", required = false) Boolean download,
			@PathVariable("imageId") Integer imageId) {
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			Image image = userManagementService.getImage(imageId);
			if (image != null) {
				// Assuming getImage() returns image data as byte[]
				byte[] imageData = image.getData();
				// Determine media type based on image content (e.g., JPEG, PNG)
				String mediaType = determineMediaType(image.getImageName());

				modelAndView.addObject("imageData", Base64.getEncoder().encodeToString(imageData));
				modelAndView.addObject("mediaType", mediaType);
				modelAndView.addObject("imageName", image.getImageName());
				modelAndView.addObject("imageId", image.getId());
			} else {
				modelAndView.addObject("error", "Image not found");
			}
		} catch (IOException e) {
			e.printStackTrace();
			modelAndView.addObject("error", "Error retrieving image");
		}
		return modelAndView;
	}

	// Method to determine MediaType based on file extension
	private String determineMediaType(String imageName) {
		String fileExtension = imageName.substring(imageName.lastIndexOf(".") + 1).toLowerCase();
		switch (fileExtension) {
		case "jpg":
		case "jpeg":
			return "image/jpeg";
		case "png":
			return "image/png";
		// Add more cases for other image types as needed
		default:
			return "application/octet-stream"; // Default to generic binary data
		}
	}

	@GetMapping("/hari")
	public Boolean getDataSource() throws SQLException {
		return dataBaseService.performDatabaseOperation();
	}

	@GetMapping("/image/{imageId}/download")
	public ResponseEntity<byte[]> handleDownloadImage(
			@RequestParam(value = "download", required = false) Boolean download,
			@PathVariable("imageId") Integer imageId) throws IOException {

		Image image = userManagementService.getImage(imageId);

		byte[] imageData = image.getData();

		HttpHeaders header = new HttpHeaders();

		header.setContentDispositionFormData("attachment", image.getImageName());
//		header.setContentDispositionFormData("inline", image.getImageName());
		header.setContentType(MediaType.IMAGE_JPEG);
//		header.setContentLength(imageData.length);

		return new ResponseEntity(imageData, header, HttpStatus.OK); // This should be the name of your JSP without the
																		// .jsp suffix
	}

	@GetMapping("/next")
	public String handleIndex(@RequestParam(value = "download", required = false) Boolean download) {
		if (download != null && download) {
			return "downloadPage"; // Assume you have a JSP named downloadPage.jsp
		}
		return "nex"; // This should be the name of your JSP without the .jsp suffix
	}
}
