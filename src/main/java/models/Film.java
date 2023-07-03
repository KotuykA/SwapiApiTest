package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Film extends EntityModel {

    String title;
    @JsonProperty("episode_id")
    int episodeId;
    @JsonProperty("opening_crawl")
    String openingCrawl;
    String director;
    String producer;
    @JsonProperty("release_date")
    String releaseDate;
    List<String> characters;
    List<String> planets;
    List<String> starships;
    List<String> vehicles;
    List<String> species;

}
