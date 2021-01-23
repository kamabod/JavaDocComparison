

# A Threaded C. Distance Calculator for Text Documents


**This is a Java API which can rapidly compare a query file against a subject file by computing the c.distance between them.**



## Usage

To run the program successfully, there must a query file and subject file present.

This project uses five classes. The classes are as follows:

## Calculator

This class merges two sets to create a set of all keys. It also takes in query map and subject map, calculates the frequency of query file and subject file, their magnitudes, dot products and returns c. distance between the two files.

## FileHandler

This class takes in a file and reads its contents. The contents of a file is returned as a string.

## Runner

This class runs the application. It deals with threads and synchronizes their execution.

This class creates a primitive UI. It enables the user to enter query file and subject file path and to view c. distance between them.

## Parser

This class takes in a string with file contents, parses it into words, converts words into hash codes, builds a map with hashcodes and the frequency of their occurance.

## Task

This class implements Runnable interface. It allows the use of threads. Two threads are used to concurrently place contents of query file and subject file into relevant maps.


