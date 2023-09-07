package co.edu.unbosque.controller;

import co.edu.unbosque.model.PeliculaDTO;
import co.edu.unbosque.model.persistance.PeliculaDAO;

public class AplMain {

	public static void main(String[] args) {
		
		//FiFo (first-in, first-out) -> Filas
		//LiFo (last-in, first-out) -> Colas

		PeliculaDAO pdao = new PeliculaDAO();
		pdao.agregarFinal(new PeliculaDTO("Interstellar", 2014, 269, "Christopher Nolan", "Paramount Pictures", 73));
		pdao.agregarFinal(new PeliculaDTO("The Shawshank Redeption", 1994, 142, "Frank Darabont", "Castle Rock Entertainment", 90));
		pdao.agregarFinal(new PeliculaDTO("The Godfather", 1972, 175, "Francis Ford Coppola", "Paramount Pictures", 98));
		pdao.agregarFinal(new PeliculaDTO("Pulp Fiction", 1994, 154, "Quentin Tarantino", "Miramax Films", 92));
		pdao.agregarFinal(new PeliculaDTO("The Dark Knight", 2008, 152, "Christopher Nolan", "Warner Bros. Pictures", 94));
		pdao.agregarFinal(new PeliculaDTO("Forrest Gump", 1994, 142, "Robert Zemeckis", "Paramount Pictures", 71));
		pdao.agregarFinal(new PeliculaDTO("The Matrix", 1999, 146, "Lana Wachowski, Lilly Wachowski", "Warner Bros. Pictures", 83));
		pdao.agregarFinal(new PeliculaDTO("Inception", 2010, 148, "Christopher Nolan", "Warner Bros. Pictures", 87));
		pdao.agregarFinal(new PeliculaDTO("Mad Max: Fury Road", 2015, 120, "George Miller", "Warner Bros. Pictures", 97));
		pdao.agregarFinal(new PeliculaDTO("Parasite", 2019, 132, "Bong Joon-ho", "CJ Entertainment", 99));
		pdao.agregarFinal(new PeliculaDTO("The Shining", 1980, 146, "Stanley Kubrick", "Warner Bros. Pictures", 83));
		pdao.agregarFinal(new PeliculaDTO("Spirited Away", 2001, 125, "Hayao Miyazaki", "Studio Ghibli", 96));
		pdao.agregarFinal(new PeliculaDTO("Toy Story", 1995, 81, "John Lasseter", "Pixar Animation Studios", 100));
		pdao.agregarFinal(new PeliculaDTO("Alien", 1979, 116, "Ridley Scott", "Brandywine Productions", 98));
		pdao.agregarFinal(new PeliculaDTO("2001: A Space Odyssey", 1968, 142, "Stanley Kubrick", "Metro-Goldwyn-Mayer", 92));
		pdao.agregarFinal(new PeliculaDTO("Apocalypse Now", 1979, 147, "Francis Ford Coppola", "Zoetrope Studios", 98));
		pdao.agregarFinal(new PeliculaDTO("Saving Private Ryan", 1968, 169, "Steven Spielberg", "DreamWorks", 94));
		pdao.agregarFinal(new PeliculaDTO("The Truman Show", 1998, 103, "Peter Weir", "Paramount Pictures", 94));
		pdao.agregarFinal(new PeliculaDTO("Kiki's Delivery Service", 1989, 102, "Hayao Miyazaki", "Studio Ghibli", 98));
		pdao.agregarFinal(new PeliculaDTO("Castle in the Sky", 1986, 124, "Hayao Miyazaki", "Studio Ghibli", 96));
		pdao.agregarFinal(new PeliculaDTO("Howl's Moving Castle", 2004, 119,  "Hayao Miyazaki", "Studio Ghibli", 87));
		pdao.agregarFinal(new PeliculaDTO("Grave of the Fireflies", 1988, 89, "Hayao Miyazaki", "Studio Ghibli", 100 ));
		pdao.agregarFinal(new PeliculaDTO("Porco Rosso", 1992, 94, "Hayao Miyazaki", "Studio Ghibli", 96 ));
		pdao.agregarFinal(new PeliculaDTO("My Neighbor Totoro", 1988, 86, "Hayao Miyazaki", "Studio Ghibli", 93));
		pdao.agregarFinal(new PeliculaDTO("Princess Mononoke", 1997, 133,  "Hayao Miyazaki", "Studio Ghibli", 93));
		pdao.agregarFinal(new PeliculaDTO("Ocean Waves", 1993, 72,  "Hayao Miyazaki", "Studio Ghibli", 89));
		pdao.agregarFinal(new PeliculaDTO("Whisper of the Heart", 1995, 111,  "Hayao Miyazaki", "Studio Ghibli", 94));
		pdao.agregarFinal(new PeliculaDTO("The Cat Returns", 2002, 75,  "Hayao Miyazaki", "Studio Ghibli", 88));
		pdao.agregarFinal(new PeliculaDTO("Arrietty", 2010, 95, "Hayao Miyazaki", "Studio Ghibli", 94));
		pdao.agregarFinal(new PeliculaDTO("From Up on Poppy Hill", 2011, 92, "Hayao Miyazaki", "Studio Ghibli", 87));
		pdao.agregarFinal(new PeliculaDTO("The Wind Rises", 2013, 126, "Hayao Miyazaki", "Studio Ghibli", 88));
		System.out.println(pdao.mostrar());
	}

}
