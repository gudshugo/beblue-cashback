package br.com.project.rest.cashback.task;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;

import java.io.IOException;

public interface SpotifyImportTask {

     Paging<Track> importarDiscos()  throws IOException, SpotifyWebApiException;

}
