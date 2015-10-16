package impiegato.engine.tests.vocabolario;

import impiegato.engine.TestItem;

public class VocabolarioItem extends TestItem {

	private final String challenge;
	private final String answer;

	public VocabolarioItem(String challenge, String answer) {
		super();
		this.challenge = challenge;
		this.answer = answer;
	}

	@Override
	public String getChallenge() {
		return challenge + ": ";
	}

	@Override
	public String getCorrectAnswer() {
		return answer;
	}

	@Override
	public String getKey() {
		return challenge.replaceAll(" ", "_");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (challenge == null ? 0 : challenge.hashCode());
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
		VocabolarioItem other = (VocabolarioItem) obj;
		if (challenge == null) {
			if (other.challenge != null) {
				return false;
			}
		} else if (!challenge.equals(other.challenge)) {
			return false;
		}
		return true;
	}
}
