package com.yuliya1303.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class OrbitaQAAutomationVacancyDetails {
    //locators
    SelenideElement vacancyDetailsPageTitle = $(byAttribute("data-qa","vacancy-title")),
            vacancyDescription = $(".vacancy-description"),
            vacancyType = $(".vacancy-view-employment-mode"),
            similarVacancy = $(".recommended-vacancies"),
            emailOrPhoneField = $(byAttribute("data-qa","account-signup-email")),
            submitEmailBtn = $(byAttribute("data-qa","account-signup-submit")),
            enterCode = $(byAttribute("data-qa","otp-code-form")),
            invalidEmailOrPhoneError = $(".field-error-login_BAD_LOGIN");

    //actions
    @Step("Open Vacancy Details Page")
    public OrbitaQAAutomationVacancyDetails openPage() {
        open("/vacancy/55354866?query=QA%20automation%20engineer&from=vacancy_search_catalog&hhtmFrom=vacancy_search_catalog");
        vacancyDetailsPageTitle.shouldHave(text("QA"));

        return this;
    }

    @Step("Check that Framework exists in vacancy description")
    public OrbitaQAAutomationVacancyDetails checkFrameworkExistsInDescription(String framework) {
        vacancyDescription.shouldHave(text(framework));

        return this;
    }

    @Step("Check Vacancy type")
    public OrbitaQAAutomationVacancyDetails checkTypeExistsInDescription(String workType) {
        vacancyType.shouldHave(text(workType));

        return this;
    }

    @Step("Check that Similar vacancies list is not empty")
    public OrbitaQAAutomationVacancyDetails checkSimilarVacancyNotEmpty() {
        similarVacancy.shouldNotBe(empty);

        return this;
    }

    @Step("Enter Email")
    public OrbitaQAAutomationVacancyDetails enterEmail(String email) {
        emailOrPhoneField.scrollTo();
        emailOrPhoneField.setValue(email);

        return this;
    }

    @Step("Click Submit email btn")
    public OrbitaQAAutomationVacancyDetails clickSubmitEmailBtn() {
        submitEmailBtn.click();

        return this;
    }

    @Step("Check that Enter code block is displayed")
    public OrbitaQAAutomationVacancyDetails checkEnterCodeIsDisplayed() {
        enterCode.shouldBe(visible);

        return this;
    }

    @Step("Check that Invalid Email or Phone error message is displayed")
    public OrbitaQAAutomationVacancyDetails checkInvalidEmailOrPhoneErrorIsDisplayed() {
        invalidEmailOrPhoneError.shouldBe(visible);

        return this;
    }
}
