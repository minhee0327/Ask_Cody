package vo;

import java.sql.Date;

public class BookmarkVO {
	int bookmark_id;
	int cloth_id;
	String user_id;
	Date bookmark_date;
	
	
	public BookmarkVO() {}

	public BookmarkVO(int bookmark_id, int cloth_id, String user_id, Date bookmark_date) {
		this.bookmark_id = bookmark_id;
		this.cloth_id = cloth_id;
		this.user_id = user_id;
		this.bookmark_date = bookmark_date;
	}

	public int getBookmark_id() {
		return bookmark_id;
	}

	public void setBookmark_id(int bookmark_id) {
		this.bookmark_id = bookmark_id;
	}

	public int getCloth_id() {
		return cloth_id;
	}

	public void setCloth_id(int cloth_id) {
		this.cloth_id = cloth_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getBookmark_date() {
		return bookmark_date;
	}

	public void setBookmark_date(Date bookmark_date) {
		this.bookmark_date = bookmark_date;
	}

	@Override
	public String toString() {
		return "BookmarkVO [bookmark_id=" + bookmark_id + ", cloth_id=" + cloth_id + ", user_id=" + user_id
				+ ", bookmark_date=" + bookmark_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookmark_date == null) ? 0 : bookmark_date.hashCode());
		result = prime * result + bookmark_id;
		result = prime * result + cloth_id;
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
		BookmarkVO other = (BookmarkVO) obj;
		if (bookmark_date == null) {
			if (other.bookmark_date != null)
				return false;
		} else if (!bookmark_date.equals(other.bookmark_date))
			return false;
		if (bookmark_id != other.bookmark_id)
			return false;
		if (cloth_id != other.cloth_id)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	
}
