# Universal File Zipper

## Description

The goal is to create a program that reads all the folder paths written in a text file called "directorylist.txt" and recursively visits them to zip all the files within.

## Specifications

The program starts by defining a thread pool of 10 threads that will be shared and used across all processes of the program as needed, even for performing different tasks.
The file containing the paths is read and recursively visited by a thread.
Folders are then opened and scanned, operating recursively on subfolders, while other files are zipped using the JAVA GZip API through the thread pool.
The program stops when all files have been zipped.
