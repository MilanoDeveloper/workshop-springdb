package com.milano.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.milano.workshopmongo.domain.Post;
import com.milano.workshopmongo.domain.User;
import com.milano.workshopmongo.dto.AuthorDTO;
import com.milano.workshopmongo.dto.CommentDTO;
import com.milano.workshopmongo.repository.PostRepository;
import com.milano.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GTM"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("22/03/2021"), "Partiu Viagem", "Estou indo para São Paulo",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("30/09/2021"), "Partiu Balada", "Estou indo para Augusta",new AuthorDTO(bob));
		
		CommentDTO c1 = new CommentDTO("Tamo junto,Cara!",  sdf.parse("30/7/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Estou afim de viajar",  sdf.parse("30/2/2008"), new AuthorDTO(maria));
		CommentDTO c3 = new CommentDTO("Vou faltar amanhã",  sdf.parse("15/7/2020"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
