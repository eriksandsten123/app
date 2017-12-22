package hello.service;

import hello.domain.UserAccount;
import hello.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserAccountRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserAccount userAccount = userRepository.findOne(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException(username);
        }
        return userAccount;
    }
}