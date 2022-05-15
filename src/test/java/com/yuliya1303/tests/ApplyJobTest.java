package com.yuliya1303.tests;

import com.yuliya1303.pages.OrbitaQAAutomationVacancyDetails;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class ApplyJobTest extends TestBase {
    OrbitaQAAutomationVacancyDetails orbitaQAAutomationVacancyDetails = new OrbitaQAAutomationVacancyDetails();

    @Test
    @DisplayName("Vacancy parameters are exists in Description")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    void checkThatParametersExistsInDescription() {
        String framework = "Selenide";
        String workType = "удаленная работа";

        orbitaQAAutomationVacancyDetails.openPage()
                .checkFrameworkExistsInDescription(framework)
                .checkTypeExistsInDescription(workType);
    }

    @Test
    @DisplayName("Similar jobs block is displayed")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Job details")
    @Story("Jobs")
    @Tag("Smoke")
    void checkThatSimilarJobBlockExists() {
        orbitaQAAutomationVacancyDetails.openPage()
                .checkSimilarVacancyNotEmpty();
    }

    @ValueSource(strings = {
            "yuliyalevkovets1303@@gmail.com", //invalid data to show Failed status
            "yuliyalevkovets1303@" ////invalid data to show Failed status
    })

    @ParameterizedTest(name = "Check that valid Email {0} is Applied")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @Tag("Smoke")
    void checkValidEmailIsApplied(String testData) {

        orbitaQAAutomationVacancyDetails.openPage()
                .enterEmail(testData)
                .clickSubmitEmailBtn();

        orbitaQAAutomationVacancyDetails.checkEnterCodeIsDisplayed();
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
    @Disabled //disabled to show Skipped status
    void checkErrorDisplayedWhenInvalidEmailEntered(String testData) {

        orbitaQAAutomationVacancyDetails.openPage()
                .enterEmail(testData)
                .clickSubmitEmailBtn();

        orbitaQAAutomationVacancyDetails.checkInvalidEmailOrPhoneErrorIsDisplayed();
    }

}