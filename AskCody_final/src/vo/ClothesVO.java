package vo;

import java.util.Date;

public class ClothesVO {

	int cloth_id;
	String cloth_name;
	String cloth_type;
	String cloth_color;
	Date save_date;
	String image;
	
	public ClothesVO() {}

	public ClothesVO(int cloth_id, String cloth_name, String cloth_type, String cloth_color, Date save_date,
			String image) {
		super();
		this.cloth_id = cloth_id;
		this.cloth_name = cloth_name;
		this.cloth_type = cloth_type;
		this.cloth_color = cloth_color;
		this.save_date = save_date;
		this.image = image;
	}

	public int getCloth_id() {
		return cloth_id;
	}

	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}

	public String getCloth_name() {
		return cloth_name;
	}

	public void setCloth_name(String cloth_name) {
		this.cloth_name = cloth_name;
	}

	public String getCloth_type() {
		return cloth_type;
	}

	public void setCloth_type(String cloth_type) {
		this.cloth_type = cloth_type;
	}

	public String getCloth_color() {
		return cloth_color;
	}

	public void setCloth_color(String cloth_color) {
		this.cloth_color = cloth_color;
	}

	public Date getSave_date() {
		return save_date;
	}

	public void setSave_date(Date save_date) {
		this.save_date = save_date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cloth_color == null) ? 0 : cloth_color.hashCode());
		result = prime * result + cloth_id;
		result = prime * result + ((cloth_name == null) ? 0 : cloth_name.hashCode());
		result = prime * result + ((cloth_type == null) ? 0 : cloth_type.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((save_date == null) ? 0 : save_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClothesVO other = (ClothesVO) obj;
		if (cloth_color == null) {
			if (other.cloth_color != null)
				return false;
		} else if (!cloth_color.equals(other.cloth_color))
			return false;
		if (cloth_id != other.cloth_id)
			return false;
		if (cloth_name == null) {
			if (other.cloth_name != null)
				return false;
		} else if (!cloth_name.equals(other.cloth_name))
			return false;
		if (cloth_type == null) {
			if (other.cloth_type != null)
				return false;
		} else if (!cloth_type.equals(other.cloth_type))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (save_date == null) {
			if (other.save_date != null)
				return false;
		} else if (!save_date.equals(other.save_date))
			return false;
		return true;
	}
	
}