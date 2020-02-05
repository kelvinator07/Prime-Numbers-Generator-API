# Prime Numbers Generator project using Spring API Assessment

## Setup Instructions

### This application uses Swagger UI and H2 database all configured for easy testing just open this URL `http://localhost:8080/swagger-ui.html` after running application to test end Points
    
Use this login details if you get a prompt... User: `kelvin` Password: `password`.


1. Clone this repository and open in your favourite IDE.


2. Open the `application.properties` file under the resources directory to see configurations.

    Note that the application uses H2 (Testing purposes)
    
3. Clean and install project using `mvnw clean install` command on your terminal 

4.  Run Application using `mvnw spring-boot:run` command on your terminal.
    
5. Open Swagger UI URL `http://localhost:8080/swagger-ui.html` to test end Points
    
    Use this login details if you get a prompt... User: `kelvin` Password: `password`.
    
    For H2 (Default in memory Database for testing)
    
    Now, once you get the Spring application running, you can navigate at the `http://localhost:8080/h2-console`.
    
    Click on PRIME and Run Query to see database contents

## API Endpoints

<table>
<tr><th>HTTP VERB</th><th>ENDPOINTS</th><th>DESCRIPTION</th></tr>
<tr><td>Home Controller</td></tr>
<tr><td>POST</td><td>/api/v1/prime</td><td>Creates user account</td></tr>
</table>