package vo;

import java.sql.Date;

public class CoordiVO {
	int coordi_id;
	String coordi_name;
	String user_id;
	Date coordi_date;
	
	
	public CoordiVO() {}

	public CoordiVO(int coordi_id, String coordi_name, String user_id, Date coordi_date) {
		this.coordi_id = coordi_id;
		this.coordi_name = coordi_name;
		this.user_id = user_id;
		this.coordi_date = coordi_date;
	}

	public int getCoordi_id() {
		return coordi_id;
	}

	public void setCoordi_id(int coordi_id) {
		this.coordi_id = coordi_id;
	}

	public String getCoordi_name() {
		return coordi_name;
	}

	public void setCoordi_name(String coordi_name) {
		this.coordi_name = coordi_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getCoordi_date() {
		return coordi_date;
	}

	public void setCoordi_date(Date coordi_date) {
		this.coordi_date = coordi_date;
	}

	@Override
	public String toString() {
		return "CoordiVO [coordi_id=" + coordi_id + ", coordi_name=" + coordi_name + ", user_id=" + user_id
				+ ", coordi_date=" + coordi_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordi_date == null) ? 0 : coordi_date.hashCode());
		result = prime * result + coordi_id;
		result = prime * result + ((coordi_name == null) ? 0 : coordi_name.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		CoordiVO other = (CoordiVO) obj;
		if (coordi_date == null) {
			if (other.coordi_date != null)
				return false;
		} else if (!coordi_date.equals(other.coordi_date))
			return false;
		if (coordi_id != other.coordi_id)
			return false;
		if (coordi_name == null) {
			if (other.coordi_name != null)
				return false;
		} else if (!coordi_name.equals(other.coordi_name))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
}
