package mbti;

import java.util.Scanner;

public class MBTIPersonalityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer the following questions with 'A' or 'B':");
        char[] answers = new char[20]; // Store the user's answers in an array

        // Define the questions
        String[] questions = {
                "1) A. Expend energy, enjoy groups.			 B. Conserve energy, one-on-one",
                "2) A. Interpret literally. 			 B. Look for meaning and possibilities",
                "3) A. Logical, thinking, questioning. 			 B. Empathetic, feeling, accommodating",
                "4) A. Organized, orderly. 			 B. Flexible, adaptable",
                "5) A. More outgoing, think out loud. 			 B. More reserved, think to yourself.",
                "6) A. Practical, realistic, experiential. 			 B. Imagination, innovative, theoretical.",
                "7) A. Candid, straight forward, frank. 			 B. Tactful, kind, encouraging.",
                "8) A. Plan, schedule. 			 B. Unplanned, spontaneous",
                "9) A. seek many tasks, public activities, interaction with others 			 B. seek private, solitary activities with quiet to concentrate.",
                "10) A. standard, usual, conventional. 			 B. different, novel, unique.",
                "11) A. firm, tend to criticize, hold the line. 			 B. gentle, tend to appreciate, conciliate.",
                "12) A.regulated, structured. 			 B. easygoing, live  and let live",
                "13) A. external, communicative, express yourself. 			 B. internal, reticent, keep to yourself.",
                "14) A. focus on here-and-now. 			 B. look to the future, global perspective, big picture",
                "15) A. tough minded, just. 			 B. tender-hearted, merciful",
                "16) A. preparation, plan ahead. 			 B. go with the flow, adapt as you go.",
                "17) A. active, initiate.       B. reflective, deliberate",
                "18) A. facts, things, what is			 B. ideas, dreams, 'what could be', philosophical",
                "19) A. matter of fact, issue oriented 			 B. sensitive, people-oriented, compassionate",
                "20) A. control, govern 			 B. latitude, freedom",
        };

        // Loop to get user's answers for each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            char answer = scanner.next().toUpperCase().charAt(0);

            // Validate the user's input (A or B)
            while (answer != 'A' && answer != 'B') {
                System.out.println("Invalid input. Answer with 'A' or 'B':");
                answer = scanner.next().toUpperCase().charAt(0);
            }

            // Store the answer in the answers array
            answers[i] = answer;
        }

        scanner.close();

        // Calculate scores based on the answers
        int[] scores = calculateScores(answers);

        // Determine MBTI type based on the scores
        String mbtiType = determineMBTIType(scores);
        System.out.println("Your MBTI personality type is: " + mbtiType);
    }

    public static int[] calculateScores(char[] answers) {
        // Initialize scores for each category
        int[] scores = new int[8];

        for (int i = 0; i < answers.length; i++) {
            switch (i % 20) {
                case 0 -> {
                    scores[0] += (answers[i] == 'A') ? 1 : 0; // Extraversion
                    scores[1] += (answers[i] == 'B') ? 1 : 0; // Introversion
                }
                case 1 -> {
                    scores[2] += (answers[i] == 'A') ? 1 : 0; // Sensing
                    scores[3] += (answers[i] == 'B') ? 1 : 0; // Intuition
                }
                case 2 -> {
                    scores[4] += (answers[i] == 'A') ? 1 : 0; // Thinking
                    scores[5] += (answers[i] == 'B') ? 1 : 0; // Feeling
                }
                case 3 -> {
                    scores[6] += (answers[i] == 'A') ? 1 : 0; // Judging
                    scores[7] += (answers[i] == 'B') ? 1 : 0; // Perceiving
                }
            }
        }

        return scores;
    }

    public static String determineMBTIType(int[] scores) {

        String mbtiType = ((scores[0] > scores[1]) ? "E" : "I") + // Extraversion vs. Introversion
                ((scores[2] > scores[3]) ? "S" : "N") + // Sensing vs. Intuition
                ((scores[4] > scores[5]) ? "T" : "F") + // Thinking vs. Feeling
                ((scores[6] > scores[7]) ? "J" : "P"); // Judging vs. Perceiving

        return mbtiType;
    }
}

