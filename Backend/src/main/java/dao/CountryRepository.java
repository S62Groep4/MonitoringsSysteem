package dao;

import domain.Country;
import domain.SystemModule;

import java.util.List;

/**
 * Created by Sjoerd on 26-2-2018.
 */
public interface CountryRepository {
    Country getCountry(Long id);

    Country getCountry(String name);

    List<Country> getCountries();

    Country createCountry(Country country);

    Country updateCountry(Country country);
}
