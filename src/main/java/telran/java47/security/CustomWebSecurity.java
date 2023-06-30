package telran.java47.security;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java47.accounting.dao.UserAccountRepository;
import telran.java47.accounting.model.UserAccount;
import telran.java47.post.dao.PostRepository;
import telran.java47.post.model.Post;

@RequiredArgsConstructor
@Service("customSecurity")
public class CustomWebSecurity {
	final PostRepository postRepository;
	final UserAccountRepository userRepository;
	
	public boolean checkPostAuthor(String postId, String login) {
		Post post = postRepository.findById(postId).orElseThrow(null);
		return post != null && post.getAuthor().equalsIgnoreCase(login);
	}
	
	public boolean checkPasswordDate(String login) {
		UserAccount user = userRepository.findById(login).orElse(null);
		return user != null && user.checkPasswordDate();
	}
}
