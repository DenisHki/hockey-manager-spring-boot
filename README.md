# Hockey Manager Spring Boot

## Project Overview
The Hockey Manager Spring Boot project is a web application that enables users to manage a hockey team's roster. The application provides features for adding, editing, and deleting players, viewing player statistics, and searching for players by name. Additionally, the app includes authentication functionality, allowing users to sign up, log in, and access secure pages based on their roles.

## Technologies Used
- Spring Boot
- Thymeleaf (template engine)
- Spring Security
- MySQL (or any other database of your choice)
- Bootstrap (CSS framework)

## Project Structure
The project is organized into several packages:

- `com.chuvakov.hockeymanager`: Contains the main configuration class `WebSecurityConfig`.
- `com.chuvakov.hockeymanager.domain`: Includes domain classes such as `AppUser`, `Player`, `Position`, and repositories for database interactions.
- `com.chuvakov.hockeymanager.web`: Contains controllers (`PlayerController` and `UserController`) responsible for handling HTTP requests.

## How to Use

### Prerequisites
- Java Development Kit (JDK)
- Integrated Development Environment (IDE) like IntelliJ or Eclipse
- MySQL (or another relational database)

### Steps
1. Clone the repository:

   ```bash
   git clone https://github.com/DenisHki/hockey-manager-spring-boot.git
   cd hockey-manager-spring-boot

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/signin.png) 

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/signup.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/home.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/playerlist.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/user_playerslist.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/addplayer.png)

![Project Logo](https://github.com/DenisHki/hockey-manager-spring-boot/blob/main/images_hm/statistics.png)




