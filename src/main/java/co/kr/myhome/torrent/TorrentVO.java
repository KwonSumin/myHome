package co.kr.myhome.torrent;

public class TorrentVO {
	
	public TorrentVO() {
		super();
	}

	public TorrentVO(String title, String downloadLink,String size) {
		super();
		this.title = title;
		this.downId = downloadLink;
		this.size = size;
	}
	String title;
	String downId;
	String size;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDownId() {
		return downId;
	}

	public void setDownId(String downId) {
		this.downId = downId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "TorrentVO [title=" + title + ", downId=" + downId + ", size=" + size + "]\n";
	}
	
}
