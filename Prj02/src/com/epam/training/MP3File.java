package com.epam.training;

public class MP3File {
	private String songPerformer;
	private String albumName;
	private String title;
	private double songDuration;
	private String path;

	public String getSongPerformer() {
		return songPerformer;
	}

	public void setSongPerformer(String songPerformer) {
		this.songPerformer = songPerformer;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(double songDuration) {
		this.songDuration = songDuration;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((albumName == null) ? 0 : albumName.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		long temp;
		temp = Double.doubleToLongBits(songDuration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((songPerformer == null) ? 0 : songPerformer.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		MP3File other = (MP3File) obj;
		if (albumName == null) {
			if (other.albumName != null)
				return false;
		} else if (!albumName.equals(other.albumName))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (Double.doubleToLongBits(songDuration) != Double
				.doubleToLongBits(other.songDuration))
			return false;
		if (songPerformer == null) {
			if (other.songPerformer != null)
				return false;
		} else if (!songPerformer.equals(other.songPerformer))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public MP3File(String songPerformer, String albumName, String title,
			double songDuration, String path) {
		super();
		this.songPerformer = songPerformer;
		this.albumName = albumName;
		this.title = title;
		this.songDuration = songDuration;
		this.path = path;
	}

	public MP3File() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MP3File [songPerformer=" + songPerformer + ", albumName="
				+ albumName + ", title=" + title + ", songDuration="
				+ songDuration + ", path=" + path + "]";
	}
	
	

}
