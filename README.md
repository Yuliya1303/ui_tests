# Проект по автоматизации тестирования страницы деталей вакансии QA Automation в ООО "Центр Орбита" на сайте hh.ru
## <a target="_blank" href="https://hh.ru/vacancy/55354866?query=QA%20automation%20engineer&from=vacancy_search_catalog&hhtmFrom=vacancy_search_catalog">hh.ru - Вакансия QA Automation</a>

## :floppy_disk: Содержание:

- <a href="#computer-сode_stack:">Code stack</a>
- <a href="#computer-сode_stack:">Infrastucture stack</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- <a href="#electric_plug-сборки-в-Jenkins">Сборки в Jenkins</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#robot-отчет-в-slack">Отчет в Slack</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Code stack:
<p align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
</p>

## :computer: Infrastucture stack:
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Slack" src="images/logo/Slack.svg">

## :notebook_with_decorative_cover: Реализованные проверки
- Проверка наличия текста "QA" в названии вакансии
- Проверка соответствия вакансии на необходимый тип работы: удаленная работа
- Проверка соответствия вакансии на наличие необходимых навыков: Selenoid
- Проверка перехода на ввод кода при вводе валидного Email и отклике на вакансию (тест failed для отражения статуса failed в отчетах)
- Проверка наличия ошибки при вводе неверного формата Email (тест Disabled для отражения статуса skipped в отчетах)

## :electric_plug: Сборки в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/C08-Yuliya_B-ReadmeForVacancy13All/">Параметризированная сборка в Jenkins со всеми тестами</a>
<p align="center">
<img title="Jenkins Job Run with parameters" src="images/screenshots/jenkins-run.png">
</p>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard-all.png">
</p>
### <a target="_blank" href="https://jenkins.autotests.cloud/job/C08-Yuliya_B-ReadmeForVacancy13/">Сборка в Jenkins со Smoke тестами</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard-smoke.png">
</p>  

## :arrow_forward: Запуск из терминала
Локальный запуск всех тестов:
```
gradle clean test
```

Локальный запуск только Smoke тестов (c тегом Smoke):
```
gradle clean smoke_tests
```

Удаленный запуск всех тестов:
```
clean
test
-Dremote=${REMOTE}
-Dbrowser=${BROWSER}
```

Удаленный запуск только Smoke тестов (c тегом Smoke):
```
clean
smoke_tests
 -Dbrowser=${BROWSER}
 -DbrowserVersion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -DbaseUrl=${BASE_URL}
```

## :open_book: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>

## :robot: Отчет в Telegram
<p align="center">
<img title="Telegram notification message (All results)" src="images/screenshots/telegram-bot.png">
</p>

## :robot: Отчет в Slack
<p align="center">
<img title="Slack notification message (Only failed tests)" src="images/screenshots/slack-bot.png">
</p>

## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/test-run.gif">
</p>
