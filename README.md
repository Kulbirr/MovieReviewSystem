MovieReviewSystem
A Spring Boot-based application that allows users to review movies. It supports functionalities such as adding, updating, and retrieving movie reviews.

Features
Add movie reviews.
Update movie reviews.
List all reviews for a movie.

Technologies Used
Spring Boot - for building the backend API
JPA - for database interaction
MySQL Database - for storing movie and review data
Maven - for dependency management
RESTful API - for client-server communication
Postman - for testing the API endpoints
Requirements
Java 11 or higher
Maven 3.6 or higher
A database

Installation
Clone the repository:
bash
git clone https://github.com/Kulbirr/MovieReviewSystem.git
Navigate to the project directory:

cd MovieReviewSystem
Build the project using Maven:

mvn clean install
Run the application:

mvn spring-boot:run
By default, the application will be available at:


http://localhost:8080
API Endpoints
1. Add a Review
Method: POST

Endpoint: /review/add/{movieId}

Request Body:

json
{
  "reviewerName": "John Doe",
  "comment": "Great movie!",
  "rating": 5
}
Description: Adds a review for the movie with the given movieId.

2. Update a Review
Method: PUT

Endpoint: /review/update/{reviewId}

Request Body:

json
Copy
Edit
{
  "reviewerName": "Jane Doe",
  "comment": "An amazing movie with great visual effects.",
  "rating": 4.5
}
Description: Updates the review with the given reviewId.

Example Response
Adding a Review:
json
Copy
Edit
{
    "id": 1,
    "reviewerName": "John Doe",
    "comment": "Great movie!",
    "rating": 5,
    "movie": {
        "id": 1,
        "title": "Interstellar",
        "genre": "Sci-Fi",
        "releaseYear": 2014
    }
}
Fetching Reviews for a Movie:
json
Copy
Edit
{
    "id": 1,
    "title": "Interstellar",
    "genre": "Sci-Fi",
    "releaseYear": 2014,
    "reviews": [
        {
            "id": 1,
            "reviewerName": "John Doe",
            "comment": "Great movie!",
            "rating": 5
        },
        {
            "id": 2,
            "reviewerName": "Jane Doe",
            "comment": "Amazing visual effects!",
            "rating": 4.5
        }
    ]
}
