package com.incamp.companyprojects;

import java.util.List;

public class User {
    private List<String> tokens;
    private List<Integer> managing;

    public User(List<String> tokens,
                List<Integer> managing) {
        this.tokens = tokens;
        this.managing = managing;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<Integer> getManaging() {
        return managing;
    }

    public void setManaging(List<Integer> managing) {
        this.managing = managing;
    }
}
