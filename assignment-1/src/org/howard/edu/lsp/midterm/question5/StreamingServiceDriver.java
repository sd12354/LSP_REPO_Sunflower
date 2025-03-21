package org.howard.edu.lsp.midterm.question5;

public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of different media types
        Music music = new Music("Still a Friend - Incognito");
        Movie movie = new Movie("Avengers End Game");
        Audiobook audiobook = new Audiobook("A Promised Land – Barack Obama");

        // Test common behaviors
        System.out.println("Testing common behaviors for all media types:\n");
        
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

        // Test unique behaviors
        movie.rewind(30);
        System.out.println();

        audiobook.setPlaybackSpeed(1.5);
        System.out.println();

        music.addToPlaylist("Favorites");
        System.out.println();
    }
}
