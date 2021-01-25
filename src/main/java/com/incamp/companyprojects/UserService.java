package com.incamp.companyprojects;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public User get(String token) {
        // This is stub for auth
        if (token.startsWith("manager")) {
            // Token type 'manager-projectId' returns new user
            // with certain project managing rules
            return new User(
                    List.of(token),
                    List.of(Integer.parseInt(token.split("-")[1])));
        } else if (token.startsWith("ok")) {
            // Token 'ok' returns authorized user
            // with minimal ruleset
            return new User(List.of(token), List.of());
        }

        return null;
    }

    public boolean isUserManaging(String token, Integer projectId) {
        return isUserManaging(get(token), projectId);
    }

    public boolean isUserManaging(User user, Integer projectId) {
        return user.getManaging().contains(projectId);
    }
}
