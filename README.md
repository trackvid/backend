[![Build Status](https://travis-ci.com/trackvid/backend.svg?branch=master)](https://travis-ci.com/trackvid/backend.svg?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ba8fadfb81c24f57aaecab595e9fba62)](https://app.codacy.com/gh/trackvid/backend?utm_source=github.com&utm_medium=referral&utm_content=trackvid/backend&utm_campaign=Badge_Grade_Dashboard)
# backend

## Data model

We created data model in Miro: [Data model](https://miro.com/app/board/o9J_ktA824Q=/)

## How to run


### Required properties in application.properties
```
//neo4j username
spring.data.neo4j.username=*
// neo4j password
spring.data.neo4j.password=*
```

optionally you can change type of updating indexes neo4j and server port
```
spring.data.neo4j.auto-index=*
server.port=*
```


### Run
```
./gradlew build
./gradlew bootRuun
```

Tests:
```
./gradlew check
```

### Swagger

Additionally under path specified below is swagger documentation of api.
 
```
${project_url}/swagger-ui.html
```
