# Diplom_3
Третья часть финального проекта на курсе по автоматизации на Java.
Яндекс практикум.
###Используемые технологии
* Java 11
* junit 4.13.2
* selenium-java 3.141.59
* webdrivermanager 4.4.3
* rest-assured 5.3.1
* allure-maven 2.10.0
* gson 2.10.1
###Запуск тестов
Для Google Chrome: \
`mvn clean test -DbrowserName=chrome`\
\
Для Yandex Browser: \
`mvn clean test -DbrowserName=yandex`\
\
В проекте прописан путь до бинарника с драйвером Яндекс Браузера для Mac OS. Для настройки под другие системы - поменять путь в переменной **YA_BROWSER_DIRECTORY** в **config**.
###Получение allure отчета
`mvn allure:serve`