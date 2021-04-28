import java.util.ArrayList;
import java.util.HashMap;

public class TornamentWinner {
    //O(n) time where n is number of elements in results array
    //O(k) space where k is unique teams in competitions array

    public int HOME_TEAM_WON = 1;
    public int winnerPoints = 3;

    public String tournamentWinner( ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = "";
        HashMap<String, Integer> teamScores = new HashMap<String, Integer>();
        teamScores.put(currentBestTeam, 0);

        for(int idx = 0; idx < competitions.size(); idx++){
            ArrayList<String> competition = competitions.get(idx);
            int result = results.get(idx);

            var homeTeam = competition.get(0);
            var awayTeam = competition.get(1);

            var winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;

            updateScores(winningTeam, winnerPoints, teamScores);
            if(teamScores.get(winningTeam) > teamScores.get(currentBestTeam)) currentBestTeam = winningTeam;
        }
        return currentBestTeam;
    }

    public void updateScores(String team, int points, HashMap<String, Integer> scores){
        if (!scores.containsKey(team)) scores.put(team, 0);

        scores.put(team, scores.get(team) + points);

    }

}
