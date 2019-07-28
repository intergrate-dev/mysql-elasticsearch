# SyncMysqlToElasticsearch

####  介绍
利用Binlog和Kafka实时同步mysql数据到Elasticsearch

#### 项目模块
BinlogMiddleware
1、binlog中间件，负责解析binlog，把变动的数据以json形式发送到kafka队列。

KafkaMiddleware
2、kafka中间件，负责消费kafka队列中的Message，把数据写入Elasticsearch中。

#### 基础服务
（1）Mysql
（2）Kafka（用于存放mysql变动消息，存放于Kafka队列）
（3）Elasticsearch




#### 使用说明

1. Demo初始化数据库使用: teemoliu_init.sql
2. Demo初始化ES索引使用：es_build_index.py
   使用postman put, body(row-json)
3. docker-compose
   ./docker/docker-compose.yml
   at first time, docker-compose [-f xxx.yml] up -d
   docker start zookeeper, dokcer start kafka
   
4. 教程见：https://www.jianshu.com/p/3ebab93ff075

#### Email:lzhzh825@gmail.com
PS:本demo只是简单示例，有很多可以优化的地方，本人也才疏学浅，欢迎大家提建议。



https://www.cnblogs.com/sunsky303/p/9438737.html
https://www.cnblogs.com/weihe-xunwu/p/6687000.html
https://www.cnblogs.com/wangpinzhou/articles/8997289.html



#### postman
{"version":1,"collections":[{"id":"1c7c017d-2ab4-cce2-636c-43bdda9baef8","name":"elastic-collection","timestamp":1564300630150,"requests":[{"collectionId":"1c7c017d-2ab4-cce2-636c-43bdda9baef8","id":"bf4a5f35-f7d5-cbfb-fc6b-f34c5fd5a032","name":"user_get","description":"get user doc","url":"http://localhost:9200/housesearch/user/4?pretty","method":"GET","headers":"","data":"{\n  'mappings': {\n    'user': {\n      'properties': {\n        'id': {\n          'type': 'long'\n        },\n        'name': {\n          'type': 'keyword'\n        }\n      }\n    },\n    'role': {\n      'properties': {\n        'id': {\n          'type': 'long'\n        },\n        'name': {\n          'type': 'keyword'\n        }\n      }\n    },\n    \n  },\n  'settings': {\n    'index': {\n      'refresh_interval': '60s',\n      'number_of_shards': '5',\n      'number_of_replicas': '0',\n      'translog': {\n        'sync_interval': '60s',\n        'durability': 'async',\n        'flush_threshold_size': '1g'\n      }\n    }\n  }\n}","dataMode":"raw","timestamp":0,"version":2,"time":1564326867451},{"collectionId":"1c7c017d-2ab4-cce2-636c-43bdda9baef8","id":"f60800d2-cab1-568b-7966-128821d3657b","name":"es_setting_index","description":"init index","url":"http://localhost:9200/housesearch","method":"PUT","headers":"","data":"{\n  'mappings': {\n    'user': {\n      'properties': {\n        'id': {\n          'type': 'long'\n        },\n        'name': {\n          'type': 'keyword'\n        }\n      }\n    },\n    'role': {\n      'properties': {\n        'id': {\n          'type': 'long'\n        },\n        'name': {\n          'type': 'keyword'\n        }\n      }\n    },\n    \n  },\n  'settings': {\n    'index': {\n      'refresh_interval': '60s',\n      'number_of_shards': '5',\n      'number_of_replicas': '0',\n      'translog': {\n        'sync_interval': '60s',\n        'durability': 'async',\n        'flush_threshold_size': '1g'\n      }\n    }\n  }\n}","dataMode":"raw","timestamp":0,"responses":[],"version":2}]}],"environments":[],"headerPresets":[],"globals":[]}





