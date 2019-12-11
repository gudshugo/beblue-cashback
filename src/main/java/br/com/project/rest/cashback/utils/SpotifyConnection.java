package br.com.project.rest.cashback.utils;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.exceptions.detailed.UnauthorizedException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SpotifyConnection {

    private static String clientID = "eee034204d184245bd1147a92e4906e3";
    private static String clientSecret = "4f1611af4e2c40419db080b2cc16ca52";
    private static String accessToken = "BQA2qX4IlCDmUwOgzWxfjBy5FXtsI2SacHtqoFZqEP8fpUZVDSnvz7BY030_laZP0KjIBWqGcrJQLEf9CyC0_tI4nvjfzRuBx7-0bdp6jmnPb5wiDnb83Roh5Y-pu_aZHG5HLGGrwibeQmo";

    private static SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientID)
            .setClientSecret(clientSecret)
            .setAccessToken(accessToken)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    public static Boolean executeAuthentication() {

        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            return true;
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

    public Paging<Track> searchTracks(String genero) throws SpotifyWebApiException, IOException {

        Boolean authenticated = SpotifyConnection.executeAuthentication();

        if(authenticated) {
            SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(genero)
                    .market(CountryCode.US)
                    .limit(50)
                    .build();

            return searchTracksRequest.execute();
        }

        throw new UnauthorizedException("Falha de autenticação no serviço do Spotify");
    }
}