

Как хрянятся данные интерфейса

{
    "type":"VisualInterfaceData",
    "version":1.0,
    "visualInterface":"member",
    "parentVisualInterface":null,
    "parentID":null,
    "data":[
        {"visualElement":"GUID элемента интерфейса", "value":"element value as string", "parent":"GUID элемента родителя" },
        .................
    ]
}    

В даннном случае интерфей "member" описывается линейно независимо, сколько подчиненных элементтов он имеет

{
    "visualInterfaceDataList": [
    {
        "visualInterface":"member",
        "ID", "100",
        "parentVisualInterface":null,
        "parentID":null,
        "recordData":[  // Это описание основных данных
            {"visualElement":"ID", "value":"100" },
            {"visualElement":"firstName", "value":"Ivanov" },
            {"visualElement":"lastName", "value":"Evgeniy" },
            {"visualElement":"middleName", "value":"Ivanovich" },
            {"visualElement":"dataBirthday", "value":"8778789798789" }
        ]
    },
    {
        "visualInterface":"member_phones",
        "ID", "1",
        "parentVisualInterface":"member",
        "parentID":"100",
        "recordData":[        
            // Это описание основных данных
            {"visualElement":"ID", "value":"1" },
            {"visualElement":"phoneNumber", "value":"+7 926 3454390" }
        ]
    },
    {
        "visualInterface":"member_phones",
        "ID", "2",
        "parentVisualInterface":"member",
        "parentID":"100",
        "recordData":[        
            // Это описание основных данных
            {"visualElement":"ID", "value":"2" },
            {"visualElement":"phoneNumber", "value":"+7 499 1234567" }
        ]
    },
    .........................
}       

    





    "events":[
        {   "file_guid":"127671-128998-81js018-2980","time":2140908938900, "temperature measurement":["temperature":"38.7"],
            "file_guid":"127671-128998-81js018-2980","time":2141906538922, "taking medicine":["name":"38.7","value":"500", "unit","mg"]}
        }
    ]
