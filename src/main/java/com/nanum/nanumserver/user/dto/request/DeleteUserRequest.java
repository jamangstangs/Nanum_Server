package com.nanum.nanumserver.user.dto.request;

public class DeleteUserRequest {

    private String password;

    public DeleteUserRequest() {
    }

    public DeleteUserRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
