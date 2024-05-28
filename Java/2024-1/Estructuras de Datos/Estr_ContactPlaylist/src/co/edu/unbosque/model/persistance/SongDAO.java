package co.edu.unbosque.model.persistance;

import java.util.Collections;
import java.util.LinkedList;

import co.edu.unbosque.model.SongDTO;
import co.edu.unbosque.util.CRUDoperations;

public class SongDAO implements CRUDoperations {

	private LinkedList<SongDTO> playlist;

	public SongDAO() {
		playlist = new LinkedList<SongDTO>();
	}

	public SongDAO(LinkedList<SongDTO> playlist) {
		super();
		this.playlist = playlist;
	}

	public LinkedList<SongDTO> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(LinkedList<SongDTO> playlist) {
		this.playlist = playlist;
	}

	@Override
	public void create(Object o) {
		playlist.addFirst((SongDTO) o);
	}

	@Override
	public int delete(int index) {
		try {
			playlist.remove(index);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	@Override
	public int update(int index, Object o) {
		try {
			playlist.set(index, (SongDTO) o);
			return 0;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	@Override
	public String read() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < playlist.size(); i++) {
			sb.append(i + ": " + playlist.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public String readShuffled() {
		StringBuilder sb = new StringBuilder();
		LinkedList<SongDTO> shuffledPlaylist = playlist;

		Collections.shuffle(shuffledPlaylist);

		for (int i = 0; i < shuffledPlaylist.size(); i++) {
			sb.append(i + ": " + shuffledPlaylist.get(i).toString() + "\n");
		}
		return sb.toString();
	}

}
