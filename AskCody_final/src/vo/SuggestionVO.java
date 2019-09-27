package vo;

import java.util.Date;

public class SuggestionVO {
	int cloth_id;
	Date save_date;
	String image;
	
	public SuggestionVO() {}
	public SuggestionVO(int cloth_id, Date save_date, String image) {
		this.cloth_id = cloth_id;
		this.save_date = save_date;
		this.image = image;
	}
	public int getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
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
	public String toString() {
		return "SuggestionVO [cloth_id=" + cloth_id + ", save_date=" + save_date + ", image=" + image + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cloth_id;
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
		SuggestionVO other = (SuggestionVO) obj;
		if (cloth_id != other.cloth_id)
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
