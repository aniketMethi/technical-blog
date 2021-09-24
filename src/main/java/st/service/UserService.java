package st.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import st.model.User;
import st.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void registerUser(User newUser) {
        repository.registerUser(newUser);
    }

    public List<User> getAllUser() {
        return repository.getAllUser();
    }

    public void deleteUser(Integer userId) {
        repository.deleteUser(userId);
    }

    public List<User> getAllUserByName(String keyword) {
        return repository.getAllUserByName(keyword);
    }
}
