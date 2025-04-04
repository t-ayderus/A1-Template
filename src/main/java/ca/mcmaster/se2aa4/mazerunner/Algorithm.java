/*
 * File:Algoritm.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: An Abstract class for algortihms
 */
package ca.mcmaster.se2aa4.mazerunner;

public interface Algorithm {
    public String findPath();

    public void addObserver(Observer observer);

    public void notifyObserver(Move move);
}