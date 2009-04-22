package jofc2.model;

import java.io.Serializable;

public abstract class AnimationPie implements Serializable {

	private static final long serialVersionUID = 1001959972688283807L;
	private String type;
	private Integer distance;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public static class Fade extends AnimationPie implements Serializable {
	
		private static final long serialVersionUID = -3878420396240140754L;

		public Fade() {
			setType("fade");
		}
	}

	public static class Bounce extends AnimationPie implements Serializable {

		private static final long serialVersionUID = -2951410274832180986L;

		public Bounce(Integer distance) {
			setType("bounce");
			setDistance(distance);
		}
	}
}
