# Hospital
Assignment Works
I recommended to use IDE (IntelliJ IDEA) to run this project.
before running the project you need to create the database in mysql 
**DataBase name:- hospital**


**Use Postman to test the project**
**For SignUP--->**
select POST and put the url:- http://localhost:8080/staff/signup
go to body-->raw--->select JSON and put JSON object into body
example of json object:-> 
{
  "username": "staff1",
  "password": "password123"
}
and click send you will also get status code 201 Created and in response you will get Signed up successfully!
check database the details has been saved on database..

For SignIn--->
select POST and put the url:- http://localhost:8080/staff/login
go to body-->raw--->select JSON and put JSON object into body
example of json object:-> 
{
  "username": "staff1",
  "password": "password123"
}
and click send
you will also get response **Login successful!**

**To save the Patient details:-**
Select POST and put the url:- http://localhost:8080/patients/add
go to body-->raw--->select JSON and put JSON object into body
example of json object:-> 
{
  "name": "Rocky",
  "age": 33,
  "room": "A103",
  "doctorName": "Dr. Jhon",
  "admitDate": "2023-07-09",
  "expenses": 3500.00,
  "status": "admitted"
}
and click send 
you will also get response **Patient admitted successfully!**

**To get all admitted Patient details:-**
Select GET and put the url:- http://localhost:8080/patients/getAll
and click send 
you will get all patient details weather patient is admitted or descharged.

**To  update the status of patient :-**
Select DELETE and put the url:- http://localhost:8080/patients/{patientId}
url example :- http://localhost:8080/patients/2
and click send
you will also get response **Patient discharged successfully!**


