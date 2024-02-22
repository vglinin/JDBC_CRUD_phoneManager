
Привет, это CRUD - приложение.
     ...Мелкая инструкция по использованию...
Для теста нужен "Postman", как и что заполнять можно посмотреть на ютубе.
Вам нужно создать 4 HTTP Protocol
1. POST - created phone
( JSON )
{
    "namePhone": "Iphone",
    "versionPhone": "16"
}

2. GET - get phone
( PARAMS )
key = id / value = "ВАШ id DB"

3. PUT - edit phone
( JSON )
{
    "id": 9,
    "namePhone": "Iphone",
    "versionPhone": "X"
}

4. DELETE - delete phone
( PARAMS )
key = id / value = "ВАШ id DB"
