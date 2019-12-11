package br.com.project.rest.cashback.task.impl;

import br.com.project.rest.cashback.task.SpotifyImportTask;
import br.com.project.rest.cashback.utils.spotify.SpotifyConnection;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SpotifyImportTaskImpl implements SpotifyImportTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyImportTaskImpl.class);

    private static SpotifyConnection spotifyConnection;

    @Autowired
    public SpotifyImportTaskImpl(SpotifyConnection spotifyConnection){
        this.spotifyConnection = spotifyConnection;
    }

    public Paging<Track> importarDiscos() throws IOException, SpotifyWebApiException {

        return spotifyConnection.searchTracks("pop");

    }

}
