package be.kdg.prog12.enums;

import java.util.ArrayList;
import java.util.List;

public class TestMovies {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Ronin", 1998, Format.DVD, Audio.DOLBY));
        movies.add(new Movie("Lakeview Terrace", 2008, Format.BLU_RAY, Audio.DOLBY_HD));
        movies.add(new Movie("Ghost Town", 2008, Format.DVD, Audio.DOLBY));
        movies.add(new Movie("Stealth", 2005, Format.VHS, Audio.VHS));
        movies.add(new Movie("Fast & Furious 6", 2013, Format.BLU_RAY, Audio.DTS_HD));
        movies.add(new Movie("Twilight", 2008, Format.DVD, Audio.DOLBY));
        movies.add(new Movie("The Brave One", 2007, Format.VHS, Audio.VHS));

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
