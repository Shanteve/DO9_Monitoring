## Part 1. Получение метрик и логов
### Задание

1. Использовать Docker Swarm из первого проекта. 

Перед запуском проекта нужно создать .env файл. Пример в файле .env.example 

2. Написать при помощи библиотеки Micrometer сборщики следующих метрик приложения: 
   - количество отправленных сообщений в rabbitmq;
   - количество обработанных сообщений в rabbitmq;
   - количество бронирований;
   - количество полученных запросов на gateway;
   - количество полученных запросов на авторизацию пользователей.

Пример с booking-service (В других сервисах реализация похожа)
- Добавил новые зависимости в pom.xml файл
![alt text](images/part1/execise2/image.png)
- Добавил конфигурацию для метрик в файле application.properties
![alt text](<images/part1/execise2/image copy.png>)
- Создал счётчики метрик "bookings.total" (Количество бронирований) и "rabbitmq.messages.sent" (Количество отправленных сообщений в rabbitmq)
![alt text](<images/part1/execise2/image copy 2.png>)
- Пример того, как подключаются метрики. 1) Импортируется класс Counter (Счётчик). 2) Привязывается наш ранее созданный счётчик *sentMessagesRabbitmqCounter* 3) После отправки сообщения в RabbitMQ значения счётчика увеличивается на 1.
![alt text](<images/part1/execise2/image copy 3.png>)

- После сборки я запушил все новые образы в dockerhub с тегом v2 и впоследствии использовал их в docker-compose.yml файле.
![alt text](<images/part1/execise2/image copy 4.png>)

3. Добавить логи приложения с помощью Loki.

- Конфигурация Loki
![alt text](images/part1/exercise3/image.png)

- Для сбора логов приложения используется Alloy (Современная замена устаревшего Promtail). Содержимое файла alloy_config.alloy
![alt text](<images/part1/exercise4/image copy 12.png>)
![alt text](<images/part1/exercise4/image copy 13.png>)

4. Создать новый стек для Docker Swarm из сервисов с Prometheus Server, Loki, node_exporter, blackbox_exporter, cAdvisor. Проверить получение метрик на порту 9090 через браузер.

- Я создал отдельный docker-compose-monitroing.yml файл для присоединения стека мониторинга в Docker Swarm.Содержимое файла docker-compose-monitroing.yml
![alt text](images/part1/exercise4/image.png)
![alt text](<images/part1/exercise4/image copy.png>)
![alt text](<images/part1/exercise4/image copy 2.png>)
![alt text](<images/part1/exercise4/image copy 3.png>)
![alt text](<images/part1/exercise4/image copy 4.png>)
![alt text](<images/part1/exercise4/image copy 5.png>)
![alt text](<images/part1/exercise4/image copy 6.png>)

- Конфигурации для сервисов хранятся в директории monitoring:
1) prometheus.yml
- ![alt text](<images/part1/exercise4/image copy 7.png>)
![alt text](<images/part1/exercise4/image copy 8.png>)
![alt text](<images/part1/exercise4/image copy 9.png>)
![alt text](<images/part1/exercise4/image copy 10.png>)
![alt text](<images/part1/exercise4/image copy 11.png>)

2) blackbox.yml
- ![alt text](<images/part1/exercise4/image copy 14.png>)

### Запуск стека сервисов, portainer и мониторинга
- Запуск стека с сервисами
![alt text](<images/part1/exercise4/image copy 15.png>)
![alt text](<images/part1/exercise4/image copy 16.png>)

- Запуск стека с portainer
![alt text](<images/part1/exercise4/image copy 17.png>)
![alt text](<images/part1/exercise4/image copy 18.png>)
![alt text](<images/part1/exercise4/image copy 19.png>)

- Запуск стека с мониторингом
![alt text](<images/part1/exercise4/image copy 20.png>)
![alt text](<images/part1/exercise4/image copy 21.png>)
![alt text](<images/part1/exercise4/image copy 22.png>)

