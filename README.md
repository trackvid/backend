[![Build Status](https://travis-ci.com/trackvid/backend.svg?branch=master)](https://travis-ci.com/trackvid/backend.svg?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ba8fadfb81c24f57aaecab595e9fba62)](https://app.codacy.com/gh/trackvid/backend?utm_source=github.com&utm_medium=referral&utm_content=trackvid/backend&utm_campaign=Badge_Grade_Dashboard)
# TRACKvid (backend)

> This project was created while **EUvsVirus** hacathon

## Why?

### Inspiration
We want create a tool for people to allow them to check if they could be in close proximity with infected with covid-19 in future in every other deadly disease.
They could also check if in place where they want to go is safe and is do not have any cases at that moment.
### What it does
It allows users to track their movement and compare it with movement people with known infection to check if there was a chance to be near to the somebody with disease. If it was it  alerts them to take additional precautions.
### How we built it
We built it with: ```javascript```, ```typesript```, ```vue```, ```lefleat```, ```java```, ```spring```, ```neo4j```
### Challenges we ran into
Functionality to leave browser awake when user blocks phone or changes app. Integration typescript with vuex, lefleat and there was some problem with application deployment on azure.
### Accomplishments that we're proud of
Integrating **graph database** to use it structure to perform fast search of hit cases and display all possible infection locations with description in **map**.
### What we learned
We get to know neo4j database and. We discovered how to use triangulation to discover user position, thanks to that device which runs the app does not need gps.
### What's next for Trackvid
We want to create an app whit the most dangerous paths, regions etc. . We want to do some optimization for matching the data. We have to add functionality to frontend to force browser to not sleep (currently, to track data browser has to be open).

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
