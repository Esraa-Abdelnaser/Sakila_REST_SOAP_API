package iti.jets.service.impls;

import iti.jets.database.entities.Film;
import iti.jets.database.repos.impls.FilmRepoImpl;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.interfaces.FilmServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.FilmMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class FilmServicesImpl implements FilmServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    FilmRepoImpl filmRepo = new FilmRepoImpl(entityManager);
    FilmMapper mapper = FilmMapper.INSTANCE;

    @Override
    public List<FilmDto> getAll() {
        List<Film> listOfFilms = filmRepo.getAll();
        List<FilmDto> listOfFilmDto = new ArrayList<>();
        for (Film film : listOfFilms) {
            listOfFilmDto.add(mapper.toDto(film));
        }
        return listOfFilmDto;
    }

    @Override
    public FilmDto getById(Integer id) {
        return mapper.toDto(filmRepo.getById(id));
    }

    @Override
    public void insert(FilmDto filmDto) {
        filmRepo.insert(mapper.toEntity(filmDto));
    }

    @Override
    public void update(FilmDto filmDto) {
        filmRepo.update(mapper.toEntity(filmDto));
    }

    @Override
    public void delete(FilmDto filmDto) {
        filmRepo.delete(mapper.toEntity(filmDto));
    }
}
