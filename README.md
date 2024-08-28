# Anagram Application

This is a Spring Boot application designed to determine if two strings are anagrams of each other and to find all anagrams from a list of candidate words.

## Features

- **Check if two strings are anagrams**
- **Find all anagrams of a given string from a list of candidates**

## Technologies Used

- **Java 21**
- **Spring Boot 3.3.3**
- **Maven**

## Project Structure

- `src/main/java/com/wordplay/anagram/api/AnagramService.java`: Contains the core logic to check and find anagrams.
- `src/main/java/com/wordplay/anagram/api/AnagramController.java`: Exposes REST endpoints to interact with the anagram logic.
- `src/main/resources/static/index.html`: A simple frontend to interact with the REST API.
- `src/main/resources/application.properties`: Configuration for the Spring Boot application.

## Getting Started

### Prerequisites

- **Java 21 or higher**
- **Maven**

### Running the Application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ArminFB040/anagram.git
   cd anagram

2. **Build with maven**

   ```bash
   cd anagramBackend
   ./mvnw package
   
  This will create a JAR file in the target directory.
  
3. **Run the application**
    ```bash
    cd anagramBackend/target
    java -jar target/anagram-0.0.1-SNAPSHOT.jar
    
# Accessing the Frontend

Once the application is running, you can access the frontend by navigating to http://localhost:8080 in your web browser.

## Using the API
### Check Anagrams
```bash
Endpoint: /api/anagram/check
Method: POST
Parameters:
text1 (String): The first string to compare.
text2 (String): The second string to compare.
```

### Example Request
```bash
POST /api/anagram/check?text1=listen&text2=silent
Response:
true
```
### Find All Anagrams
```bash
Endpoint: /api/anagram/findAll
Method: POST
Parameters:
text (String): The base string to find anagrams for.
Request Body: A list of candidate strings.
```
### Example Request:
```bash
POST /api/anagram/findAll?text=listen
Content-Type: application/json
["enlist", "google", "inlets", "banana", "silent"]
Response:
["enlist", "inlets", "silent"]
```
## Running Tests
To run the tests for this application, use the following Maven command:
```bash
./mvnw test
```
## Contact
If you have any questions or need further assistance, please feel free to contact me.
