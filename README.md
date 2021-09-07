### {Run Server}
1-	clone the project using git.

2-	Go to /Bloomberg/src/main/resources/application.properties and edit the DB connection

	dbc:mysql://localhost:3306/{your DB Schema}?useUnicode=……
	
3-	change the value of spring.jpa.hibernate.ddl-auto from none to update.

	spring.jpa.hibernate.ddl-auto=update
	
4-	make maven clean update and run.


Note: For logging files go to /Bloomberg/logs






###  {API}   
```
request URL:  {host}/api/deals/save-new	

{
 "fCurrencyISOCode": "JOD",
 "tCurrencyISOCode": "USD",
  "amount": 1025.02154448
}
```


```
Success response : 201 created

{
    "id": 2,
    "creationDate": "2021-09-05T10:15:52.162+00:00",
    "amount": 520.02154448,
    "tcurrencyISOCode": "USD",
    "fcurrencyISOCode": "JOD"
}

```

```
Failed  response : 200 ok / 400 Bad Request

 {
    "status": "OK",
    "message": "Deals Already saved",
    "date": "2021-09-05T10:15:52.162+00:00"
}

{
    "status": "BAD_REQUEST",
    "message": "fCurrencyISOCode is mandatory",
    "date": "2021-09-06T10:40:25.873+00:00"
}
```



###  {WEB}   
 
find the deal by ID:

1-	serve the angular project that found in Bloomberg front-end folder


2-	go to http://localhost:4200/.





