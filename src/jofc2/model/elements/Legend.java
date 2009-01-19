package jofc2.model.elements;

public class Legend {

	private String position;
	private boolean visible;
	private String bg_colour;
	private String border_color;
	private boolean shadow;
	private Integer margin;
	private Integer alpha;
	private Integer padding;
	private boolean border;
	private Integer stroke;

	/**
	 * Default constructor for Legend. Automatically sets visibility to true and
	 * position to right cause they are the only correct values at that time
	 */
	public Legend() {
		super();
		setVisible(true);
		setPosition("right");
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getBg_colour() {
		return bg_colour;
	}

	public void setBg_colour(String bg_colour) {
		this.bg_colour = bg_colour;
	}

	public String getBorder_color() {
		return border_color;
	}

	public void setBorder_color(String border_color) {
		this.border_color = border_color;
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}

	public Integer getMargin() {
		return margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}

	public Integer getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public Integer getPadding() {
		return padding;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public Integer getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}
}
