# процедура запуска авто-тестов
## 1.Перечень необходимого установленного ПО
* **Windows 10**
* **IntelliJ IDEA**
* **Java 11** 
* **puTTY**

## 2. Перечень сервисов (наличие зарегистрированного аккаунта)
* **Git** 
* **appveyor**


## 3. Перечень необходимых файлов (техническая часть)
* **[ приложение ](https://github.com/UBCh/courseProject/blob/master/aqa-shop.jar)**
* **[ docker-compose.yml  ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/docker-compose.yml#L1)**
* **[ application.properties ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/application.properties#L1)**
* **[dockerfile](https://github.com/UBCh/courseProject/blob/f01747dcec4f7987f9e92d08a0873b2906f18949/Dockerfile#L1)**
* **[ .appveyor.yml ](https://github.com/UBCh/courseProject/blob/dd8cbf9a88bad9e07253c54bdde1d59caaf547b8/.appveyor.yml#L1)**

## 3. Шаги ( запуск на локальной машине в intelliJ IDEA с запуском БД и симулятора в виртуальной машине)
* выполнить команду docker-compose up в терминале 
* открыть проект в IntelliJ IDEA
* выполнить  java -jar aqa-shop.jar в терминале
* командой ./gradlew test запустить тестирование





[![Build status](https://ci.appveyor.com/api/projects/status/pg1j3uk0o1xqphlt?svg=true)](https://ci.appveyor.com/project/UBCh/courseproject)
