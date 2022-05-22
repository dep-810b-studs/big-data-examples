## Запуск HBase:
### Обычный режим

`sudo docker compose -f ./docker-compose.standalone.yml up -d`

### Псевдораспределенный режим

`sudo docker compose -f ./docker-compose.distributed.yml up -d`

### Запуск с SQL интерфейсом для HBase - phoneix

`sudo docker compose -f ./docker-compose.phoneix.yml up -d`

<br/>

## Пример работы в HBase:

<br/>`$ docker exec -it hbase /bin/bash`
<br/>`# /opt/hbase-1.2.6/bin/hbase shell`
<br/> `hbase(main):003:0> create 'test', 'cf'`
<br/> `hbase(main):005:0> list 'test'`
<br/> `hbase(main):006:0> describe 'test'`
<br/> `hbase(main):007:0> put 'test', 'row1', 'cf:a', 'value1'`
<br/> `hbase(main):008:0> put 'test', 'row2', 'cf:b', 'value2'`
<br/> `hbase(main):009:0> put 'test', 'row3', 'cf:c', 'value3'`
<br/> `hbase(main):001:0> scan 'test'`
<br/> `get 'test', 'row1'`
<br/> `hbase(main):003:0> disable 'test'`
<br/> `drop 'test'`

## Источники:
- https://hbase.apache.org/book.html#quickstart
- https://gethue.com/blog/querying-live-kafka-data-in-apache-hbase-with-phoenix/
- Локальный запуск hadoop в docker: https://www.youtube.com/watch?v=ny2w5zImqvA&t=339s
- https://www.youtube.com/watch?v=WLVngOrhtnU&list=PLrCZzMib1e9rPxMIgPri9YnOpvyDAL9HD&index=8
- https://www.youtube.com/watch?v=CJdz9GMsNdE
- https://www.youtube.com/watch?v=0Tzl6qMPWQo
