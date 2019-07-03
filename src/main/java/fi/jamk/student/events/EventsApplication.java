package fi.jamk.student.events;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jamk.student.events.domain.UserRepository;
import fi.jamk.student.events.domain.Event;
import fi.jamk.student.events.domain.EventRepository;
import fi.jamk.student.events.domain.User;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoAdd(EventRepository repository, UserRepository urepository) {
		return(args) ->{
			

			
			Event e1 = new Event ("JAMK Syyslukukausi", "Lutakko", "20.09.2019", "62.2411328", "25.7593833");
			Event e2 = new Event ("Qstock 2019", "Oulu", "26.07.2019", "65.0058582", "25.4680658");
			Event e3 = new Event ("Ruska maraton", "Levi", "7.09.2019", "67.7050229", "24.7242054");
			
			repository.save(e1);
			repository.save(e2);
			repository.save(e3);
			
			//Create users: user/user, useri/useri, admin/admin 
			User user1 = new User("user", "$2a$10$UBii/e.Wy3sx5HiWgpfj7edVYR/e/zTuAoKP5bHZeFJcRe7WsIEz6", "user@email.me", "USER");
			User user2 = new User("useri", "$2a$10$ti4io24XeSDi8WSbEAl6Ce1L/7zuA0rpId3jCiRmNZm2jxMcFGmRG", "useri@email.me", "USER");
			User user3 = new User("admin", "$2a$10$SzTnZOy1xTkAKGb4aItDDuPEgJcyGF8q4mIXDAYSvhvLRGb/Q7gqG", "admin@email.me", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
		};
	}

}
