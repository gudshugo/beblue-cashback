package br.com.project.rest.cashback.utils;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.exceptions.detailed.UnauthorizedException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SpotifyConnection {

    private static final String clientID = "eee034204d184245bd1147a92e4906e3";
    private static final String clientSecret = "4f1611af4e2c40419db080b2cc16ca52";
    private static final String accessToken = "BQA99FnwNr2ZPhzs-wCREhhRUWbZVslLwPyiuda6nu_w_3hd90a3CeI3bvgPx6NxFe2yoz_qJN68Uau5w3dEl3BLeIiROChEyPYmj8APAcJ_6zUrigQ0G81jHiDMLIsVO3NOcs9W66Q-l5b-ew1Pv6Q";

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
                    .market(CountryCode.PT)
                    .limit(50)
                    .build();

            return searchTracksRequest.execute();
        }

        throw new UnauthorizedException("Falha de autenticação no serviço do Spotify");
    }
}