package br.com.project.rest.cashback.repository;

import br.com.project.rest.cashback.utils.spotify.SpotifyConnection;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class SpotifyConnectionRepository {

    private final SpotifyConnection spotifyConnection;

    @Autowired
    public SpotifyConnectionRepository(SpotifyConnection spotifyConnection){
        this.spotifyConnection = spotifyConnection;
    }

    public Paging<Track> searchTracks(String q) throws SpotifyWebApiException, IOException {
        return spotifyConnection.searchTracks(q);
    }

}
