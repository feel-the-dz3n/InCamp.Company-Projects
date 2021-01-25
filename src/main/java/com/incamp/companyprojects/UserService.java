package com.incamp.companyprojects;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public User get(String token) {
        // This is stub for auth
        // Token type 'manager-projectId' returns new user
        // with certain project managing rules
        if (token.startsWith("manager")) {
            return new User(
                    List.of(token),
                    List.of(Integer.parseInt(token.split("-")[1])));
        }

        return null;
    }

    public boolean isUserManaging(User user, Integer projectId) {
        return user.getManaging().contains(projectId);
    }
}
