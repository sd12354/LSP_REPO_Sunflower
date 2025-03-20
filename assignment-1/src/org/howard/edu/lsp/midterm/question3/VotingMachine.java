package org.howard.edu.lsp.midterm.question3;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class VotingMachine {
	private Map<String, Integer> votes;
    /**
     * Constructor initializes the voting machine with an empty list of candidates.
     */
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the election
     * @param candidateName The name of the candidate.
     */
    public void addCandidate(String candidateName) {
        votes.putIfAbsent(candidateName, 0);
    }

    /**
     * Casts a vote for a given candidate.
     * @param candidateName The name of the candidate to vote for
     * @return true if the vote is successfully cast, false if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        return votes.computeIfPresent(candidateName, (key, value) -> value + 1) != null;
    }

    /**
     * Retrieves the name of the candidate with the most votes.
     * @return The name of the winning candidate.
     */
    public String getWinner() {
        return Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey() + 
               " WINS with " + Collections.max(votes.values()) + " votes!!";
    }
}
