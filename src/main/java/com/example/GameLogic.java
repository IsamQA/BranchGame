package com.example;

public class GameLogic {

    public String processChoice(String currentGameState, String choice) {
        // Default game state is intro if restart is chosen
        if ("restart".equals(choice) || currentGameState == null) {
            return "intro";
        }

        if (choice == null) {
            choice = ""; // default value if 'choice' is null
        }

        // Choice handle, better and more compact than if-else
        switch (choice) {
            case "pathA":
                return "pathA";

            case "GoodEndingA":
                return "GoodEndingA";

            case "BadEndingA":
                return "BadEndingA";

            case "pathB":
                return "pathB";

            case "continuePathBA":
                return "continuePathBA";

            case "NeutralEndingBAA":
                return "NeutralEndingBAA";

            case "BadEndingBAB":
                return "BadEndingBAB";

            case "continuePathBB":
                return "continuePathBB";

            case "GoodEndingBB":
                return "GoodEndingBB";

            case "restart":
                return "intro"; // Reset game state if restart is chosen
            default:
                // Return the current state if no valid choice is made
                return currentGameState;
        }
    }
}
