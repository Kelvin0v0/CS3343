package CS3343.game;

public class SicBo implements Game {
        private String choice;
        private int money;

        // Display the Sic Bo board
        @Override
        public void intro() {
                System.out.println(
                                "------------------------------------------------------------------------------------------");
                System.out.println("| Odd:       | Selection: \t\t\t\t\t\t\t\t |");
                System.out.println(
                                "| ---------------------------------------------------------------------------------------|");
                System.out.println("| 1 wins 1   | Big(No. 4-10) , Small(No. 11 to 17), One dice\t\t\t\t |");
                System.out.println("| 1 dice 2   | One two dice\t\t\t\t\t\t\t\t |");
                System.out.println("| 1 wins 3   | One three dice\t\t\t\t\t\t\t\t |");
                System.out.println(
                                "| 1 wins 6   | 1&2, 1&3, 1&4, 1&5, 1&6, 2&3, 2&4, 2&5, 2&6, 3&4, 3&5, 3&6, 4&5, 4&6, 5&6 |");
                System.out.println(
                                "|            |  9 ,  10,  11,  12,                                                       |");
                System.out.println("| 1 wins 11  | Double1, Double2, Double3, Double4, Double5, Double6\t\t\t |");
                System.out.println(
                                "| 1 wins 12  |  7 ,  14                                                                  |");
                System.out.println(
                                "| 1 wins 18  |  6 ,  15                                                                  |");
                System.out.println(
                                "| 1 wins 20  |  5 ,  16                                                                  |");
                System.out.println("| 1 wins 30  | Triple for all\t\t\t\t\t\t\t\t |");
                System.out.println(
                                "| 1 wins 60  |  4 ,  17                                                                  |");
                System.out.println("| 1 wins 180 | Triple1, Triple2, Triple3, Triple4, Triple5, Triple6\t\t\t |");
                System.out.println(
                                "------------------------------------------------------------------------------------------");

        }

        // Give user input
        @Override
        public void gamePlay() {
                SicBoInput input = SicBoInput.getInput();
                this.choice = input.getChoice();
                this.money = input.getMoney();
                
                //check result
                this.result();
        }

        // Check the result and return it
     
        public void result() {
                int[] pattern = this.shakeDice();
                //int[] pattern = { 6, 6, 6 };
                System.out.println("===Dices Open===");
                System.out.println(" " + pattern[0] + " " + pattern[1] + " " + pattern[2] + " ");
                if (checkSelect(choice)) {
                        if (checkChoice(this.choice, pattern)) {
                                System.out.print("You won the bet!! ");
                                System.out.println("You earn: " + reward(choice, this.money));
                        } else {
                                System.out.println("You Lose this time :( ");
                        }
                } else {
                        System.out.println("Please input a correct choice");
                }

        }

        // Calcuate how much user earned
        private int reward(String choice, int result) {
                if (choice.equals("9") || choice.equals("10") || choice.equals("11") || choice.equals("12")
                                || choice.contains("&")) {
                        result = result + result * 6;
                } else if (choice.equals("7") || choice.equals("14")) {
                        result = result + result * 12;
                } else if (choice.equals("6") || choice.equals("15")) {
                        result = result + result * 18;
                } else if (choice.equals("5") || choice.equals("16")) {
                        result = result + result * 20;
                } else if (choice.equals("4") || choice.equals("17")) {
                        result = result + result * 60;
                } else if (choice.equals("Big") || choice.equals("Small")) {
                        result = result + result;
                } else if (choice.equals("Double")) {
                        result = result + result * 11;
                } else if (choice.equals("Triple for all")) {
                        result = result + result * 30;
                } else if (choice.equals("Triple1") || choice.equals("Triple2") || choice.equals("Triple3")
                                || choice.equals("Triple4") || choice.equals("Triple5") || choice.equals("Triple6")) {
                        result = result + result * 180;
                } else if (choice.equals("One dice 1") || choice.equals("One dice 2") || choice.equals("One dice 3")
                                || choice.equals("One dice 4") || choice.equals("One dice 5")
                                || choice.equals("One dice 6")) {
                        result = result + result;
                } else if (choice.equals("One two dice 1") || choice.equals("One two dice 2")
                                || choice.equals("One two dice 3") || choice.equals("One two dice 4")
                                || choice.equals("One two dice 5") || choice.equals("One two dice 6")) {
                        result = result + result * 2;
                } else if (choice.equals("One three dice 1") || choice.equals("One three dice 2")
                                || choice.equals("One three dice 3") || choice.equals("One three dice 4")
                                || choice.equals("One three dice 5") || choice.equals("One three dice 6")) {
                        result = result + result * 3;
                }
                return result;
        }

