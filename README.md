# Airport management
 
Managing an airport using the Java programming language (This project is part of the course "Aprende Programación en Java (de Básico a Avanzado)" available on Udemy (https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/), made by Programación ATS)

**En memoria de _Alejandro Miguel Taboada Sanchez_ (creador del canal de YouTube Programación ATS), gracias por cada curso, cada clase y todos esos conocimientos aportados, la forma en que dabas tus clases permitía (y sigue permitiendo) entender la programación de manera más fácil**
 
### Previous requirements
To run this project you only need to have the IDE of your choice installed to develop in Java language.
 
### Introduction
* Goal: The objective of this project is to apply different knowledge such as structured programming, object-oriented programming and data structure through the Java language and try to translate them into a real life example.

### Design and coding requirements for this software
* For each airport it is necessary to know:
    1. All the flight companies that operate in it.
    2. Name of the airport, the city where it is located and the country to which it belongs.
* Each company is characterized by its name and the list of flights it offers.
* Flights are defined by their identifier, the city of origin, the city of destination, the price of the trip, the list of passengers, the maximum number of passengers allowed on the flight and the actual number of passengers who have reserved a seat on the flight. plane.
* Airports can be private or public.
    1. Private airports have a number of companies that sponsor them and it is necessary to know the name of each of those companies.
    2. For public airports it is required to know the amount of money corresponding to the government subsidy.
* You also need to manage passenger information.
    1. For each passenger you need to know name, passport number and nationality.

The application will have a menu with the following options:
1. Consult the managed airports, indicating separately the public and private airports. For each of them you must show your name, the city of location, and the country to which it belongs.
2. Visualize the companies that sponsor a certain airport in the case that it is private, or the amount of the subsidy in the case that it is a public airport.
3. For a certain airport, it should be possible to show the list of companies that fly from that airport.
4. For a certain company that operates in a specific airport, list all the possible flights that said company offers, showing its identifier, the city of origin and destination, and the price of the flight.
5. Show all the possible flights (identifier) that depart from an origin city to another destination city (indicated by the user) and show their price.

***

2022 [Samuel Ramirez](https://github.com/Samvel24/)