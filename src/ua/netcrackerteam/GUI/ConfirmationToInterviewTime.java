package ua.netcrackerteam.GUI;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author AlexK
 * @version 1.0.0
 */
public class ConfirmationToInterviewTime extends Window implements Button.ClickListener {
    private MainPage mainPage;
    private String userName;
    private Button yesButton;
    private Button noButton;
    private VerticalLayout layout = (VerticalLayout) getContent();
    private HorizontalLayout buttonsPanel = new HorizontalLayout();
    private String CONFIRMATION_MESSAGE;
    private Label message;
    private TabSheet pageTabs;

    public ConfirmationToInterviewTime(MainPage mainPage, String username) {
        this.userName = username;
        this.mainPage = mainPage;
        this.setIcon(new ThemeResource("icons/32/time-icon.png"));
        setCaption("Запись на собеседование");
        setModal(true);
        setWidth("30%");
        setResizable(false);
        center();
        CONFIRMATION_MESSAGE = "Анкета сохранена успешно! " + userName + ", хотите выбрать время собеседования сейчас?";
        initButtons();
        initLayouts();
    }

    private void initButtons() {
        yesButton = new Button("Ок");
        yesButton.setVisible(true);
        yesButton.addListener(this);
        noButton = new Button("Отмена");
        noButton.setVisible(true);
        noButton.addListener(this);
        message = new Label(CONFIRMATION_MESSAGE);
    }

    private void initLayouts() {
        layout.setWidth("100%");
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.addComponent(message);
        layout.setComponentAlignment(message, Alignment.TOP_CENTER);
        layout.addComponent(buttonsPanel);
        layout.setComponentAlignment(buttonsPanel, Alignment.BOTTOM_CENTER);
        buttonsPanel.addComponent(yesButton);
        buttonsPanel.addComponent(noButton);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        Button source = event.getButton();
        if (source == yesButton) {
            pageTabs = mainPage.getPanel().getTabSheet();
            pageTabs.setSelectedTab(2);
            ConfirmationToInterviewTime.this.close();
        } else if (source == noButton) {
            ConfirmationToInterviewTime.this.close();
        }
    }
}
