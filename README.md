ROBOT apocalypse 

Welcome to the Robot Apocalypse Survival System, the last hope for humanity! In the year 2050, the world is overrun by robots, and your mission is to develop a REST API to manage survivors, resources, and information crucial for human survival.
Table of Contents
1.	Introduction
2.	Features
3.	Getting Started
4.	Prerequisites
5.	Installation
6.	API Endpoints
7.	Usage
8.	Reports
9.	Notes
10.	Contributing
Introduction
The Robot Apocalypse Survival System is a Spring Boot application that utilizes Maven and an H2 database for testing purposes. It provides a REST API for managing survivors, updating their locations, flagging them as infected, and retrieving essential information about the current state of the apocalypse.
Features
•	Register survivors with name, age, gender, ID, last location, and an inventory of resources.
•	Update survivor location with latitude and longitude.
•	Flag survivors as infected based on reports from other survivors.
•	Connect to the Robot CPU system to get a list of all robots and their known locations.
•	Retrieve reports on the percentage of infected and non-infected survivors, lists of infected and non-infected survivors, and a list of robots.
Getting Started
Prerequisites
Make sure you have the following installed on your machine:
•	Java Development Kit (JDK)
•	Maven
Installation
Clone the repository: 

git clone https://github.com/MolefeTechno/RobotApocalypse.git
	

API Endpoints

Endpoint: /survivors
HTTP Method: GET
Status: 200
Description: Get all the survivors.

Endpoint: /survivors
HTTP Method: POST
Status: 201
Description: Add survivors to the database 

Endpoint: /survivors/resource
HTTP Method: POST
Status: 201
Description: Add resources to a specific survivor

Endpoint: /survivors/{id}
HTTP Method: GET
Status: 200
Description: Get a survivor with a given survivor ID.

Endpoint: /survivor/{id}/check-infection
HTTP Method: GET
Status: 200
Description: Check survivor infection by an ID

Endpoint: /survivors/{id}/update-location
HTTP Method: PUT
Status: 200
Description: Update survivor location by survivor ID

Endpoint: /survivors/infection-reports
HTTP Method: GET
Status: 200
Description: Get all infection reports

Endpoint: /robots
HTTP Method: GET
Status: 200
Description: Connect to the Robot CPU system and retrieve all Robot data

Usage
Follow the Swagger documentation or make HTTP requests to the provided endpoints to interact with the system. No authentication is required.

Reports
•	Retrieve important reports to understand the current state of the apocalypse:
•	GET /survivors/infection-reports: Get the percentage of infected and non-infected survivors, lists of infected and non-infected survivors, and a list of robots.

Notes
•	This solution includes a minimal set of features described in the problem statement.
•	The application does not require authentication for simplicity.
•	Proper programming and architecture techniques are applied to ensure the system's robustness.

Contributing
Feel free to contribute by submitting issues or pull requests. Together, we can enhance the survival system for the betterment of humanity!

•	Please keep in mind that this is an in-memory database, once the application is shut down, all data will be lost. 
•	For quick POCO tests only.
