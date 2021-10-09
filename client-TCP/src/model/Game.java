package model;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    public String type = "Game";

    private User[] users;  
    private User winner;

    private boolean turnPlayer1;
    private boolean isFull;

    private Queue<Problem> problems;

    private static final int NUM_PROBLEMS = 5;

    public Game() {
        users = new User[2];
        turnPlayer1 = true;
        isFull = false;
        problems = new LinkedList<>();

        createProblems(NUM_PROBLEMS);
    }

    private void createProblems(int num){
        for (int i = 0; i < num; i++) {
            Problem p = new Problem();
            problems.add(p);
        }
    }

    public User[] getUsers() {
        return users;
    }
    public User getWinner() {
        return winner;
    }

    public boolean isTurnPlayer1() {
        return turnPlayer1;
    }

    public boolean isFull() {
        return isFull;
    }

    public Queue<Problem> getProblems() {
        return problems;
    }

    public static int getNumProblems() {
        return NUM_PROBLEMS;
    }

}
