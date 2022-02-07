# процедура запуска авто-тестов
## 1.Перечень необходимого установленного ПО
* **Windows 10**
* **IntelliJ IDEA**
* **Java 11** 
* **Node.js** 
* **MySQL и MySQL Workbench** и  **PostgreSQL 11**
* либо 
* **Docker** 

## 2. Перечень сервисов (наличие зарегистрированного аккаунта)
* **Git** 
* **appveyor**


## 3. Перечень необходимых файлов (техническая часть)
* **[ приложение ](https://github.com/UBCh/courseProject/blob/master/aqa-shop.jar)**
* **[ симулятор банковского сервиса ](https://github.com/UBCh/courseProject/tree/master/gate-simulator)**
* **[ docker-compose.yml  ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/docker-compose.yml#L1)**
* **[ application.properties ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/application.properties#L1)**
* **[ .appveyor.yml ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/.appveyor.yml#L1)**

## 3. Шаги ( запуск на локальной машине в intelliJ IDEA)
* открыть MySQL Workbench
* запустить соединение с локально установленной BD, которая должна стартовать на порту 3306
* запустить симулятор банковских операций на порту 9999, для чего В IDEA из каталога \gate-simulator в терминале выполнить команду npm start .
* запустить приложение на порту 8080 командой java -jar aqa-shop.jar.
* командой RUN запустить TestService.java
