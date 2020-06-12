package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.pages.forms.FormPage;
import org.fundacionjala.trello.context.UserTrello;
import org.fundacionjala.trello.pages.IIdentifiable;
import org.fundacionjala.trello.pages.list.ListForm;
import org.fundacionjala.trello.pages.list.ListUpdateForm;
import org.fundacionjala.trello.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BoardPage extends PageObject implements IIdentifiable {

    private static final String TITLE_TEXT = "div.mod-board-name > span";
    private static final String TITLE_INPUT = "div.mod-board-name > input";
    private static final String DELETE_CONTAINER = "p.delete-container a";
    private static final String DELETE_CONFIRM = "div.no-back input[value=\"Delete\"]";
    private static final String SHOW_MENU = "a.mod-show-menu";
    private static final String BOARD_HEADER = "div.board-header";
    private static final String BOARD_CANVAS = "#board";
    private static final String ADD_LIST = "div.js-add-list span.icon-add";
    private static final String GET_LIST = "//textarea[contains(text(), '%s')]/parent::"
            + "div[contains(@class,'list-header')]";
    private static final int ID_INDEX = 1;
    private static final String URL_REGEX = "/b/[\\w]+/";
    private static final String BTN_INVITE = "a.board-header-btn-invite";
    private static final String MEMBERS_INPUT = "input[data-test-id='add-members-input']";
    private static final String NEW_MEMBER =
            ".autocomplete-search-results div[data-test-id='team-invitee-option'] div.member-container";
    private static final String EMPTY = " ";
    private static final String SEND_INVITE_BUTTON = "button[data-test-id='team-invite-submit-button']";
    private static final String TEAM_POPOVER_CLOSE = "button[data-test-id='popover-close']";

    @FindBy(css = BTN_INVITE)
    private WebElement openInviteBtn;

    @FindBy(css = MEMBERS_INPUT)
    private WebElement membersInput;

    @FindBy(css = NEW_MEMBER)
    private WebElement newMember;

    @FindBy(css = SEND_INVITE_BUTTON)
    private WebElement sendInviteBtn;

    @FindBy(css = TEAM_POPOVER_CLOSE)
    private WebElement skipTeamCreation;

    @FindBy(css = BOARD_HEADER)
    private WebElement boardHeader;

    @FindBy(css = BOARD_CANVAS)
    private WebElement board;

    @FindBy(css = DELETE_CONTAINER)
    private WebElement deleteContainer;

    @FindBy(css = DELETE_CONFIRM)
    private WebElement deleteConfirm;

    @FindBy(css = TITLE_TEXT)
    private WebElement titleBoard;

    @FindBy(css = TITLE_INPUT)
    private WebElement titleBoardInput;

    @FindBy(css = SHOW_MENU)
    private WebElement showMenuButton;

    @FindBy(css = ADD_LIST)
    private WebElement addListIcon;

    public BoardPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        action.waitForVisibility(boardHeader);
        action.waitForVisibility(board);
        return boardHeader.isDisplayed() && board.isDisplayed();
    }

    @Override
    public String handleUrl() throws URISyntaxException {
        wait.until(ExpectedConditions.urlMatches(URL_REGEX));
        String currentUri = new URI(driver.getCurrentUrl()).getPath();
        return Paths.get(currentUri).getName(ID_INDEX).toString();
    }

    public String getTitle() {
        return action.getElementText(titleBoard);
    }

    public MenuBoard displayMenu() {
        action.click(showMenuButton);
        return new MenuBoard(driver);
    }

    public void permanentlyDelete() {
        action.click(deleteContainer);
        action.click(deleteConfirm);
    }

    public FormPage<?> createNewList() {
        action.click(addListIcon);
        return new ListForm(driver);
    }

    public FormPage<?> updateList(final String listName) {
        String getList = String.format(GET_LIST, listName);
        WebElement actualList = driver.findElement(By.xpath(getList));
        action.click(actualList);
        return new ListUpdateForm(driver);
    }

    public BoardPage addMembersToInvite(final List<String> usersKeys) {
        action.click(openInviteBtn);
        action.waitForVisibility(membersInput);
        List<String> newMembers = getMembersKeywords(usersKeys);

        for (String member : newMembers) {
            if (EMPTY.equals(member)) {
                continue;
            }
            action.setInputField(membersInput, member);
            action.click(newMember);
        }
        return this;
    }

    public BoardPage sendInvitation() {
        action.click(sendInviteBtn);
        skipTeamCreation();
        return this;
    }

    private void skipTeamCreation() {
        Environment env = Environment.getInstance();
        try {
            wait.withTimeout(env.getReducedTime(), TimeUnit.SECONDS);
            action.waitForVisibility(skipTeamCreation);
            action.click(skipTeamCreation);
        } catch (TimeoutException ignored) {
        } finally {
            wait.withTimeout(env.getExplicitTimeWait(), TimeUnit.SECONDS);
        }
    }

    private List<String> getMembersKeywords(final List<String> usersKeys) {
        Stream<String> usersStream = usersKeys.stream()
                .map(user -> {
                    try {
                        return (new UserTrello(user)).getUsername();
                    } catch (Exception e) {
                        // Log -> user not valid
                        return EMPTY;
                    }
                });
        return usersStream.collect(Collectors.toList());
    }
}
