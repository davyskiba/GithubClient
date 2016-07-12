package com.example.wda.github;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.example.wda.github.BR;

public class LoginPresenter extends BaseObservable {

    private String login;
    private String password;

    private Context context;
    private String loginError;

    public LoginPresenter(Context context) {
        this.context = context;
    }

    @Bindable
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String trimmedText = login.trim();

        if (TextUtils.areStringsEqual(trimmedText, this.login)) {
            return;
        }

        validateLoginText(trimmedText);

        this.login = trimmedText;
        notifyPropertyChanged(BR.login);
    }

    private boolean validateLoginText(String login) {
        boolean isLoginCorrect = TextUtils.isEmail(login);

        if (!isLoginCorrect) {
            String errorTextString = context.getString(R.string.login_not_email_error_text);
            setLoginErrorText(errorTextString);
        }

        return isLoginCorrect;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordText) {
        String trimmedPassword = passwordText.trim();

        if(TextUtils.areStringsEqual(trimmedPassword,this.password)){
            return;
        }

        this.password = trimmedPassword;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getLoginErrorText() {
        return loginError;
    }

    public void setLoginErrorText(String loginError) {
        if (!TextUtils.areStringsEqual(this.loginError, loginError)) {
            this.loginError = loginError;
            notifyPropertyChanged(BR.loginErrorText);
        }
    }

    public void onLoginClicked() {
        Toast.makeText(context, login + " " + password, Toast.LENGTH_LONG).show();
    }
}
