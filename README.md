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

## 4. Шаги ( запуск на локальной машине в intelliJ IDEA)

* выполнить команду docker-compose up в терминале
* открыть проект в IntelliJ IDEA
* выполнить в терминале java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=app
  -Dspring.datasource.password=pass -jar aqa-shop.jar &
* запустить тестирование командой ./gradlew test -Dsql.url=jdbc:mysql://localhost:3306/app
  -Dsql.http=http://localhost:8080 -Dsql.user=app -Dsql.pass=pass
* выполнить в терминале java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app
  -Dspring.datasource.username=app -Dspring.datasource.password=pass -Dserver.port=9090 -jar aqa-shop.jar &
* запустить тестирование командой ./gradlew test -Dsql.url=jdbc:postgresql://localhost:5432/app
  -Dsql.http=http://localhost:9090  -Dsql.user=app -Dsql.pass=pass

## 5. [ Report.md ](https://github.com/UBCh/courseProject/blob/master/Report.md)

## 6.  [Summary.md ](https://github.com/UBCh/courseProject/blob/master/Summary.md)

## 7.  [Plan.md](https://github.com/UBCh/courseProject/blob/master/Plan/Plan.md)

[![Build status](https://ci.appveyor.com/api/projects/status/pg1j3uk0o1xqphlt?svg=true)](https://ci.appveyor.com/project/UBCh/courseproject)
