package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Starship extends EntityModel {

    String name;
    String model;
    String manufacturer;
    String length;
    String crew;
    String passengers;
    String consumables;
    @JsonProperty("cost_in_credits")
    String costInCredits;
    @JsonProperty("max_atmosphering_speed")
    String maxAtmospheringSpeed;
    @JsonProperty("cargo_capacity")
    String cargoCapacity;
    @JsonProperty("hyperdrive_rating")
    String hyperdriveRating;
    @JsonProperty("starship_class")
    String starshipClass;
    List<String> films;
    List<String> pilots;
    @JsonProperty("MGLT")
    String MGLT;

}
