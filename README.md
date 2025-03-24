# Number-System-Converter

## About
This is a spring boot project that allows users to give in a number as input and convert it into any number system. It also has proper error handling for any wrong input. Users can convert to any one of the four formats - decimal, binary, octal, hexadecimal.

## How to use it
### Method 1: mvnw package command
* Clone the project
* Extract the project files and open it up
* Open command prompt and type the command `mvnw package` to convert the project into a jar file.
* Once the project is built, you'll see a jar file in target folder.
* To run the jar file, open command prompt in the target folder and write `java -jar <filename.jar>`.
* The project will start running. In your browser, go to `http://localhost:8080/` where you'll see the website.

### Method 2: Docker
* Clone the project
* Install docker in your machine
* In your pom.xml file, make changes to the java version according to java installed in your machine. Also in the Dockerfile, change it from openjdk:22 to your java version. Changing the port can also be done. I've selected 8080.
* Rest can be left as is.
* In the folder containing Dockerfile, open terminal and type the command `docker build -t your-app-name .`.
* Once the image is successfully created, youcan check existing images in docker by the command `docker images`.
* If you see the image with your app name, then write the following command `docker run -p 8080:8080 your-app-name`. Replace 8080:8080 with the port number you entered in the Dockerfile.
* The app should start running and you can access it on `http://localhost:portnumber/`.
  
