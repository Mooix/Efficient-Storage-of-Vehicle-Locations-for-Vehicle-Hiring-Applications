# Efficient Storage of Vehicle Locations for Vehicle Hiring Applications
This repository contains an implementation of a data structure for efficient storage of vehicle locations, which can be used in vehicle hiring applications. The implementation is written in Java.

## Background 
Vehicle hiring applications require the ability to quickly retrieve the location of available vehicles. This is typically done by querying a database that stores the location of all vehicles. However, as the number of vehicles in the system grows, the time it takes to query the database can become prohibitively long.
To address this issue, a data structure can be used to store the location of vehicles in a more efficient way. This repository provides an implementation of such a data structure.

## Implementation 
The data structure used in this implementation is a quadtree. A quadtree is a tree data structure in which each internal node has exactly four children, corresponding to the four quadrants of the Cartesian plane. The root node represents the entire plane, and each child of a node represents one of its quadrants.
Each leaf node in the quadtree represents a small region of the plane, and contains a list of vehicles whose locations fall within that region. When a query is made for the location of available vehicles, the quadtree is searched recursively to find all leaf nodes that intersect with the query region, and the lists of vehicles in those nodes are returned.
This implementation also includes a Main class for generating test data, and a PerformanceTest class for testing the performance of the data structure.

## Getting Started
To use this implementation, clone the repository and compile the Java code:
1. git clone https://github.com/Mooix/Efficient-Storage-of-Vehicle-Locations-for-Vehicle-Hiring-Applications.git
2. cd Efficient-Storage-of-Vehicle-Locations-for-Vehicle-Hiring-Applications
3. javac *.java

## Conclusion 
This implementation provides an efficient way to store and retrieve the location of vehicles in a vehicle hiring application. The quadtree data structure allows for fast queries, even as the number of vehicles in the system grows.
