package com.example.wda.github;

import com.example.wda.github.BR;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;
import android.databinding.Observable;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LoginPresenterTest {

    private LoginPresenter loginPresenter;

    @Mock
    private Observable.OnPropertyChangedCallback onPropertyChangedCallback;
    @Mock
    private Context context;

    @Before
    public void prepare(){
        initMocks(this);

        loginPresenter=new LoginPresenter(context);

        loginPresenter.addOnPropertyChangedCallback(onPropertyChangedCallback);
    }

    //region setLogin

    @Test
    public void setLoginTextTrims() throws Exception {
        loginPresenter.setLogin(" with@spaces.com ");

        assertEquals("with@spaces.com",loginPresenter.getLogin());
    }

    @Test
    public void setLoginTextNotifiesPropertyChangedCallback() throws Exception {
        loginPresenter.setLogin(" with@spaces.com ");

        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class),eq(com.example.wda.github.BR.login));
    }

    @Test
    public void setLoginTextWithSameTextDoesNotNotifyPropertyChangedCallback() throws Exception{
        loginPresenter.setLogin("login@login.com");
        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class),eq(BR.login));

        loginPresenter.setLogin("login@login.com");

        verifyNoMoreInteractions(onPropertyChangedCallback);
    }

    @Test
    public void setLoginTextWithNotMailSetsErrorText(){
        when(context.getString(R.string.login_not_email_error_text)).thenReturn("login must be proper email address");

        loginPresenter.setLogin("notmail");

        assertEquals("login must be proper email address",loginPresenter.getLoginErrorText());
    }

    @Test
    public void setLoginTextWithNotMailNotifiesErrorTextChange(){
        when(context.getString(R.string.login_not_email_error_text)).thenReturn("login must be proper email address");

        loginPresenter.setLogin("notmail");

        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class),eq(com.example.wda.github.BR.loginErrorText));
    }

    @Test
    public void setLoginTextWithNotMailNotifiesLoginTextChange(){
        loginPresenter.setLogin("notmail");

        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class),eq(com.example.wda.github.BR.login));
    }

    //endregion

    @Test
    public void setPasswordTrims(){
        loginPresenter.setPassword(" password ");

        assertEquals("password",loginPresenter.getPassword());
    }

    @Test
    public void setPasswordRaisesOnPropertyChangedCallback() throws Exception{
        loginPresenter.setPassword("password");

        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class), eq(BR.password));
    }

    @Test
    public void setPasswordWithSameValueNotRaisesOnPropertChangedCallback() throws Exception{
        loginPresenter.setPassword("password");
        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class), eq(BR.password));

        loginPresenter.setPassword("password");

        verifyNoMoreInteractions(onPropertyChangedCallback);
    }
}