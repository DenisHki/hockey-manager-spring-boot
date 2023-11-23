# Hockey Manager Spring Boot

## Project Overview
The Hockey Manager Spring Boot project is a web application that enables users to manage a hockey team's roster. The application provides features for adding, editing, and deleting players, viewing player statistics, and searching for players by name. Additionally, the app includes authentication functionality, allowing users to sign up, log in, and access secure pages based on their roles.

## Technologies Used
- Spring Boot
- Thymeleaf (template engine)
- Spring Security
- MySQL 
- Bootstrap (CSS framework)

## Project Structure
The project is organized into several packages:

- `com.chuvakov.hockeymanager`: Contains the main configuration class `WebSecurityConfig` and `HockeyApplication`.
- `com.chuvakov.hockeymanager.domain`: Includes domain classes such as `AppUser`, `Player`, `Position`, `SignupForm.java` and repositories for database interactions.
- `com.chuvakov.hockeymanager.web`: Contains controllers (`PlayerController` and `UserController`) responsible for handling HTTP requests.

## How to Use

### Prerequisites
- Java Development Kit (JDK)
- Integrated Development Environment (IDE) like IntelliJ or Eclipse
- MySQL (or another relational database)

### Steps
1. Clone the repository:

   ```bash
   - git clone https://github.com/DenisHki/hockey-manager-spring-boot.git
   - cd hockey-manager-spring-boot
   
2. Set up your database:

   - Create a MySQL database.
   - Update the application.properties file in src/main/resources with your database configuration.
     
3. Run the application:

   - Open the project in your IDE.
   - Run the HockeyManagerApplication class.

4. Access the application:

   - Open a web browser and go to http://localhost:8080.

5. Explore the features:
   
   - Sign up for a user account and log in to access secure pages.
   - Navigate through different pages, such as the home page, player list, and top players.
   - Add, edit, or delete players from the roster.
   
## Screenshots
![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/signin.png) 

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/signup.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/home.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/playerlist.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/user_playerslist.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/addplayer.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/statistics.png)

## Contributors

   - DenisHki (@DenisHki)

## License

This project is licensed under the MIT License - see the LICENSE file for details.
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
