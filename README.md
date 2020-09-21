# SE-Task

This is a Core banking system with SOAP service,integrator with REST APIs who consume the SOAP services and a Audit Log which recode all service calls with parameters.

## Installation

Clone the project and import/open from your IDE.
In the integrator, set your userName and password to MySQL in the Application.property file.
Core bank dummy will run on the port - 8080
integrator will run on the port - 8091
A sql dump file is included in the DB folder


## Usage
If you want to test SOAP services, request format for each endpoint is available inside resources package.
to access SOAP service -http://localhost:8080/soapWS
To access swagger - http://localhost:8091/swagger-ui.html

```

