package rework.relogo

enum Skill {
	INEXPERIENCED, MEDIUM, EXPERIENCED

	static Skill getRandom() {
		return values()[(int) (Math.random() * values().length)];
	}
}
