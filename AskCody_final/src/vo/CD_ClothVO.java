package vo;

public class CD_ClothVO {
	int cdcloth_id;
	int coordi_id;
	String image;
	
	public CD_ClothVO() {}

	public CD_ClothVO(int cdcloth_id, int coordi_id, String image) {
		this.cdcloth_id = cdcloth_id;
		this.coordi_id = coordi_id;
		this.image = image;
	}

	public int getCdcloth_id() {
		return cdcloth_id;
	}

	public void setCdcloth_id(int cdcloth_id) {
		this.cdcloth_id = cdcloth_id;
	}

	public int getCoordi_id() {
		return coordi_id;
	}

	public void setCoordi_id(int coordi_id) {
		this.coordi_id = coordi_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CD_ClothVO [cdcloth_id=" + cdcloth_id + ", coordi_id=" + coordi_id + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdcloth_id;
		result = prime * result + coordi_id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		CD_ClothVO other = (CD_ClothVO) obj;
		if (cdcloth_id != other.cdcloth_id)
			return false;
		if (coordi_id != other.coordi_id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}
	
	
}
