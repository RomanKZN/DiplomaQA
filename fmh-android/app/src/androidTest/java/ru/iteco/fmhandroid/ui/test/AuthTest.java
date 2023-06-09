package ru.iteco.fmhandroid.ui.test;

import static ru.iteco.fmhandroid.ui.data.Helper.authInfo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.CommonSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.SplashScreenSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthSteps authSteps = new AuthSteps();
    MainScreenSteps mainScreenSteps = new MainScreenSteps();
    CommonSteps commonSteps = new CommonSteps();
    SplashScreenSteps splashScreenSteps = new SplashScreenSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> rule = new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashScreenSteps.appDownloading();
        try {
            authSteps.checkAuthPageLoaded();
            authSteps.isAuthScreen();
        } catch (Exception e) {
            mainScreenSteps.clickLogOutBtn();
            authSteps.checkAuthPageLoaded();
        }
    }

    @Test
    @DisplayName("Проверка элементов экрана авторизации")
    @Description("Корректность отображения всех элементов экрана Авторизация")
    public void shouldCheckAuthScreenElements() {
        authSteps.isAuthScreen();
    }

    @Test
    @DisplayName("Вход с валидными данными")
    @Description("При вводе валидного логина и пароля пользователь переходит на главный экран")
    public void shouldLogInWithValidData() {
        authSteps.authWithValidData(authInfo());
        authSteps.clickSignInBtn();
        mainScreenSteps.checkMainScreenLoaded();
        mainScreenSteps.isMainScreen();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с невалидными данными")
    @Description("При вводе невалидных значений логина и пароля всплывает сообщение о неверных данных")
    public void shouldNotLogInWithInvalidData() {
        authSteps.authWithInvalidData(authInfo());
        authSteps.clickSignInBtn();
        commonSteps.checkWrongAuthDataToast();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с пустыми данными")
    @Description("При попытке авторизоваться с пустыми логином и паролем пользователь не авторизуется, вплывает сообщение о незаполненных полях")
    public void shouldNotLogInWithEmptyData() {
        authSteps.clickSignInBtn();
        commonSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с пустым логином")
    @Description("При попытке авторизации с пустым логином пользователь не авторизуется, всплывает собщение о незаполненом поле")
    public void shouldNotLogInWithEmptyLogin() {
        authSteps.authWithEmptyLogin(authInfo());
        authSteps.clickSignInBtn();
        commonSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с пустым паролем")
    @Description("При попытке авторизации с пустым паролеи пользователь не авторизуется, всплывает собщение о незаполненом поле")
    public void shouldNotLogInWithEmptyPassword() {
        authSteps.authWithEmptyPass(authInfo());
        authSteps.clickSignInBtn();
        commonSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с невалидным паролем")
    @Description("При попытке авторизации с невалидным паролем пользователь не авторизуется, всплывает собщение о неверно заполненном поле")
    public void shouldNotLogInWithInvalidPass() {
        authSteps.authWithInvalidPass(authInfo());
        authSteps.clickSignInBtn();
        commonSteps.checkWrongAuthDataToast();
    }

    @Test
    @DisplayName("Сообщение об ошибке при авторизации с невалидным логином")
    @Description("При попытке авторизации с невалидным логином пользователь не авторизуется, всплывает собщение о неверно заполненном поле")
    public void shouldNotLogInWithInvalidLogin() {
        authSteps.authWithInvalidLogin(authInfo());
        authSteps.clickSignInBtn();
        commonSteps.checkWrongAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация и выход ")
    @Description("Пользователь авторизуется с валидными данными и выходит из приложения с помощью кнопки Log out")
    public void shouldLogInAndLogOut() {
        authSteps.authWithValidData(authInfo());
        authSteps.clickSignInBtn();
        mainScreenSteps.checkMainScreenLoaded();
        mainScreenSteps.isMainScreen();
        mainScreenSteps.clickLogOutBtn();
        authSteps.isAuthScreen();
    }


}