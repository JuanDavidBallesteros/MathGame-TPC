package model;

public class User {
	
	
	public String type = "User";
	private String id;
	private int numProblem;
	
	private transient Game game;
	
	public User() {}
	
	public User(String id) {
		this.id = id;
		numProblem = 1;
	}
	
	public String getId() {
		return id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getStatus() {
		String status = Game.getNumProblems() + " x " + numProblem;
		return status;
	}	
	
	

}
