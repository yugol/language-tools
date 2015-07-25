package impiegato.engine;

import java.util.Random;

public abstract class TestItem {

    public static double MAX_RELEVANCE = 100;
    protected static final Random RANDOMIZER = new Random();

    private int presentationCount;
    private int correctAnswerCount;

    public abstract String getChallenge();

    public abstract String getCorrectAnswer();

    public abstract String getKey();

    public int getPresentationCount() {
        return presentationCount;
    }

    public void setPresentationCount(int presentatioCount) {
        presentationCount = presentatioCount;
    }

    public void incPresentationCount() {
        ++presentationCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }

    public void incCorrectAnswerCount() {
        ++correctAnswerCount;
    }

    public double getRelevance() {
        if (presentationCount == 0) {
            return MAX_RELEVANCE;
        }
        if (presentationCount == 1) {
            return MAX_RELEVANCE / 2;
        }
        if (presentationCount == 2) {
            return MAX_RELEVANCE / 3;
        }
        if (presentationCount == 3) {
            return MAX_RELEVANCE / 4;
        }
        double relevance = (1. - correctAnswerCount / (double) presentationCount) * MAX_RELEVANCE;
        if (relevance < 1) {
            relevance = 1;
        }
        return relevance;
    }

    public int getScore(String response) {
        if (response != null) {
            response = response.trim();
            if (response.equalsIgnoreCase(getCorrectAnswer().trim())) {
                return 1;
            }
        }
        return 0;
    }

}
