# Mini Calendly Java

The Java and Spring boot-based backend of the mini version of Calendly

[![Build Status](https://travis-ci.com/TheoOkafor/mini-calendly-java.svg?branch=development)](https://travis-ci.com/TheoOkafor/mini-calendly-java)
![Java CI](https://github.com/TheoOkafor/mini-calendly-java/workflows/Java%20CI/badge.svg?branch=development)
[![Maintainability](https://api.codeclimate.com/v1/badges/6025fa3faefe55654128/maintainability)](https://codeclimate.com/github/TheoOkafor/mini-calendly-java/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6025fa3faefe55654128/test_coverage)](https://codeclimate.com/github/TheoOkafor/mini-calendly-java/test_coverage)

## About
This backend has 3 models `user` (which I used to store the mentors' and users' information), `openings` (which I used to store the openings that the mentor has made available), and `bookings` (which I used to store the openings that the user booked).
#### API routes
1. POST http://localhost:8080/users - Create user
2. GET http://localhost:8080/users - Fetch all users
3. GET http://localhost:8080/users/{id} - Fetch user by id
4. POST http://localhost:8080/openings - Create an opening
5. GET http://localhost:8080/openings - Fetch all openings
6. GET http://localhost:8080/mentor/{mentorId}/openings - Fetch all openings belonging to a mentor
7. POST http://localhost:8080/bookings - book an opening
8. GET http://localhost:8080/bookings - Fetch all bookings
9. GET http://localhost:8080/user/{userId}/bookings - Fetch all bookings belonging to a user
10. GET http://localhost:8080/booking/{id} - Fetch booking by id


## Getting Started

Clone this [repo](https://github.com/TheoOkafor/mini-calendly-java.git)

```bash
git clone https://github.com/TheoOkafor/mini-calendly-java.git
```
#### Requirements
You need JDK 1.8+ and above to run this app. Start by installing it (if you do not have it installed already).
Maven 3.2+
I used IntelliJ IDE (You should consider using this too. it's awesome)

#### Environment
I used the following:

JPA - for connecting to my H2 database

H2 - An In-memory SQL database

Lombok - a cool tool that implements some needful boilerplate codes (like getters and setters) in the background

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
