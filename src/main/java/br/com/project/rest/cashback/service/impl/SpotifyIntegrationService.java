package br.com.project.rest.cashback.service.impl;

import br.com.project.rest.cashback.service.ISpotifyIntegrationService;
import br.com.project.rest.cashback.utils.spotify.SpotifyConnection;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.exceptions.detailed.UnauthorizedException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SpotifyIntegrationService implements ISpotifyIntegrationService {

    private final SpotifyConnection spotifyConnection;

    @Autowired
    public SpotifyIntegrationService( SpotifyConnection spotifyConnection){
        this.spotifyConnection = spotifyConnection;
    }

    public Paging<Track> searchTracks(String q) throws SpotifyWebApiException, IOException {
        Boolean authenticated = SpotifyConnection.executeAuthentication();

        if(authenticated)
            return SpotifyConnection.searchTracksRequest.execute();

        throw new UnauthorizedException("Falha de autorização ao logar no Spotify");
    }

}
