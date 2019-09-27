package vo;

import java.sql.Date;

public class BoardVO {
	int post_id;
	String user_id;
	String title;
	String content;
	Date post_date;
	int count;
	
	public BoardVO() {}

	public BoardVO(int post_id, String user_id, String title, String content, Date post_date,
			int count) {
		this.post_id = post_id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.post_date = post_date;
		this.count = count;
		
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoardVO [post_id=" + post_id + ", user_id=" + user_id + ", title=" + title + ", content=" + content
				+ ", post_date=" + post_date + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + count;
		result = prime * result + ((post_date == null) ? 0 : post_date.hashCode());
		result = prime * result + post_id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (count != other.count)
			return false;
		if (post_date == null) {
			if (other.post_date != null)
				return false;
		} else if (!post_date.equals(other.post_date))
			return false;
		if (post_id != other.post_id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
}
