# **Мобильное приложение «Мобильный хоспис».**

## **Процедура запуска авто-тестов:**

1. Склонировать данный репозиторий или скачать архив

2. Открыть проект fmh-android в Android Studio.

3. Запустить эмулятор (API 29).

4. Запуск тестов:

- Перейти к папке с тестами fmh-android\app\src\androidTest\java\ru\iteco\fmhandroid\ui\test нажать ПКМ и выбрать Run 'Tests in 'ru.iteco.fmhandroid.ui.test' или комбинацией клавиш Ctrl+Shift+F10
- Запустить каждый тестовыый класс отдельно, например выбать AuthTest > ПКМ > выбрать Run 'AuthTest' или комбинацией клавиш Ctrl+Shift+F10
- Через терминал командой ./gradlew connectedAndroidTest
  (Внимание! Есть не стабильные тесты при запуске всех тестов, если их запускать отдельно, то они проходят)

5. Выгрузить каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора.

6. Выполнить команду allure serve, находясь на уровень выше allure-results.
