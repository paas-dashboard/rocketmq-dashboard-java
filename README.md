# rocketmq-dashboard-java
## backend api command
### topic
#### create topic
```bash
curl -iv -X PUT -H "Content-Type: application/json" http://localhost:10012/api/rocketmq/topics -d '{"name":"test"}'
```
#### list topic
```bash
curl -iv -X GET -H "Content-Type: application/json" http://localhost:10012/api/rocketmq/topics
```
