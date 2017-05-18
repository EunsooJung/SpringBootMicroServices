/**
 * Lecture 5.5 Use Hypermedia example tutorial
 */
package com.ej.microservices;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author eunsoojung
 *
 */
@RestController
@RequestMapping("/people/{id}/photo")
public class PersonPhotoRestController {
	
	private File root;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Value("${user.home}")
	public void setUserHome(String home) {
		this.root = new File(home, "Desktop/images");
		Assert.isTrue(this.root.exists() || this.root.mkdir(),
				"The path '" + this.root.getAbsolutePath() + "' must exist.");
	}
	
	private Person findOne(Long id) {
		Person person = this.personRepository.findOne(id);
		if (null != person) {
			return person;
		}
		return null;
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Resource> read(@PathVariable Long id) throws Exception {
		Person person = this.personRepository.findOne(id);
		File file = fileFor(person);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		Resource resource = new FileSystemResource(file);
		return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> read(@PathVariable Long id) throws Exception {
		Person person = this.findOne(id);
		File file = fileFor(person);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<>(
				new InputStreamResource(
						new FileInputStream(file)),httpHeaders, HttpStatus.OK);
	}
	
	/*@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> write(@PathVariable Long id,
			@RequestParam MultipartFile file) throws Exception {
		Person person = this.personRepository.findOne(id);
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(fileFor(person)));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}*/
	
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> write(@PathVariable Long id,
			@RequestParam MultipartFile file) throws Exception {
		Person person = this.personRepository.findOne(id);
		try (InputStream is = new BufferedInputStream(file.getInputStream());
				OutputStream os = new BufferedOutputStream(
						new FileOutputStream(this.fileFor(person)))) {
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		}
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(id).toUri()).build();
	}
	
	private File fileFor(Person person) {
		return new File(this.root, Long.toString(person.getId()));
	}
}
