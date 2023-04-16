package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.FilmText;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.FilmTextRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.FilmTextDto;
import iti.jets.service.interfaces.FilmTextServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.FilmTextMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class FilmTextServicesImpl implements FilmTextServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    FilmTextRepoImpl actorRepoImpl = new FilmTextRepoImpl(entityManager);
    FilmTextMapper mapper = FilmTextMapper.INSTANCE;

    @Override
    public List<FilmTextDto> getAll() {
        List<FilmText> listOfFilmTexts = actorRepoImpl.getAll();
        List<FilmTextDto> listOfFilmTextDto = new ArrayList<>();
        for (FilmText filmText : listOfFilmTexts) {
            listOfFilmTextDto.add(mapper.toDto(filmText));
        }
        return listOfFilmTextDto;
    }

    @Override
    public FilmTextDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(FilmTextDto filmTextDto) {
        actorRepoImpl.insert(mapper.toEntity(filmTextDto));
    }

    @Override
    public void update(FilmTextDto filmTextDto) {
        actorRepoImpl.update(mapper.toEntity(filmTextDto));
    }

    @Override
    public void delete(FilmTextDto filmTextDto) {
        actorRepoImpl.delete(mapper.toEntity(filmTextDto));
    }
}
