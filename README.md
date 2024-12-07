## Java Springboot API Application

### How to use
1. Clone repo
2. Run the database.sql (using mysql)
3. Set port in the application setting (default 8080)
4. Run the app

### Endpoints
#### Movies
GET    /api/movies          => Get All Movies
POST   /api/movies          => Create Movie
GET    /api/movies/{id}     => Get Movie By Id
PUT    /api/movies/{id}     => Update Movie By Id
DELETE  /api/movies/{id}    => Delete Movie By Id

#### Genres
GET    /api/genres          => Get All Genres
POST   /api/genres          => Create Genres
GET    /api/genres/{id}     => Get Genres By Id
PUT    /api/genres/{id}     => Update Genres By Id
DELETE  /api/genres/{id}    => Delete Genres By Id
