package impiegato.engine.tests.espressioni;

import impiegato.engine.TestItem;
import impiegato.engine.tests.nomi.NomeItem;
import impiegato.util.StringUtil;

public class EspressioneItem extends TestItem {

    private static final String LEFT_MARKER_PATTERN = "\\[";
    private static final String SEPARATOR_PATTERN = "\\|";
    private static final String RIGHT_MARKER_PATTERN = "]";

    private final String template;
    private String correctAnswer;

    public EspressioneItem(String template) {
        super();
        this.template = template.trim();
    }

    @Override
    public String getChallenge() {
        String left = "", hotSpot = null, right = "";
        boolean capitalizeFocus = false;

        // parse template
        int rightIndex = 0;
        String[] leftChunks = template.split(LEFT_MARKER_PATTERN);
        if (leftChunks.length == 1) {
            capitalizeFocus = true;
        } else {
            left = leftChunks[0];
            rightIndex = 1;
        }
        String[] rightChunks = leftChunks[rightIndex].split(RIGHT_MARKER_PATTERN);
        hotSpot = rightChunks[0].trim().toLowerCase();
        if (rightChunks.length > 1) {
            right = rightChunks[1];
        }

        // generate challenge and answer
        String[] predefinedAnswers = hotSpot.split(SEPARATOR_PATTERN);
        if (predefinedAnswers.length == 1) {
            return buildSingleChoiceChalenge(left, predefinedAnswers[0], right);
        }
        return buildMultipleChoiceChalenge(left, predefinedAnswers, right, capitalizeFocus);
    }

    private String buildSingleChoiceChalenge(String left, String answer, String right) {
        correctAnswer = answer;
        StringBuilder challenge = new StringBuilder();
        challenge.append(left).append("[...]").append(right);
        challenge.append(" : ");
        return challenge.toString();
    }

    private String buildMultipleChoiceChalenge(String left, String[] answers, String right, boolean capitalizeFocus) {
        String[] variants = new String[answers.length];
        for (int i = 0; i < variants.length; ++i) {
            variants[i] = answers[i].trim().toLowerCase();
            if (capitalizeFocus) {
                variants[i] = StringUtil.capitalizeFirst(variants[i]);
            }
        }
        String theAnswer = variants[0];
        for (int i = 0; i < 100; ++i) {
            int firstIdx = RANDOMIZER.nextInt(variants.length);
            int secondIdx = RANDOMIZER.nextInt(variants.length);
            if (firstIdx != secondIdx) {
                String foo = variants[firstIdx];
                variants[firstIdx] = variants[secondIdx];
                variants[secondIdx] = foo;
            }
        }
        for (int i = 0; i < variants.length; ++i) {
            String answer = variants[i];
            if (theAnswer.equals(answer)) {
                correctAnswer = String.valueOf(i + 1);
            }
            variants[i] = left.trim() + " _" + answer + " " + right.trim();
        }
        StringBuilder challenge = new StringBuilder();
        for (int i = 0; i < variants.length; ++i) {
            challenge.append(i + 1).append(". ").append(variants[i]).append("\n");
        }
        challenge.append("    Type answer index [ 1 - ").append(variants.length).append(" ]: ");
        return challenge.toString();
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String getKey() {
        StringBuilder key = new StringBuilder(NomeItem.class.getSimpleName());
        key.append(".").append(template);
        return String.valueOf(key.toString().hashCode());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (template == null ? 0 : template.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EspressioneItem other = (EspressioneItem) obj;
        if (template == null) {
            if (other.template != null) {
                return false;
            }
        } else if (!template.equals(other.template)) {
            return false;
        }
        return true;
    }
}
