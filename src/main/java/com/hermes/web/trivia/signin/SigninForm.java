package com.hermes.web.trivia.signin;

import org.hibernate.validator.constraints.NotBlank;

public class SigninForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = SigninForm.NOT_BLANK_MESSAGE)
	private String login;

    @NotBlank(message = SigninForm.NOT_BLANK_MESSAGE)
	private String password;

    public SigninForm() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
