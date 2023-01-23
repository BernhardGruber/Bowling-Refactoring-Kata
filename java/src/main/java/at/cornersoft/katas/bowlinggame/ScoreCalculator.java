package at.cornersoft.katas.bowlinggame;

public class ScoreCalculator {
    public int calculate(String scoreCard) {
        return calculatePosition(scoreCard, 0, 0);
    }

    public int calculatePosition(String scoreCard, int currentPosition, int currentSum) {
        long xCount = scoreCard.chars().filter(ch -> ch == 'X').count();
        if (scoreCard.endsWith("X")) {
            xCount -= 1;
        }
        if (xCount > 10) {
            xCount = 10;
        }
        long frameCount = currentPosition + xCount;
        if (scoreCard.length() == currentPosition || frameCount == 20) {
            return currentSum;
        }

        if (scoreCard.charAt(currentPosition) == '-') {
            return calculatePosition(scoreCard, currentPosition + 1, currentSum);
        } else if (scoreCard.charAt(currentPosition) == '/') {
            currentSum += 10;
            if (currentPosition < scoreCard.length() - 1) {
                if (scoreCard.charAt(currentPosition + 1) == '/' || scoreCard.charAt(currentPosition + 1) == 'X') {
                    currentSum += 10;
                } else {
                    currentSum += Integer.parseInt("" + scoreCard.charAt(currentPosition + 1));
                }
            }
            return calculatePosition(scoreCard, currentPosition + 1, currentSum);
        } else if (scoreCard.charAt(currentPosition) == 'X') {
            currentSum += 10;
            if (currentPosition < scoreCard.length() - 1) {
                currentSum += ((scoreCard.charAt(currentPosition + 1) == '/' || scoreCard.charAt(currentPosition + 1) == 'X')) ? 10 : Integer.parseInt("" + scoreCard.charAt(currentPosition + 1));
            }
            if (currentPosition < scoreCard.length() - 2) {
                currentSum += ((scoreCard.charAt(currentPosition + 2) == '/' || scoreCard.charAt(currentPosition + 2) == 'X')) ? 10 : Integer.parseInt("" + scoreCard.charAt(currentPosition + 2));
            }
            return calculatePosition(scoreCard, currentPosition+1, currentSum);
        } else {
            try {
                currentSum += Integer.parseInt("" + scoreCard.charAt(currentPosition));
                return calculatePosition(scoreCard, currentPosition+1, currentSum);
            } catch (Exception ignore) {
                //we do not check for errors in scorecard
                return currentSum;
            }
        }
    }
}
