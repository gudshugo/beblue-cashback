package br.com.project.rest.cashback.task;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

public interface ISpotifyImportTask {

    void importarDiscos() throws IOException, SpotifyWebApiException;

}
