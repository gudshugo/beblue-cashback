package br.com.project.rest.cashback.service;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;

import java.io.IOException;

public interface ISpotifyIntegrationService {

    Paging<Track> searchTracks(String q) throws SpotifyWebApiException, IOException;

}
