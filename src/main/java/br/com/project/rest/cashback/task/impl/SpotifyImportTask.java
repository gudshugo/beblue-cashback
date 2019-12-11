package br.com.project.rest.cashback.task.impl;

import br.com.project.rest.cashback.enumeration.GeneroEnum;
import br.com.project.rest.cashback.model.Disco;
import br.com.project.rest.cashback.model.Genero;
import br.com.project.rest.cashback.service.IDiscoService;
import br.com.project.rest.cashback.service.IGeneroService;
import br.com.project.rest.cashback.task.ISpotifyImportTask;
import br.com.project.rest.cashback.utils.SpotifyConnection;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SpotifyImportTask implements ISpotifyImportTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpotifyImportTask.class);

    private final SpotifyConnection spotifyConnection;

    private final IGeneroService generoService;

    private final IDiscoService discoService;

    @Autowired
    public SpotifyImportTask(SpotifyConnection spotifyConnection, IGeneroService generoService, IDiscoService discoService){
        this.spotifyConnection = spotifyConnection;
        this.generoService = generoService;
        this.discoService = discoService;
    }

    @Scheduled(initialDelay=0, fixedRate=4*60*60*1000)
    public void importarDiscos() throws IOException, SpotifyWebApiException {

        if (LOGGER.isInfoEnabled()) LOGGER.info("Inicio da importação dos discos da Spotify API.");

        List<Genero> generos = generoService.findGeneros();

        for (Genero genero : generos) {

            Paging<Track> tracks = spotifyConnection.searchTracks(String.format("genre: %s", GeneroEnum.toGender(genero.getDescricao())));

            List<Disco> discos = Arrays.stream(tracks.getItems()).map(track -> new Disco.Builder()
                    .withUniqueId(UUID.randomUUID())
                    .withNome(track.getAlbum().getName())
                    .withDataLancamento(DateUtils.parseDate(track.getAlbum().getReleaseDate()))
                    .withGenero(genero)
                    .build()).collect(Collectors.toList());

            discoService.saveDiscos(discos);

        }

        if (LOGGER.isInfoEnabled()) LOGGER.info("Fim da importação dos discos da Spotify API.");

    }

}
