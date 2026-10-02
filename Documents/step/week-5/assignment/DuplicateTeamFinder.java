package assignment;
public class DuplicateTeamFinder {

    static String findDuplicateTeam(String[] teamNames) {
        // Outer loop selects current team
        for (int i = 0; i < teamNames.length; i++) {
            // Inner loop checks only team names that come after to prevent redundant checks
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams1)); // Duplicate Found: ByteForce

        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams2)); // No Duplicates Found
    }
}