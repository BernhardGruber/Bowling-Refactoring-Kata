export class ScoreCalculator {

  public calculate(scoreCard: string): number {
    return this.calculatePosition(scoreCard, 0, 0);
  }

  public calculatePosition(scoreCard: string, currentPosition: number, currentSum: number): number {
    let xCount: number = 0
    for (let i = 0; i < scoreCard.length; i++) {
      if (scoreCard.charAt(i) === 'X') {
        xCount += 1;
      }
    }
    if (scoreCard.endsWith("X")) {
        xCount -= 1;
    }
    if (xCount > 10) {
        xCount = 10;
    }
    let frameCount: number = currentPosition + xCount;
    if (scoreCard.length == currentPosition || frameCount == 20) {
        return currentSum;
    }

    if (scoreCard.charAt(currentPosition) === '-') {
      return this.calculatePosition(scoreCard, currentPosition+1, currentSum);
    } else if (scoreCard.charAt(currentPosition) == '/') {
      currentSum += 10
      if (currentPosition < scoreCard.length - 1) {

        if (scoreCard.charAt(currentPosition + 1) == '/' || scoreCard.charAt(currentPosition + 1) == 'X') {
          currentSum += 10
        } else {
          currentSum += parseInt("" + scoreCard.charAt(currentPosition + 1));
        }
        return this.calculatePosition(scoreCard, currentPosition + 1, currentSum);

      }

    } else if (scoreCard.charAt(currentPosition) == 'X') {
      currentSum += 10;
      if (currentPosition < scoreCard.length - 1) {
          currentSum += ((scoreCard.charAt(currentPosition + 1) == '/' || scoreCard.charAt(currentPosition + 1) == 'X')) ? 10 : parseInt("" + scoreCard.charAt(currentPosition + 1));
      }
      if (currentPosition < scoreCard.length - 2) {
          currentSum += ((scoreCard.charAt(currentPosition + 2) == '/' || scoreCard.charAt(currentPosition + 2) == 'X')) ? 10 : parseInt("" + scoreCard.charAt(currentPosition + 2));
      }
      return this.calculatePosition(scoreCard, currentPosition+1, currentSum);
    } else {
      try {
          currentSum += parseInt("" + scoreCard.charAt(currentPosition));
          return this.calculatePosition(scoreCard, currentPosition+1, currentSum);
      } catch (Exception) {
          //we do not check for errors in scorecard
          return currentSum;
      }
    }
    return 0;
  }

}