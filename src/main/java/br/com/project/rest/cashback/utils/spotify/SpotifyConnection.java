package br.com.project.rest.cashback.utils.spotify;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpotifyConnection {

    @Value("${spotify.client-id}")
    private static String clientID;

    @Value("${spotify.client-secret}")
    private static String clientSecret;

    @Value("${spotift.access-token}")
    private static String accessToken;

    private static final String q = "genre:%s";


    public SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientID)
            .setClientSecret(clientSecret)
            .setAccessToken(accessToken)
            .build();

    public SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(q)
            .limit(50)
            .build();

    public Paging<Track> searchTracks(String q) throws SpotifyWebApiException, IOException{

        Paging<Track> tracks = searchTracksRequest.execute();
        return tracks;

    }

}
