package ru.hh.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class VacancyDetailsPage {
    //locators
    SelenideElement vacancyDetailsPageTitle = $(by("data-qa","vacancy-title")),
            vacancyDescription = $(".vacancy-description"),
            vacancyType = $(by("data-qa","vacancy-view-employment-mode")),
            similarVacancy = $(".recommended-vacancies"),
            emailOrPhoneField = $(by("data-qa","account-signup-email")),
            submitEmailBtn = $(by("data-qa","account-signup-submit")),
            enterCode = $(by("data-qa","otp-code-form")),
            invalidEmailOrPhoneError = $(".field-error-login_BAD_LOGIN");

    //actions
    @Step("Open Vacancy Details Page")
    public VacancyDetailsPage openPage() {
        open("/vacancy/55354866");
        vacancyDetailsPageTitle.shouldHave(text("QA"));

        return this;
    }

    @Step("Check that Framework exists in vacancy description")
    public VacancyDetailsPage checkFrameworkExistsInDescription(String framework) {
        vacancyDescription.shouldHave(text(framework));

        return this;
    }

    @Step("Check Vacancy type")
    public VacancyDetailsPage checkTypeExistsInDescription(String workType) {
        vacancyType.shouldHave(text(workType));

        return this;
    }

    @Step("Check that Similar vacancies list is not empty")
    public VacancyDetailsPage checkSimilarVacancyNotEmpty() {
        similarVacancy.shouldNotBe(empty);

        return this;
    }

    @Step("Enter email {email}")
    public VacancyDetailsPage enterEmail(String email) {
        emailOrPhoneField.scrollTo();
        emailOrPhoneField.setValue(email);

        return this;
    }

    @Step("Click Submit email btn")
    public VacancyDetailsPage clickSubmitEmailBtn() {
        submitEmailBtn.click();

        return this;
    }

    @Step("Check that Enter code block is displayed")
    public VacancyDetailsPage checkEnterCodeIsDisplayed() {
        enterCode.shouldBe(visible);

        return this;
    }

    @Step("Check that Invalid Email or Phone error message is displayed")
    public VacancyDetailsPage checkInvalidEmailOrPhoneErrorIsDisplayed() {
        invalidEmailOrPhoneError.shouldBe(visible);

        return this;
    }
}
