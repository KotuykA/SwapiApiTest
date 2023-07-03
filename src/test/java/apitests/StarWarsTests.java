package apitests;

import models.Actor;
import models.Actors;
import models.Films;
import models.Starship;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static configuration.Endpoints.FILMS;
import static configuration.Endpoints.PEOPLE;
import static configuration.Endpoints.SWAPI_URL;
import static restassured.RestAssuredService.sendGetRequest;
import static restassured.RestAssuredService.sendGetRequestWithSearch;

public class StarWarsTests extends Base {

    @Test
    public void starshipAndPilotTest() {
        String filmNameToSearch = "A New Hope";
        List<String> charactersLinksList = sendGetRequestWithSearch(FILMS, filmNameToSearch, Films.class)
                .getResults()
                .stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Couldn't find a film: " + filmNameToSearch))
                .getCharacters();

        String actorNameToSearch = "Biggs Darklighter";
        Actor actorBiggs = sendGetRequestWithSearch(PEOPLE, actorNameToSearch, Actors.class)
                .getResults()
                .stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Couldn't find an actorBiggs with the name: " + actorNameToSearch));

        String errorMessage = String.format("Actor '%s' is not present in the list of actors of the film '%s'.", actorNameToSearch, filmNameToSearch);
        Assert.assertTrue(errorMessage, charactersLinksList.contains(actorBiggs.getUrl()));

        String starShipActorFlow = actorBiggs.getStarships()
                .stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("There are no starships the actor was flying on."))
                .replace(SWAPI_URL, "");

        Starship starship = sendGetRequest(starShipActorFlow, Starship.class);

        String starshipClass = "Starfighter";
        Assert.assertEquals("Not expected class of the starship.", starshipClass, starship.getStarshipClass());

        String actorName = "Luke Skywalker";
        String actorSkywalkerLink = sendGetRequestWithSearch(PEOPLE, actorNameToSearch, Actors.class)
                .getResults()
                .stream().findFirst()
                .orElseThrow(() -> new NoSuchElementException("Couldn't find an actorBiggs with the name: " + actorName))
                .getUrl();

        errorMessage = String.format("'%s' is not present in the list of pilots of the '%s' starship.", actorName, starshipClass);
        Assert.assertTrue(errorMessage, starship.getPilots().contains(actorSkywalkerLink));
    }

}
