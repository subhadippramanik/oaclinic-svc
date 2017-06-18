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
        "active": true,
        "templatePath": null
    },
    {
        "id": 2,
        "fullName": "Subhadip Pramanik",
        "userName": "subhadip",
        "userPassword": "root",
        "userRole": "dev",
        "active": true,
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
	"active": true
}

response: 201 CREATED
```
### user login
On login, API provides session id which needs to be passed with request header for all subsequent requests.
```sh
POST /login/{usrName} 
body: {"userPassword":<some_password>}
response: 
{
    "sessionId": "995eda70-bea9-4ae0-b1fb-721e30cd24d8",
    "userName": "subhadip"
}
```
### user logout
```sh
POST /logout/{usrName}
header:
"session-id":<generated_session-id>
```

This module also provides API for `change password` 

## Test
This module shows/adds/updates test name and cost
### get all tests
```sh
GET /tets
response: 
[
    {
        "id": 1,
        "testName": "blood group",
        "testType": "blood",
        "testCost": 100
    },
    {
        "id": 2,
        "testName": "blood sugar",
        "testType": "blood",
        "testCost": 350
    }
]
```
### get test by id
```sh
GET /test/id/1
response:  
{
    "id": 1,
    "testName": "blood group",
    "testType": "blood",
    "testCost": 100
}
```
### add test
```sh
POST /test
body:
{
	"testName":"blood group",
	"testType":"blood",
	"testCost":100
}
response: 201 CREATED
```
### update all properties of a test by id
```sh
POST /test/id/1
body: 
{    
    "testName": "Blood Group",
    "testType": "blood",
    "testCost": 150
}
response: 200 OK
```
### update property(not all) of a test by id
```sh
POST /test/id/1
body: 
{
    "testCost": 135
}
response: 200 OK
```

## Doctor
This module provides API to show/add/update doctors name and details
### get all doctors
```sh
GET /doctors
response: 
[
    {
        id: 1,
        name: 'Dr. Firstname Lastname'        
    },
    {
        id: 2,
        name: 'some doctor'
    }
]
```
### get doctor by id
```sh
GET /doctor/id/1
response: 
{
        id: 1,
        name: 'Dr. Firstname Lastname'        
}
```
### add doctor
```sh
POST /doctor
body: 
{
    name: 'Dr. Firstname Lastname'
}
response: 201 CREATED
```
## Patient
API to create/read/update patient details
```sh
GET /patients
response: 
[
    {
        id: 1,
        name: 'Firstname Lastname',
        address: 'some address'
    },
    {
        id: 2,
        name: 'some patient',        
        address: 'some address'
    }
]
```

## Billing
API to create/read/update bills

