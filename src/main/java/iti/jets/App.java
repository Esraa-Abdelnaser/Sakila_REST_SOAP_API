package iti.jets;

import iti.jets.database.entities.Actor;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.impls.ActorServicesImpl;
import iti.jets.utils.SingletonEntityManager;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        ActorRepoImpl actorRepo = new ActorRepoImpl();
//        List<Actor> listOfActors = actorRepo.getAllActors();
//        for (Actor actor : listOfActors) {
//            System.out.println(actor.getFirstName()+" "+actor.getLastName());
//        }

//        LanguageRepoImpl languageRepo = new LanguageRepoImpl();
//        List<Language> listOfActors = languageRepo.getAllLanguages();
//        for (Language actor : listOfActors) {
//            System.out.println(actor.getId() + " " + actor.getName());
//        }

//        CategoryRepoImpl categoryRepo = new CategoryRepoImpl();
//        List<Category> listOfcate = categoryRepo.getAll();
//        for (Category cat : listOfcate) {
//            System.out.println(cat.getId() + " " + cat.getName());
//        }

//        FileTextRepoImpl fileTextRepo = new FileTextRepoImpl();
//        List<FilmText> listOfFilmText = fileTextRepo.getAll();
//        for (FilmText ft : listOfFilmText) {
//            System.out.println(ft.getId() + " " + ft.getTitle()+" "+ ft.getDescription());
//        }
        EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
        ActorRepoImpl actorRepoImpl = new ActorRepoImpl(entityManager);

        Actor actor = new Actor();
        actor.setFirstName("esraa");
        actor.setLastName("naser");
        actor.setLastUpdate(Instant.parse("2017-02-03T10:37:30.00Z"));
        actorRepoImpl.insert(actor);
        List<Actor> listOfActors = actorRepoImpl.getAll();
        List<ActorDto> listOfActorsDto = new ActorServicesImpl().getAll();
        for (ActorDto actor1 : listOfActorsDto) {
            System.out.println(actor1.getFirstName()+" "+actor1.getLastName());
        }
//        LanguageRepoImpl languageRepoImpl = new LanguageRepoImpl(entityManager);
//        CategoryRepoImpl  categoryRepoImpl = new CategoryRepoImpl(entityManager);
//        FilmTextRepoImpl  filmTextRepoImpl = new FilmTextRepoImpl(entityManager);

    }
}
