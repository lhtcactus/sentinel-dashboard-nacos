基于sentinel 1.8.0
### sentinel-dashboard
sentinel控制台，因为sentinel的官方只是给了持久化规则的例子，并有没真正实现，
所以需要自己实现规则持久化，主要修改有：
1. com.alibaba.csp.sentinel.dashboard.rule.nacos.*下的文件
2. com.alibaba.csp.sentinel.dashboard.controller.DegradeController
3. com.alibaba.csp.sentinel.dashboard.controller.AuthorityRuleController
4. com.alibaba.csp.sentinel.dashboard.controller.FlowControllerV1
5. com.alibaba.csp.sentinel.dashboard.controller.ParamFlowRuleController
6. com.alibaba.csp.sentinel.dashboard.controller.SystemController
7. pom.xml中的相关依赖，因为官方的依赖都是<scope>test</scope>,需要放开

现在还有一个监控数据的持久化没有做，（默认使用内存保存，只保存5分钟内的（InMemoryMetricsRepository）），
需要实现com.alibaba.csp.sentinel.dashboard.repository.metric.MetricsRepository，
最好是仿照com.alibaba.csp.sentinel.dashboard.repository.metric.InMemoryMetricsRepository来实现，
目前觉得比较好的方案是实现一个基于Influxdb（一个时序数据库），但是因为时间关系没有实现，有时间可以实现一下


### sentinel-demo
一个和sentinel-dashboard完成对接的demo