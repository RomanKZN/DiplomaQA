# **Мобильное приложение «Мобильный хоспис».**

## **Процедура запуска авто-тестов:**

1. Склонировать данный репозиторий

2. Открыть проект fmh-android в Android Studio.

3. Запустить эмулятор (API 29).

4. Запустить тесты - кнопкой Run или командой ./gradlew connectedAndroidTest

5. Выгрузить каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора.

6. Выполнить команду allure serve, находясь на уровень выше allure-results.
