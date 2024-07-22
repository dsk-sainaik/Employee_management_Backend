package com.employee.dto;

public class LoginResponse {
	private boolean success;

    public LoginResponse(boolean success) {
        this.success = success;
    }

    // Getter
    public boolean isSuccess() {
        return success;
    }

}
