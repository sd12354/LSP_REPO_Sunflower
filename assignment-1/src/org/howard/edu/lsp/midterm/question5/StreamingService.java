package org.howard.edu.lsp.midterm.question5;

import java.util.*; // Import Java collections for managing playlists

class Music {
    private String title;
    private List<String> playlists; // Using List to store playlists

    /**
     * Constructor to initialize a music track.
     * @param title The title of the music track.
     */
    public Music(String title) {
        this.title = title;
        this.playlists = new ArrayList<>(); // Initialize the playlist collection
    }

    /** Plays the music track. */
    public void play() {
        System.out.println("Playing music: " + title);
    }

    /** Pauses the music track. */
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    /** Stops the music track. */
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the music track to a playlist.
     * @param playlistName The name of the playlist.
     */
    public void addToPlaylist(String playlistName) {
        playlists.add(playlistName);
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}

/**
 * Represents a Movie that can be played, paused, stopped, and rewound.
 */
class Movie {
    private String title;

    /**
     * Constructor to initialize a movie.
     * @param title The title of the movie.
     */
    public Movie(String title) {
        this.title = title;
    }

    /** Plays the movie. */
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    /** Pauses the movie. */
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    /** Stops the movie. */
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewinds the movie by a given number of seconds.
     * @param seconds The number of seconds to rewind.
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}

/**
 * Represents an Audiobook that can be played, paused, stopped, and has adjustable playback speed.
 */
class Audiobook {
    private String title;
    private double playbackSpeed;

    /**
     * Constructor to initialize an audiobook.
     * @param title The title of the audiobook.
     */
    public Audiobook(String title) {
        this.title = title;
        this.playbackSpeed = 1.0; // Default playback speed
    }

    /** Plays the audiobook. */
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    /** Pauses the audiobook. */
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    /** Stops the audiobook. */
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed of the audiobook.
     * @param speed The new playback speed.
     */
    public void setPlaybackSpeed(double speed) {
        this.playbackSpeed = speed;
        System.out.println("Setting playback speed of audiobook: " + title + " to " + playbackSpeed + "x");
    }
}