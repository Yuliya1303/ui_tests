package ru.hh.tests;

import ru.hh.pages.VacancyDetailsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ApplyJobTest extends TestBase {
    VacancyDetailsPage vacancyDetailsPage = new VacancyDetailsPage();

    @Test
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @DisplayName("Vacancy parameters are exists in Description")
    void checkThatParametersExistsInDescription() {
        String framework = "Selenide";
        String workType = "удаленная работа";

        vacancyDetailsPage.openPage()
                .checkFrameworkExistsInDescription(framework)
                .checkTypeExistsInDescription(workType);
    }

    @Test
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Job details")
    @Story("Jobs")
    @Tag("Smoke")
    @DisplayName("Similar jobs block is displayed")
    void checkThatSimilarJobBlockExists() {
        vacancyDetailsPage.openPage()
                .checkSimilarVacancyNotEmpty();
    }

    @ValueSource(strings = {
            "yuliyalevkovets1303@@gmail.com", //invalid data to show Failed status in Report
            "yuliyalevkovets1303@" //invalid data to show Failed status in Report
    })

    @ParameterizedTest(name = "Check that valid Email {0} is Applied")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @Tag("Smoke")
    void checkValidEmailIsApplied(String testData) {

        vacancyDetailsPage.openPage()
                .enterEmail(testData)
                .clickSubmitEmailBtn();

        vacancyDetailsPage.checkEnterCodeIsDisplayed();
    }

    @ValueSource(strings = {
            "yuliyalevkovets1303@",
            "test.test@@test.com "
    })

    @ParameterizedTest(name = "Check that Error is displayed when invalid Email {0} is entered")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @Tag("Smoke")
    @Disabled //disabled to show Skipped status in Report
    void checkErrorDisplayedWhenInvalidEmailEntered(String testData) {

        vacancyDetailsPage.openPage()
                .enterEmail(testData)
                .clickSubmitEmailBtn();

        vacancyDetailsPage.checkInvalidEmailOrPhoneErrorIsDisplayed();
    }

}