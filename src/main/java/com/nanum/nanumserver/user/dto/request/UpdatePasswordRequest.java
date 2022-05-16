package com.nanum.nanumserver.user.dto.request;

public class UpdatePasswordRequest {
    private String originPassword;
    private String newPassword;

    public UpdatePasswordRequest() {
    }

    public UpdatePasswordRequest(String originPassword, String newPassword) {
        this.originPassword = originPassword;
        this.newPassword = newPassword;
    }

    public String getOriginPassword() {
        return originPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
