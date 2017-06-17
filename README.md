# What is OAClinic
OAClinic is an application for the android platform of a private hospital. The field collectors of that company can access this application for their billing purpose. The collectors can make entry of the data of the billing to direct their database using this application API. And they can also check the billing details from the database by this application API.

# API and module details
## User
The application supports multiple field collectors. They can log in through the API and run the app from their devices.

### get all users
```sh
GET /users
response: 
[
    {
        "id": 1,
        "fullName": "Avik Manna",
        "userName": "avik",
        "userPassword": "root",
        "userRole": "dev",
        "isActive": "true",
        "templatePath": null
    },
    {
        "id": 2,
        "fullName": "Subhadip Pramanik",
        "userName": "subhadip",
        "userPassword": "root",
        "userRole": "dev",
        "isActive": "true",
        "templatePath": null
    }
]
```
### create user
```sh
POST /user
body:
{
	"userName":"avik",
	"fullName":"Avik Manna",
	"userPassword":"root",
	"userRole":"dev",
	"isActive":"true"
}

response: 201 CREATED
```
### user login
On login, API provides session id which needs to be passed with request header for all subsequent requests.
```sh
POST /login/{usrId} 
body: {"userPassword":"root"}
response: 
{
    "sessionId": "995eda70-bea9-4ae0-b1fb-721e30cd24d8",
    "userName": "subhadip"
}
```
This module also provides API for `logout`, `change password` 
###### partially implemented 
## Test
This module shows/adds/updates test name and cost
```sh
GET /tets
response: {
    test1{
        name: 'blood group',
        id: '001',
        cost: 150.00
    },
    test2{
        name: 'some test',
        id: '002',
        cost: 250.00
    }
}

GET /test/001
response:  {
    test1{
        name: 'blood group',
        id: '001',
        cost: 150.00
    }
}

POST /test/001
body: {
    name: 'Blood Group',
    cost: 100.00
}
response: 200 OK
```

## Doctor
This module provides API to show/add/update doctors name and details
```sh
GET /doctors
response: {
    doct1{
        name: 'Dr. Firstname Lastname',
        id: '001'
    },
    doct2{
        name: 'some doctor',
        id: '002'
    }
}

GET /doctor/001
response: {
    doct1{
        name: 'Dr. Firstname Lastname',
        id: '001'
    }
}
```

## Patient
API to create/read/update patient details
```sh
GET /patients
response: {
    patient1{
        name: 'Firstname Lastname',
        id: '001',
        address: 'some address'
    },
    patient2{
        name: 'some doctor',
        id: '002',
        address: 'some address'
    }
}
```

## Billing
API to create/read/update bills

