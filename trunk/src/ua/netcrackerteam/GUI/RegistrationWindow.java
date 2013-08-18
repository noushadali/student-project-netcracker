/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.netcrackerteam.GUI;

import java.sql.SQLException;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import org.apache.commons.mail.EmailException;

import ua.netcrackerteam.controller.GeneralController;
import ua.netcrackerteam.controller.SendMails;

/**
 *
 * @author akush_000
 */
@SuppressWarnings("serial")
class RegistrationWindow extends Window implements FieldEvents.BlurListener{
    CaptchaField captchaField;
    TextField captchaInput;
    MainPage mainPage;
    TextField email;
    TextField username;
    PasswordField password;
    PasswordField password2;

    public TextField getEmail() {
        return email;
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public RegistrationWindow(MainPage mainPage) {
        this.mainPage = mainPage;
        setModal(true);
        setWidth("30%");
        setResizable(false);
        center();
        setCaption("Регистрация");
        VerticalLayout layout = (VerticalLayout) getContent();
        layout.setWidth("100%");
        layout.setSpacing(true);
        layout.setMargin(true);
        username = new TextField("Введите логин: ");
        username.setRequired(true);
        username.addListener(this);
        username.setMaxLength(25);
        layout.addComponent(username);
        username.addValidator(new RegexpValidator("\\w{3,}", "Имя должно быть не короче 3х символов латиницы."));
        email = new TextField("Введите email: ");
        email.addListener(this);
        layout.addComponent(email);
        email.addValidator(new EmailValidator("Email должен содержать знак '@' и полный домен."));
        email.setRequired(true);
        password = new PasswordField("Введите пароль: ");
        layout.addComponent(password);
        password.addListener(this);
        password.addValidator(new RegexpValidator("\\w{6,}",
                        "Пароль должен содержать буквы английского алфавита и/или цифры, и быть не короче 6 символов."));
        password.setRequired(true);
        password2 = new PasswordField("Введите пароль еще раз: ");
        layout.addComponent(password2);
        password2.setRequired(true);
        password2.addListener(this);
        password2.addValidator(new AbstractValidator("Пароли должны совпадать.") {
            public boolean isValid(Object value) {
                return password.getValue().equals(password2.getValue());
            }
        });
        captchaField = new CaptchaField(this.mainPage);
        captchaField.setHeight("150");
        layout.addComponent(captchaField);
        captchaInput = new TextField("Введите текст, изображенный на картинке: ");
        layout.addComponent(captchaInput);
        captchaInput.setRequired(true);
        captchaInput.addValidator(new AbstractValidator("Текст введен неверно.") {
            public boolean isValid(Object value) {
            	if (value != null && captchaInput.getValue() != null)
            		return captchaField.validateCaptcha((String)captchaInput.getValue());
            	else
            		return false;
            }
        });
        Button okBut = new Button("Регистрация");
        okBut.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                buttonClickRegistr();
            }
        });
        layout.addComponent(okBut);
        layout.setComponentAlignment(okBut, Alignment.TOP_CENTER);
    }
    
    
    
    public void buttonClickRegistr() {
        if (isValid()) {
            String userName = String.valueOf(this.getUsername());
            String userPassword = String.valueOf(this.getPassword());
            String userEmail = String.valueOf(this.getEmail());
            try {
            	GeneralController.setUsualUser(userName, userPassword, userEmail);
            } catch (SQLException e) {
                Notification n = new Notification("Ошибка", Notification.TYPE_TRAY_NOTIFICATION);
                n.setDescription("Такой пользователь уже существует");
                n.setPosition(Notification.POSITION_CENTERED);
                mainPage.getMainWindow().showNotification(n);
                return;
            }
            
            Notification n = new Notification("Регистрация завершена успешно!", Notification.TYPE_TRAY_NOTIFICATION);
            n.setDescription("На ваш email выслано письмо с регистрационными данными.\n" +
                    "Теперы Вы можете зайти под своим логином.");
            n.setPosition(Notification.POSITION_CENTERED);
            try {
                SendMails.sendMailToUserAfterReg(userEmail, userName, userPassword);
            } catch (EmailException e) {
                e.printStackTrace();
            }
            mainPage.getMainWindow().showNotification(n);
            close();
        }
    }
    
    private boolean isValid() {
        boolean result =  (email.isValid() && password.isValid() && password2.isValid() && username.isValid());
        captchaField.validateCaptcha("");
        return result;
    }

    public void blur(BlurEvent event) {
        Object source = event.getComponent();
        if(source instanceof TextField) {
            TextField tf = (TextField) source;
            tf.isValid();
        } else if(source instanceof PasswordField){
            PasswordField pf = (PasswordField) source;
            pf.isValid();
        }
    }
}