        // check choice weather exist
        private boolean checkSelect(String choice) {
                String[] options = { "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                                "1&2", "1&3", "1&4", "1&5", "1&6", "2&3", "2&4", "2&5", "2&6", "3&4", "3&5", "3&6",
                                "4&5", "4&6", "5&6", "Big", "Small", "Double1", "Double2", "Double3", "Double4",
                                "Double5", "Double6", "Triple for all", "Triple1", "Triple2", "Triple3", "Triple4",
                                "Triple5", "Triple6", "One dice 1", "One dice 2", "One dice 3", "One dice 4",
                                "One dice 5", "One dice 6", "One two dice 1", "One two dice 2", "One two dice 3",
                                "One two dice 4", "One two dice 5", "One two dice 6", "One three dice 1",
                                "One three dice 2", "One three dice 3", "One three dice 4", "One three dice 5",
                                "One three dice 6" };
                for (int i = 0; i < options.length; i++) {
                        if (options[i].equals(choice)) {
                                return true;
                        }
                }

                return false;
        }

        // check user selection whether correct
        private boolean checkChoice(String choice, int[] dices) {

                if (choice.length() <= 2 && !choice.contains("&")) {
                        this.checkNumber(choice, dices);
                } else if (choice.contains("&")) {
                        return this.checkPair(choice, dices);
                } else if (choice.equals("Big") || choice.equals("Small")) {
                        return this.checkBigSmall(choice, dices);
                } else if (choice.contains("Double")) {
                        return this.checkDouble(choice, dices);
                } else if (choice.contains("Triple")) {
                        return this.checkTriple(choice, dices);
                } else if (choice.contains("One dice") || choice.contains("One two") || choice.contains("One three")) {
                        return this.checkSingleDice(choice, dices);
                }
                return false;
        }

        // check Rule
        public boolean checkNumber(String choice, int[] dices) {
                int sum = 0;

                for (int i = 0; i < dices.length; i++) {
                        sum += dices[i];
                }
                if (sum == Integer.parseInt(choice)) {
                        return true;
                }
                return false;
        }

        public boolean checkPair(String choice, int[] dices) {
                int count = 0;
                for (int i = 0; i < dices.length; i++) {
                        if (choice.contains(Integer.toString(dices[i]))) {
                                count++;
                        }
                }
                if (count >= 2) {
                        return true;
                } else
                        return false;
        }

        public boolean checkBigSmall(String choice, int[] dices) {
                int sum = 0;

                for (int i = 0; i < dices.length; i++) {
                        sum += dices[i];
                }
                if (!(dices[0] == dices[1] && dices[1] == dices[2])) {
                        if (choice.equals("Small")) {
                                return (sum >= 4 && sum <= 10);
                        } else if (choice.equals("Big")) {
                                return (sum >= 11 && sum <= 17);
                        }
                }

                return false;
        }

        public boolean checkDouble(String choice, int[] dices) {
                int num = Character.getNumericValue(choice.charAt(6));
                int count = 0;

                for (int i = 0; i < dices.length; i++) {
                        if (dices[i] == num) {
                                count++;
                        }
                }
                if (count > 2) {
                        return true;
                }
                return false;
        }

        public boolean checkTriple(String choice, int[] dices) {

                if (choice.equals("Triple for all")) {
                        return (dices[0] == dices[1] && dices[1] == dices[2]);
                } else {
                        int num = Character.getNumericValue(choice.charAt(6));
                        return (dices[0] == num && dices[1] == num && dices[2] == num);
                }

        }

        public boolean checkSingleDice(String choice, int[] dices) {
                if (choice.contains("One dice")) {
                        int num = Character.getNumericValue(choice.charAt(9));
                        return (dices[0] == num || dices[1] == num || dices[2] == num);
                } else if (choice.contains("One two")) {
                        int num = Character.getNumericValue(choice.charAt(13));
                        return (dices[0] == dices[1] || dices[1] == dices[2]);
                } else if (choice.contains("One three")) {
                        int num = Character.getNumericValue(choice.charAt(15));
                        return (dices[0] == num && dices[1] == num && dices[2] == num);
                }

                return false;
        }

        // shack dice
        public int[] shakeDice() {
                int dice1 = (int) (Math.random() * 6 + 1);
                int dice2 = (int) (Math.random() * 6 + 1);
                int dice3 = (int) (Math.random() * 6 + 1);
                int[] pattern = { dice1, dice2, dice3 };

                return pattern;
        }

}