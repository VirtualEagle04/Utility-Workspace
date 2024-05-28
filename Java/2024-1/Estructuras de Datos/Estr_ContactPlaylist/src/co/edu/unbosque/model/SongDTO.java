package co.edu.unbosque.model;

public class SongDTO {

	private String name;
	private String artist;
	private String genre;
	private float duration;

	public SongDTO() {

	}

	public SongDTO(String name, String artist, String genre, float duration) {
		super();
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return this.getArtist() + " - " + this.getName() + " [" + this.getDuration() + "] - " + this.getGenre();
	}

}
