package vo;

public class BD_ImgVO {
	int img_num;
	int post_id;
	String image;
	double width;
	double height;
	
	public BD_ImgVO() {}

	public BD_ImgVO(int img_num, int post_id, String image, double width, double height) {
		this.img_num = img_num;
		this.post_id = post_id;
		this.image = image;
		this.width = width;
		this.height = height;
	}

	public int getImg_num() {
		return img_num;
	}

	public void setImg_num(int img_num) {
		this.img_num = img_num;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "BD_ImgVO [img_num=" + img_num + ", post_id=" + post_id + ", image=" + image + ", width=" + width
				+ ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + img_num;
		result = prime * result + post_id;
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BD_ImgVO other = (BD_ImgVO) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (img_num != other.img_num)
			return false;
		if (post_id != other.post_id)
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}
}
