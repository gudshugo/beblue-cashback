package br.com.project.rest.cashback.service;

import br.com.project.rest.cashback.utils.spotify.SpotifyConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegracaoSpotifyService
{

    private final SpotifyConnection spotifyConnection;

    @Autowired
    public IntegracaoSpotifyService(SpotifyConnection spotifyConnection){
        this.spotifyConnection = spotifyConnection;
    }



}