## Part 2. Визуализация

В этой главе тебе предстоит настроить Grafana для визуализации метрик и логов.

### Задание

1. Развернуть grafana как новый сервис в стеке мониторинга.
- В стек мониторинга добавлена Grafana
![alt text](<images/part2/exercise1/image copy 23.png>)

2. Добавить в Grafana дашборд со следующими метриками:
   - количество нод;
   - количество контейнеров;
   - количество стеков;
   - использование CPU по сервисам;
   - использование CPU по ядрам и узлам;
   - затраченная RAM;
   - доступная и занятая память;
   - количество CPU;
   - доступность google.com;
   - количество отправленных сообщений в rabbitmq;
   - количество обработанных сообщений в rabbitmq;
   - количество бронирований;
   - количество полученных запросов на gateway;
   - количество полученных запросов на авторизацию пользователей;
   - логи приложения.

1) Количество нод
- ![alt text](images/part2/exercise2/image.png)
2) Количество контейнеров
- ![alt text](<images/part2/exercise2/image copy.png>)
3) Количество стеков
- ![alt text](<images/part2/exercise2/image copy 2.png>)
4) Использование CPU по сервисам
- ![alt text](<images/part2/exercise2/image copy 3.png>)
5) Использование CPU по ядрам и узлам
- ![alt text](<images/part2/exercise2/image copy 4.png>)
6) Затраченная RAM
- ![alt text](<images/part2/exercise2/image copy 6.png>)
7) Доступная и занятая память
- ![alt text](<images/part2/exercise2/image copy 5.png>)
8) Количество CPU
- ![alt text](<images/part2/exercise2/image copy 7.png>)
9) Доступность google.com
- ![alt text](<images/part2/exercise2/image copy 8.png>)
10) Количество отправленных сообщений в rabbitmq
- ![alt text](<images/part2/exercise2/image copy 9.png>)
11) Количество обработанных сообщений в rabbitmq
- ![alt text](<images/part2/exercise2/image copy 10.png>)
12) Количество бронирований
- ![alt text](<images/part2/exercise2/image copy 11.png>)
13) Количество полученных запросов на gateway
- ![alt text](<images/part2/exercise2/image copy 12.png>)
14) Количество полученных запросов на авторизацию пользователей
- ![alt text](<images/part2/exercise2/image copy 13.png>)
15) Логи приложения.
- ![alt text](<images/part2/exercise2/image copy 14.png>)


## Part 3. Отслеживание критических событий

В этой главе тебе предстоит настроить Alert Manager для оповещения о критических событиях.

### Задание

1. Развернуть Alert Manager как новый сервис в стеке монтиторинга.
- Был добавлен новый сервис Alert Manager.
![alt text](images/part3/exercise1/image.png)

### Важно уточнить
Для хранения секретов telegram_token и email_token я использовал docker secret
```
printf "Ваш секретный токен" | docker secret create gmail_token -
printf "Ваш секретный токен" | docker secret create telegram_token -
```

- Содержимое файла alertmanager.yml
![alt text](<images/part3/exercise1/image copy.png>)

2. Добавить следующие критические события:
   - доступная память меньше 100 Мб;
   - затраченная RAM больше 1 Гб;
   - использование CPU по сервису превышает 10%.

- Правила алертов написаны в конфигурационном файле alert-rules.yml
![alt text](<images/part3/exercise2/image copy 2.png>)
![alt text](<images/part3/exercise2/image copy 3.png>)

3. Настроить получение оповещений через личные email и Телеграм.
Пример уведомлений. У меня стоит проверка, что "использование CPU по сервису превышает 10%" на ноде вызывает alert. На manager01 данная проверка срабатывает сразу же из-за rabbitmq.

- Письмо в gmail
![alt text](images/part3/exercise3/image.png)
![alt text](<images/part3/exercise3/image copy.png>)

- Сообщение в телеграмме
![alt text](<images/part3/exercise3/image copy 2.png>)