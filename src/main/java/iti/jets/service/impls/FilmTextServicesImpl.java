package iti.jets.service.impls;

import iti.jets.database.entities.FilmText;
import iti.jets.database.repos.impls.FilmTextRepoImpl;
import iti.jets.service.dtos.FilmTextDto;
import iti.jets.service.interfaces.FilmTextServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.FilmTextMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class FilmTextServicesImpl implements FilmTextServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    FilmTextRepoImpl filmTextRepo = new FilmTextRepoImpl(entityManager);
    FilmTextMapper mapper = FilmTextMapper.INSTANCE;

    @Override
    public List<FilmTextDto> getAll() {
        List<FilmText> listOfFilmTexts = filmTextRepo.getAll();
        List<FilmTextDto> listOfFilmTextDto = new ArrayList<>();
        for (FilmText filmText : listOfFilmTexts) {
            listOfFilmTextDto.add(mapper.toDto(filmText));
        }
        return listOfFilmTextDto;
    }

    @Override
    public FilmTextDto getById(Integer id) {
        return mapper.toDto(filmTextRepo.getById(id));
    }

    @Override
    public void insert(FilmTextDto filmTextDto) {
        filmTextRepo.insert(mapper.toEntity(filmTextDto));
    }

    @Override
    public void update(FilmTextDto filmTextDto) {
        filmTextRepo.update(mapper.toEntity(filmTextDto));
    }

    @Override
    public void delete(FilmTextDto filmTextDto) {
        filmTextRepo.delete(mapper.toEntity(filmTextDto));
    }
}
