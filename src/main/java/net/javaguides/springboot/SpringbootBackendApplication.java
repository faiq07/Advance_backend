package net.javaguides.springboot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//this.userRepository.save(new User(1,"Faiq","8080","faiqijaz143@gmail.com", "Kisi k dill me ni", "03204474808"));
		//this.userRepository.save(new User(3,"Sajid", "8080", "sajidsaleem@gmail.com", "Sab k dillon mein", "03294234324"));
		//this.userController.checkstatus("faiqijaz143@gmail.com","8080" );
		//this.userController.show("faiqijaz43@gmail.com", "8080");
		//Map<String, String> obj= new HashMap<String, String>();
		//obj.put("faiqijaz143@gmail.com", "8080");
		//this.userController.search(obj );
		//this.userController.getUsers();
	}
}
